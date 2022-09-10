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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "phieukhamthuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phieukhamthuoc.findAll", query = "SELECT p FROM Phieukhamthuoc p"),
    @NamedQuery(name = "Phieukhamthuoc.findByIdPhieuKhamThuoc", query = "SELECT p FROM Phieukhamthuoc p WHERE p.idPhieuKhamThuoc = :idPhieuKhamThuoc"),
    @NamedQuery(name = "Phieukhamthuoc.findByGiaThuoc", query = "SELECT p FROM Phieukhamthuoc p WHERE p.giaThuoc = :giaThuoc"),
    @NamedQuery(name = "Phieukhamthuoc.findBySoLuong", query = "SELECT p FROM Phieukhamthuoc p WHERE p.soLuong = :soLuong")})
public class Phieukhamthuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPhieuKhamThuoc")
    private Integer idPhieuKhamThuoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giaThuoc")
    private long giaThuoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soLuong")
    private int soLuong;
    @JoinColumn(name = "idPhieuKham", referencedColumnName = "idPhieuKham")
    @ManyToOne(optional = false)
    private Phieukham idPhieuKham;
    @JoinColumn(name = "idThuoc", referencedColumnName = "idThuoc")
    @ManyToOne(optional = false)
    private Thuoc idThuoc;

    public Phieukhamthuoc() {
    }

    public Phieukhamthuoc(Integer idPhieuKhamThuoc) {
        this.idPhieuKhamThuoc = idPhieuKhamThuoc;
    }

    public Phieukhamthuoc(Integer idPhieuKhamThuoc, long giaThuoc, int soLuong) {
        this.idPhieuKhamThuoc = idPhieuKhamThuoc;
        this.giaThuoc = giaThuoc;
        this.soLuong = soLuong;
    }

    public Integer getIdPhieuKhamThuoc() {
        return idPhieuKhamThuoc;
    }

    public void setIdPhieuKhamThuoc(Integer idPhieuKhamThuoc) {
        this.idPhieuKhamThuoc = idPhieuKhamThuoc;
    }

    public long getGiaThuoc() {
        return giaThuoc;
    }

    public void setGiaThuoc(long giaThuoc) {
        this.giaThuoc = giaThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Phieukham getIdPhieuKham() {
        return idPhieuKham;
    }

    public void setIdPhieuKham(Phieukham idPhieuKham) {
        this.idPhieuKham = idPhieuKham;
    }

    public Thuoc getIdThuoc() {
        return idThuoc;
    }

    public void setIdThuoc(Thuoc idThuoc) {
        this.idThuoc = idThuoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhieuKhamThuoc != null ? idPhieuKhamThuoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phieukhamthuoc)) {
            return false;
        }
        Phieukhamthuoc other = (Phieukhamthuoc) object;
        if ((this.idPhieuKhamThuoc == null && other.idPhieuKhamThuoc != null) || (this.idPhieuKhamThuoc != null && !this.idPhieuKhamThuoc.equals(other.idPhieuKhamThuoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " " + idPhieuKhamThuoc ;
    }
    
}
