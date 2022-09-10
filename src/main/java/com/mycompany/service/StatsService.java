/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface StatsService {

    List<Object[]> catetStats();

    List<Object[]> phieukhamStats(String kw, Date fromDate, Date toDate);

    List<Object[]> tssdthuocStats(String kw, Date fromDate, Date toDate);

}
