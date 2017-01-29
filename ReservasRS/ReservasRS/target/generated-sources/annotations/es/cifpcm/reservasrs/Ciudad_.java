package es.cifpcm.reservasrs;

import es.cifpcm.reservasrs.Aeropuerto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-28T12:14:40")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile CollectionAttribute<Ciudad, Aeropuerto> aeropuertoCollection;
    public static volatile SingularAttribute<Ciudad, String> nombre;
    public static volatile SingularAttribute<Ciudad, Short> idCiudad;
    public static volatile SingularAttribute<Ciudad, String> pais;

}