/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.pojo.Thuoc;
import com.mycompany.service.PhieuKhamService;
import com.mycompany.service.ThuocService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */

@RestController
public class ApiBacSi {

    @PostMapping("/api/Thuoc")
    public Map themThuoc(@RequestBody Thuoc thuoc, HttpSession session) {
        Map<Integer,Thuoc> thuocs = (Map<Integer,Thuoc>) session.getAttribute("thuoc");

        if (thuocs==null)
            thuocs =new HashMap<>();
        int thuocID = thuoc.getIdThuoc();
        if (!thuocs.containsKey(thuocID))
            thuocs.put(thuocID, thuoc);
        try{
            session.setAttribute("thuoc", thuocs);
        }catch(Exception ex){
            
        }
        
        return thuocs;
    }
    
    @DeleteMapping("/api/Thuoc/{idThuocxoa}")
    public void deleteThuoc(@PathVariable(value ="idThuocxoa")int idThuoc,HttpSession session)
    {
        Map<Integer,Thuoc> thuocs = (Map<Integer,Thuoc>) session.getAttribute("thuoc");
        if (thuocs!=null&& thuocs.containsKey(idThuoc))
        {
            thuocs.remove(idThuoc);
            session.setAttribute("thuoc", thuocs);
            System.err.println(idThuoc);
        }
    }
    
}
