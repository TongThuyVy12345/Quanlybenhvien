package com.mycompany.pojo;

import com.mycompany.pojo.Loaithuoc;
import com.mycompany.pojo.Phieukhamthuoc;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-09T15:50:46")
@StaticMetamodel(Thuoc.class)
public class Thuoc_ { 

    public static volatile CollectionAttribute<Thuoc, Phieukhamthuoc> phieukhamthuocCollection;
    public static volatile SingularAttribute<Thuoc, Loaithuoc> idLoaiThuoc;
    public static volatile SingularAttribute<Thuoc, String> cachDung;
    public static volatile SingularAttribute<Thuoc, Integer> idThuoc;
    public static volatile SingularAttribute<Thuoc, Boolean> active;
    public static volatile SingularAttribute<Thuoc, String> tenThuoc;
    public static volatile SingularAttribute<Thuoc, Long> gia;

}