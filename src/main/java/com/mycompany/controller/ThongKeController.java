 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mycompany.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@RequestMapping("/admin")
public class ThongKeController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/thongke-nd")
    public String thongkenguoidung(Model model) {
        model.addAttribute("nguoidungstats", this.statsService.catetStats());
        return "TKND";
    }

    @GetMapping("/thongke-pk")
    public String thongkephieukham(Model model, @RequestParam(required = false) Map<String, String> params) throws Exception {
        String kw = params.getOrDefault("kw", null);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        model.addAttribute("phieukhamstats", this.statsService.phieukhamStats(kw, fromDate, toDate));
        return "TKPK";
    }

    @GetMapping("/thongke-t")
    public String thongkethuoc(Model model,@RequestParam(required = false) Map<String,String> params)throws Exception

    {
        String kw = params.getOrDefault("kw", null);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        Date fromDate = null, toDate = null;
        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = f.parse(from);
            }

            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = f.parse(to);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        model.addAttribute("tssdthuocStats", this.statsService.tssdthuocStats(kw, fromDate, toDate));
        return "TKT";
    }
}
