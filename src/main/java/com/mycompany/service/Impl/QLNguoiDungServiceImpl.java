package com.mycompany.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojo.Nguoidung;
import com.mycompany.pojo.Phieukham;
import com.mycompany.repository.QLNguoiDungRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.repository.QLPhieuKhamRepository;
import com.mycompany.repository.UserRepository;
import java.util.Map;
import com.mycompany.service.QLNguoiDungService;
import java.io.IOException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author ASUS
 */
@Service
public class QLNguoiDungServiceImpl implements QLNguoiDungService {

    @Autowired
    private QLNguoiDungRepository qLNguoiDungRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
//   

//   
    @Override
    public List<Nguoidung> dsND() {
        return this.qLNguoiDungRepository.dsND();
    }

    @Override
    public boolean addNguoiDung(Nguoidung nguoidung) {
        String matkhau = nguoidung.getMatKhau();
        nguoidung.setMatKhau(this.passwordEncoder.encode(matkhau));
        nguoidung.setActive(Boolean.TRUE);

        try {
            Map r = this.cloudinary.uploader().upload(nguoidung.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            nguoidung.setAvatar((String) r.get("secure_url"));
            return this.qLNguoiDungRepository.addNguoiDung(nguoidung);

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean deleteNguoiDungById(int idNguoiDung) {
        return this.qLNguoiDungRepository.deleteNguoiDungById(idNguoiDung);
    }
}
