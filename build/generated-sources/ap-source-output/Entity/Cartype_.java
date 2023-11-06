package Entity;

import Entity.Cars;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-23T17:05:46")
@StaticMetamodel(Cartype.class)
public class Cartype_ { 

    public static volatile CollectionAttribute<Cartype, Cars> carsCollection;
    public static volatile SingularAttribute<Cartype, Integer> id;
    public static volatile SingularAttribute<Cartype, String> typename;

}