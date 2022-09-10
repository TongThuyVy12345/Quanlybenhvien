/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.service.QLNguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/superadmin/quanlyAM")
public class QLAdminController {
    @Autowired
    private QLNguoiDungService qlNguoiDungService;
    @Autowired
    private Environment env;

    @GetMapping("/admin")
    public String getND(Model model) {
        model.addAttribute("dsAM", this.qlNguoiDungService.dsND());
        return "QLADMIN";
    }

    @GetMapping("/form_AM")
    public String form_AM(Model model) {
        model.addAttribute("dsAMF", new Nguoidung());
        return "Form_AMIN";
    }

    @PostMapping("/form_AM")
    public String addNguoiDung(Model model,
            @ModelAttribute(value = "dsAMF") Nguoidung p
    ) {
        if (this.qlNguoiDungService.addNguoiDung(p) == true) {
            return "redirect:/superadmin/quanlyAM/admin";
        } else {
            model.addAttribute("errMg", "DA XAY RA LOI VUI LONG QUAY LAI SAU");
        }

        return "Form_AMIN";
    }

    @GetMapping("/nguoidung/delete/{idNguoiDung}")
    public String deleteNguoiDungById(@PathVariable(value = "idNguoiDung") int idNguoiDung) {
        if (qlNguoiDungService.deleteNguoiDungById(idNguoiDung)) {
            return "redirect:/superadmin/quanlyAM/admin";
        }
        return "QLADMIN";

    }

}


