/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.reservasrs;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByNumReserva", query = "SELECT r FROM Reserva r WHERE r.numReserva = :numReserva"),
    @NamedQuery(name = "Reserva.findByNombre", query = "SELECT r FROM Reserva r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Reserva.findByApellidos", query = "SELECT r FROM Reserva r WHERE r.apellidos = :apellidos"),
    @NamedQuery(name = "Reserva.findByTelefono", query = "SELECT r FROM Reserva r WHERE r.telefono = :telefono"),
    @NamedQuery(name = "Reserva.findByTarjeta", query = "SELECT r FROM Reserva r WHERE r.tarjeta = :tarjeta"),
    @NamedQuery(name = "Reserva.findByImporte", query = "SELECT r FROM Reserva r WHERE r.importe = :importe")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_reserva")
    private Short numReserva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "tarjeta")
    private String tarjeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private float importe;
    @JoinColumn(name = "id_vuelo", referencedColumnName = "id_vuelo")
    @ManyToOne(optional = false)
    private Vuelo idVuelo;

    public Reserva() {
    }

    public Reserva(Short numReserva) {
        this.numReserva = numReserva;
    }

    public Reserva(Short numReserva, String nombre, String apellidos, String telefono, String tarjeta, float importe) {
        this.numReserva = numReserva;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
        this.importe = importe;
    }

    public Short getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(Short numReserva) {
        this.numReserva = numReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Vuelo getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Vuelo idVuelo) {
        this.idVuelo = idVuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numReserva != null ? numReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.numReserva == null && other.numReserva != null) || (this.numReserva != null && !this.numReserva.equals(other.numReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.cifpcm.reservasrs.Reserva[ numReserva=" + numReserva + " ]";
    }
    
}
