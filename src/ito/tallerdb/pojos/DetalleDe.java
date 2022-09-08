/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ito.tallerdb.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafao
 */
@Entity
@Table(name = "detalle_de")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleDe.findAll", query = "SELECT d FROM DetalleDe d"),
    @NamedQuery(name = "DetalleDe.findByIdp", query = "SELECT d FROM DetalleDe d WHERE d.detalleDePK.idp = :idp"),
    @NamedQuery(name = "DetalleDe.findByIdv", query = "SELECT d FROM DetalleDe d WHERE d.detalleDePK.idv = :idv"),
    @NamedQuery(name = "DetalleDe.findByCantidad", query = "SELECT d FROM DetalleDe d WHERE d.cantidad = :cantidad")})
public class DetalleDe implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleDePK detalleDePK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idp", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "idv", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ventas ventas;

    public DetalleDe() {
    }

    public DetalleDe(DetalleDePK detalleDePK) {
        this.detalleDePK = detalleDePK;
    }

    public DetalleDe(DetalleDePK detalleDePK, int cantidad) {
        this.detalleDePK = detalleDePK;
        this.cantidad = cantidad;
    }

    public DetalleDe(int idp, int idv) {
        this.detalleDePK = new DetalleDePK(idp, idv);
    }

    public DetalleDePK getDetalleDePK() {
        return detalleDePK;
    }

    public void setDetalleDePK(DetalleDePK detalleDePK) {
        this.detalleDePK = detalleDePK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleDePK != null ? detalleDePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDe)) {
            return false;
        }
        DetalleDe other = (DetalleDe) object;
        if ((this.detalleDePK == null && other.detalleDePK != null) || (this.detalleDePK != null && !this.detalleDePK.equals(other.detalleDePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ito.tallerdb.pojos.DetalleDe[ detalleDePK=" + detalleDePK + " ]";
    }
    
}
