/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "phieukham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phieukham.findAll", query = "SELECT p FROM Phieukham p"),
    @NamedQuery(name = "Phieukham.findByIdPhieuKham", query = "SELECT p FROM Phieukham p WHERE p.idPhieuKham = :idPhieuKham"),
    @NamedQuery(name = "Phieukham.findByNgayKham", query = "SELECT p FROM Phieukham p WHERE p.ngayKham = :ngayKham"),
    @NamedQuery(name = "Phieukham.findByTienKham", query = "SELECT p FROM Phieukham p WHERE p.tienKham = :tienKham"),
    @NamedQuery(name = "Phieukham.findByTrieuChung", query = "SELECT p FROM Phieukham p WHERE p.trieuChung = :trieuChung"),
    @NamedQuery(name = "Phieukham.findByKetLuan", query = "SELECT p FROM Phieukham p WHERE p.ketLuan = :ketLuan"),
    @NamedQuery(name = "Phieukham.findByIsThanhToan", query = "SELECT p FROM Phieukham p WHERE p.isThanhToan = :isThanhToan"),
    @NamedQuery(name = "Phieukham.findByActive", query = "SELECT p FROM Phieukham p WHERE p.active = :active")})
public class Phieukham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPhieuKham")
    private Integer idPhieuKham;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngayKham")
    @DateTimeFormat(pattern = "yyyy-mm-dd")

    @Temporal(TemporalType.DATE)
    private Date ngayKham;
    @Column(name = "tienKham")
    private Long tienKham;
    @Size(max = 255)
    @Column(name = "trieuChung")
    private String trieuChung;
    @Size(max = 100)
    @Column(name = "ketLuan")
    private String ketLuan;
    @Column(name = "isThanhToan")
    private Boolean isThanhToan;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "idBacSi", referencedColumnName = "idNguoiDung")
    @ManyToOne(optional = false)
    private Nguoidung idBacSi;
    @JoinColumn(name = "idBenhNhan", referencedColumnName = "idNguoiDung")
    @ManyToOne(optional = false)
    private Nguoidung idBenhNhan;
    @JoinColumn(name = "xacNhanBoiYTa", referencedColumnName = "idNguoiDung")
    @ManyToOne
    private Nguoidung xacNhanBoiYTa;

    public Phieukham() {
    }

    public Phieukham(Integer idPhieuKham) {
        this.idPhieuKham = idPhieuKham;
    }

    public Phieukham(Integer idPhieuKham, Date ngayKham) {
        this.idPhieuKham = idPhieuKham;
        this.ngayKham = ngayKham;
    }

    public Integer getIdPhieuKham() {
        return idPhieuKham;
    }

    public void setIdPhieuKham(Integer idPhieuKham) {
        this.idPhieuKham = idPhieuKham;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public Long getTienKham() {
        return tienKham;
    }

    public void setTienKham(Long tienKham) {
        this.tienKham = tienKham;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String getKetLuan() {
        return ketLuan;
    }

    public void setKetLuan(String ketLuan) {
        this.ketLuan = ketLuan;
    }

    public Boolean getIsThanhToan() {
        return isThanhToan;
    }

    public void setIsThanhToan(Boolean isThanhToan) {
        this.isThanhToan = isThanhToan;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Nguoidung getIdBacSi() {
        return idBacSi;
    }

    public void setIdBacSi(Nguoidung idBacSi) {
        this.idBacSi = idBacSi;
    }

    public Nguoidung getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(Nguoidung idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public Nguoidung getXacNhanBoiYTa() {
        return xacNhanBoiYTa;
    }

    public void setXacNhanBoiYTa(Nguoidung xacNhanBoiYTa) {
        this.xacNhanBoiYTa = xacNhanBoiYTa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPhieuKham != null ? idPhieuKham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phieukham)) {
            return false;
        }
        Phieukham other = (Phieukham) object;
        if ((this.idPhieuKham == null && other.idPhieuKham != null) || (this.idPhieuKham != null && !this.idPhieuKham.equals(other.idPhieuKham))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idPhieuKham ;
    }

}
