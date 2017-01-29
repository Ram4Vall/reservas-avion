/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.reservasrs;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Ramiro
 */
@Entity
@Table(name = "aerolinea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aerolinea.findAll", query = "SELECT a FROM Aerolinea a"),
    @NamedQuery(name = "Aerolinea.findByCodAerolinea", query = "SELECT a FROM Aerolinea a WHERE a.codAerolinea = :codAerolinea"),
    @NamedQuery(name = "Aerolinea.findByNombre", query = "SELECT a FROM Aerolinea a WHERE a.nombre = :nombre")})
public class Aerolinea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_aerolinea")
    private String codAerolinea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "codAerolinea")
    private Collection<VueloGenerico> vueloGenericoCollection;

    public Aerolinea() {
    }

    public Aerolinea(String codAerolinea) {
        this.codAerolinea = codAerolinea;
    }

    public Aerolinea(String codAerolinea, String nombre) {
        this.codAerolinea = codAerolinea;
        this.nombre = nombre;
    }

    public String getCodAerolinea() {
        return codAerolinea;
    }

    public void setCodAerolinea(String codAerolinea) {
        this.codAerolinea = codAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<VueloGenerico> getVueloGenericoCollection() {
        return vueloGenericoCollection;
    }

    public void setVueloGenericoCollection(Collection<VueloGenerico> vueloGenericoCollection) {
        this.vueloGenericoCollection = vueloGenericoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAerolinea != null ? codAerolinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aerolinea)) {
            return false;
        }
        Aerolinea other = (Aerolinea) object;
        if ((this.codAerolinea == null && other.codAerolinea != null) || (this.codAerolinea != null && !this.codAerolinea.equals(other.codAerolinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cifpcm.reservasrs.Aerolinea[ codAerolinea=" + codAerolinea + " ]";
    }
    
}
