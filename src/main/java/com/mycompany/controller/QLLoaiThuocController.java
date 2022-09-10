/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.pojo.Loaithuoc;
import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.service.QLLoaiThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.service.QLNguoiDungService;
import com.mycompany.service.QLPhieuKhamService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.validation.Valid;
import org.apache.http.protocol.HTTP;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
@ControllerAdvice
@RequestMapping("admin/quanlyLT")
public class QLLoaiThuocController {

//    @Autowired
//    private QLNguoiDungService qlNguoiDungService;
    @Autowired
    private QLLoaiThuocService qLLoaiThuocService;
    @Autowired
    private Environment env;

    @GetMapping("/loaithuoc")
    public String getLT(Model model
    ) {
//        String kw=params.getOrDefault("kw", null);
//        int page=Integer.parseInt(params.getOrDefault("page","1"));   
        model.addAttribute("dsLT", this.qLLoaiThuocService.dsLT());
        return "QLLT";
    }
// GET form loai thuoc

    @GetMapping("/form_LT")
    public String form_LT(Model model) {
        model.addAttribute("dsLTF", new Loaithuoc());
        return "Form_LoaiThuoc";
    }

// POST form loai thuoc
    @PostMapping("/form_LT")
    public String addLoaiThuoc(Model model,
            @ModelAttribute(value = "dsLTF") Loaithuoc p) {
        if (this.qLLoaiThuocService.addLoaiThuoc(p) == true) {
            return "redirect:/admin/quanlyLT/loaithuoc";
        } else {
            model.addAttribute("errMg", "DA XAY RA LOI VUI LONG QUAY LAI SAU");
        }

        return "Form_LoaiThuoc";
    }

    @GetMapping("/loaithuoc/delete/{idLoaiThuoc}")
    public String deleteRouteById(@PathVariable(value = "idLoaiThuoc") int idLoaiThuoc) {
        if (qLLoaiThuocService.deleteLoaiThuocById(idLoaiThuoc)) {
            return "redirect:/admin/quanlyLT/loaithuoc";
        }

        return "QLLT";
    }

    @GetMapping("/loaithuoc/update/{idLoaiThuoc}")
    public String update_LT(Model model, @PathVariable(value = "idLoaiThuoc") int idLoaiThuoc) {
        model.addAttribute("dsLTU", this.qLLoaiThuocService.getLoaiThuocbyID(idLoaiThuoc));
        return "Update_LoaiThuoc";
    }

//    @PostMapping("/loaithuoc/update")
//    public String updateCompanyinfo(@PathVariable(value = "idLoaiThuoc") int idLoaiThuoc,
//            @ModelAttribute(value = "dsLTU") Loaithuoc lt) {
//        if (this.qLLoaiThuocService.addLoaiThuoc(lt) == true) {
//            lt.setTenLoaiThuoc(lt.getTenLoaiThuoc());
//            return "redirect:/admin/quanlyLT/loaithuoc";
//        }
//
//        return "QLLT";
//    }

}
