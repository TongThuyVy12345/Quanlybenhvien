package com.mycompany.pojo;

import com.mycompany.pojo.Thuoc;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-09T15:50:46")
@StaticMetamodel(Loaithuoc.class)
public class Loaithuoc_ { 

    public static volatile CollectionAttribute<Loaithuoc, Thuoc> thuocCollection;
    public static volatile SingularAttribute<Loaithuoc, Integer> idLoaiThuoc;
    public static volatile SingularAttribute<Loaithuoc, String> tenLoaiThuoc;
    public static volatile SingularAttribute<Loaithuoc, Boolean> active;

}