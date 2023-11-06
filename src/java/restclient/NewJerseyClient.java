/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package restclient;

import java.text.ParseException;
import java.util.Date;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author hitesh
 */
public class NewJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/CarRentalSecurity/webresources";
 
    public NewJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

      public String DeleteCity(int cityid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("DeleteCity/{0}", new Object[]{cityid})).request().delete(String.class);
    }

    public <T> T SearchCity(Class<T> responseType, int cityid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchCity/{0}", new Object[]{cityid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }    
    
    public String UpdateCity(int cityid, String cityname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("UpdateCity/{0}/{1}", new Object[]{cityid,  cityname})).request().post(null, String.class);
    }
 
    public String InsertCity( String cityname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("InsertCity/{0}", new Object[]{ cityname})).request().post(null, String.class);
    }

    public <T> T ShowCity(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("ShowCity");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    
    
//Car Types    
      public String DeleteCarType(int id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("DeleteCarType/{0}", new Object[]{id})).request().delete(String.class);
    }

    public <T> T SearchCarType(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchCarType/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }    
    
    public String UpdateCarType(int id, String name) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("UpdateCarType/{0}/{1}", new Object[]{id,  name})).request().post(null, String.class);
    }
 
    public String InsertCarType( String name) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("InsertCarType/{0}", new Object[]{ name})).request().post(null, String.class);
    }

    public <T> T ShowCarType(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("ShowCarType");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
    //Terms
    
       
      public String DeleteTerms(int id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("DeleteTerms/{0}", new Object[]{id})).request().delete(String.class);
    }

    public <T> T SearchTerms(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchTerms/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }    
    
    public String UpdateTerms(int id, String name) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("UpdateTerms/{0}/{1}", new Object[]{id,  name})).request().post(null, String.class);
    }
 
    public String InsertTerms( String name) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("InsertTerms/{0}", new Object[]{ name})).request().post(null, String.class);
    }

    public <T> T ShowTerms(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("ShowTerms");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
    
    
    //FAQ
    
        public <T> T SearchFaq(Class<T> responseType, int faqid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchFaq/{0}", new Object[]{faqid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T ShowFaq(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("ShowFaq");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public String UpdateFaq(int faqid, String question, String answer) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("UpdateFaq/{0}/{1}/{2}", new Object[]{faqid, question, answer})).request().post(null, String.class);
    }    
    
    public String InsertFaq(String question, String answer) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("InsertFaq/{0}/{1}", new Object[]{question, answer})).request().post(null, String.class);
    }

    public String DeleteFaq(int faqid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("DeleteFaq/{0}", new Object[]{faqid})).request().delete(String.class);
    }

    //FeedBack
     public String InsertFeedback(String email, String message) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("InsertFeedback/{0}/{1}", new Object[]{email, message})).request().post(null, String.class);
    }

    public <T> T SearchFeedback(Class<T> responseType, int feedbackid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchFeedback/{0}", new Object[]{feedbackid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public String DeleteFeedback(int feedbackid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("DeleteFeedback/{0}", new Object[]{feedbackid})).request().delete(String.class);
    }

    public <T> T ShowFeedback(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("ShowFeedback");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public String UpdateFeedback(int feedbackid, String message) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("UpdateFeedback/{0}/{1}", new Object[]{feedbackid, message})).request().post(null, String.class);
    }
    
    
    //Contactus
    public String DeleteContactus(int contactusid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("DeleteContactus/{0}", new Object[]{contactusid})).request().delete(String.class);
    }

    public <T> T ShowContactus(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("ShowContactus");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T SearchContactus(Class<T> responseType, int contactusid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchContactus/{0}", new Object[]{contactusid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public String UpdateContactus(int contactusid, String name, String email, String contactno, String subject, String message) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("UpdateContactus/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{contactusid, name, email, contactno, subject, message})).request().post(null, String.class);
    }

    public String InsertContactus(String name, String email, String contactno, String subject, String message) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("InsertContactus/{0}/{1}/{2}/{3}/{4}", new Object[]{name, email, contactno, subject, message})).request().post(null, String.class);
    }

    
    //Team and Staff
        public <T> T ShowTeam(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("ShowTeam");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }    
    public String InsertTeam(String name, String gender, String post, String image, String descriptioon, int cityid, String joindate, String contactno, String email) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("InsertTeam/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{name, gender, post, image, descriptioon, cityid, joindate, contactno, email})).request().post(null, String.class);
    }   
    public String UpdateTeam(int teamid, String name, String gender, String post, String image, String descriptioon, int cityid, String joindate, String contactno, String email) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("UpdateTeam/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}", new Object[]{teamid, name, gender, post, image, descriptioon, cityid, joindate, contactno, email})).request().post(null, String.class);
    } 
    public String DeleteTeam(int teamid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("DeleteTeam/{0}", new Object[]{teamid})).request().delete(String.class);
    }   
    public <T> T SearchTeam(Class<T> responseType, int teamid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchTeam/{0}", new Object[]{teamid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
 
    
    // Cars
    
    public <T> T ShowCars(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("ShowCars");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }    
    public String InsertCars( String mname, String type, int cartypeid, String drivemode, int pcapacity,int lcapacity, int cityid,String image) throws ClientErrorException

    {
        return webTarget.path(java.text.MessageFormat.format("InsertCars/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{mname, type,cartypeid,drivemode,pcapacity,lcapacity,cityid, image})).request().post(null, String.class);
    }   
    public String UpdateCars(int id,String mname, String type, int cartypeid, String drivemode, int pcapacity,int lcapacity, int cityid,String image) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("UpdateCars/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{id,mname, type,cartypeid,drivemode,pcapacity,lcapacity,cityid, image})).request().post(null, String.class);
    } 
    public String DeleteCars(int id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("DeleteCars/{0}", new Object[]{id})).request().delete(String.class);
    }   
    public <T> T SearchCars(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchCars/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
    
  //CarPackage  
 
     
        public String InsertCarpackage(int cid, String pname,int price) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("InsertCarpackage/{0}/{1}/{2}", new Object[]{cid, pname,price})).request().post(null, String.class);
    }

          public String UpdateCarpackage(int id,int cid, String pname,int price) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("UpdateCarpackage/{0}/{1}/{2}/{3}", new Object[]{id,cid, pname,price})).request().post(null, String.class);
    }
        
    public <T> T SearchCarpackage(Class<T> responseType, int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("SearchCarpackage/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public String DeleteCarpackage(int id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("DeleteCarpackage/{0}", new Object[]{id})).request().delete(String.class);
    }
//UpdateCarpackage/{id}/{cid}/{pname}/{price}
//    public String UpdateCarpackage(int id, int cid, String pname,int price) throws ClientErrorException {
//        //return webTarget.path(java.text.MessageFormat.format("UpdateCarpackage/{0}/{1}/{2}/{3}", new Object[]{id, cid, pname,price})).request().post(null, String.class);
//      return webTarget.path(java.text.MessageFormat.format("InsertCarpackage/{0}/{1}/{2}", new Object[]{cid, pname,price})).request().post(null, String.class);
//    
//    }
   
    
     //public String UpdateCarpackage(int id,int cid,String pname,int price) throws ClientErrorException {
  //     return webTarget.path(java.text.MessageFormat.format("InsertCarpackage/{0}/{1}/{2}", new Object[]{cid, pname,price})).request().post(null, String.class);
 
//        return webTarget.path(java.text.MessageFormat.format("UpdateCarpackage/{0}/{1}/{2}/{3}", new Object[]{id,cid,pname, price})).request().post(null, String.class);
  //  } 
    public <T> T ShowCarpackage(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("ShowCarpackage");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
   

//Login
public <T> T CheckUserLogin(Class<T> responseType, String email, String password) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("CheckUserLogin/{0}/{1}", new Object[]{email, password})).request().post(null, responseType);
    }    
    public void close() {
        client.close();
    }
    
}
