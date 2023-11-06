/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;
 
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
import ejb.AdminSessionBeanLocal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
//import servlets.AmenityServlet;

/**
 * REST Web Service
 *
 * @author hitesh
 */
@Path("generic")
public class GenericResource {

  //  CarSessionBeanLocal carSessionBean1 = lookupCarSessionBeanLocal();

    AdminSessionBeanLocal adminSessionBean = lookupAdminSessionBeanLocal();
        
    @Context
    private UriInfo context;

    
    private AdminSessionBeanLocal lookupAdminSessionBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (AdminSessionBeanLocal) c.lookup("java:global/CarRentalSecurity/AdminSessionBean!ejb.AdminSessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
 //City
@POST
@Path("InsertCity/{cityname}")
public String InsertCity(@PathParam("cityname") String cityname)
{
   
    return adminSessionBean.insertCity(cityname);
   
}
@GET
@Path("ShowCity/")
@Produces(MediaType.APPLICATION_XML)
public Collection<City> ShowCity()
{
    return adminSessionBean.showCity();
}

@DELETE
@Path("DeleteCity/{cityid}")
public String DeleteCity(@PathParam("cityid") int cityid)
{
   
    return adminSessionBean.deleteCity(cityid);
   
}

@GET
@Path("SearchCity/{cityid}")
@Produces(MediaType.APPLICATION_XML)
public City SearchCity(@PathParam("cityid") int cityid)
{
   
    return adminSessionBean.searchCity(cityid);
   
}
@POST
@Path("UpdateCity/{cityid}/{cityname}")
public String UpdateCity(@PathParam("cityid") int cityid,@PathParam("cityname") String cityname)
{
   
    return adminSessionBean.updateCity(cityid,  cityname);
   
}

//Car Types
@POST
@Path("InsertCarType/{typename}")
public String InsertCarType(@PathParam("typename") String typename)
{
   
    return adminSessionBean.insertCarType(typename);
   
}
@GET
@Path("ShowCarType/")
@Produces(MediaType.APPLICATION_XML)
public Collection<Cartype> ShowCarType()
{
    return adminSessionBean.showCarType();
}

@DELETE
@Path("DeleteCarType/{id}")
public String DeleteCarType(@PathParam("id") int id)
{
   
    return adminSessionBean.deleteCarType(id);
   
}

@GET
@Path("SearchCarType/{id}")
@Produces(MediaType.APPLICATION_XML)
public Cartype SearchCarType(@PathParam("id") int id)
{
   
    return adminSessionBean.searchCarType(id);
   
}
@POST
@Path("UpdateCarType/{id}/{name}")
public String UpdateCarType(@PathParam("id") int id,@PathParam("name") String name)
{
   
    return adminSessionBean.updateCarType(id,name);
   
}


//Car Types
@POST
@Path("InsertTerms/{tname}")
public String InsertTerms(@PathParam("tname") String tname)
{
   
    return adminSessionBean.insertTerms(tname);
   
}
@GET
@Path("ShowTerms/")
@Produces(MediaType.APPLICATION_XML)
public Collection<Terms> ShowTerms()
{
    return adminSessionBean.showTerms();
}

@DELETE
@Path("DeleteTerms/{id}")
public String DeleteTerms(@PathParam("id") int id)
{
   
    return adminSessionBean.deleteTerms(id);
   
}

@GET
@Path("SearchTerms/{id}")
@Produces(MediaType.APPLICATION_XML)
public Terms SearchTerms(@PathParam("id") int id)
{
   
    return adminSessionBean.searchTerms(id);
   
}
@POST
@Path("UpdateTerms/{id}/{name}")
public String UpdateTerms(@PathParam("id") int id,@PathParam("name") String name)
{
   
    return adminSessionBean.updateTerms(id,name);
   
}


//FAQ

@GET
@Path("ShowFaq/")
@Produces(MediaType.APPLICATION_XML)
public Collection<Faq> ShowFaq()
{
    return adminSessionBean.showFaq();
}

@POST
@Path("InsertFaq/{question}/{answer}")
public String InsertFaq(@PathParam("question") String question,@PathParam("answer") String answer)
{
    Faq f = new Faq();
    f.setQuestion(question);
    f.setAnswer(answer);
    return adminSessionBean.insertFaq(f);
}

@DELETE
@Path("DeleteFaq/{faqid}")
public String DeleteFaq(@PathParam("faqid") int faqid)
{
   
    return adminSessionBean.deleteFaq(faqid);
   
}

@GET
@Path("SearchFaq/{faqid}")
@Produces(MediaType.APPLICATION_XML)
public Faq SearchFaq(@PathParam("faqid") int faqid)
{
   
    return adminSessionBean.searchFaq(faqid);
   
}

@POST
@Path("UpdateFaq/{faqid}/{question}/{answer}")
public String UpdateFaq(@PathParam("faqid") int faqid,@PathParam("question") String question,@PathParam("answer") String answer)
{
    Faq f = new Faq();
    f.setFaqid(faqid);
    f.setQuestion(question);
    f.setAnswer(answer);
    return adminSessionBean.updateFaq(f);
}


//Feedback

@GET
@Path("ShowFeedback/")
@Produces(MediaType.APPLICATION_XML)
public Collection<Feedback> ShowFeedback()
{
    return adminSessionBean.showFeedback();
}

@POST
@Path("InsertFeedback/{email}/{message}")
public String InsertFeedback(@PathParam("email") String email,@PathParam("message") String message)
{
    Feedback f = new Feedback();
    f.setEmail(email);
    f.setMessage(message);
    return adminSessionBean.insertFeedback(f);
}

@POST
@Path("UpdateFeedback/{feedbackid}/{message}")
public String UpdateFeedback(@PathParam("feedbackid") int feedbackid,@PathParam("message") String message)
{
    Feedback f = new Feedback();
    f.setFeedbackid(feedbackid);
    f.setMessage(message);
    return adminSessionBean.updateFeedback(f);
}

@DELETE
@Path("DeleteFeedback/{feedbackid}")
public String DeleteFeedback(@PathParam("feedbackid") int feedbackid)
{
   
    return adminSessionBean.deleteFeedback(feedbackid);
   
}

@GET
@Path("SearchFeedback/{feedbackid}")
@Produces(MediaType.APPLICATION_XML)
public Feedback SearchFeedback(@PathParam("feedbackid") int feedbackid)
{
   
    return adminSessionBean.searchFeedback(feedbackid);
   
}

//Contact Us

@GET
@Path("ShowContactus/")
@Produces(MediaType.APPLICATION_XML)
public Collection<Contactus> ShowContactus()
{
    return adminSessionBean.showContactus();
}

@POST
@Path("InsertContactus/{name}/{email}/{contactno}/{subject}/{message}")
public String InsertContactus(@PathParam("name") String name,@PathParam("email") String email,@PathParam("contactno") String contactno,@PathParam("subject") String subject,@PathParam("message") String message)
{
    Contactus c = new Contactus();
    c.setName(name);
    c.setEmail(email);
    c.setContactno(contactno);
    c.setSubject(subject);
    c.setMessage(message);
    return adminSessionBean.insertContactus(c);
}

@POST
@Path("UpdateContactus/{contactusid}/{name}/{email}/{contactno}/{subject}/{message}")
public String UpdateContactus(@PathParam("contactusid") int contactusid,@PathParam("name") String name,@PathParam("email") String email,@PathParam("contactno") String contactno,@PathParam("subject") String subject,@PathParam("message") String message)
{
    Contactus c = new Contactus();
    c.setContacustid(contactusid);
    c.setName(name);
    c.setEmail(email);
    c.setContactno(contactno);
    c.setSubject(subject);
    c.setMessage(message);
    return adminSessionBean.updateContactus(c);
}

@DELETE
@Path("DeleteContactus/{contactusid}")
public String DeleteContactus(@PathParam("contactusid") int contactusid)
{
   
    return adminSessionBean.deleteContactus(contactusid);
   
}

@GET
@Path("SearchContactus/{contactusid}")
@Produces(MediaType.APPLICATION_XML)
public Contactus SearchContactus(@PathParam("contactusid") int contactusid)
{
   
    return adminSessionBean.searchContactus(contactusid);
   
}

//Team
@GET
@Path("ShowTeam/")
@Produces(MediaType.APPLICATION_XML)
public Collection<Team> ShowTeam()
{
    return adminSessionBean.showTeam();
}


 
@POST
@Path("InsertTeam/{name}/{gender}/{post}/{image}/{descriptioon}/{cityid}/{joindate}/{contactno}/{email}")
public String InsertTeam(@PathParam("name") String name,@PathParam("gender") String gender,@PathParam("post") String post,@PathParam("image") String image,@PathParam("descriptioon") String descriptioon,@PathParam("cityid") int cityid,@PathParam("joindate") String joindate,@PathParam("contactno") String contactno,@PathParam("email") String email) throws ParseException
{
    String jd = joindate;
    Date dt1 = new SimpleDateFormat("yyyy-MM-dd").parse(jd);
    return adminSessionBean.insertTeam(name, gender, post, image, descriptioon, cityid, dt1, contactno, email);
}

@POST
@Path("UpdateTeam/{teamid}/{name}/{gender}/{post}/{image}/{descriptioon}/{cityid}/{joindate}/{contactno}/{email}")
public String UpdateTeam(@PathParam("teamid") int teamid,@PathParam("name") String name,@PathParam("gender") String gender,@PathParam("post") String post,@PathParam("image") String image,@PathParam("descriptioon") String descriptioon,@PathParam("cityid") int cityid,@PathParam("joindate") String joindate,@PathParam("contactno") String contactno,@PathParam("email") String email) throws ParseException
{
    String jd = joindate;
    Date dt1 = new SimpleDateFormat("yyyy-MM-dd").parse(jd);
    return adminSessionBean.updateTeam(teamid, name, gender, post, image, descriptioon, cityid, dt1, contactno, email);
}

@DELETE
@Path("DeleteTeam/{teamid}")
public String DeleteTeam(@PathParam("teamid") int teamid)
{
   
    return adminSessionBean.deleteTeam(teamid);
   
}

@GET
@Path("SearchTeam/{teamid}")
@Produces(MediaType.APPLICATION_XML)
public Team SearchTeam(@PathParam("teamid") int teamid)
{
   
    return adminSessionBean.searchTeam(teamid);
   
}
  
  //Cars  

@GET
@Path("ShowCars/")
@Produces(MediaType.APPLICATION_XML)
public Collection<Cars> ShowCars()
{
    return adminSessionBean.showCars();
}

@POST
@Path("InsertCars/{mname}/{type}/{cartypeid}/{drivemode}/{pcapacity}/{lcapacity}/{cityid}/{image}")
public String InsertCars(@PathParam("mname") String mname,@PathParam("type") String type,@PathParam("cartypeid") int cartypeid,@PathParam("drivemode") String drivemode,@PathParam("pcapacity") int pcapacity,@PathParam("lcapacity") int lcapacity,@PathParam("cityid") int cityid,@PathParam("image") String image) throws ParseException
{
  
    return adminSessionBean.insertCar(mname, type, cartypeid, drivemode, pcapacity,lcapacity, cityid, image);
}

@POST
@Path("UpdateCars/{id}/{mname}/{type}/{cartypeid}/{drivemode}/{pcapacity}/{lcapacity}/{cityid}/{image}")
 
public String UpdateCars(@PathParam("id") int id,@PathParam("mname") String mname,@PathParam("type") String type,@PathParam("cartypeid") int cartypeid,@PathParam("drivemode") String drivemode,@PathParam("pcapacity") int pcapacity,@PathParam("lcapacity") int lcapacity,@PathParam("cityid") int cityid,@PathParam("image") String image) throws ParseException
{
    
   return adminSessionBean.updateCar(id,mname, type, cartypeid, drivemode, pcapacity,lcapacity, cityid, image);
}

@DELETE
@Path("DeleteCars/{id}")
public String DeleteCars(@PathParam("id") int id)
{
   
    return adminSessionBean.deleteCars(id);
   
}

@GET
@Path("SearchCars/{carid}")
@Produces(MediaType.APPLICATION_XML)
public Cars SearchCars(@PathParam("carid") int carid)
{
   
    return adminSessionBean.searchCars(carid);
   
}
  
//CarPackage

    @GET
@Path("ShowCarpackage/")
@Produces(MediaType.APPLICATION_XML)
    public Collection<Carpackage> ShowCarpackage()
{
    return adminSessionBean.showCarpackages();
}

@POST
@Path("InsertCarpackage/{cid}/{pname}/{price}")
public String InsertCarpackage(@PathParam("cid") int cid,@PathParam("pname") String pname,@PathParam("price") int price)
{
//    Carpackage cp=new Carpackage();
//    cp.setPname(pname);
//    cp.setCarid(cid);
//    cp.setPrice(price);
    return adminSessionBean.insertCarpackage(cid, pname, price);
   
}

@DELETE
@Path("DeleteCarpackage/{id}")
public String DeleteCarpackage(@PathParam("id") int id)
{
   
    return adminSessionBean.deleteCarpackage(id);
   
}

@GET
@Path("SearchCarpackage/{id}")
@Produces(MediaType.APPLICATION_XML)
public Carpackage SearchCarpackage(@PathParam("id") int id)
{
   
    return adminSessionBean.searchCarpackage(id);
   
}
 
//int id, int cid, String pname, int price
@POST
@Path("UpdateCarpackage/{id}/{cid}/{pname}/{price}")
public String UpdateCarpackage(@PathParam("id") int id,@PathParam("cid") int cid,@PathParam("pname") String pname,@PathParam("price") int price)
{
 
    return adminSessionBean.updateCarpackage(id,cid, pname, price);
   
}


@POST
    @Path("CheckUserLogin/{email}/{password}")
    public Reg CheckUserLogin(@PathParam("email") String email, @PathParam("password") String password)
    {
        Reg u = adminSessionBean.checkuserLogin(email, password);
        return u;
    }

}
