package Entity;

import Entity.Cars;
import Entity.Team;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-23T17:05:46")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile CollectionAttribute<City, Team> teamCollection;
    public static volatile CollectionAttribute<City, Cars> carsCollection;
    public static volatile SingularAttribute<City, String> cityname;
    public static volatile SingularAttribute<City, Integer> id;

}