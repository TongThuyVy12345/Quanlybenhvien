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
import com.mycompany.pojo.Thuoc;
import com.mycompany.repository.QLLoaiThuocRepository;
import com.mycompany.repository.QLThuocRepository;
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
public class QLThuocRepositoryImpl implements QLThuocRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    @Autowired
    private QLThuocRepository qLThuocmRepository;

    @Override
    public List<Thuoc> dsT() {
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Thuoc> q = b.createQuery(Thuoc.class);
            Root root = q.from(Thuoc.class);
            Query query = session.createQuery(q);
            return query.getResultList();
        }

    }

    @Override
    public boolean addThuoc(Thuoc thuoc) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(thuoc);

            return true;
        } catch (HibernateException ex) {
            System.err.println(("ADD PK ERROR!" + ex.getMessage()));
            ex.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean deleteThuocById(int idThuoc) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {

            Query q = session.createQuery("Update Thuoc "
                    + "set active=:active\n"
                    + "where idThuoc=:idThuoc");
            q.setInteger("idThuoc", idThuoc);
            q.setBoolean("active", false);

            q.executeUpdate();
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

}
