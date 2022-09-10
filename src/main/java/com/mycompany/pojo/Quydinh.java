/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "quydinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quydinh.findAll", query = "SELECT q FROM Quydinh q"),
    @NamedQuery(name = "Quydinh.findByIdQuydinh", query = "SELECT q FROM Quydinh q WHERE q.idQuydinh = :idQuydinh"),
    @NamedQuery(name = "Quydinh.findBySoBenhNhanToiDa", query = "SELECT q FROM Quydinh q WHERE q.soBenhNhanToiDa = :soBenhNhanToiDa")})
public class Quydinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idQuydinh")
    private Integer idQuydinh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soBenhNhanToiDa")
    private int soBenhNhanToiDa;

    public Quydinh() {
    }

    public Quydinh(Integer idQuydinh) {
        this.idQuydinh = idQuydinh;
    }

    public Quydinh(Integer idQuydinh, int soBenhNhanToiDa) {
        this.idQuydinh = idQuydinh;
        this.soBenhNhanToiDa = soBenhNhanToiDa;
    }

    public Integer getIdQuydinh() {
        return idQuydinh;
    }

    public void setIdQuydinh(Integer idQuydinh) {
        this.idQuydinh = idQuydinh;
    }

    public int getSoBenhNhanToiDa() {
        return soBenhNhanToiDa;
    }

    public void setSoBenhNhanToiDa(int soBenhNhanToiDa) {
        this.soBenhNhanToiDa = soBenhNhanToiDa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuydinh != null ? idQuydinh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quydinh)) {
            return false;
        }
        Quydinh other = (Quydinh) object;
        if ((this.idQuydinh == null && other.idQuydinh != null) || (this.idQuydinh != null && !this.idQuydinh.equals(other.idQuydinh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojo.Quydinh[ idQuydinh=" + idQuydinh + " ]";
    }
    
}
