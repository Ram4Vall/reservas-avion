package es.cifpcm.reservasrs;

import es.cifpcm.reservasrs.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-28T12:14:40")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Short> numReserva;
    public static volatile SingularAttribute<Reserva, String> apellidos;
    public static volatile SingularAttribute<Reserva, Vuelo> idVuelo;
    public static volatile SingularAttribute<Reserva, String> telefono;
    public static volatile SingularAttribute<Reserva, String> tarjeta;
    public static volatile SingularAttribute<Reserva, String> nombre;
    public static volatile SingularAttribute<Reserva, Float> importe;

}