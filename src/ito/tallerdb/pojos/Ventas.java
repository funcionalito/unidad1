/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ito.tallerdb.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafao
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findById", query = "SELECT v FROM Ventas v WHERE v.id = :id"),
    @NamedQuery(name = "Ventas.findByDescuento", query = "SELECT v FROM Ventas v WHERE v.descuento = :descuento"),
    @NamedQuery(name = "Ventas.findByFecha", query = "SELECT v FROM Ventas v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Ventas.findByMontofinal", query = "SELECT v FROM Ventas v WHERE v.montofinal = :montofinal")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "descuento")
    private Float descuento;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "montofinal")
    private float montofinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventas")
    private List<DetalleDe> detalleDeList;
    @JoinColumn(name = "clave", referencedColumnName = "clave")
    @ManyToOne(optional = false)
    private Clientes clave;

    public Ventas() {
    }

    public Ventas(Integer id) {
        this.id = id;
    }

    public Ventas(Integer id, Date fecha, float montofinal) {
        this.id = id;
        this.fecha = fecha;
        this.montofinal = montofinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getMontofinal() {
        return montofinal;
    }

    public void setMontofinal(float montofinal) {
        this.montofinal = montofinal;
    }

    @XmlTransient
    public List<DetalleDe> getDetalleDeList() {
        return detalleDeList;
    }

    public void setDetalleDeList(List<DetalleDe> detalleDeList) {
        this.detalleDeList = detalleDeList;
    }

    public Clientes getClave() {
        return clave;
    }

    public void setClave(Clientes clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ito.tallerdb.pojos.Ventas[ id=" + id + " ]";
    }
    
}
