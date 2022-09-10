
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

;

/**
 *
 * @author ADMIN
 */
@Configuration
@EnableTransactionManagement
@EnableWebSecurity
@ComponentScan(basePackages = {
    "com.mycompany.repository",
    "com.mycompany.service",
    "com.mycompany.controller",
    "com.mycompany.validator"
})

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary clo;
        clo = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dbevamq2u",
                "api_key", "724382329795156",
                "api_secret", "Mhx_7ca9sztbZqsO--p8tG5ofMI",
                "secure", true));
        return clo;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll().and()
                .formLogin().loginPage("/dangnhap")
                .defaultSuccessUrl("/")
                .failureUrl("/dangnhap?error")
                .usernameParameter("taiKhoan")
                .passwordParameter("matKhau").and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/dangnhap");
        http.formLogin().successHandler(this.loginSuccessHandler);
        http.logout().logoutSuccessUrl("/dangnhap");
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_SUPERADMIN')")
                .antMatchers("/superadmin/**").access("hasRole('ROLE_SUPERADMIN')")
                .antMatchers("/phieukham/xacnhan/**").access("hasRole('ROLE_YTA')")
                .antMatchers("/phieukham/thanhtoan/**").access("hasRole('ROLE_YTA')")
                .antMatchers("/phieukham/**").access("hasRole('ROLE_BACSI')")
                .antMatchers("/bacsi/lichkham/**").access("hasRole('ROLE_BACSI')")
                .antMatchers("/api/Thuoc/**").access("hasRole('ROLE_BACSI')")
                .antMatchers("/datlichkham/lichkham/**").access("hasRole('ROLE_NGUOIDUNG')")
                .and().exceptionHandling().accessDeniedPage("/error");
        http.csrf().disable();
    }

}
