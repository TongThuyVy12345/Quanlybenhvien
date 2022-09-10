/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.pojo.Thuoc;
import com.mycompany.service.QLLoaiThuocService;
import com.mycompany.service.QLThuocService;
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
@RequestMapping("/admin/quanlyT")
public class QLThuocController {

    @Autowired
    private QLThuocService qLThuocService;
    @Autowired
    private QLLoaiThuocService qLLoaiThuocService;
    @Autowired
    private Environment env;

    @GetMapping("/thuoc")
    public String getT(Model model) {
        model.addAttribute("dsTGet", this.qLThuocService.dsT());
        return "QLT";
    }

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("dsLT", this.qLLoaiThuocService.dsLT
        ());
    }
    @GetMapping("/form_T")
    public String form_LT(Model model) {
        model.addAttribute("dsT", new Thuoc());
        return "Form_Thuoc";
    }

// POST form loai thuoc
    @PostMapping("/form_T")
    public String addThuoc(Model model,
            @ModelAttribute(value = "dsT") Thuoc p) {
        if (this.qLThuocService.addThuoc(p) == true) {
            return "redirect:/admin/quanlyT/thuoc";
        } else {
            model.addAttribute("errMg", "DA XAY RA LOI VUI LONG QUAY LAI SAU");
        }

        return "Form_Thuoc";
    }

    @GetMapping("/thuoc/delete/{idThuoc}")
    public String deleteThuocById(@PathVariable(value = "idThuoc") int idThuoc) {
        if (qLThuocService.deleteThuocById(idThuoc)) {
            return "redirect:/admin/quanlyT/thuoc";
        }
        return "QLT";

    }

}
