package Entity;

import Entity.Carpackage;
import Entity.Cartype;
import Entity.City;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-23T17:05:46")
@StaticMetamodel(Cars.class)
public class Cars_ { 

    public static volatile SingularAttribute<Cars, String> drivemode;
    public static volatile CollectionAttribute<Cars, Carpackage> carpackageCollection;
    public static volatile SingularAttribute<Cars, String> image;
    public static volatile SingularAttribute<Cars, Cartype> cartypeid;
    public static volatile SingularAttribute<Cars, String> modelname;
    public static volatile SingularAttribute<Cars, Integer> luggagecapacity;
    public static volatile SingularAttribute<Cars, Integer> id;
    public static volatile SingularAttribute<Cars, Integer> passcapacity;
    public static volatile SingularAttribute<Cars, City> cityid;
    public static volatile SingularAttribute<Cars, String> type;

}