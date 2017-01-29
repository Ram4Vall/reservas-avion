package es.cifpcm.reservasrs;

import es.cifpcm.reservasrs.VueloGenerico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-28T12:14:40")
@StaticMetamodel(Aerolinea.class)
public class Aerolinea_ { 

    public static volatile SingularAttribute<Aerolinea, String> codAerolinea;
    public static volatile CollectionAttribute<Aerolinea, VueloGenerico> vueloGenericoCollection;
    public static volatile SingularAttribute<Aerolinea, String> nombre;

}