/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojo.Thuoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface QLThuocRepository {

    List<Thuoc> dsT();

    boolean deleteThuocById(int idThuoc);

    boolean addThuoc(Thuoc thuoc);
}
