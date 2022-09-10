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
@Table(name = "loaithuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loaithuoc.findAll", query = "SELECT l FROM Loaithuoc l"),
    @NamedQuery(name = "Loaithuoc.findByIdLoaiThuoc", query = "SELECT l FROM Loaithuoc l WHERE l.idLoaiThuoc = :idLoaiThuoc"),
    @NamedQuery(name = "Loaithuoc.findByTenLoaiThuoc", query = "SELECT l FROM Loaithuoc l WHERE l.tenLoaiThuoc = :tenLoaiThuoc"),
    @NamedQuery(name = "Loaithuoc.findByActive", query = "SELECT l FROM Loaithuoc l WHERE l.active = :active")})
public class Loaithuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLoaiThuoc")
    private Integer idLoaiThuoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenLoaiThuoc")
    private String tenLoaiThuoc;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLoaiThuoc")
    private Collection<Thuoc> thuocCollection;

    public Loaithuoc() {
    }

    public Loaithuoc(Integer idLoaiThuoc) {
        this.idLoaiThuoc = idLoaiThuoc;
    }

    public Loaithuoc(Integer idLoaiThuoc, String tenLoaiThuoc) {
        this.idLoaiThuoc = idLoaiThuoc;
        this.tenLoaiThuoc = tenLoaiThuoc;
    }

    public Integer getIdLoaiThuoc() {
        return idLoaiThuoc;
    }

    public void setIdLoaiThuoc(Integer idLoaiThuoc) {
        this.idLoaiThuoc = idLoaiThuoc;
    }

    public String getTenLoaiThuoc() {
        return tenLoaiThuoc;
    }

    public void setTenLoaiThuoc(String tenLoaiThuoc) {
        this.tenLoaiThuoc = tenLoaiThuoc;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<Thuoc> getThuocCollection() {
        return thuocCollection;
    }

    public void setThuocCollection(Collection<Thuoc> thuocCollection) {
        this.thuocCollection = thuocCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoaiThuoc != null ? idLoaiThuoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loaithuoc)) {
            return false;
        }
        Loaithuoc other = (Loaithuoc) object;
        if ((this.idLoaiThuoc == null && other.idLoaiThuoc != null) || (this.idLoaiThuoc != null && !this.idLoaiThuoc.equals(other.idLoaiThuoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tenLoaiThuoc;
    }
    
}
