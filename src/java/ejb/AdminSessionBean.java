/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
//@DeclareRoles({"Admin", "Supervisor"})
@Stateless
public class AdminSessionBean implements AdminSessionBeanLocal {

    @PersistenceContext(unitName = "Demo1PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

        public String insertCity(String cityname)
    {
        try{
            
            City c = new City();
            c.setCityname(cityname);
            
            em.persist(c);
            return "Inserted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

     public List<City> showCity()
    {
        try
       {
          
           List<City> lst=em.createNamedQuery("City.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }
 
    public String deleteCity(int cityid)
    {
        try
       {
       City c=em.find(City.class,cityid);
           em.remove(c);
           return "Deleted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    } 

    public String updateCity(int cityid,String cityname)
    {
                try{
            
            City c = em.find(City.class, cityid);
            c.setCityname(cityname);
            
            em.merge(c);
            return "Updated";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        
    }

    public City searchCity(int id)
    {
        try
        {
            City c = em.find(City.class, id);
            return c;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    
    
           public String insertCarType(String typename)
    {
        try{
            
            Cartype c = new Cartype();
            c.setTypename(typename); 
            em.persist(c);
            return "Inserted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

     public List<Cartype> showCarType()
    {
        try
       {
          
           List<Cartype> lst=em.createNamedQuery("Cartype.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }
 
    public String deleteCarType(int id)
    {
        try
       {
       Cartype c=em.find(Cartype.class,id);
           em.remove(c);
           return "Deleted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    } 

    public String updateCarType(int id,String typename)
    {
                try{
            
            Cartype c = em.find(Cartype.class, id);
            c.setTypename(typename);
            
            em.merge(c);
            return "Updated";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        
    }

    public Cartype searchCarType(int id)
    {
        try
        {
            Cartype c = em.find(Cartype.class, id);
            return c;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    
    
    
          public String insertTerms(String tname)
    {
        try{
            
            Terms t=new Terms();
           t.setTerms(tname);
            em.persist(t);
            return "Inserted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

     public List<Terms> showTerms()
    {
        try
       {
          
           List<Terms> lst=em.createNamedQuery("Terms.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }
 
    public String deleteTerms(int id)
    {
        try
       {
       Terms t=em.find(Terms.class,id);
           em.remove(t);
           return "Deleted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    } 

    public String updateTerms(int id,String tname)
    {
                try{
            
            Terms t = em.find(Terms.class, id);
            t.setTerms(tname);
            
            em.merge(t);
            return "Updated";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        
    }

    public Terms searchTerms(int id)
    {
        try
        {
            Terms t = em.find(Terms.class, id);
            return t;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    
    
       //Contact Us
    public String insertContactus(Contactus c)
    {
       try
       {
           em.persist(c);
           return "Inserted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    }
    
    public List<Contactus> showContactus()
    {
        try
       {
          //  em.createNamedQuery("Dept.findAll").getResultList();
           
           List<Contactus> lst=em.createNamedQuery("Contactus.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }

    public String deleteContactus(int cno)
    {
        try
       {
           Contactus c=em.find(Contactus.class,cno);
           em.remove(c);
           return "Deleted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    } 
    
    public String updateContactus(Contactus c)
    {
        try
       {
           em.merge(c);
           return "Updated";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    }

    public Contactus searchContactus(int id)
    {
        try
        {
            Contactus c = em.find(Contactus.class, id);
            return c;
        }
        catch(Exception e)
        {
            return null;
        }
    }  
    
    
     //FAQ
    public String insertFaq(Faq f)
    {
       try
       {
           em.persist(f);
           return "Inserted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    }
    
         public List<Faq> showFaq()
    {
        try
       {
          //  em.createNamedQuery("Dept.findAll").getResultList();
           
           List<Faq> lst=em.createNamedQuery("Faq.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }

    public String deleteFaq(int fno)
    {
        try
       {
           Faq f=em.find(Faq.class,fno);
           em.remove(f);
           return "Deleted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    } 
    
    public String updateFaq(Faq f)
    {
        try
       {
           em.merge(f);
           return "Updated";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    }

    public Faq searchFaq(int id)
    {
        try
        {
            Faq f = em.find(Faq.class, id);
            return f;
        }
        catch(Exception e)
        {
            return null;
        }
    }  
    
    
        //Feedback
    public String insertFeedback(Feedback f)
    {
       try
       {
           em.persist(f);
           return "Inserted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    }
    
    public List<Feedback> showFeedback()
    {
        try
       {
          //  em.createNamedQuery("Dept.findAll").getResultList();
           
           List<Feedback> lst=em.createNamedQuery("Feedback.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }

    public String deleteFeedback(int fno)
    {
        try
       {
           Feedback f=em.find(Feedback.class,fno);
           em.remove(f);
           return "Deleted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    } 
    
    public String updateFeedback(Feedback f)
    {
        try
       {
       
           em.merge(f);
           return "Updated";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    }

    public Feedback searchFeedback(int id)
    {
        try
        {
            Feedback f = em.find(Feedback.class, id);
            return f;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
      //Team
        public String insertTeam(String name,String gender,String post,String image,String description,int cityid,Date joindate,String contactno,String email)
    {
       try
       {
         image="staff1.jpg";
           Team eb=new Team();
           eb.setName(name);
           eb.setGender(gender);
           eb.setPost(post);
           eb.setImage(image);
           eb.setDescriptioon(description);
           eb.setJoindate(joindate);
           eb.setContactno(contactno);
           eb.setEmail(email);
          
           
           City e=em.find(City.class,cityid);
           eb.setCityid(e);
           em.persist(eb);
           return "Inserted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    }
    public String updateTeam(int teamid,String name,String gender,String post,String image,String description,int cityid,Date joindate,String contactno,String email)
    {
       try
       {
         
           Team eb=em.find(Team.class,teamid);
           eb.setName(name);
           eb.setGender(gender);
           eb.setPost(post);
           eb.setImage(image);
           eb.setDescriptioon(description);
           eb.setJoindate(joindate);
           eb.setContactno(contactno);
           eb.setEmail(email);
           
           
           City e=em.find(City.class,cityid);
           eb.setCityid(e);
           em.persist(eb);
           return "Updated";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    }
 
    public List<Team> showTeam()
    {
        try
       {
          //  em.createNamedQuery("Dept.findAll").getResultList();
           
           List<Team> lst=em.createNamedQuery("Team.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }
    public String deleteTeam(int ebno)
    {
       try
       {
           Team d=em.find(Team.class,ebno);
           em.remove(d);
           return "Deleted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    } 
    public Team searchTeam(int id)
    {
         try
         {
             Team eb =em.find(Team.class,id);
             return eb;
         }
          catch(Exception ex)
       {
           return null;
       }        
    }
    
    
       //Car
        public String insertCar(String mname,String type,int cartypeid,String drivemode,int pcapacity,int lcapacity,int cityid,String image)
    {
       try
       {
         
           image="car1.jpg";
           Cars c=new Cars();
          c.setModelname(mname);
          c.setType(type);
          Cartype ct=em.find(Cartype.class,cartypeid);
          c.setCartypeid(ct);
          c.setDrivemode(drivemode);
          c.setPasscapacity(pcapacity);
          c.setLuggagecapacity(lcapacity);
          
           City e=em.find(City.class,cityid);
           c.setCityid(e);
          c.setImage(image);
          
           em.persist(c);
           return "Inserted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    }
         public String updateCar(int id,String mname,String type,int cartypeid,String drivemode,int pcapacity,int lcapacity,int cityid,String image)
    {
       try
       {
         
           Cars c=em.find(Cars.class,id);
           c.setModelname(mname);
          c.setType(type);
          Cartype ct=em.find(Cartype.class,cartypeid);
          c.setCartypeid(ct);
          c.setDrivemode(drivemode);
          c.setPasscapacity(pcapacity);
          c.setLuggagecapacity(lcapacity);
          
           City e=em.find(City.class,cityid);
           c.setCityid(e);
          c.setImage(image);
          
           em.persist(c);
           
           return "Updated";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    }
 
    public List<Cars> showCars()
    {
        try
       {
          //  em.createNamedQuery("Dept.findAll").getResultList();
           
           List<Cars> lst=em.createNamedQuery("Cars.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }
    
    
        public List<Booking> showBookings()
    {
        try
       {
          //  em.createNamedQuery("Dept.findAll").getResultList();
           
           List<Booking> lst=em.createNamedQuery("Booking.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }
    
       public List<Cars> showCarsByCity(int cityid)
    {
        try
       {
          //  em.createNamedQuery("Dept.findAll").getResultList();
           
           List<Cars> lst=em.createNamedQuery("Cars.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }
       
    public String deleteCars(int id)
    {
       try
       {
           Cars d=em.find(Cars.class,id);
           em.remove(d);
           return "Deleted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    } 
    public Cars searchCars(int id)
    {
         try
         {
             Cars eb =em.find(Cars.class,id);
             return eb;
         }
          catch(Exception ex)
       {
           return null;
       }        
    }
    
    
    
      //Car Package
    public String insertCarpackage(int cid,String pname,int price)
    {
        try{
            
            Carpackage cp=new Carpackage();
            cp.setPname(pname);
            cp.setPrice(price);
            Cars c = em.find(Cars.class, cid);
            cp.setCarid(c);
            em.persist(cp);
            return "Inserted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

     public List<Carpackage> showCarpackages()
    {
        try
       {
          
           List<Carpackage> lst=em.createNamedQuery("Carpackage.findAll").getResultList();
           
           return lst;
       }
       catch(Exception ex)
       {
           return null;
       }
    }
     
//     
//       public List<Carpackage> showCarpackages(Date pdate,Date)
//    {
//        try
//       {
//          
//           List<Carpackage> lst=em.createNamedQuery("Carpackage.findAll").getResultList();
//           
//           return lst;
//       }
//       catch(Exception ex)
//       {
//           return null;
//       }
//    }
     public Collection<Carpackage> searchCarpackages(int cid)
    {
        try
       {
          Cars c=em.find(Cars.class,cid);
          
          // List<Carpackage> lst=em.createNamedQuery("Carpackage.findAll").getResultList();
           
           return c.getCarpackageCollection();
       }
       catch(Exception ex)
       {
           return null;
       }
    }
 
 
    public String deleteCarpackage(int id)
    {
        try
       {
       Carpackage c=em.find(Carpackage.class,id);
           em.remove(c);
           return "Deleted";
       }
       catch(Exception ex)
       {
           return ex.getMessage();
       }
    } 

    public String updateCarpackage(int id,int cid,String pname,int price)
    {
                try{
            
            Carpackage cp = em.find(Carpackage.class, id);
            cp.setPname(pname);
            cp.setPrice(price);
            Cars c = em.find(Cars.class, cid);
            cp.setCarid(c);
            em.merge(c);
            return "Updated";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        
    }

    
    
    public List<Cars> searchCarByDate(int id,Date pdate,Date ddate)
    {
        try
        {
              
            City c = em.find(City.class, id);
            Collection<Cars> clist=c.getCarsCollection();
               
            ArrayList<Cars> newcarlist=new ArrayList<>();
            for (Cars tmp:clist)
            {
                boolean flag=true;
              Collection<Carpackage> cplist=  tmp.getCarpackageCollection();
              
              for (Carpackage cptmp:cplist)
            {
              Collection<Booking> booklist =  cptmp.getBookingCollection();
            
             for (Booking bktmp:booklist)
            {
                Date bpdate=bktmp.getPickDate();
                Date bddate=bktmp.getDropDate();
                
                if (!( (pdate.before(bpdate) && ddate.before(bddate)) || (pdate.after(bddate) && ddate.after(bddate))  ))
                {
                    flag=false;
                }
//                else
//                {
//                    flag=true;
//                }
            }
            
            }
               if (flag==true)
             {
              newcarlist.add(tmp);
             }
            }
            
            
           // return c;
           
           return newcarlist;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public Carpackage searchCarpackage(int id)
    {
        try
        {
            Carpackage c = em.find(Carpackage.class, id);
            return c;
        }
        catch(Exception e)
        {
            return null;
        }
    }

//User Login
      public Reg checkuserLogin(String email,String password)
    {
        try
        {
            Reg u = (Reg) em.createQuery("SELECT u FROM Reg u WHERE u.email ='" + email + "' and u.password ='" + password+"'").getSingleResult();
            return u;
        }
        catch(Exception ex)
        {
            return null;
        }

    }
      
       public String insertUser(String fname,String gender,String address,int cityid,String contactno,String email,String password)
    {
        try{
            Date d = new Date();
            Reg u = new Reg();
//         
            u.setUsername(fname);
            u.setPassword(password);
            u.setGender(gender);
            u.setAddress(address);
            City c=em.find(City.class, cityid);
            u.setCityid(c.getId());
            u.setContactno(contactno);
            u.setEmail(email);
            u.setPassword(password);
            u.setRegistrationdatetime(d);
            u.setGroupname("User");
            em.persist(u); 
            
//         //   Groups g1 = em.find(Groups.class, 2);
//           Group g1=new Groups();
//           g1.setGroupName("User");
//           g1.setUsername(u);
          
           // em.persist(g1);
            return "Inserted";
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }
       
    public List<Booking> showBookingByUser(int uid)
    {
        try
       {
           List<Booking> blist=em.createNamedQuery("Booking.findByUserid").setParameter("userid", uid).getResultList();
           return blist;
             
       }
       catch(Exception ex)
       {
           return null;
       }
    }
       
}
