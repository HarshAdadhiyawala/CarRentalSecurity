package Entity;

import Entity.Booking;
import Entity.Cars;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-23T17:05:46")
@StaticMetamodel(Carpackage.class)
public class Carpackage_ { 

    public static volatile SingularAttribute<Carpackage, String> pname;
    public static volatile SingularAttribute<Carpackage, Integer> price;
    public static volatile SingularAttribute<Carpackage, Integer> id;
    public static volatile CollectionAttribute<Carpackage, Booking> bookingCollection;
    public static volatile SingularAttribute<Carpackage, Cars> carid;

}