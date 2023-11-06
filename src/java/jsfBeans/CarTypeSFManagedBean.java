/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsfBeans;
 
import Entity.Cartype;
import Entity.City;

import ejb.AdminSessionBeanLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

 
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
 
import restclient.NewJerseyClient;

/**
 *
 * @author hitesh
 */
@Named(value = "carTypeJSFManagedBean")
@SessionScoped
//@RequestScoped
public class CarTypeSFManagedBean implements Serializable { 
    
    @EJB
    private AdminSessionBeanLocal adminSessionBean;

    

    
    
    //SecureClient njc=new SecureClient();
   NewJerseyClient njc = new NewJerseyClient();
    String name;
int id;
    
    public void clear()
    {
         name = "";
         id=0;
    }
    
    
 
    //City
    public String insertcartype()
    {
        Cartype c=new Cartype();
       c.setTypename(name);
       
       String successmsg1 = njc.InsertCarType(name);
//       if(successmsg1.length()==0)
//       {
//           msg2 = "true";
//       }
       clear();
//       return "addcity.xhtml?faces-redirect=true";
       return "viewcartype.xhtml?faces-redirect=true";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     
    
    
    public List<Cartype> showcartype()
    {
        Response rs= njc.ShowCarType(Response.class);
        ArrayList<Cartype> clist = new ArrayList<Cartype>();
        GenericType<Collection<Cartype>> gctype = new GenericType<Collection<Cartype>>() { };
        clist = ( ArrayList<Cartype> ) rs.readEntity( gctype);
        return clist;
    }          
    
    public String deletecartype(int id)
    {
        njc.DeleteCarType(id);
        return "viewcartype.xhtml?faces-redirect=true";
    }
    
    public String searchcartype(int tid)
    {    
        Response rs = njc.SearchCarType(Response.class, tid);   
        GenericType<Cartype> gctype = new GenericType<Cartype>(){ };
        Cartype ct= rs.readEntity(gctype);
        id= ct.getId();
        name = ct.getTypename();
         
        return "editcartype.xhtml?faces-redirect=true";       
    }
    
    public String updatecartype()
    {
       Cartype c=new Cartype();
       c.setId(id);
       c.setTypename(name);
       njc.UpdateCarType(id, name);
       return "viewcartype.xhtml?faces-redirect=true";
    }

//        //Port
//    public String insertport()
//    {
//        Port p=new Port();
//       p.setStateid(new State(stateid));
//       p.setPortname(portname);
//       njc.InsertPort(stateid, portname);
//       return "viewport.xhtml?faces-redirect=true";
//    }
//    
//    public List<Port> showport()
//    {
//        Response rs= njc.ShowPort(Response.class);
//        ArrayList<Port> plist = new ArrayList<Port>();
//        GenericType<Collection<Port>> gcport = new GenericType<Collection<Port>>() { };
//        plist = ( ArrayList<Port> ) rs.readEntity( gcport);
//        return plist;
//    }          
//    
//    public String deleteport(int pid)
//    {
//        njc.DeletePort(pid);
//        return "viewport.xhtml?faces-redirect=true";
//    }
//    
//    public String searchport(int id)
//    {    
//        Response rs = njc.SearchPort(Response.class, id);   
//        GenericType<Port> gport = new GenericType<Port>(){ };
//        Port pt= rs.readEntity(gport);
//        portid = pt.getPortid();
//        portname = pt.getPortname();
//        State s = pt.getStateid();
//        return "editport.xhtml?faces-redirect=true";       
//    }
//    
//    public String updateport()
//    {
//       Port p=new Port();
//       p.setPortid(portid);
//       p.setStateid(new State(stateid));
//       p.setPortname(portname);
//       njc.UpdatePort(portid, stateid, portname);
//       return "viewport.xhtml?faces-redirect=true";
//    }
//
//    //Cabin
//    
//    public List<Cabin> showcabin()
//    {
//        Response rs= njc.ShowCabin(Response.class);
//        ArrayList<Cabin>  clist = new ArrayList<Cabin>();
//        GenericType<Collection<Cabin>> gccabin = new GenericType<Collection<Cabin>>(){ };
//        clist = ( ArrayList<Cabin> ) rs.readEntity(gccabin);
//        return clist;
//
//    }
//    
//    public String insertcabin()
//    {
//        Cabin c = new Cabin();
//        c.setCruiseshipid(new Cruiseship(cruiseshipid));
//        c.setCabinname(cabinname);
//        c.setArea(area);
//        c.setOccupancy(occupancy);
//        c.setCharge(cbcharge);
//        c.setDescription(cbdescription);
////        c.setImage(cbimage);
//        if(cbimage==null)
//        {
//            errmsg6 = "Please Select Image";
//            return "addcabin.xhtml?faces-redirect=true";
//        }
//        else
//        {
//            c.setImage(cbimage);
//            njc.InsertCabin(cruiseshipid, cabinname, area, occupancy, cbcharge, cbimage, cbdescription);
//            return "viewcabin.xhtml?faces-redirect=true";
//        }
////        njc.InsertCabin(cruiseshipid, cabinname, area, occupancy, cbcharge, cbimage);
////        return "viewcabin.xhtml";
//    }
//    
//    public String deletecabin(int id)
//    {
//        njc.DeleteCabin(id);
//        return "viewcar.xhtml?faces-redirect=true";
//    }
//    
//    public String searchcabin(int id)
//    {
//        Response rs = njc.SearchCabin(Response.class, id);
//        GenericType<Cabin> gcabin = new GenericType<Cabin>(){ };
//        Cabin cb=rs.readEntity(gcabin);
//        cabinid = cb.getCabinid();
//        Cruiseship c=cb.getCruiseshipid();
//        cabinname = cb.getCabinname();
//        area = cb.getArea();
//        occupancy = cb.getOccupancy();
//        cbcharge=cb.getCharge();
////        image = cb.getImage();
//        cbimage=cb.getImage();
//        cbdescription = cb.getDescription();
//        return "editcar.xhtml?faces-redirect=true";
//    }
//    
//    public String updatecabin()
//    {
//        Cabin c=new Cabin();
//        c.setCruiseshipid(new Cruiseship(cruiseshipid));
//        c.setCabinname(cabinname);
//        c.setArea(area);
//        c.setOccupancy(occupancy);
//        c.setCharge(cbcharge);
//        c.setImage(cbimage);
//        c.setDescription(cbdescription);
//        njc.UpdateCabin(cabinid, cruiseshipid, cabinname, area, occupancy, cbcharge, cbimage, cbdescription);
//        return "viewcar.xhtml?faces-redirect=true";
//    }
//    
//    public String detailcabin(int id)
//    {    
//
//        Response rs = njc.SearchCabin(Response.class, id);
//        GenericType<Cabin> gcabin = new GenericType<Cabin>(){ };
//        Cabin cb=rs.readEntity(gcabin);
//        cabinid = cb.getCabinid();
//        Cruiseship c=cb.getCruiseshipid();
//        cruiseshipid = c.getCruiseshipid();
//        cruisename = c.getCruisename();
//        cabinname = cb.getCabinname();
//        area = cb.getArea();
//        occupancy = cb.getOccupancy();
//        cbcharge=cb.getCharge();
////        image = cb.getImage();
//        cbimage=cb.getImage();
//        cbdescription = cb.getDescription();
//        
//        return "detailcar.xhtml?faces-redirect=true";       
//    }    
//    
//    //Amenity
//    
//    public List<Amenities> showamenity()
//    {
//        Response rs= njc.ShowAmenity(Response.class);
//        ArrayList<Amenities>  alist = new ArrayList<Amenities>();
//        GenericType<Collection<Amenities>> gcamenity = new GenericType<Collection<Amenities>>(){ };
//        alist = ( ArrayList<Amenities> ) rs.readEntity(gcamenity);
//        return alist;
//
//    }
//    
//    public String insertamenity()
//    {
//        Amenities a = new Amenities();
//        a.setTitle(title);
//        a.setDescription(description);
//        String successmsg = njc.InsertAmenity(title, description);
//        if(successmsg!=""){
//            String msg = "true";
//        }
//        return "viewamenity.xhtml?faces-redirect=true";
//    }
//    
//    public String deleteamenity(int id)
//    {
//        njc.DeleteAmenity(id);
//        return "viewamenity.xhtml?faces-redirect=true";
//    }
//    
//    public String searchamenity(int id)
//    {
//        Response rs = njc.SearchAmenity(Response.class, id);
//        GenericType<Amenities> gamenity = new GenericType<Amenities>(){ };
//        Amenities am=rs.readEntity(gamenity);
//        amenityid = am.getAmenityid();
//        title = am.getTitle();
//        description = am.getDescription();
//        return "editamenity.xhtml?faces-redirect=true";
//    }
//    
//    public String updateamenity()
//    {
//        Amenities a = new Amenities();
//        a.setAmenityid(amenityid);
//        a.setTitle(title);
//        a.setDescription(description);
//        njc.UpdateAmenity(amenityid, title, description);
//        return "viewamenity.xhtml?faces-redirect=true";
//    }
//    
//    //Cruise
//    
//    public List<Cruiseship> showcruiseship()
//    {
//        Response rs= njc.ShowCruiseship(Response.class);
//        ArrayList<Cruiseship>  clist = new ArrayList<Cruiseship>();
//        GenericType<Collection<Cruiseship>> gccruise = new GenericType<Collection<Cruiseship>>(){ };
//        clist = ( ArrayList<Cruiseship> ) rs.readEntity(gccruise);
//        return clist;
//
//    }
//    
//    public String insertcruiseship()
//    {
//        Cruiseship c = new Cruiseship();
//        c.setCruisename(cruisename);
//        c.setCapacity(capacity);
//        c.setTotalstaff(totalstaff);
//        c.setImage(cruiseshipimage);
//        capacity1 = capacity + "";
//        totalstaff1 = totalstaff + "";
////        c.setCapacity(capacity);
////        c.setTotalstaff(totalstaff);
////        System.out.println("Bean Capacity " + capacity);
////        System.out.println("Bean Total Staff " + totalstaff);
//
////        njc.InsertCruise(cruisename, capacity1, totalstaff1);
////        return "viewcruise.xhtml";
//       if(cruiseshipimage==null)
//        {
//            errmsg5 = "Please Upload Your Image";
//            return "addcruiseship.xhtml?faces-redirect=true";
//        }
//        else
//        {
//          c.setImage(cruiseshipimage);
//          njc.InsertCruiseship(cruisename, capacity1, totalstaff1, cruiseshipimage);
//        }
////        String successmsg = njc.InsertCruiseship(cruisename, capacity1, totalstaff1, cruiseshipimage);
////        if(successmsg!="")
////        {
////            String msg = "true";
////        }
//        clear();
//        return "viewcruiseship.xhtml?faces-redirect=true";
//        
//    }
//    
//    public String deletecruiseship(int id)
//    {
//        njc.DeleteCruiseship(id);
//        return "viewcruiseship.xhtml?faces-redirect=true";
//    }
//    
//    public String searchcruiseship(int id)
//    {
//        Response rs = njc.SearchCruiseship(Response.class, id);
//        GenericType<Cruiseship> gcruise = new GenericType<Cruiseship>(){ };
//        Cruiseship cr =rs.readEntity(gcruise);
//        cruiseshipid = cr.getCruiseshipid();
//        cruisename = cr.getCruisename();
//        capacity = cr.getCapacity();
//        totalstaff = cr.getTotalstaff();
//        cruiseshipimage = cr.getImage();
//        return "editcarcategory.xhtml?faces-redirect=true";
//    }
//    
//    public String updatecruiseship()
//    {
//        Cruiseship c = new Cruiseship();
//        c.setCruiseshipid(cruiseshipid);
//        c.setCruisename(cruisename);
//        c.setCapacity(capacity);
//        
//        capacity1 = capacity + "";
//        totalstaff1 = totalstaff + "";
//        
//        c.setTotalstaff(totalstaff);
//        c.setImage(cruiseshipimage);
//        njc.UpdateCruiseship(cruiseshipid, cruisename, capacity1, totalstaff1, cruiseshipimage);
//        return "viewcarcategory.xhtml?faces-redirect=true";
//    }
//   
//    public void handleFileUploadCruiseShip(FileUploadEvent event)
//    {
//                Random random = new Random();
//	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg);   
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfname=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfname+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfname+=event.getFile().getFileName();
//
//                    cruiseshipimage=dfname;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfname));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                    
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }	    
//        
//    }
//    
//    //Faq
//    
//    public List<Faq> showfaq()
//    {
//        Response rs= njc.ShowFaq(Response.class);
//        ArrayList<Faq>  flist = new ArrayList<Faq>();
//        GenericType<Collection<Faq>> gcfaq = new GenericType<Collection<Faq>>(){ };
//        flist = ( ArrayList<Faq> ) rs.readEntity(gcfaq);
//        return flist;
//
//    }
//    
//    public String insertfaq()
//    {
//        Faq f = new Faq();
//        f.setQuestion(question);
//        f.setAnswer(answer);
//        String successmsg = njc.InsertFaq(question, answer);
//        if(successmsg != "")
//        {
//            msg = "true";
//        }
//        return "viewfaq.xhtml?faces-redirect=true";
//    }
//    
//    public String deletefaq(int id)
//    {
//        njc.DeleteFaq(id);
//        return "viewfaq.xhtml?faces-redirect=true";
//    }
//    
//    public String searchfaq(int id)
//    {
//        Response rs = njc.SearchFaq(Response.class, id);
//        GenericType<Faq> gfaq = new GenericType<Faq>(){ };
//        Faq faq =rs.readEntity(gfaq);
//        faqid = faq.getFaqid();
//        question = faq.getQuestion();
//        answer = faq.getAnswer();
//        return "editfaq.xhtml?faces-redirect=true";
//    }
//    
//    public String updatefaq()
//    {
//        Faq f = new Faq();
//        f.setFaqid(faqid);
//        f.setQuestion(question);
//        f.setAnswer(answer);
//        njc.UpdateFaq(faqid, question, answer);
//        return "viewfaq.xhtml?faces-redirect=true";
//    }    
//    
//    //Feedback
//    
//    public List<Feedback> showfeedback()
//    {
//        Response rs= njc.ShowFeedback(Response.class);
//        ArrayList<Feedback>  flist = new ArrayList<Feedback>();
//        GenericType<Collection<Feedback>> gcfeedback = new GenericType<Collection<Feedback>>(){ };
//        flist = ( ArrayList<Feedback> ) rs.readEntity(gcfeedback);
//        return flist;
//
//    }
//    
////    public String insertfeedback()
////    {
////        Feedback f = new Feedback();
////        f.setMessage(message);
////        f.setEmail(femail);
////        njc.InsertFeedback(message,femail);
////        return "viewfeedback.xhtml?faces-redirect=true";
////    }
//    
//    public String deletefeedback(int id)
//    {
//        njc.DeleteFeedback(id);
//        return "viewfeedback.xhtml?faces-redirect=true";
//    }
//    
//    public String searchfeedback(int id)
//    {
//        Response rs = njc.SearchFeedback(Response.class, id);
//        GenericType<Feedback> gfeedback = new GenericType<Feedback>(){ };
//        Feedback feedback =rs.readEntity(gfeedback);
//        feedbackid = feedback.getFeedbackid();
//        message = feedback.getMessage();
//        return "viewfeedback.xhtml?faces-redirect=true";
//    }
//    
//    public String updatefeedback()
//    {
//        Feedback f = new Feedback();
//        f.setFeedbackid(feedbackid);
//        f.setMessage(message);
//        njc.UpdateFeedback(feedbackid, message);
//        return "viewfeedback.xhtml?faces-redirect=true";
//    }
//
//    //Contact Us
//    
//    public List<Contactus> showcontactus()
//    {
//        Response rs= njc.ShowContactus(Response.class);
//        ArrayList<Contactus>  clist = new ArrayList<Contactus>();
//        GenericType<Collection<Contactus>> gccontactus = new GenericType<Collection<Contactus>>(){ };
//        clist = ( ArrayList<Contactus> ) rs.readEntity(gccontactus);
//        return clist;
//
//    }
//    
//    public String insertcontactus()
//    {
//        Contactus c = new Contactus();
//        c.setName(name);
//        c.setEmail(email);
//        c.setContactno(contactno);
//        c.setSubject(subject);
//        c.setMessage(contactmessage);
//        njc.InsertContactus(name, email, contactno, subject, contactmessage);
//                     FacesContext.getCurrentInstance().
//                   addMessage(null,
//                      new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                       "Message Sent Successfully!", null));
//        return "addusercontactus.xhtml?faces-redirect=true";
//    }
//    
//    public String deletecontactus(int id)
//    {
//        njc.DeleteContactus(id);
//        return "viewcontactus.xhtml?faces-redirect=true";
//    }
//    
//    public String searchcontactus(int id)
//    {
//        Response rs = njc.SearchContactus(Response.class, id);
//        GenericType<Contactus> gcontactus = new GenericType<Contactus>(){ };
//        Contactus contactus =rs.readEntity(gcontactus);
//        contactusid = contactus.getContacustid();
//        name = contactus.getName();
//        email = contactus.getEmail();
//        subject = contactus.getSubject();
//        contactmessage = contactus.getMessage();
//        return "viewcontactus.xhtml?faces-redirect=true";
//    }
//    
//    public String updatecontactus()
//    {
//        Contactus c = new Contactus();
//        c.setContacustid(contactusid);
//        c.setName(name);
//        c.setEmail(email);
//        c.setContactno(contactno);
//        c.setSubject(subject);
//        c.setMessage(contactmessage);
//        njc.UpdateContactus(contactusid, name, email, contactno, subject, contactmessage);
//        return "viewcontactus.xhtml?faces-redirect=true";
//    }
//
//    public String getcontactus(int id)
//    {    
//       
//        contactusid = id;
//        searchcontactus(id);
//        return "addcontactus.xhtml?faces-redirect=true";       
//    }
//    
// public void givecontactusanswer(String sub,String cm,String e,String m)
//    {
//   
//        try
//        {
//     
//            subject = sub;
//            contactmessage = cm;
//            email = e;
//            contactusanswer = m;
//            
//            
//            String host = "smtp.gmail.com";
//            //final String from = "tandel.shefali25@gmail.com";//your gmail account
//            //final String password1 = "25shefali1993";//your password of gmail account
//            final String from = "066dhruvipatel@gmail.com";//your gmail account
//            final String password1 = "mcelgafzrivktvif";//your password of gmail account
//            String port = "465";
////            String to = "066dhruvipatel@gmail.com";
//            String to = email.toString();
//            Properties prop = new Properties();
//            prop.put("mail.smtp.user", from);
//            prop.put("mail.smtp.host", host);
//            prop.put("mail.smtp.port", port);
//            prop.put("mail.smtp.starttls.enable", "true");
//            prop.put("mail.smtp.auth", "true");
//            prop.put("mail.smtp.debug", "true");
//            prop.put("mail.smtp.socketFactory.port", port);
//            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//            prop.put("mail.smtp.socketFactory.fallback", "false");
//            // Get the default Session object.
//            Session session1 = Session.getInstance(prop, new javax.mail.Authenticator() {
//
//               @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(from, password1);
//                }
//            });
//
//            session1.setDebug(true);
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session1);
//
//            // Set the RFC 822 "From" header field using the
//            // value of the InternetAddress.getLocalAddress method.
//            message.setFrom(new InternetAddress(from));
//
//
//            // Add the given addresses to the specified recipient type.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            // Set the "Subject" header field.
//            message.setSubject("Subject : " + subject + "");
//
//            // Sets the given String as this part's content,
//            // with a MIME type of "text/plain".
////            message.setText(contactmessage + "");
//            String htmlcode = "<p style='font-size:16px'> Query : " + contactmessage + "</p><h3>" + contactusanswer + "</h3>";
//            message.setContent(htmlcode, "text/html");
////            message.setText("<h2>" + contactmessage + "</h2><h4>" + contactusanswer + "</h4>");
//            Transport.send(message);
//            // Send message
//           
////           JOptionPane.showMessageDialog(null, "Please Check Your Mail..." );
//
//        }
//                catch (MessagingException ex1) {
//           
//                    ex1.printStackTrace();
////            JOptionPane.showMessageDialog(null, "Mail not sent,Please Check Your Connection...");
//        }        
//          catch (Exception ex) {
//                    ex.printStackTrace();
//        }          
//    }
//    
//    
//    //Package
//    
//    public String insertcruisepackage()
//    {
//        Cruisepackage p = new Cruisepackage();
//        Date d1 = departuredate;
//        Date d2 = departuretime;
//        Date d3 = arrivaldate;
//        
//        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
//        DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
//        
//        ddate = df1.format(d1);
//        dtime = df2.format(d2);
//        adate = df1.format(d3);
//        
//        p.setPortid(new Port(portid));
//        p.setCruiseshipid(new Cruiseship(cruiseshipid));
//        p.setPlace(place);
//        p.setDescription(packagedescription);
//        p.setPrice(price);
//        p.setDays(days);
////        p.setDeparturedate(departuredate);
////        p.setDeparturetime(departuretime);
////        p.setArrivaldate(arrivaldate);
//        p.setImage(fname);
//        strprice = price + "";
//        
//        if(fname==null)
//        {
//            errmsg = "Please Upload Your Image";
//            return "addpackage.xhtml?faces-redirect=true";
//        }
//        else
//        {
//            p.setImage(fname);
//            njc.InsertCruisePackage(portid, cruiseshipid, place, packagedescription, strprice, days, ddate, dtime, adate, fname);
//            return "viewpackage.xhtml?faces-redirect=true";
//        }
//        
////       njc.InsertPackage(portid, cruiseid, place, packagedescription, strprice, days, ddate, dtime, adate, fname);
////       return "viewpackage.xhtml";
//    }
//    
//    public List<Cruisepackage> showcruisepackage()
//    {
//        Response rs= njc.ShowCruisePackage(Response.class);
//        ArrayList<Cruisepackage> plist = new ArrayList<Cruisepackage>();
//        GenericType<Collection<Cruisepackage>> gcpackage = new GenericType<Collection<Cruisepackage>>() { };
//        plist = ( ArrayList<Cruisepackage> ) rs.readEntity( gcpackage);
//        for(Cruisepackage p : plist)
//           {
//                System.out.println("Departure Date "+p.getDeparturedate());
//                System.out.println("Departure Time" + p.getDeparturetime());
//                System.out.println("Arrival Time" + p.getArrivaldate());
//           }
//        return plist;
//    }          
//    
//    public String deletecruisepackage(int pid)
//    {
//        njc.DeleteCruisePackage(pid);
//        return "viewpackage.xhtml?faces-redirect=true";
//    }
//    
//    public String searchcruisepackage(int id)
//    {    
//        Response rs = njc.SearchCruisePackage(Response.class, id);   
//        GenericType<Cruisepackage> gpackage = new GenericType<Cruisepackage>(){ };
//        Cruisepackage p = rs.readEntity(gpackage);
//        cruisepackageid = p.getCruisepackageid();
//        Port pt = p.getPortid();
//        Cruiseship cs = p.getCruiseshipid();
//        place = p.getPlace();
//        packagedescription = p.getDescription();
//        price = p.getPrice();
//        days = p.getDays();
//        departuredate = p.getDeparturedate();
//        departuretime = p.getDeparturetime();
//        arrivaldate = p.getArrivaldate();
//        image = p.getImage();
//        fname = p.getImage();
//        
//        return "editpackage.xhtml?faces-redirect=true";       
//    }
//
//    public String detailcruisepackage(int id)
//    {    
//        Response rs = njc.SearchCruisePackage(Response.class, id);   
//        GenericType<Cruisepackage> gpackage = new GenericType<Cruisepackage>(){ };
//        Cruisepackage p = rs.readEntity(gpackage);
//        cruisepackageid = p.getCruisepackageid();
//        Port pt = p.getPortid();
//        portid = pt.getPortid();
//        portname = pt.getPortname();
//        Cruiseship cs = p.getCruiseshipid();
//        cruiseshipid = cs.getCruiseshipid();
//        cruisename = cs.getCruisename();
//        place = p.getPlace();
//        packagedescription = p.getDescription();
//        price = p.getPrice();
//        days = p.getDays();
//        departuredate = p.getDeparturedate();
//        departuretime = p.getDeparturetime();
//        arrivaldate = p.getArrivaldate();
//        image = p.getImage();
////        fname = p.getImage();
//        
//        return "detailpackage.xhtml?faces-redirect=true";       
//    }
//    
//    public String updatecruisepackage()
//    {
//        Cruisepackage p = new Cruisepackage();
//        Date d1 = departuredate;
//        Date d2 = departuretime;
//        Date d3 = arrivaldate;
//        
//        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
//        DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
//        
//        ddate = df1.format(d1);
//        dtime = df2.format(d2);
//        adate = df1.format(d3);
//
//
//        p.setCruisepackageid(cruisepackageid);
//        p.setPortid(new Port(portid));
//        p.setCruiseshipid(new Cruiseship(cruiseshipid));
////        p.setCruiseid(new Cruiseship(cruiseshipid));
//        p.setPlace(place);
//        p.setDescription(packagedescription);
//        p.setPrice(price);
//        p.setDays(days);
////        p.setDeparturedate(departuredate);
////        p.setDeparturetime(departuretime);
////        p.setArrivaldate(arrivaldate);
//        p.setImage(fname);
//        strprice = price + "";
////       njc.UpdatePackage(packageid, portid, cruiseid, place, packagedescription, strprice, days, ddate, dtime, adate, fname);
//        njc.UpdateCruisePackage(cruisepackageid, portid, cruiseshipid, place, packagedescription, strprice, days, ddate, dtime, adate, fname);
//       return "viewpackage.xhtml?faces-redirect=true";
//    } 
//
//        public void handleFileUploadpackage(FileUploadEvent event)
//    {
//                Random random = new Random();
//	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg);   
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfname=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfname+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfname+=event.getFile().getFileName();
//
////                    fname=dfname;
//fname = dfname;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfname));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                    
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }	    
//        
//    }
//    
//        public void handleFileUpload(FileUploadEvent event)
//    {
//                Random random = new Random();
//	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg);   
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfname=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfname+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfname+=event.getFile().getFileName();
//
////                    fname=dfname;
//fnameteam = dfname;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfname));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                    
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }	    
//        
//    }
//
//    //User
////    public String insertuser()
////    {
////        Usertbl u=new Usertbl();
////        
////        u.setName(uname);
////        u.setGender(ugender);
////        u.setAddress(uaddress);
////        u.setCityid(new City(cityid));
////        u.setContactno(ucontactno);
////        u.setEmail(uemail);
////        u.setPassword(upassword);
////        
////       njc.InsertUser(uname, ugender, uaddress, cityid, ucontactno, uemail, upassword);
////       return "viewuser.xhtml";
////    }
//        
//    public String insertuser()
//    {
//       groupid=2;
//        Usertbl u=new Usertbl();
//        u.setGroupid(new Grouptbl(groupid));
////        u.setName(uname);
//u.setUsername(uname);
//        u.setGender(ugender);
//        u.setAddress(uaddress);
//        u.setCityid(new City(cityid));
//        u.setContactno(ucontactno);
//        u.setEmail(uemail);
//        u.setPassword(upassword);
//       
//       njc.InsertUser(groupid, uname, ugender, uaddress, cityid, ucontactno, uemail, upassword);
//       return "/Usermodule/userlogin.xhtml?faces-redirect=true";
//    }        
//    
//    public List<entity.Usertbl> showuser()
//    {
//        Response rs= njc.ShowUser(Response.class);
//        ArrayList<entity.Usertbl> ulist = new ArrayList<entity.Usertbl>();
//        GenericType<Collection<entity.Usertbl>> gcuser = new GenericType<Collection<entity.Usertbl>>() { };
//        ulist = ( ArrayList<entity.Usertbl> ) rs.readEntity(gcuser);
//        return ulist;
//    }          
//    
//    public String deleteuser(int uid)
//    {
//        njc.DeleteUser(uid);
//        return "viewuser.xhtml?faces-redirect=true";
//    }
//    
//    public String searchuser(int id)
//    {    
//        Response rs = njc.SearchUser(Response.class,id);
//        GenericType<entity.Usertbl> guser = new GenericType<entity.Usertbl>(){ };
//        entity.Usertbl u = rs.readEntity(guser);
//        
//        userid=u.getUserid();
////        uname=u.getName();
//uname=u.getUsername();
//        ugender=u.getGender();
//        uaddress=u.getAddress();
//        City c=u.getCityid();
//        ucontactno=u.getContactno();
//        uemail=u.getEmail();
//        upassword=u.getPassword();
//        
//        return "viewuser.xhtml?faces-redirect=true";       
//    }
//    
//    public String updateuser()
//    {
//       Usertbl u=new Usertbl();
//        u.setUserid(userid);
////        u.setName(uname);
//u.setUsername(uname);
//        u.setGender(ugender);
//        u.setAddress(uaddress);
//        u.setCityid(new City(cityid));
//        u.setContactno(ucontactno);
//        u.setEmail(uemail);
//        u.setPassword(upassword);
//        njc.UpdateUser(userid, name, ugender, uaddress, cityid, ucontactno, uemail, upassword);
//       return "viewpackage.xhtml?faces-redirect=true";
//    }    
//    public String detailuser(int id)
//    {    
//        Response rs = njc.SearchUser(Response.class,id);
//        GenericType<entity.Usertbl> guser = new GenericType<entity.Usertbl>(){ };
//        entity.Usertbl u = rs.readEntity(guser);
//        
//        userid=u.getUserid();
////        uname=u.getName();
//uname=u.getUsername();
//        ugender=u.getGender();
//        uaddress=u.getAddress();
//        City c=u.getCityid();
//        cityid=c.getCityid();
//        cityname=c.getCityname();
//        
//        ucontactno=u.getContactno();
//        uemail=u.getEmail();
//        upassword=u.getPassword();
//        
//        
//        return "detailuser.xhtml?faces-redirect=true";       
//    }    
//     //Testimonial
//    public String inserttestimonial()
//    {
//        entity.Testimonial t=new entity.Testimonial();
//        t.setUserid(new Usertbl(userid));
//        t.setName(name);
//        t.setImage(timage);
//        t.setMessage(tmessage);
//        t.setRating(rating);
//        t.setCityid(new City(cityid));
//        
//        njc.InsertTestimonial(userid, name, image, message, rating, cityid);
//       return "viewtestimonial.xhtml?faces-redirect=true";
//    }
//    
//    public List<entity.Testimonial> showtestimonial()
//    {
//        Response rs= njc.ShowTestimonial(Response.class);
//        ArrayList<entity.Testimonial> tlist = new ArrayList<entity.Testimonial>();
//        GenericType<Collection<entity.Testimonial>> gctestimonial = new GenericType<Collection<entity.Testimonial>>() { };
//        tlist = ( ArrayList<entity.Testimonial> ) rs.readEntity(gctestimonial);
//        return tlist;
//    }          
//    
//    public String deletetestimonial(int tid)
//    {
//        njc.DeleteTestimonial(tid);
//        return "viewtestimonial.xhtml?faces-redirect=true";
//    }
//    
//    public String searchtestimonial(int id)
//    {    
//        Response rs = njc.SearchTestimonial(Response.class,id);
//        GenericType<entity.Testimonial> gtestimonial = new GenericType<entity.Testimonial>(){ };
//        entity.Testimonial t = rs.readEntity(gtestimonial);
//        testimonialid=t.getTestimonialid();
//        Usertbl u=t.getUserid();
//        uname=t.getName();
//        timage=t.getImage();
//        tmessage=t.getMessage();
//        rating=t.getRating();
//        City c=u.getCityid();
//       
//        
//        return "edittestimonial.xhtml?faces-redirect=true";       
//    }
//    
//    public String updatetestimonial()
//    {
//        entity.Testimonial t=new entity.Testimonial();
//        t.setTestimonialid(testimonialid);
//        t.setUserid(new Usertbl(userid));
//        t.setName(uname);
//        t.setImage(timage);
//        t.setMessage(tmessage);
//        t.setRating(rating);
//        t.setCityid(new City(cityid));
//        njc.UpdateTestimonial(testimonialid, userid, name, image, message, rating, cityid);
//        return "viewtestimonial.xhtml?faces-redirect=true";       
//    }  
//     
//      public String detailtestimonial(int id)
//    {    
//        Response rs = njc.SearchTestimonial(Response.class,id);
//        GenericType<entity.Testimonial> gtestimonial = new GenericType<entity.Testimonial>(){ };
//        entity.Testimonial t = rs.readEntity(gtestimonial);
//        
//        testimonialid=t.getTestimonialid();
//        Usertbl u=t.getUserid();
//        
////        uname=u.getName();
//        uname=u.getUsername();
//        fname=t.getImage();
//        tmessage=t.getMessage();
//        rating=t.getRating();
//        City c=t.getCityid();
//        cityid=c.getCityid();
//        cityname=c.getCityname();
//       
//        
//        return "detailtestimonial.xhtml?faces-redirect=true";       
//    }    
//    
////CruiseShipAmenity
//    public String insertcruiseshipamenity(int id)
//    {
//        
//      
//       cruiseshipid=id;
//        Cruiseshipamenities ca=new Cruiseshipamenities();
//       ca.setCruiseshipid(new Cruiseship(cruiseshipid));
//       ca.setAmenityid(new Amenities(amenityid));
//       
////       njc.InsertCruiseAmenity(cruiseid, amenityid);
////       return "viewcruise.xhtml";
//
//        String successmg = njc.InsertCruiseShipAmenity(cruiseshipid, amenityid);
//        if(successmg!="")
//        {
//            String msg = "true";
//        }
//               return "viewcruiseshipamenity.xhtml?faces-redirect=true";
//
//    }
//    
//    public List<Cruiseshipamenities> showcruiseshipamenity()
//    {
//        Response rs= njc.ShowCruiseShipAmenity(Response.class);
//        ArrayList<Cruiseshipamenities> calist = new ArrayList<Cruiseshipamenities>();
//        GenericType<Collection<Cruiseshipamenities>> gccruiseamenity = new GenericType<Collection<Cruiseshipamenities>>() { };
//        calist = ( ArrayList<Cruiseshipamenities> ) rs.readEntity( gccruiseamenity);
//        return calist;
//    }          
//    
//    public String deletecruiseshipamenity(int caid)
//    {
//        njc.DeleteCruiseShipAmenity(caid);
//        return "viewcruiseshipamenity.xhtml?faces-redirect=true";
//    }
//    
//    public String searchcruiseshipamenity(int id)
//    {    
//        Response rs = njc.SearchCruiseShipAmenity(Response.class,id);
//        GenericType<Cruiseshipamenities> gcruiseamenity = new GenericType<Cruiseshipamenities>(){ };
//        Cruiseshipamenities ca= rs.readEntity(gcruiseamenity);
//        cruiseshipamenityid = ca.getCruiseshipamenityid();
//        Cruiseship c=ca.getCruiseshipid();
//        Amenities a=ca.getAmenityid();
//      
//        return "editcruiseshipamenity.xhtml?faces-redirect=true";       
//    }
//    
//    public String updatecruiseamenity()
//    {
//        Cruiseshipamenities ca=new Cruiseshipamenities();
//       ca.setCruiseshipamenityid(cruiseshipamenityid);
//       ca.setCruiseshipid(new Cruiseship(cruiseshipid));
//       ca.setAmenityid(new Amenities(amenityid));
//       
//       njc.UpdateCruiseShipAmenity(cruiseshipamenityid, cruiseshipid, amenityid);
//
//      
//       return "viewcruiseshipamenity.xhtml?faces-redirect=true";
//    }
//     public String getcruiseshipamenity(int id)
//    {    
//       
//        cruiseshipid=id;
//        
//        
//      
//        return "addFeatures.xhtml?faces-redirect=true";       
//    }   
//
////Team
//    public String insertteam()
//    {
//        Team t=new Team();
//        Date dt = joindate;
//               
//        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
//        ddate = df1.format(dt);
//
//        t.setName(tmname);
//        t.setGender(tmgender);
//        t.setPost(tmpost);
//        t.setImage(fnameteam);
//        t.setDescriptioon(tmdescriptioon);
//        t.setCityid(new City(cityid));
//        
//        t.setContactno(tmcontactno);
//        t.setEmail(tmemaill);
//        
//        
//                if(fnameteam==null)
//        {
//            errmsg = "Please Upload Your Image";
//            return "addteam.xhtml?faces-redirect=true";
//        }
//        else
//        {
//          t.setImage(fnameteam);
//          njc.InsertTeam(tmname, tmgender, tmpost, fnameteam, tmdescriptioon, cityid, ddate, tmcontactno, tmemaill);
//        }
//
//        return "viewteam.xhtml?faces-redirect=true";
//        
////       njc.InsertTeam(tmname, tmgender, tmpost,fname,tmdescriptioon, cityid, ddate, tmcontactno, tmemaill);
////       return "viewteam.xhtml";
//    }
//    
//    public List<Team> showteam()
//    {
//        Response rs= njc.ShowTeam(Response.class);
//        ArrayList<entity.Team> tmlist = new ArrayList<entity.Team>();
//        GenericType<Collection<entity.Team>> gcteam = new GenericType<Collection<entity.Team>>() { };
//        tmlist = ( ArrayList<entity.Team> ) rs.readEntity( gcteam);
////        teamcnt = tmlist.size();
//        return tmlist;
//    }          
//    
//    public String deleteteam(int tmid)
//    {
//        njc.DeleteTeam(tmid);
//        return "viewteam.xhtml?faces-redirect=true";
//    }
//    
//    public String searchteam(int id)
//    {    
//        Response rs = njc.SearchTeam(Response.class,id);
//        GenericType<entity.Team> gteam = new GenericType<entity.Team>(){ };
//        entity.Team t = rs.readEntity(gteam);
//        teamid=t.getTeamid();
//        tmname=t.getName();
//        tmgender=t.getGender();
//        tmpost=t.getPost();
//        fname=t.getImage();
//        tmdescriptioon=t.getDescriptioon();
//        City c=t.getCityid();
//        joindate=t.getJoindate();
//        tmcontactno=t.getContactno();
//        tmemaill=t.getEmail();
//       
//        
//        return "editteam.xhtml?faces-redirect=true";       
//    }
//    public String detailteam(int id)
//    {    
//        Response rs = njc.SearchTeam(Response.class,id);
//        GenericType<entity.Team> gteam = new GenericType<entity.Team>(){ };
//        entity.Team t = rs.readEntity(gteam);
//        teamid=t.getTeamid();
//        tmname=t.getName();
//        tmgender=t.getGender();
//        tmpost=t.getPost();
////        fname=t.getImage();
//fnameteam=t.getImage();
//tmimage = t.getImage();
//        tmdescriptioon=t.getDescriptioon();
//        City c=t.getCityid();
//        cityid=c.getCityid();
//        cityname=c.getCityname();
//        joindate=t.getJoindate();
//        tmcontactno=t.getContactno();
//        tmemaill=t.getEmail();
//       
//        
//        return "detailteam.xhtml?faces-redirect=true";       
//    }
//    
//    public String updateteam()
//    {
//        Team t=new Team();
//        Date dt = joindate;
//               
//        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
//        ddate = df1.format(dt);
//        t.setTeamid(teamid);
//        t.setName(tmname);
//        t.setGender(tmgender);
//        t.setPost(tmpost);
////        t.setImage(fname);
//t.setImage(fnameteam);
//        t.setDescriptioon(tmdescriptioon);
//        t.setCityid(new City(cityid));
//        
//        t.setContactno(tmcontactno);
//        t.setEmail(tmemaill);
//        
//        
//       njc.UpdateTeam(teamid, tmname, tmgender, tmpost, fnameteam, tmdescriptioon, cityid, ddate, tmcontactno,tmemaill);
//       return "viewteam.xhtml?faces-redirect=true";
//    } 
//    //Itinerary
//    public String insertitinerary(int id)
//    {
//        
//      
//       packageid=id;
//        Itinerary i=new Itinerary();
//       i.setCruisepackageid(new Cruisepackage(cruisepackageid));
//       i.setTitle(ititle);
//       i.setDescription(idescription);
//       
//       String successmsg = njc.InsertItinerary(cruisepackageid, ititle, idescription);
//       if(successmsg != "")
//       {
//           msg = "true";
//       }
//       return "viewitinerary.xhtml?faces-redirect=true";
//    }
//    
//    public List<Itinerary> showitinerary()
//    {
//        Response rs= njc.ShowItinerary(Response.class);
//        ArrayList<Itinerary> ilist = new ArrayList<Itinerary>();
//        GenericType<Collection<Itinerary>> gcitinerary = new GenericType<Collection<Itinerary>>() { };
//        ilist = ( ArrayList<Itinerary> ) rs.readEntity( gcitinerary);
//        return ilist;
//    }          
//    
//    public String deleteitinerary(int iid)
//    {
//        njc.DeleteItinerary(iid);
//        return "viewitinerary.xhtml?faces-redirect=true";
//    }
//    
//    public String searchitinerary(int id)
//    {    
//        Response rs = njc.SearchItinerary(Response.class,id);
//        GenericType<Itinerary> gitinerary = new GenericType<Itinerary>(){ };
//        Itinerary i= rs.readEntity(gitinerary);
//        itineraryid=i.getItineraryid();
//        Cruisepackage p = i.getCruisepackageid();
//        ititle=i.getTitle();
//        idescription=i.getDescription();
//        
//      
//        return "edititinerary.xhtml?faces-redirect=true";       
//    }
//    
//    public String updateitinerary()
//    {
//        
//  
//       Itinerary i=new Itinerary();
//       i.setItineraryid(itineraryid);
//       i.setCruisepackageid(new Cruisepackage(cruisepackageid));
//       i.setTitle(ititle);
//       i.setDescription(idescription);
//       
//       njc.UpdateItinerary(itineraryid, cruisepackageid, ititle, idescription);
//       return "viewitinerary.xhtml?faces-redirect=true";
//      
//      
//    }
//     public String getitinerarypackage(int id)
//    {    
//       
//        cruisepackageid=id;
//        
//        
//      
//        return "additinerary.xhtml?faces-redirect=true";       
//    }   
//    //Facility
//    public String insertfacility(int id)
//    {
//        
//      
//       cruisepackageid=id;
//        Facility f=new Facility();
//       
//       
//       f.setCruisepackageid(new Cruisepackage(cruisepackageid));
//       f.setFacility(facility);
//       f.setDescription(fdescription);
//       
////       njc.InsertFacility(packageid, facility, fdescription);
////       return "viewpackage.xhtml";
//
//       String successmsg = njc.InsertFacility(cruisepackageid, facility, fdescription);
//       if(successmsg!="")
//       {
//           String msg = "true";
//       }
//       return "viewfacility.xhtml?faces-redirect=true";
//    }
//    
//    public List<Facility> showfacility()
//    {
//        Response rs= njc.ShowFacility(Response.class);
//        ArrayList<Facility> flist = new ArrayList<Facility>();
//        GenericType<Collection<Facility>> gcfacility = new GenericType<Collection<Facility>>() { };
//        flist = ( ArrayList<Facility> ) rs.readEntity( gcfacility);
//        return flist;
//    }          
//    
//    public String deletefacility(int fid)
//    {
//        njc.DeleteFacility(fid);
//        return "viewfacility.xhtml?faces-redirect=true";
//    }
//    
//    public String searchfacility(int id)
//    {    
//        Response rs = njc.SearchFacility(Response.class,id);
//        GenericType<Facility> gfacility = new GenericType<Facility>(){ };
//        Facility f= rs.readEntity(gfacility);
//        facilityid=f.getFacilityid();
//        Cruisepackage p = f.getCruisepackageid();
//        facility=f.getFacility();
//        fdescription=f.getDescription();
//        return "editfacility.xhtml?faces-redirect=true";       
//    }
//    
//    public String updatefacility()
//    {
//        
//       
//       Facility f=new Facility();
//       
//       f.setFacilityid(facilityid);
//       f.setCruisepackageid(new Cruisepackage(cruisepackageid));
//       f.setFacility(facility);
//       f.setDescription(fdescription);
//       
//       njc.UpdateFacility(facilityid, cruisepackageid, facility, fdescription);
//       return "viewfacility.xhtml?faces-redirect=true";
//      
//    }
//     public String getfacilitypackage(int id)
//    {    
//       
//        cruisepackageid=id;
//        
//        
//      
//        return "addfacility.xhtml?faces-redirect=true";       
//    }        
//     
//     
//    //Event
//    public String insertevent(int id)
//    {
//        Date d1 = eventdate;
//        Date d2 = starttime;
//        Date d3 = endtime;
//        
//        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
//        DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
//        
//        edate = df1.format(d1);
//        stime = df2.format(d2);
//        etime = df2.format(d3);
//        
//      
//       cruisepackageid=id;
//        Event e = new Event();
//        e.setCruisepackageid(new Cruisepackage(cruisepackageid));
//        e.setTitle(eventtitle);
//        e.setDescription(eventdescription);
//        
//        e.setImage1(image1);
//        e.setImage2(image2);
//        e.setImage3(image3);
//       
//        if(image1==null && image2==null && image3==null)
//        {
//            errmsg1 = "Please Upload Your Image";
//            errmsg2 = "Please Upload Your Image";
//            errmsg3 = "Please Upload Your Image";
//            return "addevent.xhtml?faces-redirect=true";
//        }
//        else
//        {
//          e.setImage1(image1);
//          e.setImage2(image2);
//          e.setImage3(image3);
////          njc.InsertEvent(packageid, eventtitle, eventdescription, edate, stime,etime, image1, image2, image3);
////        return "viewevent.xhtml";
//          String successmsg = njc.InsertEvent(cruisepackageid, eventtitle, eventdescription, edate, stime,etime, image1, image2, image3);
//          if(successmsg!="")
//          {
//              String msg = "true";
//          }
//        return "viewevent.xhtml?faces-redirect=true";
//        }        
//        
////       njc.InsertEvent(packageid, eventtitle, eventdescription, edate, stime, etime, image1, image2, image3);
////       return "viewevent.xhtml";
//    }
//    
//    public List<Event> showevent()
//    {
//        Response rs= njc.ShowEvent(Response.class);
//        ArrayList<Event> elist = new ArrayList<Event>();
//        GenericType<Collection<Event>> gcevent = new GenericType<Collection<Event>>() { };
//        elist = ( ArrayList<Event> ) rs.readEntity( gcevent);
//        return elist;
//    }          
//    
//    public String deleteevent(int eid)
//    {
//        njc.DeleteEvent(eid);
//        return "viewevent.xhtml?faces-redirect=true";
//    }
//    
//    public String searchevent(int id)
//    {    
//        Response rs = njc.SearchEvent(Response.class,id);
//        GenericType<Event> gcevent = new GenericType<Event>(){ };
//        Event ev= rs.readEntity(gcevent);
//        eventid = ev.getEventid();
//        Cruisepackage p = ev.getCruisepackageid();
//        cruisepackageid = p.getCruisepackageid();
//        eventtitle = ev.getTitle();
//        eventdescription = ev.getDescription();
//        eventdate = ev.getEventdate();
//        starttime = ev.getStarttime();
//        endtime = ev.getEndtime();
//        image1 = ev.getImage1();
//        image2 = ev.getImage2();
//        image3 = ev.getImage3();
//      
//        return "editevent.xhtml?faces-redirect=true";       
//    }
//    
//    public String updateevent()
//    {
//        Date d1 = eventdate;
//        Date d2 = starttime;
//        Date d3 = endtime;
//        
//        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
//        DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
//        
//        edate = df1.format(d1);
//        stime = df2.format(d2);
//        etime = df2.format(d3);
//        
//        Event e = new Event();
//        e.setEventid(eventid);
//        e.setCruisepackageid(new Cruisepackage(cruisepackageid));
//        e.setTitle(eventtitle);
//        e.setDescription(eventdescription);
//        
//        e.setImage1(image1);
//        e.setImage2(image2);
//        e.setImage3(image3);
//       
//       carSessionBean.updateEvent(eventid, cruisepackageid, eventtitle, eventdescription, eventdate, starttime, endtime, image1, image2, image3);
//        
////       njc.UpdateEvent(eventid, cruisepackageid, eventtitle, eventdescription, edate, stime, etime, image1, image2, image3);
//
//      
//       return "viewevent.xhtml?faces-redirect=true";
//    }
//     public String geteventpackage(int id)
//    {    
//       
//        cruisepackageid=id;
//        
//        
//      
//        return "addevent.xhtml?faces-redirect=true";       
//    }        
//
//    public String detailevent(int id)
//    {    
//        Response rs = njc.SearchEvent(Response.class,id);
//        GenericType<Event> gcevent = new GenericType<Event>(){ };
//        Event ev= rs.readEntity(gcevent);
//        eventid = ev.getEventid();
//        Cruisepackage p = ev.getCruisepackageid();
//        eventtitle = ev.getTitle();
//        eventdescription = ev.getDescription();
//        eventdate = ev.getEventdate();
//        starttime = ev.getStarttime();
//        endtime = ev.getEndtime();
//        image1 = ev.getImage1();
//        image2 = ev.getImage2();
//        image3 = ev.getImage3();
//        //Aa be uncomment karvana
//        cruisepackageid = p.getCruisepackageid();
//        place = p.getPlace();
//        return "detailevent.xhtml?faces-redirect=true";       
//    }
//
//    //Story
// public String insertstory()
//    {
//     
//     
//        Story s=new Story();
//        s.setTitle(stitle);
//        s.setDescription(sdescription);
//        s.setImage1(simage1);
//        s.setImage2(simage2);
//        s.setImage3(simage3);
//        s.setImage4(simage4);
//        
//        s.setVideo(video);
//       
//       
////        if(simage1==null && simage2==null && simage3==null && simage4==null)
////        {
////            errmsg1 = "Please Upload Your Image";
////            errmsg2 = "Please Upload Your Image";
////            errmsg3 = "Please Upload Your Image";
////            errmsg4 = "Please Upload Your Image";
////            return "addstory.xhtml?faces-redirect=true";
////        }
////        else
////        {
////         s.setImage1(simage1);
////        s.setImage2(simage2);
////        s.setImage3(simage3);
////        s.setImage4(simage4);
////        
////                System.out.println("M" + stitle);
////        System.out.println("M" + sdescription);
////        System.out.println("M" + simage1);
////        System.out.println("M" + simage2);
////        System.out.println("M" + simage3);
////        System.out.println("M" + simage4);
////        System.out.println("M" + video);
//        
////        njc.InsertStory(stitle, sdescription, simage1, simage2, simage3, simage4, video);
//
//        carSessionBean.insertStory(s);
//        return "viewstory.xhtml?faces-redirect=true";
//                
//        
//    }
//    
//    public List<Story> showstory()
//    {
//        Response rs= njc.ShowStory(Response.class);
//        ArrayList<Story> slist = new ArrayList<Story>();
//        GenericType<Collection<Story>> gcstory = new GenericType<Collection<Story>>() { };
//        slist = ( ArrayList<Story> ) rs.readEntity(gcstory);
//        return slist;
//    }          
//    
//    public String deletestory(int sid)
//    {
//        njc.DeleteStory(sid);
//        return "viewstory.xhtml?faces-redirect=true";
//    }
//    
//    public String searchstory(int id)
//    {    
//        Response rs = njc.SearchStory(Response.class,id);
//        GenericType<Story> gcstory = new GenericType<Story>(){ };
//        Story st= rs.readEntity(gcstory);
//        storyid=st.getStoryid();
//        stitle=st.getTitle();
//        sdescription=st.getDescription();
//        simage1=st.getImage1();
//        simage2=st.getImage2();
//        simage3=st.getImage3();
//        simage4=st.getImage4();
//        video=st.getVideo();
//        
//        
//      
//        return "editstory.xhtml?faces-redirect=true";       
//    }
//    
//    public String updatestory()
//    {
//       
//        
//         Story s=new Story();
//         s.setStoryid(storyid);
//        s.setTitle(stitle);
//        s.setDescription(sdescription);
//        s.setImage1(simage1);
//        s.setImage2(simage2);
//        s.setImage3(simage3);
//        s.setImage4(simage4);
//        
//        s.setVideo(video);
//       
//       
////        if(simage1==null && simage2==null && simage3==null && simage4==null)
////        {
////            errmsg1 = "Please Upload Your Image";
////            errmsg2 = "Please Upload Your Image";
////            errmsg3 = "Please Upload Your Image";
////            errmsg4 = "Please Upload Your Image";
////            return "addstory.xhtml?faces-redirect=true";
////        }
////        else
////        {
////         s.setImage1(simage1);
////        s.setImage2(simage2);
////        s.setImage3(simage3);
////        s.setImage4(simage4);
//        //njc.UpdateStory(storyid, stitle, sdescription, simage1, simage2, simage3, simage4, video);
//        
//        carSessionBean.updateStory(s);
//        return "viewstory.xhtml?faces-redirect=true";
//        
//   }    
//      public String detailstory(int id)
//    {    
//           Response rs = njc.SearchStory(Response.class,id);
//        GenericType<Story> gcstory = new GenericType<Story>(){ };
//        Story st= rs.readEntity(gcstory);
//        storyid=st.getStoryid();
//        stitle=st.getTitle();
//        sdescription=st.getDescription();
//        simage1=st.getImage1();
//        simage2=st.getImage2();
//        simage3=st.getImage3();
//        simage4=st.getImage4();
//        video=st.getVideo();
//        
//        
//      
//        return "detailstory.xhtml?faces-redirect=true";     
//    }
//      //Service
//    public List<Service> showservice()
//    {
//        Response rs= njc.ShowService(Response.class);
//        ArrayList<Service>  slist = new ArrayList<Service>();
//        GenericType<Collection<Service>> gcservice = new GenericType<Collection<Service>>(){ };
//        slist = ( ArrayList<Service> ) rs.readEntity(gcservice);
//        return slist;
//
//    }
//    
//    public String insertservice()
//    {
//        Service s=new Service();
//        s.setTitle(srvtitle);
//        s.setDescription(srvdescription);
//        njc.InsertService(srvtitle,srvdescription);
//
//        return "viewservice.xhtml?faces-redirect=true";
//        
//    }
//    
//    public String deleteservice(int id)
//    {
//        njc.DeleteService(id);
//         return "viewservice.xhtml?faces-redirect=true";
//    }
//    
//    public String searchservice(int id)
//    {
//        Response rs = njc.SearchService(Response.class,id);
//        GenericType<Service> gservice = new GenericType<Service>(){ };
//        Service st=rs.readEntity(gservice);
//        serviceid=st.getServiceid();
//        srvtitle=st.getTitle();
//        srvdescription=st.getDescription();
//        return "editservice.xhtml?faces-redirect=true";
//    }
//    
//    public String updateservice()
//    {
//        Service s=new Service();
//        s.setServiceid(serviceid);
//        s.setTitle(srvtitle);
//        s.setDescription(srvdescription);
//        njc.UpdateService(serviceid, srvtitle, srvdescription);
//
//        return "viewservice.xhtml?faces-redirect=true";
//    }
//    
//             public void handleFileUpload1(FileUploadEvent event)
//    {
//                Random random = new Random();
//	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg);   
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfname1=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfname1+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfname1+=event.getFile().getFileName();
//
//                    image1=dfname1;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfname1));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                    
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }	    
//        
//    }
//
//                     public void handleFileUpload2(FileUploadEvent event)
//    {
//                Random random = new Random();
//	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg);   
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfname2=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfname2+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfname2+=event.getFile().getFileName();
//
//                    image2=dfname2;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfname2));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                    
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }	    
//        
//    }
//
//    public void handleFileUpload3(FileUploadEvent event)
//    {
//                Random random = new Random();
//	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg);   
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfname3=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfname3+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfname3+=event.getFile().getFileName();
//
//                    image3=dfname3;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfname3));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                    
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }	    
//        
//    }
//
//      public void handleFileUpload4(FileUploadEvent event)
//    {
//                Random random = new Random();
//	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg);   
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfnames1=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfnames1+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfnames1+=event.getFile().getFileName();
//
//                    simage1=dfnames1;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfnames1));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                    
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }	    
//        
//    }
// public void handleFileUpload5(FileUploadEvent event)
//    {
//                Random random = new Random();
//	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg);   
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfnames2=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfnames2+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfnames2+=event.getFile().getFileName();
//
//                    simage2=dfnames2;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfnames2));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                    
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }	    
//        
//    }
//  public void handleFileUpload6(FileUploadEvent event)
//    {
//                Random random = new Random();
//	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg);   
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfnames3=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfnames3+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfnames3+=event.getFile().getFileName();
//
//                    simage3=dfnames3;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfnames3));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                    
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }	    
//        
//    }
//   public void handleFileUpload7(FileUploadEvent event)
//    {
//                Random random = new Random();
//	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg);   
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfnames4=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfnames4+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfnames4+=event.getFile().getFileName();
//
//                    simage4=dfnames4;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfnames4));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                    
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }	    
//        
//    }
//    
//    public void handleFileUploadCabin(FileUploadEvent event)
//    {
//                Random random = new Random();
//       FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
//       FacesContext.getCurrentInstance().addMessage(null, msg);  
//                try {
//                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
//                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
//       
//                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
//                    String path1=extContext.getRealPath("").substring(0,pos1) ;
//                    int pos2= path1.lastIndexOf("\\");
//                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos3= path2.lastIndexOf("\\");
//                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
//                    int pos4= path3.lastIndexOf("\\");
//                    String path4=path3.substring(0,pos4)+"\\FinalCarRentalApplication-war\\web\\upload\\" ;
//
//                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
//                    File targetFolder = new File(path4);
//                    int pos=event.getFile().getFileName().lastIndexOf("\\");
//                    String dfnamecb=random.nextInt(10000) + "";
//                    if (pos>0)
//                        dfnamecb+=event.getFile().getFileName().substring(pos);
//                    else
//                        dfnamecb+=event.getFile().getFileName();
//
//                    cbimage=dfnamecb;
//                    InputStream inputStream = event.getFile().getInputstream();
//                    OutputStream out = new FileOutputStream(new File(targetFolder,dfnamecb));
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                    }
//                   
//                    inputStream.close();
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }    
//       
//    }
//    
//    public void totalcount()
//    {
//        Response rs= njc.ShowTeam(Response.class);
//        ArrayList<entity.Team> tmlist = new ArrayList<entity.Team>();
//        GenericType<Collection<entity.Team>> gcteam = new GenericType<Collection<entity.Team>>() { };
//        tmlist = ( ArrayList<entity.Team> ) rs.readEntity( gcteam);
//        teamcnt = tmlist.size();        
//
//        Response rs1= njc.ShowCruisePackage(Response.class);
//        ArrayList<Cruisepackage> plist = new ArrayList<Cruisepackage>();
//        GenericType<Collection<Cruisepackage>> gcpackage = new GenericType<Collection<Cruisepackage>>() { };
//        plist = ( ArrayList<Cruisepackage> ) rs1.readEntity( gcpackage);
//        packagecnt = plist.size();
//        
//        Response rs2= njc.ShowCruiseship(Response.class);
//        ArrayList<Cruiseship>  clist = new ArrayList<Cruiseship>();
//        GenericType<Collection<Cruiseship>> gccruise = new GenericType<Collection<Cruiseship>>(){ };
//        clist = ( ArrayList<Cruiseship> ) rs2.readEntity(gccruise);
//        cruisecnt = clist.size();
//        
//        Response rs3= njc.ShowUser(Response.class);
//        ArrayList<entity.Usertbl> ulist = new ArrayList<entity.Usertbl>();
//        GenericType<Collection<entity.Usertbl>> gcuser = new GenericType<Collection<entity.Usertbl>>() { };
//        ulist = ( ArrayList<entity.Usertbl> ) rs3.readEntity(gcuser);
//        usercnt = ulist.size();
//
//    }
//    
//    public String viewforgotpassword()
//    {
//        return "forgotpassword.xhtml?faces-redirect=true";
//    }
//   
//    public void sendotp(String em)
//    {
//        try
//        {
//           
//           
//            
//            String otp= new DecimalFormat("0000").format(new Random().nextInt(9999));
//            uemail=em;
//            String host = "smtp.gmail.com";
//            //final String from = "tandel.shefali25@gmail.com";//your gmail account
//            //final String password1 = "25shefali1993";//your password of gmail account
//            final String from = "066dhruvipatel@gmail.com";//your gmail account
//            final String password1 = "mumma1801";//your password of gmail account
//            String port = "465";
////            String to = "066dhruvipatel@gmail.com";
//            String to = uemail.toString();
//            Properties prop = new Properties();
//            prop.put("mail.smtp.user", from);
//            prop.put("mail.smtp.host", host);
//            prop.put("mail.smtp.port", port);
//            prop.put("mail.smtp.starttls.enable", "true");
//            prop.put("mail.smtp.auth", "true");
//            prop.put("mail.smtp.debug", "true");
//            prop.put("mail.smtp.socketFactory.port", port);
//            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//            prop.put("mail.smtp.socketFactory.fallback", "false");
//            // Get the default Session object.
//            Session session1 = Session.getInstance(prop, new javax.mail.Authenticator() {
//
//               @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(from, password1);
//                }
//            });
//
//            session1.setDebug(true);
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session1);
//
//            // Set the RFC 822 "From" header field using the
//            // value of the InternetAddress.getLocalAddress method.
//            message.setFrom(new InternetAddress(from));
//
//
//            // Add the given addresses to the specified recipient type.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            // Set the "Subject" header field.
//            message.setSubject("Subject : " + subject + "");
//
//            // Sets the given String as this part's content,
//            // with a MIME type of "text/plain".
////            message.setText(contactmessage + "");
//            String htmlcode = "<p style='font-size:16px'> Query : " + contactmessage + "</p><h3>" + contactusanswer + "</h3>";
//            message.setContent(htmlcode, "text/html");
////            message.setText("<h2>" + contactmessage + "</h2><h4>" + contactusanswer + "</h4>");
//            Transport.send(message);
//            // Send message
//           
//           JOptionPane.showMessageDialog(null, "Please Check Your Mail..." );
//
//        }
//                catch (MessagingException ex1) {
//           
//                    ex1.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Mail not sent,Please Check Your Connection...");
//        }        
//          catch (Exception ex) {
//                    ex.printStackTrace();
//        }          
//
//    }
//    
////    public String checkuserlogin()
////    {
////        try
////        {
////        Response rs = njc.CheckUserLogin(Response.class, uemail, upassword);
////        GenericType<Usertbl> gc = new GenericType<Usertbl>() { };
////        Usertbl u = rs.readEntity(gc);
////       
////          FacesContext context = FacesContext.getCurrentInstance();
////            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
////          session.setAttribute("userobj", u);
////        uname = u.getName();
////        uemail=u.getEmail();
////        upassword=u.getPassword();
////        userid=u.getUserid();
////     
////       
////        Usertbl ut = (Usertbl) session.getAttribute("userobj");
////        userid = ut.getUserid();
////        clear();
////        return "viewuserfaq.xhtml?faces-redirect=true";
////        }
////        catch(Exception e)
////        {
////             FacesContext.getCurrentInstance().
////                   addMessage(null,
////                      new FacesMessage(FacesMessage.SEVERITY_INFO,
////                                       "Invalid Email or Password!", null));
////             clear();
////            return e.getMessage();
////        }
////           
////    }
//    
//    public List<Booking> showbooking()
//    {
//        Response rs= njc.ShowBooking(Response.class);
//        ArrayList<Booking> blist = new ArrayList<Booking>();
//        GenericType<Collection<Booking>> gcpackage = new GenericType<Collection<Booking>>() { };
//        blist = ( ArrayList<Booking> ) rs.readEntity( gcpackage);
//        return blist;
//    }
//    
//    ArrayList<Packagepassenger> pcplist = new ArrayList<Packagepassenger>();
//
//    public ArrayList<Packagepassenger> getPcplist() {
//        return pcplist;
//    }
//
//    public void setPcplist(ArrayList<Packagepassenger> pcplist) {
//        this.pcplist = pcplist;
//    }
//    
//    
//    
//    //Report ma chale
//    public List<Packagepassenger> showpersonperpackage() throws SQLException
//    {
//        //Response rs= njc.ShowBooking(Response.class);
////        ArrayList<Booking> blist = new ArrayList<Booking>();
////        GenericType<Collection<Booking>> gcpackage = new GenericType<Collection<Booking>>() { };
////        blist = ( ArrayList<Booking> ) rs.readEntity( gcpackage);
//        //return blist;
//        
////        ArrayList<Packagepassenger> pcplist = new ArrayList<Packagepassenger>();
////        GenericType<Collection<Booking>> gcpackage = new GenericType<Collection<Booking>>() { };
////        pcplist = ( ArrayList<Packagepassenger> ) rs.readEntity( gcpackage);
//        
//        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental","root","root");
//        Statement st = cn.createStatement();
//        String qry = "select cp.cruisepackageid,sum(b.passengers),cp.place from booking b,packagecabin p,cruisepackage cp where b.packagecabinid=p.packagecabinid and p.cruisepackageid=cp.cruisepackageid GROUP BY p.cruisepackageid";
//        ResultSet rs1 = st.executeQuery(qry);
//    pcplist.clear();
//        while(rs1.next())
//        {
//            pcplist.add(new Packagepassenger(rs1.getInt(1),rs1.getInt(2),rs1.getString(3)));
//            //System.out.println("Hello " + rs1.getInt(1) + " " + rs1.getInt(2) + " " + rs1.getString(3));
//        }
//        cn.close();
//        return pcplist;
//    }
//    
//       String u,p,loginerrmsg;
//
//    public String getLoginerrmsg() {
//        return loginerrmsg;
//    }
//
//    public void setLoginerrmsg(String loginerrmsg) {
//        this.loginerrmsg = loginerrmsg;
//    }
//     
//    String adu,adpa;
//
//    public String getAdu() {
//        return adu;
//    }
//
//    public void setAdu(String adu) {
//        this.adu = adu;
//    }
//
//    public String getAdpa() {
//        return adpa;
//    }
//
//    public void setAdpa(String adpa) {
//        this.adpa = adpa;
//    }
//    
//    
//    String logvar;
//
//    public String getLogvar() {
//        return logvar;
//    }
//
//    public void setLogvar(String logvar) {
//        this.logvar = logvar;
//    }
//    
//    
//    
//     public String checkadminlogin(String username,String password) throws SQLException
//     {
//
//                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental","root","root");
//                Statement stmt = conn.createStatement();
//                String sql = "select username,password,groupid from usertbl u where u.username ='" + username +"' and u.password='"+ password +"'";
//                ResultSet rs =  stmt.executeQuery(sql);
//                if(rs.next())
//                {
//                    if(rs.getInt(3) == 1)
//                    {
//                             FacesContext context = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
//        session.setAttribute("adminusername", rs.getString(1));
//                    System.out.println(rs.getString(1));
//                    System.out.println(rs.getString(2));
//                    loginerrmsg="";
//                    return "admindashboard.xhtml?faces-redirect=true";
//                    }
//                    else
//                    {
//                                     loginerrmsg="Only Admins are allowed!";
//                 return "Login.xhtml?faces-redirect=true"; 
//                    }
//                }
//                else
//                {
//                                     loginerrmsg="Invalid Username or Password!";
//                 return "Login.xhtml?faces-redirect=true"; 
//                }
//                
////            if(username.equals("Admin") && password.equals("admin123"))
////            {
////                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrental","root","root");
////                Statement stmt = conn.createStatement();
////                String sql = "select username,password from usertbl u where u.username ='" + username +"' and u.password='"+ password +"'";
////                ResultSet rs =  stmt.executeQuery(sql);
////                while(rs.next())
////                {
////                             FacesContext context = FacesContext.getCurrentInstance();
////        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
////        session.setAttribute("adminusername", rs.getString(1));
////                    System.out.println(rs.getString(1));
////                    System.out.println(rs.getString(2));
////                    loginerrmsg="";
////                    return "admindashboard.xhtml?faces-redirect=true";
////                }
////               
////            }
////            else
////            {
////                 loginerrmsg="Invalid Username or Password!";
////                 return "Login.xhtml?faces-redirect=true"; 
////            }
// 
//     }
//    
//     public String adminlogout()
//     {
//         FacesContext context = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
//       String un = session.getAttribute("adminusername").toString();
//       if(un!=null)
//       {
//        session.removeAttribute("adminusername");
//         session.invalidate();
//       }
//       return "Login.xhtml?faces-redirect=true";        
//     }
//
//}

//public class Packagepassenger
//{
//public    int crpid;
// public   int sofp;
//
//    public int getCrpid() {
//        return crpid;
//    }
//
//    public void setCrpid(int crpid) {
//        this.crpid = crpid;
//    }
//
//    public int getSofp() {
//        return sofp;
//    }
//
//    public void setSofp(int sofp) {
//        this.sofp = sofp;
//    }
//
//    public Packagepassenger(int crpid, int sofp) {
//        this.crpid = crpid;
//        this.sofp = sofp;
//    }
//
//    public Packagepassenger() {
//    }
//int Crpid, Pid;
//
//    public Packagepassenger(int Crpid, int Pid) {
//        this.Crpid = Crpid;
//        this.Pid = Pid;
//    }
//
//    public int getCrpid() {
//        return Crpid;
//    }
//
//    public void setCrpid(int Crpid) {
//        this.Crpid = Crpid;
//    }
//
//    public int getPid() {
//        return Pid;
//    }
//
//    public void setPid(int Pid) {
//        this.Pid = Pid;
//    }
//
//    
}