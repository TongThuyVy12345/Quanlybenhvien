/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "nguoidung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoidung.findAll", query = "SELECT n FROM Nguoidung n"),
    @NamedQuery(name = "Nguoidung.findByIdNguoiDung", query = "SELECT n FROM Nguoidung n WHERE n.idNguoiDung = :idNguoiDung"),
    @NamedQuery(name = "Nguoidung.findByTenNguoiDung", query = "SELECT n FROM Nguoidung n WHERE n.tenNguoiDung = :tenNguoiDung"),
    @NamedQuery(name = "Nguoidung.findByTaiKhoan", query = "SELECT n FROM Nguoidung n WHERE n.taiKhoan = :taiKhoan"),
    @NamedQuery(name = "Nguoidung.findByMatKhau", query = "SELECT n FROM Nguoidung n WHERE n.matKhau = :matKhau"),
    @NamedQuery(name = "Nguoidung.findByAvatar", query = "SELECT n FROM Nguoidung n WHERE n.avatar = :avatar"),
    @NamedQuery(name = "Nguoidung.findByGioiTinh", query = "SELECT n FROM Nguoidung n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "Nguoidung.findByUserRole", query = "SELECT n FROM Nguoidung n WHERE n.userRole = :userRole"),
    @NamedQuery(name = "Nguoidung.findByNgaySinh", query = "SELECT n FROM Nguoidung n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Nguoidung.findByEmail", query = "SELECT n FROM Nguoidung n WHERE n.email = :email"),
    @NamedQuery(name = "Nguoidung.findByDiaChi", query = "SELECT n FROM Nguoidung n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "Nguoidung.findBySdt", query = "SELECT n FROM Nguoidung n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "Nguoidung.findByActive", query = "SELECT n FROM Nguoidung n WHERE n.active = :active")})
public class Nguoidung implements Serializable {

    @Transient
    private String confirmmatKhau;
    @Transient
    private MultipartFile file;

    public static final String SUPERADMIN = "ROLE_SUPERADMIN";
    public static final String ADMIN = "ROLE_ADMIN";

    public static final String USER = "ROLE_NGUOIDUNG";
    public static final String BACSI = "ROLE_BACSI";
    public static final String YTA = "ROLE_YTA";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNguoiDung")
    private Integer idNguoiDung;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45, message="NguoiDung.tenNguoiDung.lenErr")
    @Column(name = "tenNguoiDung")
    private String tenNguoiDung;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45, message="NguoiDung.taiKhoan.lenErr")
    @Column(name = "taiKhoan")
    private String taiKhoan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "matKhau")
    private String matKhau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gioiTinh")
    private String gioiTinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "user_role")
    private String userRole;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaySinh")
    @DateTimeFormat(pattern = "yyyy-mm-dd")

    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "diaChi")
    private String diaChi;
    @Size(max = 15)
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBacSi")
    private Collection<Phieukham> phieukhamCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBenhNhan")
    private Collection<Phieukham> phieukhamCollection1;
    @OneToMany(mappedBy = "xacNhanBoiYTa")
    private Collection<Phieukham> phieukhamCollection2;

    public Nguoidung() {
    }

    public Nguoidung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public Nguoidung(Integer idNguoiDung, String tenNguoiDung, String taiKhoan, String matKhau, String avatar, String gioiTinh, String userRole, Date ngaySinh) {
        this.idNguoiDung = idNguoiDung;
        this.tenNguoiDung = tenNguoiDung;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.avatar = avatar;
        this.gioiTinh = gioiTinh;
        this.userRole = userRole;
        this.ngaySinh = ngaySinh;
    }

    public Integer getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<Phieukham> getPhieukhamCollection() {
        return phieukhamCollection;
    }

    public void setPhieukhamCollection(Collection<Phieukham> phieukhamCollection) {
        this.phieukhamCollection = phieukhamCollection;
    }

    @XmlTransient
    public Collection<Phieukham> getPhieukhamCollection1() {
        return phieukhamCollection1;
    }

    public void setPhieukhamCollection1(Collection<Phieukham> phieukhamCollection1) {
        this.phieukhamCollection1 = phieukhamCollection1;
    }

    @XmlTransient
    public Collection<Phieukham> getPhieukhamCollection2() {
        return phieukhamCollection2;
    }

    public void setPhieukhamCollection2(Collection<Phieukham> phieukhamCollection2) {
        this.phieukhamCollection2 = phieukhamCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNguoiDung != null ? idNguoiDung.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nguoidung)) {
            return false;
        }
        Nguoidung other = (Nguoidung) object;
        if ((this.idNguoiDung == null && other.idNguoiDung != null) || (this.idNguoiDung != null && !this.idNguoiDung.equals(other.idNguoiDung))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenNguoiDung;
    }

    /**
     * @return the confirmmatKhau
     */
    public String getConfirmmatKhau() {
        return confirmmatKhau;
    }

    /**
     * @param confirmmatKhau the confirmmatKhau to set
     */
    public void setConfirmmatKhau(String confirmmatKhau) {
        this.confirmmatKhau = confirmmatKhau;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
