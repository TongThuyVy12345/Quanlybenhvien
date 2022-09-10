/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.pojo.Thuoc;
import com.mycompany.service.PhieuKhamService;
import com.mycompany.service.ThuocService;
import com.mycompany.controller.ApiBacSi;
import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.http.impl.bootstrap.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
public class BacSiController {

    @Autowired
    private ApiBacSi apiBacSi;

    @Autowired
    private Environment env;

    @Autowired
    private ThuocService thuocService;

    @Autowired
    private UserService userService;

    @Autowired
    private PhieuKhamService phieuKhamService;

    @GetMapping("/bacsi/lichkham")
    public String lichkham(Model model, HttpServletRequest request) {
        Nguoidung user = (Nguoidung) request.getSession().getAttribute("currentUser");
        if (user != null) {
            try {
                model.addAttribute("dsPhieuKham", this.phieuKhamService.dsLichKham(user.getIdNguoiDung()));
            } catch (Exception ex) {
                model.addAttribute("bug", ex);
            }
        }
        return "lichKham";
    }

    @RequestMapping("/bacsi/lichkham/{idphieukham}")
    public String bacSi(@PathVariable(value = "idphieukham") int idphieukham, Model model, @RequestParam Map<String, String> ds, HttpSession session) {
        Map<Integer, Thuoc> thuocs = (Map<Integer, Thuoc>) session.getAttribute("thuoc");

        try {
            if (!ds.containsKey("timTheoTen") && !ds.containsKey("timTheoID")) {
                model.addAttribute("getThuocByName", this.thuocService.getThuocByName(""));
            } else {//tÃ¬m thuá»‘c

                if (ds.containsKey("timTheoTen")) {
                    model.addAttribute("getThuocByName", this.thuocService.getThuocByName(ds.get("timTheoTen")));
                }

                if (ds.containsKey("timTheoID") && ds.get("timTheoID").length() > 0) {
                    model.addAttribute("getThuocByID", this.thuocService.getThuocByID(Integer.parseInt(ds.get("timTheoID"))));
                }
            }
            // Ä‘Æ°a dsthuoc táº¡m lÃªn view
            if (thuocs != null) {
                model.addAttribute("dsThuoc", thuocs.values());
            } else {
                thuocs = new HashMap<>();
                session.setAttribute("thuoc", thuocs);
            }

            Phieukham pk = this.phieuKhamService.getPhieuKhamByID(idphieukham);
            int idnguoidung = pk.getIdBenhNhan().getIdNguoiDung();
            Nguoidung nguoidung = this.userService.getUserByID(idnguoidung);
            
            
            List<Phieukham> dspk=this.phieuKhamService.getPKbyIDUser(pk.getIdBenhNhan().getIdNguoiDung());
            dspk.remove(pk);
            
            model.addAttribute("benhnhan", nguoidung);
            model.addAttribute("benhAns", dspk);
        } catch (Exception ex) {
            model.addAttribute("bug", ex);
        }

        return "bacSi";
    }

    @PostMapping("/bacsi/lichkham/{idphieukham}")
    public String raToa(@PathVariable(value = "idphieukham") int idphieukham, Model model, HttpSession session, @RequestParam Map<String, String> kham) {
        if (kham != null) {
            if(kham.containsKey("timTheoTen")||kham.containsKey("timTheoID"))
            {
                kham.remove("timTheoTen");
                kham.remove("timTheoID");
            }
            if (kham.containsKey("ketLuan"))//cap nhat ket luan
            {
                String trieuChung = kham.get("trieuChung");
                String ketLuan = kham.get("ketLuan");
                this.phieuKhamService.updateChuanDoan(idphieukham, trieuChung, ketLuan);
            } else//cap nhat thuoc
            {
                Map<Integer, Integer> ds = new HashMap<>();
                for (Map.Entry<String, String> entry : kham.entrySet()) {
                    String key = entry.getKey();
                    String val = entry.getValue();
                    try {
                        if (Integer.parseInt(key) > 0) {
                            ds.put(Integer.parseInt(key), Integer.parseInt(val));
                            this.apiBacSi.deleteThuoc(Integer.parseInt(key), session);
                        }
                    } catch (Exception ex) {
                        model.addAttribute("bug", ex);

                    }
                }
                this.phieuKhamService.updateDSThuoc(idphieukham, ds);
            }
        }
        return "bacSi";
    }

}
