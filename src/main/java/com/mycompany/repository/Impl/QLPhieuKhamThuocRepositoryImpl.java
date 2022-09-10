package com.mycompany.repository.Impl;

import com.mycompany.pojo.Loaithuoc;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.repository.QLPhieuKhamRepository;
import javax.persistence.criteria.Predicate;
import com.mycompany.pojo.Phieukham;
import com.mycompany.pojo.Phieukhamthuoc;
import com.mycompany.repository.QLLoaiThuocRepository;
import com.mycompany.repository.QLPhieuKhamThuocRepository;
import java.util.ArrayList;
import java.util.Map;
import org.hibernate.HibernateException;
import org.springframework.core.env.Environment;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class QLPhieuKhamThuocRepositoryImpl implements QLPhieuKhamThuocRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    @Autowired
    private QLLoaiThuocRepository qLLoaiThuocmRepository;

    @Override
    public List<Phieukhamthuoc> dsPKT() {
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Phieukhamthuoc> q = b.createQuery(Phieukhamthuoc.class);
            Root root = q.from(Phieukhamthuoc.class);
            Query query = session.createQuery(q);

            return query.getResultList();
        }

    }


    @Override
    public boolean addPhieuKhamThuoc(Phieukhamthuoc phieukhamthuoc) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(phieukhamthuoc);

            return true;
        } catch (HibernateException ex) {
            System.err.println(("ADD PK ERROR!" + ex.getMessage()));
            ex.printStackTrace();

        }
        return false;
    }

}
