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
 * @author Ramiro
 */
@Entity
@Table(name = "vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v"),
    @NamedQuery(name = "Vuelo.findByIdVuelo", query = "SELECT v FROM Vuelo v WHERE v.idVuelo = :idVuelo"),
    @NamedQuery(name = "Vuelo.findByFecha", query = "SELECT v FROM Vuelo v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Vuelo.findByPlazasLibres", query = "SELECT v FROM Vuelo v WHERE v.plazasLibres = :plazasLibres")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vuelo")
    private Short idVuelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plazas_libres")
    private int plazasLibres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVuelo")
    private Collection<Reserva> reservaCollection;
    @JoinColumn(name = "num_vuelo", referencedColumnName = "num_vuelo")
    @ManyToOne(optional = false)
    private VueloGenerico numVuelo;

    public Vuelo() {
    }

    public Vuelo(Short idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Vuelo(Short idVuelo, String fecha, int plazasLibres) {
        this.idVuelo = idVuelo;
        this.fecha = fecha;
        this.plazasLibres = plazasLibres;
    }

    public Short getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Short idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPlazasLibres() {
        return plazasLibres;
    }

    public void setPlazasLibres(int plazasLibres) {
        this.plazasLibres = plazasLibres;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public VueloGenerico getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(VueloGenerico numVuelo) {
        this.numVuelo = numVuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVuelo != null ? idVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.idVuelo == null && other.idVuelo != null) || (this.idVuelo != null && !this.idVuelo.equals(other.idVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cifpcm.reservasrs.Vuelo[ idVuelo=" + idVuelo + " ]";
    }
    
}
