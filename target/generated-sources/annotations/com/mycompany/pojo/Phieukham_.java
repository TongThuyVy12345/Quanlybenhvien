package com.mycompany.pojo;

import com.mycompany.pojo.Nguoidung;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-09T15:50:46")
@StaticMetamodel(Phieukham.class)
public class Phieukham_ { 

    public static volatile SingularAttribute<Phieukham, Long> tienKham;
    public static volatile SingularAttribute<Phieukham, String> trieuChung;
    public static volatile SingularAttribute<Phieukham, Integer> idPhieuKham;
    public static volatile SingularAttribute<Phieukham, Boolean> isThanhToan;
    public static volatile SingularAttribute<Phieukham, Boolean> active;
    public static volatile SingularAttribute<Phieukham, String> ketLuan;
    public static volatile SingularAttribute<Phieukham, Nguoidung> idBacSi;
    public static volatile SingularAttribute<Phieukham, Nguoidung> idBenhNhan;
    public static volatile SingularAttribute<Phieukham, Nguoidung> xacNhanBoiYTa;
    public static volatile SingularAttribute<Phieukham, Date> ngayKham;

}