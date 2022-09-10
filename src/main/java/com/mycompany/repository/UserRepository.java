/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojo.Nguoidung;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface UserRepository {

    boolean addUSer(Nguoidung nguoidung);
    Nguoidung getUserByID(int idUser);
    List<Nguoidung> getNguoidungs(String taiKhoan);

    
}
