/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
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
@RequestMapping("/admin/quanlyPK")
public class QLPhieuKhamController {

    @Autowired
    private QLNguoiDungService qlNguoiDungService;
    @Autowired
    private QLPhieuKhamService qLPhieuKhamService;
    @Autowired
    private Environment env;

    @GetMapping("/phieukham")
    public String getPK(Model model) {
        model.addAttribute("dsPK", this.qLPhieuKhamService.dsPK());
        return "QLPK";
    }

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("dsND", this.qlNguoiDungService.dsND());
    }

    @GetMapping("/form_PK")
    public String form_PK(Model model) {
        model.addAttribute("dsPKF", new Phieukham());
        return "Form_PhieuKham";
    }
// POST form phiêu khám

    @PostMapping("/form_PK")
    public String addPhieuKham(Model model,
            @ModelAttribute(value = "dsPKF") Phieukham p
    ) {

        if (this.qLPhieuKhamService.addPhieuKham(p) == true) {
            return "redirect:/admin/quanlyPK/phieukham";
        } else {
            model.addAttribute("errMg", "DA XAY RA LOI VUI LONG QUAY LAI SAU");
        }

        return "Form_PhieuKham";
    }

    @GetMapping("/phieukham/delete/{idPhieuKham}")
    public String deletePhieuKhamById(@PathVariable(value = "idPhieuKham") int idPhieuKham) {
        if (qLPhieuKhamService.deletePhieuKhamById(idPhieuKham)) {
            return "redirect:/admin/quanlyPK/phieukham";
        }

        return "QLPK";

    }

}
