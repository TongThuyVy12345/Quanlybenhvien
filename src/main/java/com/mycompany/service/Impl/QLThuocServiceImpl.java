/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.Impl;

import com.mycompany.pojo.Loaithuoc;
import com.mycompany.pojo.Phieukham;
import com.mycompany.pojo.Thuoc;
import com.mycompany.repository.QLLoaiThuocRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.repository.QLPhieuKhamRepository;
import com.mycompany.repository.QLThuocRepository;
import com.mycompany.service.QLLoaiThuocService;
import java.util.Map;
import com.mycompany.service.QLPhieuKhamService;
import com.mycompany.service.QLThuocService;

/**
 *
 * @author ASUS
 */
@Service
public class QLThuocServiceImpl implements QLThuocService {

    @Autowired
    private QLThuocRepository qLThuocRepository;

    @Override
    public List<Thuoc> dsT() {
        return this.qLThuocRepository.dsT();
    }

    @Override
    public boolean addThuoc(Thuoc thuoc) {
        thuoc.setActive(Boolean.TRUE);
        return qLThuocRepository.addThuoc(thuoc);
    }

    @Override
    public boolean deleteThuocById(int idThuoc) {
        return qLThuocRepository.deleteThuocById(idThuoc);
    }

}
