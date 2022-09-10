/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.Impl;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.repository.DatLichKhamRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.repository.QLPhieuKhamRepository;
import com.mycompany.service.DatLichKhamService;
import java.util.Map;
import com.mycompany.service.QLPhieuKhamService;

/**
 *
 * @author ASUS
 */
@Service
public class DatLichKhamServiceImpl implements DatLichKhamService {

    @Autowired
    private DatLichKhamRepository datLichKhamRepository;

    @Override
    public boolean addLichKham(Phieukham phieukham) {
        phieukham.setActive(Boolean.TRUE);
        return datLichKhamRepository.addLichKham(phieukham);
    }

    @Override
    public Phieukham getPhieuKhamById(int idPhieuKham) {
        return this.datLichKhamRepository.getPhieuKhamById(idPhieuKham);
    }

}
