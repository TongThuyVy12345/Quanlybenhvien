/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service.Impl;

import java.util.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.repository.StatsRepository;
import com.mycompany.service.StatsService;

/**
 *
 * @author ADMIN
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> catetStats() {
        return this.statsRepository.catetStats();

    }

    @Override
    public List<Object[]> phieukhamStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.phieukhamStats(kw,fromDate,toDate);
    }

    @Override
    public List<Object[]> tssdthuocStats(String kw, Date fromDate, Date toDate) {
         return this.statsRepository.tssdthuocStats(kw,fromDate,toDate);
    }

}
