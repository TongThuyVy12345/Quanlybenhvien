/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.pojo.Phieukhamthuoc;
import com.mycompany.service.PhieuKhamService;
import com.mycompany.service.ThuocService;
import com.mycompany.service.UserService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.persistence.NamedQueries;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/phieukham")
public class PhieuKhamController {

    @Autowired
    private Environment env;

    @Autowired
    private PhieuKhamService phieuKhamService;

    @Autowired
    private UserService userService;

    @Autowired
    private ThuocService thuocService;

    @GetMapping("/xacnhan")
    public String getDsXacNhan(Model model) {
        model.addAttribute("dsXacNhan", this.phieuKhamService.dsDangKyPK());
        return "xacNhanPK";
    }

    @GetMapping("/{idphieukham}")
    public String getDsXacNhan(Model model, @PathVariable(value = "idphieukham") int idphieukham) {
        try{
            Phieukham pk = this.phieuKhamService.getPhieuKhamByID(idphieukham);
            List<Phieukhamthuoc> dsThuoc = this.phieuKhamService.dsThuoc(idphieukham);
            long tongTien = 0;
            for (Phieukhamthuoc phieukhamthuoc : dsThuoc) {
                tongTien += phieukhamthuoc.getGiaThuoc() * phieukhamthuoc.getSoLuong();
            }

            int idnguoidung = pk.getIdBenhNhan().getIdNguoiDung();
            Nguoidung nguoidung = this.userService.getUserByID(idnguoidung);
            model.addAttribute("benhnhan", nguoidung);
            model.addAttribute("ttphieukham", this.phieuKhamService.getPhieuKhamByID(idphieukham));
            model.addAttribute("dsthuoc", dsThuoc);
            model.addAttribute("tongtien", tongTien);
        }catch(Exception ex){
            model.addAttribute("bug", ex);
        }
        
        return "phieukham";
    }

    @PostMapping("/xacnhan")
    public String xacnhan(Model model, @RequestParam Map<String, String> dsid, HttpServletRequest request) {
        List<Integer> ids = new ArrayList<Integer>();
        Nguoidung user = (Nguoidung) request.getSession().getAttribute("currentUser");

        if (dsid != null) {

            for (String key : dsid.values()) {
                ids.add(Integer.parseInt(key));
                try {
                    this.phieuKhamService.xacNhanPK(ids, user.getIdNguoiDung());
                    model.addAttribute("bug", 1);
                } catch (Exception ex) {
                    model.addAttribute("bug", ex);
                }
            }
        }
        return getDsXacNhan(model);
    }

    @GetMapping("/thanhtoan")
    public String getDsThanhToan(Model model) {

        List<Phieukham> dsphieukham = this.phieuKhamService.dsThanhToan();

        if (dsphieukham != null) {
            for (Phieukham phieukham : dsphieukham) {
                List<Phieukhamthuoc> pkt = this.phieuKhamService.dsThuoc(phieukham.getIdPhieuKham());
                long tongTien = 0;
                for (Phieukhamthuoc phieukhamthuoc : pkt) {
                    tongTien += phieukhamthuoc.getGiaThuoc() * phieukhamthuoc.getSoLuong();
                }
                phieukham.setTienKham(tongTien + phieukham.getTienKham());
            }
        }
        model.addAttribute("dsThanhToan", dsphieukham);
        return "xacNhanThanhToan";
    }

    @PostMapping("/thanhtoan")
    public String thanhToan(Model model, @ModelAttribute("idPhieuKham") int idphieukham) {
        try{
            
        }catch(Exception ex){
            model.addAttribute("bug", ex);
        }
            
        this.phieuKhamService.xacNhanThanhToan(idphieukham);
        return getDsThanhToan(model);
    }
}
