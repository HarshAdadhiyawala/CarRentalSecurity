/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import Entity.Booking;
import Entity.Carpackage;
import Entity.Cars;
import Entity.Cartype;
import Entity.City;
import Entity.Contactus;
import Entity.Faq;
import Entity.Feedback;
import Entity.Reg;
import Entity.Team;
import Entity.Terms;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface AdminSessionBeanLocal {

    //City
    public String updateCity(int cityid, String cityname);

    public String deleteCity(int cityid);

    public List<City> showCity();

    public String insertCity(String cityname);

    public City searchCity(int id);

    //Car Types
    public Cartype searchCarType(int id);

    public String updateCarType(int id, String typename);

    public String deleteCarType(int id);

    public List<Cartype> showCarType();

    public String insertCarType(String typename);

    
    //Terms
    public Terms searchTerms(int id);

    public String updateTerms(int id, String tname);

    public String deleteTerms(int id);

    public List<Terms> showTerms();

    public String insertTerms(String tname);
    
    
    
     //Faq
    public String insertFaq(Faq f);
    public List<Faq> showFaq();
    public String deleteFaq(int fno);
    public String updateFaq(Faq f);
    public Faq searchFaq(int id);
    
    
    
    //Feedback
    public String insertFeedback(Feedback f);
    public List<Feedback> showFeedback();
    public String deleteFeedback(int fno);
    public String updateFeedback(Feedback f);
    public Feedback searchFeedback(int id);
    
    
    //Contactus
    public String insertContactus(Contactus c);
    public List<Contactus> showContactus();
    public String deleteContactus(int cno);
    public String updateContactus(Contactus c);
    public Contactus searchContactus(int id);
    
    
                //Team
       public String insertTeam(String name,String gender,String post,String image,String description,int cityid,Date joindate,String contactno,String email);
       public String updateTeam(int teamid,String name,String gender,String post,String image,String description,int cityid,Date joindate,String contactno,String email);
       public List<Team> showTeam();
       public String deleteTeam(int ebno);
       public Team searchTeam(int id);

       
       //Cars
          public List<Cars> showCars();
         public String deleteCars(int id)  ;
       public Cars searchCars(int id);

    public String updateCar(int id, String mname, String type, int cartypeid, String drivemode, int pcapacity, int lcapacity, int cityid, String image);

    public String insertCar(String mname, String type, int cartypeid, String drivemode, int pcapacity, int lcapacity, int cityid, String image);

    
    //CarPackage
    public Carpackage searchCarpackage(int id);

    public String updateCarpackage(int id, int cid, String pname, int price);

    public String deleteCarpackage(int id);

    public List<Carpackage> showCarpackages();

    public String insertCarpackage(int cid, String pname, int price);

    public Collection<Carpackage> searchCarpackages(int cid);

    public Reg checkuserLogin(String email, String password);

    public List<Booking> showBookings();

    public String insertUser(String fname, String gender, String address, int cityid, String contactno, String email, String password);

    public List<Booking> showBookingByUser(int uid);

    public List<Cars> searchCarByDate(int id, Date pdate, Date ddate);
         
}
