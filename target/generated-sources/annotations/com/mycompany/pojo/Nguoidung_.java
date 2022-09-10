package com.mycompany.pojo;

import com.mycompany.pojo.Phieukham;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-09T15:50:46")
@StaticMetamodel(Nguoidung.class)
public class Nguoidung_ { 

    public static volatile SingularAttribute<Nguoidung, String> taiKhoan;
    public static volatile SingularAttribute<Nguoidung, String> matKhau;
    public static volatile SingularAttribute<Nguoidung, String> sdt;
    public static volatile SingularAttribute<Nguoidung, String> tenNguoiDung;
    public static volatile CollectionAttribute<Nguoidung, Phieukham> phieukhamCollection1;
    public static volatile CollectionAttribute<Nguoidung, Phieukham> phieukhamCollection2;
    public static volatile SingularAttribute<Nguoidung, Boolean> active;
    public static volatile SingularAttribute<Nguoidung, String> avatar;
    public static volatile SingularAttribute<Nguoidung, String> gioiTinh;
    public static volatile SingularAttribute<Nguoidung, String> diaChi;
    public static volatile SingularAttribute<Nguoidung, Date> ngaySinh;
    public static volatile SingularAttribute<Nguoidung, String> userRole;
    public static volatile CollectionAttribute<Nguoidung, Phieukham> phieukhamCollection;
    public static volatile SingularAttribute<Nguoidung, Integer> idNguoiDung;
    public static volatile SingularAttribute<Nguoidung, String> email;

}