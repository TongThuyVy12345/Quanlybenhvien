/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.handler;

import com.mycompany.pojo.Nguoidung;
import com.mycompany.service.QLNguoiDungService;
import com.mycompany.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService UserDetailsService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        Nguoidung u = this.UserDetailsService.getNguoidungs(a.getName()).get(0);
        request.getSession().setAttribute("currentUser", u);
        response.sendRedirect("/btljava");
    }
    
}
