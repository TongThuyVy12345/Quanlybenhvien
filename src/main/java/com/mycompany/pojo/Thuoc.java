/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "thuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thuoc.findAll", query = "SELECT t FROM Thuoc t"),
    @NamedQuery(name = "Thuoc.findByIdThuoc", query = "SELECT t FROM Thuoc t WHERE t.idThuoc = :idThuoc"),
    @NamedQuery(name = "Thuoc.findByTenThuoc", query = "SELECT t FROM Thuoc t WHERE t.tenThuoc = :tenThuoc"),
    @NamedQuery(name = "Thuoc.findByCachDung", query = "SELECT t FROM Thuoc t WHERE t.cachDung = :cachDung"),
    @NamedQuery(name = "Thuoc.findByGia", query = "SELECT t FROM Thuoc t WHERE t.gia = :gia"),
    @NamedQuery(name = "Thuoc.findByActive", query = "SELECT t FROM Thuoc t WHERE t.active = :active")})
public class Thuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idThuoc")
    private Integer idThuoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tenThuoc")
    private String tenThuoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cachDung")
    private String cachDung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia")
    private long gia;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idThuoc")
    private Collection<Phieukhamthuoc> phieukhamthuocCollection;
    @JoinColumn(name = "idLoaiThuoc", referencedColumnName = "idLoaiThuoc")
    @ManyToOne(optional = false)
    private Loaithuoc idLoaiThuoc;

    public Thuoc() {
    }

    public Thuoc(Integer idThuoc) {
        this.idThuoc = idThuoc;
    }

    public Thuoc(Integer idThuoc, String tenThuoc, String cachDung, long gia) {
        this.idThuoc = idThuoc;
        this.tenThuoc = tenThuoc;
        this.cachDung = cachDung;
        this.gia = gia;
    }

    public Integer getIdThuoc() {
        return idThuoc;
    }

    public void setIdThuoc(Integer idThuoc) {
        this.idThuoc = idThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getCachDung() {
        return cachDung;
    }

    public void setCachDung(String cachDung) {
        this.cachDung = cachDung;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<Phieukhamthuoc> getPhieukhamthuocCollection() {
        return phieukhamthuocCollection;
    }

    public void setPhieukhamthuocCollection(Collection<Phieukhamthuoc> phieukhamthuocCollection) {
        this.phieukhamthuocCollection = phieukhamthuocCollection;
    }

    public Loaithuoc getIdLoaiThuoc() {
        return idLoaiThuoc;
    }

    public void setIdLoaiThuoc(Loaithuoc idLoaiThuoc) {
        this.idLoaiThuoc = idLoaiThuoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idThuoc != null ? idThuoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thuoc)) {
            return false;
        }
        Thuoc other = (Thuoc) object;
        if ((this.idThuoc == null && other.idThuoc != null) || (this.idThuoc != null && !this.idThuoc.equals(other.idThuoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenThuoc;
    }
    
}
