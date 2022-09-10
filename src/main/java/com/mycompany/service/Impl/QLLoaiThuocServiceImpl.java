/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.Impl;

import com.mycompany.pojo.Loaithuoc;
import com.mycompany.pojo.Phieukham;
import com.mycompany.repository.QLLoaiThuocRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.repository.QLPhieuKhamRepository;
import com.mycompany.service.QLLoaiThuocService;
import java.util.Map;
import com.mycompany.service.QLPhieuKhamService;

/**
 *
 * @author ASUS
 */
@Service
public class QLLoaiThuocServiceImpl implements QLLoaiThuocService {

    @Autowired
    private QLLoaiThuocRepository qLLoaiThuocRepository;

    @Override
    public List<Loaithuoc> dsLT() {
        return this.qLLoaiThuocRepository.dsLT();
    }

    @Override
    public boolean addLoaiThuoc(Loaithuoc loaithuoc) {
        loaithuoc.setActive(Boolean.TRUE);
        return qLLoaiThuocRepository.addLoaiThuoc(loaithuoc);
    }

    @Override
    public boolean deleteLoaiThuocById(int idLoaiThuoc) {
        return qLLoaiThuocRepository.deleteLoaiThuocById(idLoaiThuoc);
    }

//    @Override
//    public List<Loaithuoc> getLT(String kw, int page) {
//        return this.qLLoaiThuocRepository.getLT(kw,page);
//    }

    @Override
    public Loaithuoc getLoaiThuocbyID(int idLoaiThuoc) {
        return qLLoaiThuocRepository.getLoaiThuocbyID(idLoaiThuoc);
    }
}
