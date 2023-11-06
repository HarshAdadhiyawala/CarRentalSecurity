package Entity;

import Entity.City;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-12-23T17:05:46")
@StaticMetamodel(Team.class)
public class Team_ { 

    public static volatile SingularAttribute<Team, String> image;
    public static volatile SingularAttribute<Team, Date> joindate;
    public static volatile SingularAttribute<Team, String> gender;
    public static volatile SingularAttribute<Team, String> post;
    public static volatile SingularAttribute<Team, Integer> teamid;
    public static volatile SingularAttribute<Team, String> name;
    public static volatile SingularAttribute<Team, String> descriptioon;
    public static volatile SingularAttribute<Team, City> cityid;
    public static volatile SingularAttribute<Team, String> email;
    public static volatile SingularAttribute<Team, String> contactno;

}