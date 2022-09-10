/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojo.Loaithuoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface QLLoaiThuocRepository {

    List<Loaithuoc> dsLT();

    boolean addLoaiThuoc(Loaithuoc loaithuoc);

    Loaithuoc getLoaiThuocbyID(int idLoaiThuoc);

    boolean deleteLoaiThuocById(int idLoaiThuoc);


}
