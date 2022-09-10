/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.formatter;

import com.mycompany.pojo.Loaithuoc;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class LoaiThuocFormatter implements Formatter<Loaithuoc> {

    @Override
    public String print(Loaithuoc t, Locale locale) {
        return String.valueOf(t.getIdLoaiThuoc());

    }

    @Override
    public Loaithuoc parse(String idLoaiThuoc, Locale locale) throws ParseException {

        Loaithuoc c = new Loaithuoc();
        c.setIdLoaiThuoc(Integer.parseInt(idLoaiThuoc));
        return c;
    }

}
