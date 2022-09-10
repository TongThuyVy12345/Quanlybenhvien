/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.Impl;

import com.mycompany.pojo.Phieukham;
import com.mycompany.pojo.Phieukhamthuoc;
import com.mycompany.pojo.Thuoc;
import com.mycompany.repository.PhieuKhamRepository;
import com.mycompany.service.PhieuKhamService;
import com.mycompany.service.ThuocService;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.velocity.runtime.directive.Foreach;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class PhieuKhamRepositoryImpl implements PhieuKhamRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private ThuocService thuocService;

    @Autowired
    private PhieuKhamService phieuKhamService;

    @Override
    public List<Phieukham> dsDangKyPK() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phieukham> query = builder.createQuery(Phieukham.class);
        Root root = query.from(Phieukham.class);
        query.select(root);

        query.where(root.get("xacNhanBoiYTa").isNull());
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean xacNhanPK(List<Integer> ids, int yta) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
//        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Phieukham");

        for (int i = 0; i < ids.size(); i++) {
            query = session.createQuery("update Phieukham set xacNhanBoiYTa= :idYta where idPhieuKham= :idPhieuKham");

            query.setLong("idPhieuKham", ids.get(i));
            query.setLong("idYta", yta);

            int result = query.executeUpdate();
        }

//        tx.rollback();
        return true;
    }

    @Override
    public Phieukham getPhieuKhamByID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(Phieukham.class, id);
    }

    @Override
    public List<Phieukham> getPKbyIDUser(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Phieukham> query = builder.createQuery(Phieukham.class);
        Root root = query.from(Phieukham.class);
        query.select(root);

        query.where(builder.equal(root.get("idBenhNhan"), id),root.get("ketLuan").isNotNull());
        query.orderBy(builder.desc(root.get("ngayKham")));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean updateChuanDoan(int id, String trieuChung, String ketLuan) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phieukham> query = builder.createQuery(Phieukham.class);
        Phieukham pk = getPhieuKhamByID(id);
        pk.setTrieuChung(trieuChung);
        pk.setKetLuan(ketLuan);

        session.update(pk);

        return true;
    }

    @Override
    public boolean updateDSThuoc(int id, Map<Integer, Integer> ds) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phieukhamthuoc> query = builder.createQuery(Phieukhamthuoc.class);

//        try {
        for (Map.Entry<Integer, Integer> entry : ds.entrySet()) {
            int idThuoc = entry.getKey();
            int soluong = entry.getValue();

            Thuoc thuoc = this.thuocService.getThuocByID(idThuoc);
            Phieukham pk = this.phieuKhamService.getPhieuKhamByID(id);

            Phieukhamthuoc pkt = new Phieukhamthuoc();

            pkt.setIdPhieuKham(pk);
            pkt.setIdThuoc(thuoc);
            pkt.setGiaThuoc(thuoc.getGia());
            pkt.setSoLuong(soluong);
            session.save(pkt);

        }
        return true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
    }

    @Override
    public List<Phieukham> dsThanhToan() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phieukham> query = builder.createQuery(Phieukham.class);
        Root root = query.from(Phieukham.class);
        query.select(root);

        query.where(builder.equal(root.get("isThanhToan"), 0));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    public List<Phieukhamthuoc> dsThuoc(int idPhieuKham) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phieukhamthuoc> query = builder.createQuery(Phieukhamthuoc.class);
        Root root = query.from(Phieukhamthuoc.class);
        query.select(root);

        query.where(builder.equal(root.get("idPhieuKham"), idPhieuKham));
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean xacNhanThanhToan(int idpk) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
//        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Phieukham");
        query = session.createQuery("update Phieukham set isThanhToan=1 where idPhieuKham= :idPhieuKham");

        query.setLong("idPhieuKham", idpk);

        int result = query.executeUpdate();

//        tx.rollback();
        return true;
    }

    @Override
    public List<Phieukham> dsLichKham(int idBacSi) {
              Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Phieukham> query = builder.createQuery(Phieukham.class);
        Root root = query.from(Phieukham.class);
        query.select(root);

        query.where(builder.equal(root.get("idBacSi"), idBacSi),root.get("ketLuan").isNull());
        Query q = session.createQuery(query);
        return q.getResultList();
    }

}
