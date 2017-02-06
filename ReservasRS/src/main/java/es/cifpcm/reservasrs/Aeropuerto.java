/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.reservasrs;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "aeropuerto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeropuerto.findAll", query = "SELECT a FROM Aeropuerto a"),
    @NamedQuery(name = "Aeropuerto.findByCodAeropuerto", query = "SELECT a FROM Aeropuerto a WHERE a.codAeropuerto = :codAeropuerto"),
    @NamedQuery(name = "Aeropuerto.findByNombre", query = "SELECT a FROM Aeropuerto a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aeropuerto.findByCategoria", query = "SELECT a FROM Aeropuerto a WHERE a.categoria = :categoria")})
public class Aeropuerto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_aeropuerto")
    private String codAeropuerto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria")
    private int categoria;
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAeropuertoLlegada")
    private Collection<VueloGenerico> vueloGenericoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAeropuertoSalida")
    private Collection<VueloGenerico> vueloGenericoCollection1;

    public Aeropuerto() {
    }

    public Aeropuerto(String codAeropuerto) {
        this.codAeropuerto = codAeropuerto;
    }

    public Aeropuerto(String codAeropuerto, String nombre, int categoria) {
        this.codAeropuerto = codAeropuerto;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getCodAeropuerto() {
        return codAeropuerto;
    }

    public void setCodAeropuerto(String codAeropuerto) {
        this.codAeropuerto = codAeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    @XmlTransient
    public Collection<VueloGenerico> getVueloGenericoCollection() {
        return vueloGenericoCollection;
    }

    public void setVueloGenericoCollection(Collection<VueloGenerico> vueloGenericoCollection) {
        this.vueloGenericoCollection = vueloGenericoCollection;
    }

    @XmlTransient
    public Collection<VueloGenerico> getVueloGenericoCollection1() {
        return vueloGenericoCollection1;
    }

    public void setVueloGenericoCollection1(Collection<VueloGenerico> vueloGenericoCollection1) {
        this.vueloGenericoCollection1 = vueloGenericoCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAeropuerto != null ? codAeropuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuerto)) {
            return false;
        }
        Aeropuerto other = (Aeropuerto) object;
        if ((this.codAeropuerto == null && other.codAeropuerto != null) || (this.codAeropuerto != null && !this.codAeropuerto.equals(other.codAeropuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cifpcm.reservasrs.Aeropuerto[ codAeropuerto=" + codAeropuerto + " ]";
    }
    
}
