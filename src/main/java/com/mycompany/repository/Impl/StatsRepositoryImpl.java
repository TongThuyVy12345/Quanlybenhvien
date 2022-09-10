/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository.Impl;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.pojo.Phieukhamthuoc;
import com.mycompany.pojo.Thuoc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.repository.StatsRepository;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> catetStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rootND = q.from(Nguoidung.class);

        q.multiselect(rootND.get("userRole"),
                b.count(rootND.get("idNguoiDung")));
        q.groupBy(rootND.get("userRole"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> phieukhamStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rootPK = q.from(Phieukham.class);
        Root rootPKT = q.from(Phieukhamthuoc.class);
        List<Predicate> predicates = new ArrayList<>();
        b.equal(rootPK, rootPKT);
        predicates.add(b.equal(rootPK.get("idPhieuKham"), rootPKT.get("idPhieuKham")));
        q.multiselect(rootPK.get("idPhieuKham"), rootPK.get("tienKham"),
                b.sum(b.prod(rootPKT.get("giaThuoc"), rootPKT.get("soLuong"))),
                b.sum(b.sum(b.prod(rootPKT.get("giaThuoc"), rootPKT.get("soLuong"))), rootPK.get("tienKham")));

        if (kw != null && kw.isEmpty()) {
            predicates.add(b.like(rootPK.get("idPhieuKham"), String.format("%%s%%", kw)));
        }

        if (fromDate != null) {
            predicates.add(b.greaterThanOrEqualTo(rootPK.get("ngayKham"), fromDate));
        }

        if (toDate != null) {
            predicates.add(b.lessThanOrEqualTo(rootPK.get("ngayKham"), toDate));
        }
        q.where(predicates.toArray(new Predicate[]{}));

        q.groupBy(rootPK.get("idPhieuKham"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> tssdthuocStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rootT = q.from(Thuoc.class);
        Root rootPK = q.from(Phieukham.class);
        Root rootPKT = q.from(Phieukhamthuoc.class);
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(rootT.get("idThuoc"), rootPKT.get("idThuoc")));
        predicates.add(b.equal(rootPK.get("idPhieuKham"), rootPKT.get("idPhieuKham")));

        q.multiselect(
              
                rootT.get("tenThuoc"),
                b.sum(rootPKT.get("idThuoc")));

        if (kw != null && kw.isEmpty()) {
            predicates.add(b.like(rootPKT.get("tenThuoc"), String.format("%%s%%", kw)));
        }

        if (fromDate != null) {
            predicates.add(b.greaterThanOrEqualTo(rootPK.get("ngayKham"), fromDate));
        }

        if (toDate != null) {
            predicates.add(b.lessThanOrEqualTo(rootPK.get("ngayKham"), toDate));
        }
        q.where(predicates.toArray(new Predicate[]{}));

        q.groupBy(rootT.get("tenThuoc"));
               
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
