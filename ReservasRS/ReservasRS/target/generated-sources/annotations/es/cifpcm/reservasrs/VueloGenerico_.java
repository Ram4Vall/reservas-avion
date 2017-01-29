package es.cifpcm.reservasrs;

import es.cifpcm.reservasrs.Aerolinea;
import es.cifpcm.reservasrs.Aeropuerto;
import es.cifpcm.reservasrs.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-28T12:14:40")
@StaticMetamodel(VueloGenerico.class)
public class VueloGenerico_ { 

    public static volatile SingularAttribute<VueloGenerico, Float> precio;
    public static volatile CollectionAttribute<VueloGenerico, Vuelo> vueloCollection;
    public static volatile SingularAttribute<VueloGenerico, Aerolinea> codAerolinea;
    public static volatile SingularAttribute<VueloGenerico, String> horaLlegada;
    public static volatile SingularAttribute<VueloGenerico, Aeropuerto> codAeropuertoSalida;
    public static volatile SingularAttribute<VueloGenerico, Aeropuerto> codAeropuertoLlegada;
    public static volatile SingularAttribute<VueloGenerico, Short> numVuelo;
    public static volatile SingularAttribute<VueloGenerico, String> horaSalida;
    public static volatile SingularAttribute<VueloGenerico, Integer> capacidad;

}