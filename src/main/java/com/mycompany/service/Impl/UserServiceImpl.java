/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojo.Nguoidung;
import com.mycompany.repository.UserRepository;
import com.mycompany.service.UserService;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
//   

    @Override
    public boolean addUser(Nguoidung nguoidung) {
        String matkhau = nguoidung.getMatKhau();
        nguoidung.setMatKhau(this.passwordEncoder.encode(matkhau));
        nguoidung.setUserRole(Nguoidung.USER);
        nguoidung.setActive(Boolean.TRUE);
        try {
            Map r = this.cloudinary.uploader().upload(nguoidung.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            nguoidung.setAvatar((String) r.get("secure_url"));
            return this.userRepository.addUSer(nguoidung);

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String taiKhoan) throws UsernameNotFoundException {

        List<Nguoidung> nguoidungs = this.getNguoidungs(taiKhoan);
        if (nguoidungs.isEmpty()) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại");
        }

        Nguoidung nguoidung = nguoidungs.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(nguoidung.getUserRole()));
        return new org.springframework.security.core.userdetails.User(nguoidung.getTaiKhoan(), nguoidung.getMatKhau(), auth);

    }

    @Override
    public List<Nguoidung> getNguoidungs(String taiKhoan) {
        return this.userRepository.getNguoidungs(taiKhoan);
    }

    @Override
    public Nguoidung getUserByID(int idUser) {
        return this.userRepository.getUserByID(idUser);
    }

}
