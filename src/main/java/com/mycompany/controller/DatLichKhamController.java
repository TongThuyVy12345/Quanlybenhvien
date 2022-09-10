/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.service.DatLichKhamService;
import com.mycompany.service.QLNguoiDungService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import static javax.swing.text.html.parser.DTDConstants.SYSTEM;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("datlichkham")
public class DatLichKhamController {

    @Autowired
    private QLNguoiDungService qlNguoiDungService;
    @Autowired
    private DatLichKhamService datLichKhamService;

//    @Autowired
//    MailSender mailSender;
    @GetMapping("/lichkham")
    public String form_LK(Model model) {
        model.addAttribute("PLK", new Phieukham());
        return "Book";
    }

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("dsND", this.qlNguoiDungService.dsND());
    }

    @PostMapping("/lichkham")
    public String addLichKham(Model model,
            @ModelAttribute(value = "PLK") Phieukham p
    ) {
        if (this.datLichKhamService.addLichKham(p) == true) {
            model.addAttribute("okMg", "THANH CONG");
            return "redirect:/datlichkham/lichkham";
        } else {
            model.addAttribute("errMg", "DA XAY RA LOI VUI LONG QUAY LAI SAU");
        }
        return "Book";
    }
//    public void mailSender(int idPhieuKham) {
//        Phieukham lichkham = this.datLichKhamService.getPhieuKhamById(idPhieuKham);
//        SimpleMailMessage m = new SimpleMailMessage();
//        m.setFrom("tongthuydy2703@gmail.com");
//        m.setTo(lichkham.getMail());
//        m.setSubject("Xác nhận đăng ký lịch khám thành công");
//        m.setText("Khách hàng vui lòng đến đúng thời điểm đã đăng ký trong lịch khám");
//       
//    }

}
