package com.mycompany.repository.Impl;

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
public class QLPhieuKhamRepositoryImpl implements QLPhieuKhamRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    @Autowired
    private QLPhieuKhamRepository qLPhieuKhamRepository;

    @Override
    public List<Phieukham> dsPK() {
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = session.getCriteriaBuilder();
            CriteriaQuery<Phieukham> q = b.createQuery(Phieukham.class);
            Root root = q.from(Phieukham.class);
            Query query = session.createQuery(q);

            return query.getResultList();
        }

    }



 
    @Override
    public boolean addPhieuKham(Phieukham phieukham) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(phieukham);

            return true;
        } catch (HibernateException ex) {
            System.err.println(("ADD PK ERROR!" + ex.getMessage()));
            ex.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean deletePhieuKhamById(int idPhieuKham) {
       Session session = sessionFactory.getObject().getCurrentSession();
              try {

          Query q = session.createQuery("Update Phieukham "
                    + "set active=:active\n"
                    + "where idPhieuKham=:idPhieuKham");
            q.setInteger("idPhieuKham", idPhieuKham);
            q.setBoolean("active", false);
            
            q.executeUpdate();
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

 

    

}
