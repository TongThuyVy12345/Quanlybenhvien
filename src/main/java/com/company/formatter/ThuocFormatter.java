/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.formatter;

import com.mycompany.pojo.Thuoc;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class ThuocFormatter implements Formatter<Thuoc> {

    @Override
    public String print(Thuoc t, Locale locale) {
        return String.valueOf(t.getIdThuoc());

    }

    @Override
    public Thuoc parse(String idThuoc, Locale locale) throws ParseException {

        Thuoc c = new Thuoc();
        c.setIdThuoc(Integer.parseInt(idThuoc));
        return c;
    }

}
