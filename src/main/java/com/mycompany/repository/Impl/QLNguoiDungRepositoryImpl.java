package com.mycompany.repository.Impl;

import com.mycompany.pojo.Nguoidung;
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
import com.mycompany.repository.QLNguoiDungRepository;
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
public class QLNguoiDungRepositoryImpl implements QLNguoiDungRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    @Autowired
    private QLNguoiDungRepository qLNguoiDungRepository;

    @Override
    public List<Nguoidung> dsND() {
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            Query q = session.createQuery("From Nguoidung");
            return q.getResultList();
        }

    }
   

    @Override
    public boolean addNguoiDung(Nguoidung nguoidung) {
      Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(nguoidung);

            return true;
        } catch (HibernateException ex) {
            System.err.println(("ADD PK ERROR!" + ex.getMessage()));
            ex.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean deleteNguoiDungById(int idNguoiDung) {
         Session session = sessionFactory.getObject().getCurrentSession();
              try {

          Query q = session.createQuery("Update Nguoidung "
                    + "set active=:active\n"
                    + "where idNguoiDung=:idNguoiDung");
            q.setInteger("idNguoiDung", idNguoiDung);
            q.setBoolean("active", false);
            
            q.executeUpdate();
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
   
   
}
