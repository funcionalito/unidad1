/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ito.tallerdb.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author rafao
 */
@Embeddable
public class DetalleDePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idp")
    private int idp;
    @Basic(optional = false)
    @Column(name = "idv")
    private int idv;

    public DetalleDePK() {
    }

    public DetalleDePK(int idp, int idv) {
        this.idp = idp;
        this.idv = idv;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getIdv() {
        return idv;
    }

    public void setIdv(int idv) {
        this.idv = idv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idp;
        hash += (int) idv;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDePK)) {
            return false;
        }
        DetalleDePK other = (DetalleDePK) object;
        if (this.idp != other.idp) {
            return false;
        }
        if (this.idv != other.idv) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ito.tallerdb.pojos.DetalleDePK[ idp=" + idp + ", idv=" + idv + " ]";
    }
    
}
