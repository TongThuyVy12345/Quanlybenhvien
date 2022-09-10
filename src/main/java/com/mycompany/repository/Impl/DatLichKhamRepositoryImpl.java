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
import com.mycompany.repository.DatLichKhamRepository;
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
public class DatLichKhamRepositoryImpl implements DatLichKhamRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public boolean addLichKham(Phieukham phieukham) {
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
    public Phieukham getPhieuKhamById(int idPhieuKham) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Phieukham.class, idPhieuKham);
    }

}
