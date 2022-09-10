/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.pojo.Phieukhamthuoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface PhieuKhamRepository {
    List<Phieukham> dsDangKyPK();
    List<Phieukham> dsThanhToan();
    List<Phieukham> dsLichKham(int idBacSi);
    List<Phieukham> getPKbyIDUser(int id);
    boolean xacNhanPK(List<Integer> ids,int yta);
    Phieukham getPhieuKhamByID(int id);
    boolean updateChuanDoan(int id,String trieuChung,String ketLuan);
    boolean updateDSThuoc(int id,Map<Integer,Integer> ds);
    List<Phieukhamthuoc> dsThuoc(int idPhieuKham);
    boolean xacNhanThanhToan(int idpk);
}
