/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.Impl;

import com.mycompany.pojo.Thuoc;
import com.mycompany.repository.ThuocRepository;
import com.mycompany.service.ThuocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class ThuocServiceImpl implements ThuocService{

    @Autowired
    private ThuocRepository thuocRepository;
    
    @Override
    public List<Thuoc> getThuocByName(String tenThuoc) {
        return thuocRepository.getThuocByName(tenThuoc);
    }

    @Override
    public Thuoc getThuocByID(int idThuoc) {
        return thuocRepository.getThuocByID(idThuoc);
    }
    
}
