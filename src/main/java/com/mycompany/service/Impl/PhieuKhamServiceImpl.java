/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.Impl;

import com.mycompany.pojo.Phieukham;
import com.mycompany.pojo.Phieukhamthuoc;
import com.mycompany.repository.PhieuKhamRepository;
import com.mycompany.service.PhieuKhamService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class PhieuKhamServiceImpl implements PhieuKhamService{
    @Autowired
    private PhieuKhamRepository phieuKhamRepository;
    
    @Override
    public List<Phieukham> dsDangKyPK() {
        return this.phieuKhamRepository.dsDangKyPK();
    }

    @Override
    public boolean xacNhanPK(List<Integer> ids,int yta) {
        return this.phieuKhamRepository.xacNhanPK(ids,yta);
    }

    @Override
    public List<Phieukham> getPKbyIDUser(int id) {
        return this.phieuKhamRepository.getPKbyIDUser(id);
    }

    @Override
    public Phieukham getPhieuKhamByID(int id) {
        return this.phieuKhamRepository.getPhieuKhamByID(id);
    }

    @Override
    public boolean updateChuanDoan(int id, String trieuChung, String ketLuan) {
        return this.phieuKhamRepository.updateChuanDoan(id, trieuChung, ketLuan);
    }

    @Override
    public boolean updateDSThuoc(int id, Map<Integer, Integer> ds) {
        return this.phieuKhamRepository.updateDSThuoc(id, ds);
    }

    @Override
    public List<Phieukham> dsThanhToan() {
        return this.phieuKhamRepository.dsThanhToan();
    }

    @Override
    public List<Phieukhamthuoc> dsThuoc(int idPhieuKham) {
        return this.phieuKhamRepository.dsThuoc(idPhieuKham);
    }

    @Override
    public boolean xacNhanThanhToan(int idpk) {
        return this.phieuKhamRepository.xacNhanThanhToan(idpk);
    }

    @Override
    public List<Phieukham> dsLichKham(int idBacSi) {
        return this.phieuKhamRepository.dsLichKham(idBacSi);
    }
    
    
}
