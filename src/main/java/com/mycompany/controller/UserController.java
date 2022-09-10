/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class UserController {
   

    @Autowired
    private UserService userDetailsService;

    @GetMapping("/dangnhap")
    public String dangnhap() {
        return "dangnhap";
    }

    @PostMapping("/dangnhap")
    public String add() {
        
        return "dangnhap";
    }

    @GetMapping("/dangky")
    public String dangkyView(Model model) {
        model.addAttribute("nguoidung", new Nguoidung());
        return "dangky";
    }

    @PostMapping("/dangky")
    public String dangky(Model model,
            @ModelAttribute(value = "nguoidung") @Valid Nguoidung nguoidung,
            BindingResult result) {
        if (result.hasErrors()){
        return "dangky";
        }
        else
        { if (nguoidung.getMatKhau().isEmpty()
                || nguoidung.getMatKhau().equals(nguoidung.getConfirmmatKhau())) {
            
            if (this.userDetailsService.addUser(nguoidung) == true) 
            {
                return "redirect:/dangnhap";
            }else  
                model.addAttribute("errMg", "DA XAY RA LOI VUI LONG QUAY LAI SAU");
        } else 
            model.addAttribute("errMg", "MAT KHAU KHONG KHOP");
        
        }
       
    return "dangky";
    
}}



