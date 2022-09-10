/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.pojo.Phieukhamthuoc;
import com.mycompany.pojo.Thuoc;
import com.mycompany.service.PhieuKhamService;
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
import com.mycompany.service.QLPhieuKhamThuocService;
import com.mycompany.service.QLThuocService;
import java.text.SimpleDateFormat;
import javax.validation.Valid;
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
@RequestMapping("/admin/quanlyPKT")
public class QLPhieuKhamThuocController {

    @Autowired
    private QLThuocService qLThuocService;
    @Autowired
    private QLPhieuKhamService qLPhieuKhamService;

    @Autowired
    private QLPhieuKhamThuocService qLPhieuKhamThuocService;
    @Autowired
    private Environment env;

    @GetMapping("/phieukhamthuoc")
    public String getPKT(Model model) {
        model.addAttribute("dsPKT", this.qLPhieuKhamThuocService.dsPKT());
        return "QLPKT";
    }

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("dsTGet", this.qLThuocService.dsT());
        model.addAttribute("dsPK", this.qLPhieuKhamService.dsPK());

    }

   

    @GetMapping("/form_PKT")
    public String form_PKT(Model model) {
        model.addAttribute("dsPKT", new Phieukhamthuoc());
        return "Form_PhieuKhamThuoc";
    }

// POST form loai thuoc
    @PostMapping("/form_PKT")
    public String addPhieuKhamThuoc(Model model,
            @ModelAttribute(value = "dsPKT") Phieukhamthuoc p) {
        if (this.qLPhieuKhamThuocService.addPhieuKhamThuoc(p) == true) {
            return "redirect:/admin/quanlyPKT/phieukhamthuoc";
        } else {
            model.addAttribute("errMg", "DA XAY RA LOI VUI LONG QUAY LAI SAU");
        }

        return "Form_PhieuKhamThuoc";
    }

}
