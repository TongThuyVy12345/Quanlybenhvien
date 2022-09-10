/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.pojo.Loaithuoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface QLLoaiThuocService {

    List<Loaithuoc> dsLT();

    Loaithuoc getLoaiThuocbyID(int idLoaiThuoc);

    boolean addLoaiThuoc(Loaithuoc loaithuoc);

    boolean deleteLoaiThuocById(int idLoaiThuoc);

}
