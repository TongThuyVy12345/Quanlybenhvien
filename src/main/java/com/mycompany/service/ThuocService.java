/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.pojo.Thuoc;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ThuocService {
    List<Thuoc> getThuocByName(String tenThuoc);
    Thuoc getThuocByID(int idThuoc);
}
