/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.pojo.Thuoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface QLThuocService {

    List<Thuoc> dsT();

    boolean addThuoc(Thuoc thuoc);

    boolean deleteThuocById(int idThuoc);

}
