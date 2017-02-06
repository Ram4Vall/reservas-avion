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
@Table(name = "vuelo_generico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VueloGenerico.findAll", query = "SELECT v FROM VueloGenerico v"),
    @NamedQuery(name = "VueloGenerico.findByNumVuelo", query = "SELECT v FROM VueloGenerico v WHERE v.numVuelo = :numVuelo"),
    @NamedQuery(name = "VueloGenerico.findByHoraSalida", query = "SELECT v FROM VueloGenerico v WHERE v.horaSalida = :horaSalida"),
    @NamedQuery(name = "VueloGenerico.findByHoraLlegada", query = "SELECT v FROM VueloGenerico v WHERE v.horaLlegada = :horaLlegada"),
    @NamedQuery(name = "VueloGenerico.findByPrecio", query = "SELECT v FROM VueloGenerico v WHERE v.precio = :precio"),
    @NamedQuery(name = "VueloGenerico.findByCapacidad", query = "SELECT v FROM VueloGenerico v WHERE v.capacidad = :capacidad")})
public class VueloGenerico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_vuelo")
    private Short numVuelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "hora_salida")
    private String horaSalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "hora_llegada")
    private String horaLlegada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad")
    private int capacidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numVuelo")
    private Collection<Vuelo> vueloCollection;
    @JoinColumn(name = "cod_aerolinea", referencedColumnName = "cod_aerolinea")
    @ManyToOne
    private Aerolinea codAerolinea;
    @JoinColumn(name = "cod_aeropuerto_llegada", referencedColumnName = "cod_aeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto codAeropuertoLlegada;
    @JoinColumn(name = "cod_aeropuerto_salida", referencedColumnName = "cod_aeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto codAeropuertoSalida;

    public VueloGenerico() {
    }

    public VueloGenerico(Short numVuelo) {
        this.numVuelo = numVuelo;
    }

    public VueloGenerico(Short numVuelo, String horaSalida, String horaLlegada, float precio, int capacidad) {
        this.numVuelo = numVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.precio = precio;
        this.capacidad = capacidad;
    }

    public Short getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(Short numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @XmlTransient
    public Collection<Vuelo> getVueloCollection() {
        return vueloCollection;
    }

    public void setVueloCollection(Collection<Vuelo> vueloCollection) {
        this.vueloCollection = vueloCollection;
    }

    public Aerolinea getCodAerolinea() {
        return codAerolinea;
    }

    public void setCodAerolinea(Aerolinea codAerolinea) {
        this.codAerolinea = codAerolinea;
    }

    public Aeropuerto getCodAeropuertoLlegada() {
        return codAeropuertoLlegada;
    }

    public void setCodAeropuertoLlegada(Aeropuerto codAeropuertoLlegada) {
        this.codAeropuertoLlegada = codAeropuertoLlegada;
    }

    public Aeropuerto getCodAeropuertoSalida() {
        return codAeropuertoSalida;
    }

    public void setCodAeropuertoSalida(Aeropuerto codAeropuertoSalida) {
        this.codAeropuertoSalida = codAeropuertoSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numVuelo != null ? numVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VueloGenerico)) {
            return false;
        }
        VueloGenerico other = (VueloGenerico) object;
        if ((this.numVuelo == null && other.numVuelo != null) || (this.numVuelo != null && !this.numVuelo.equals(other.numVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cifpcm.reservasrs.VueloGenerico[ numVuelo=" + numVuelo + " ]";
    }
    
}
