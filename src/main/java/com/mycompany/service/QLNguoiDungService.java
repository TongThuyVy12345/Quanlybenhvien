/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.pojo.Nguoidung;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface QLNguoiDungService {

    List<Nguoidung> dsND();

    boolean deleteNguoiDungById(int idNguoiDung);

    boolean addNguoiDung(Nguoidung nguoidung);

}
