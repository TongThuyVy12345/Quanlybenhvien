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
@RequestMapping("/admin/quanlyND")
public class QLNguoiDungController {

    @Autowired
    private QLNguoiDungService qlNguoiDungService;
    @Autowired
    private Environment env;

    @GetMapping("/nguoidung")
    public String getND(Model model) {
        model.addAttribute("dsND", this.qlNguoiDungService.dsND());
        return "QLND";
    }

    @GetMapping("/form_ND")
    public String form_ND(Model model) {
        model.addAttribute("dsNDF", new Nguoidung());
        return "Form_NguoiDung";
    }

    @PostMapping("/form_ND")
    public String addNguoiDung(Model model,
            @ModelAttribute(value = "dsNDF") Nguoidung p
    ) {
        if (this.qlNguoiDungService.addNguoiDung(p) == true) {
            return "redirect:/admin/quanlyND/nguoidung";
        } else {
            model.addAttribute("errMg", "DA XAY RA LOI VUI LONG QUAY LAI SAU");
        }

        return "Form_NguoiDung";
    }

    @GetMapping("/nguoidung/delete/{idNguoiDung}")
    public String deleteNguoiDungById(@PathVariable(value = "idNguoiDung") int idNguoiDung) {
        if (qlNguoiDungService.deleteNguoiDungById(idNguoiDung)) {
            return "redirect:/admin/quanlyND/nguoidung";
        }

        return "QLND";

    }

}
