/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.formatter;

import com.mycompany.pojo.Nguoidung;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
/**
 *
 * @author ADMIN
 */
public class NguoiDungFormatter implements Formatter<Nguoidung> {
    @Override
    public String print(Nguoidung t, Locale locale) {
        return String.valueOf(t.getIdNguoiDung());
    }

    @Override
    public Nguoidung parse(String idNguoiDung, Locale locale) throws ParseException {
        Nguoidung c = new Nguoidung();
        c.setIdNguoiDung(Integer.parseInt(idNguoiDung));
        return c;
    }

}
