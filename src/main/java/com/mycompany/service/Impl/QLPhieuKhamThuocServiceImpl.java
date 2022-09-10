/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.Impl;

import com.mycompany.pojo.Phieukhamthuoc;
import com.mycompany.repository.QLLoaiThuocRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.repository.QLPhieuKhamRepository;
import com.mycompany.repository.QLPhieuKhamThuocRepository;
import com.mycompany.service.QLLoaiThuocService;
import java.util.Map;
import com.mycompany.service.QLPhieuKhamService;
import com.mycompany.service.QLPhieuKhamThuocService;

/**
 *
 * @author ASUS
 */
@Service
public class QLPhieuKhamThuocServiceImpl implements QLPhieuKhamThuocService {

    @Autowired
    private QLPhieuKhamThuocRepository qLPhieuKhamThuocRepository;

    @Override
    public List<Phieukhamthuoc> dsPKT() {
        return this.qLPhieuKhamThuocRepository.dsPKT();
    }

    @Override
    public boolean addPhieuKhamThuoc(Phieukhamthuoc phieukhamthuoc) {
        return qLPhieuKhamThuocRepository.addPhieuKhamThuoc(phieukhamthuoc);

    }

}
