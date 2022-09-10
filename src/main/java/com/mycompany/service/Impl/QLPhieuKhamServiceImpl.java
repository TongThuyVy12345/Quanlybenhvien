/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.Impl;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.repository.QLPhieuKhamRepository;
import java.util.Map;
import com.mycompany.service.QLPhieuKhamService;

/**
 *
 * @author ASUS
 */
@Service
public class QLPhieuKhamServiceImpl implements QLPhieuKhamService {

    @Autowired
    private QLPhieuKhamRepository qLPhieuKhamRepository;

    @Override
    public List<Phieukham> dsPK() {
        return this.qLPhieuKhamRepository.dsPK();
    }

//    @Override
//    public Phieukham findPhieuKhambyID(long idPhieuKham) {
//        return qLPhieuKhamRepository.findPhieuKhambyID(idPhieuKham);
//    }
    @Override
    public boolean addPhieuKham(Phieukham phieukham) {
        phieukham.setActive(Boolean.TRUE);
        return qLPhieuKhamRepository.addPhieuKham(phieukham);

    }

    @Override
    public boolean deletePhieuKhamById(int idPhieuKham) {
        return qLPhieuKhamRepository.deletePhieuKhamById(idPhieuKham);
    }

}
