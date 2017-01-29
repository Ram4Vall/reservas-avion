package es.cifpcm.reservasrs;

import es.cifpcm.reservasrs.Reserva;
import es.cifpcm.reservasrs.VueloGenerico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-28T12:14:40")
@StaticMetamodel(Vuelo.class)
public class Vuelo_ { 

    public static volatile SingularAttribute<Vuelo, String> fecha;
    public static volatile SingularAttribute<Vuelo, Short> idVuelo;
    public static volatile SingularAttribute<Vuelo, Integer> plazasLibres;
    public static volatile CollectionAttribute<Vuelo, Reserva> reservaCollection;
    public static volatile SingularAttribute<Vuelo, VueloGenerico> numVuelo;

}