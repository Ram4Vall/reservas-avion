package es.cifpcm.reservasrs;

import es.cifpcm.reservasrs.Ciudad;
import es.cifpcm.reservasrs.VueloGenerico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-28T12:14:40")
@StaticMetamodel(Aeropuerto.class)
public class Aeropuerto_ { 

    public static volatile SingularAttribute<Aeropuerto, String> codAeropuerto;
    public static volatile SingularAttribute<Aeropuerto, Integer> categoria;
    public static volatile CollectionAttribute<Aeropuerto, VueloGenerico> vueloGenericoCollection;
    public static volatile CollectionAttribute<Aeropuerto, VueloGenerico> vueloGenericoCollection1;
    public static volatile SingularAttribute<Aeropuerto, String> nombre;
    public static volatile SingularAttribute<Aeropuerto, Ciudad> idCiudad;

}