/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojo.Thuoc;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ThuocRepository {
    List<Thuoc> getThuocByName(String tenThuoc);
    Thuoc getThuocByID(int idThuoc);
    
}
