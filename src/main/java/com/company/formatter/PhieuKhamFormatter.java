/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.formatter;

import com.mycompany.pojo.Phieukham;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class PhieuKhamFormatter implements Formatter<Phieukham> {

    @Override
    public String print(Phieukham t, Locale locale) {
        return String.valueOf(t.getIdPhieuKham());

    }

    @Override
    public Phieukham parse(String idPhieuKham, Locale locale) throws ParseException {

        Phieukham c = new Phieukham();
        c.setIdPhieuKham(Integer.parseInt(idPhieuKham));
        return c;
    }

}
