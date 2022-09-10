/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.Impl;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.pojo.Thuoc;
import com.mycompany.repository.ThuocRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.query.Query;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class ThuocRepositoryImpl implements ThuocRepository{

    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Thuoc> getThuocByName(String tenThuoc) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Thuoc> query = builder.createQuery(Thuoc.class);
        Root root = query.from(Thuoc.class);
        query.select(root);
        if ( !tenThuoc.isEmpty()){
            Predicate p = builder.like(root.get("tenThuoc").as(String.class), String.format("%%%s%%", tenThuoc));
            query= query.where(p);
        }
            
        Query q =session.createQuery(query);
        return q.getResultList();
    }
    

    @Override
    public Thuoc getThuocByID(int idThuoc) {
        Session session = this.sessionFactory.getObject().getCurrentSession();        
        return session.get(Thuoc.class, idThuoc);
    }
    
}
