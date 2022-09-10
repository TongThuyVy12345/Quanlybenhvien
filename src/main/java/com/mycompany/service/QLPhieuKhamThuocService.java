/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.pojo.Phieukhamthuoc;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface QLPhieuKhamThuocService {

    List<Phieukhamthuoc> dsPKT();

    boolean addPhieuKhamThuoc(Phieukhamthuoc phieukhamthuoc);

}
