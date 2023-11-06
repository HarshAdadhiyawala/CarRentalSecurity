package Entity;

import Entity.Carpackage;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-23T17:05:46")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, String> fname;
    public static volatile SingularAttribute<Booking, Date> bookDate;
    public static volatile SingularAttribute<Booking, Integer> amount;
    public static volatile SingularAttribute<Booking, String> pickTime;
    public static volatile SingularAttribute<Booking, String> city;
    public static volatile SingularAttribute<Booking, String> pcode;
    public static volatile SingularAttribute<Booking, String> contactNo1;
    public static volatile SingularAttribute<Booking, String> bookNotes;
    public static volatile SingularAttribute<Booking, Carpackage> cpid;
    public static volatile SingularAttribute<Booking, String> contactNo2;
    public static volatile SingularAttribute<Booking, String> pAddress2;
    public static volatile SingularAttribute<Booking, Date> pickDate;
    public static volatile SingularAttribute<Booking, String> pAddress1;
    public static volatile SingularAttribute<Booking, String> dropTime;
    public static volatile SingularAttribute<Booking, Date> dropDate;
    public static volatile SingularAttribute<Booking, Integer> userid;
    public static volatile SingularAttribute<Booking, String> lname;
    public static volatile SingularAttribute<Booking, String> state;
    public static volatile SingularAttribute<Booking, Integer> bid;
    public static volatile SingularAttribute<Booking, String> email;
    public static volatile SingularAttribute<Booking, String> status;

}