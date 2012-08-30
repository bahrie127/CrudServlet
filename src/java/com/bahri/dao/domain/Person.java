/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bahri.dao.domain;

/**
 *
 * @author bahrie
 */
public class Person {

    private Long id;
    private String nama;
    private String alamat;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        if ((this.alamat == null) ? (other.alamat != null) : !this.alamat.equals(other.alamat)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 31 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 31 * hash + (this.alamat != null ? this.alamat.hashCode() : 0);
        return hash;
    }


}
