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
import com.mycompany.repository.QLLoaiThuocRepository;
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
public class QLLoaiThuocRepositoryImpl implements QLLoaiThuocRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    @Autowired
    private QLLoaiThuocRepository qLLoaiThuocmRepository;

    @Override
    public List<Loaithuoc> dsLT() {
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Loaithuoc> q = b.createQuery(Loaithuoc.class);
            Root root = q.from(Loaithuoc.class);
            Query query = session.createQuery(q);
            return query.getResultList();
        }

    }

    @Override
    public boolean addLoaiThuoc(Loaithuoc loaithuoc) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.saveOrUpdate(loaithuoc);

            return true;
        } catch (HibernateException ex) {
            System.err.println(("ADD PK ERROR!" + ex.getMessage()));
            ex.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean deleteLoaiThuocById(int idLoaiThuoc) {

        Session session = sessionFactory.getObject().getCurrentSession();
        try {

            Query q = session.createQuery("Update Loaithuoc "
                    + "set active=:active\n"
                    + "where idLoaiThuoc=:idLoaiThuoc");
            q.setInteger("idLoaiThuoc", idLoaiThuoc);
            q.setBoolean("active", false);

            q.executeUpdate();
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

//    @Override
//    public List<Loaithuoc> getLT(String kw, int page) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Loaithuoc> q = b.createQuery(Loaithuoc.class);
//        Root root = q.from(Loaithuoc.class);
//        Query query = session.createQuery(q);
//        q=q.select(root);
//        q=q.orderBy(b.desc(root.get("idLoaiThuoc")));
//        if (!kw.isEmpty()) {
//            Predicate predicate = b.like(root.get("tenLoaiThuoc").as(String.class),
//                    String.format("%%%s%%", kw));
//            q.where(predicate);
//        }
//        
//        return query.getResultList();
//    }
    @Override
    public Loaithuoc getLoaiThuocbyID(int idLoaiThuoc) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Loaithuoc.class, idLoaiThuoc);
    }

    

}
