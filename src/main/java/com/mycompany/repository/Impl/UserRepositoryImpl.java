/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.Impl;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import static org.springframework.jdbc.core.JdbcOperationsExtensionsKt.query;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Transactional
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addUSer(Nguoidung nguoidung) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(nguoidung);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Nguoidung> getNguoidungs(String taiKhoan) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Nguoidung> query = builder.createQuery(Nguoidung.class);
        Root root = query.from(Nguoidung.class);
        query.select(root);
        if (!taiKhoan.isEmpty()) {
            Predicate p = builder.equal(root.get("taiKhoan").as(String.class), taiKhoan.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public Nguoidung getUserByID(int idUser) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(Nguoidung.class, idUser);
    }
    
}
