/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsfBeans;

import Entity.Booking;
import Entity.Carpackage;
import Entity.Cars;
import Entity.City;
import Entity.Reg;
import ejb.AdminSessionBeanLocal;
import ejb.UserSessionBeanLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import restclient.NewJerseyClient;

/**
 *
 * @author Admin
 */
@Named(value = "bookingJSFManagedBean")
@SessionScoped
public class BookingJSFManagedBean implements Serializable {

    /**
     * Creates a new instance of BookingJSFManagedBean
     */
      Date today,todaymonth;

    public Date getToday() {
        return new Date();
    }

//    public void setToday(Date today) {
//        this.today = today;
//    }

    public Date getTodaymonth() {
        Date d1;
        Calendar c1=Calendar.getInstance();
        int d=c1.get(Calendar.DAY_OF_MONTH);
        int m=c1.get(Calendar.MONTH)+1;
        int y=c1.get(Calendar.YEAR);
        
        return new Date(y,m,d);
    }

//    public void setTodaymonth(Date todaymonth) {
//        this.todaymonth = todaymonth;
//    }
      
    @EJB
    private UserSessionBeanLocal userSessionBean;
    @EJB
    private AdminSessionBeanLocal adminSessionBean;

    String gender,password;
String paymode;

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    

ArrayList timeslot=new ArrayList();

    public ArrayList getTimeslot() {
        for (int i=0;i<24;i++)
    {
        timeslot.add(i+":00");
    }
        return timeslot;
    }

    public void setTimeslot(ArrayList timeslot) {
        this.timeslot = timeslot;
    }
    
public BookingJSFManagedBean()
{
 FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            Reg u=(Reg)session.getAttribute("user");
            if (u!=null)
            {
    fname=u.getUsername();
  // lname=u.
    Email=u.getEmail();
    //City=u.getCityid();
    PAddress1=u.getAddress();
    CNo1=u.getContactno();
   
//    gender=u.getGender();
            }
}
    //SecureClient njc=new SecureClient();
   NewJerseyClient njc = new NewJerseyClient();
    int packid;
    
    int cityid;

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }
    Carpackage bpack;
//    String pname;
//    int price;
//    int carid;
//    String modelname;
//    String type,drivemode;

    public Carpackage getBpack() {
        return bpack;
    }

    public void setBpack(Carpackage bpack) {
        this.bpack = bpack;
    }
    
    String fname,lname,CNo1,CNo2,Email,PAddress1,PAddress2,City,Pincode,State,BookNotes,Status,PickTime,DropTime;
    int amount;
    Date PickDate,DropDate,PickTime1,DropTime1;

    public Date getPickTime1() {
        return PickTime1;
    }

    public void setPickTime1(Date PickTime1) {
        this.PickTime1 = PickTime1;
    }

    public Date getDropTime1() {
        return DropTime1;
    }

    public void setDropTime1(Date DropTime1) {
        this.DropTime1 = DropTime1;
    }
int uid;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCNo1() {
        return CNo1;
    }

    public void setCNo1(String CNo1) {
        this.CNo1 = CNo1;
    }

    public String getCNo2() {
        return CNo2;
    }

    public void setCNo2(String CNo2) {
        this.CNo2 = CNo2;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPAddress1() {
        return PAddress1;
    }

    public void setPAddress1(String PAddress1) {
        this.PAddress1 = PAddress1;
    }

    public String getPAddress2() {
        return PAddress2;
    }

    public void setPAddress2(String PAddress2) {
        this.PAddress2 = PAddress2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getBookNotes() {
        return BookNotes;
    }

    public void setBookNotes(String BookNotes) {
        this.BookNotes = BookNotes;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getPickTime() {
        return PickTime;
    }

    public void setPickTime(String PickTime) {
        this.PickTime = PickTime;
    }

    public String getDropTime() {
        return DropTime;
    }

    public void setDropTime(String DropTime) {
        this.DropTime = DropTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getPickDate() {
        return PickDate;
    }

    public void setPickDate(Date PickDate) {
        this.PickDate = PickDate;
    }

    public Date getDropDate() {
        return DropDate;
    }

    public void setDropDate(Date DropDate) {
        this.DropDate = DropDate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


    public int getPackid() {
        return packid;
    }

    public void setPackid(int packid) {
        this.packid = packid;
    }
    
   
    
    
    public String booking()
    {
        bpack=adminSessionBean.searchCarpackage(packid);
        
        return "userlogin.xhtml?faces-redirect=true";
    }
    
    
    public String BookCar()throws IOException 
    {
     ////   PickDate=new Date();
        DropDate=new Date();
       // PickTime="12:30";
       // DropTime="4:30";
       FacesContext context = FacesContext.getCurrentInstance();
         HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
          
        uid=(int)session.getAttribute("uid");
        Reg user=(Reg)session.getAttribute("user");
       amount=bpack.getPrice();
        String msg=userSessionBean.InsertBooking(packid, fname, lname, CNo1, CNo2, Email, PAddress1, PAddress2, City, Pincode, State, BookNotes, PickDate, DropDate, PickTime, DropTime, amount, uid);
        
        
        if (paymode.equals("Pay Pal"))
        {
               String redirectUrl = "";
                    redirectUrl += "http://www.sandbox.paypal.com/cgi-bin//webscr?cmd=_xclick&business=intellectcomputerssurat-buyer@gmail.com";
                    redirectUrl += "&username="+ user.getEmail();
                    redirectUrl += "&amount="+ 0.01;
                    //Session["charges"]
                    redirectUrl += "&business=intellectcomputerssurat-facilitator@gmail.com";
                    //If transactioin has been successfully performed, redirect SuccessURL page- this page will be designed by developer
                    
                    redirectUrl += "&return=https://localhost:8181/CarRentalSecurity/user/finalsuccess.jsf";
                   // session.setAttribute("successsession", "suc");
                  //  sucvar = session.getAttribute("successsession").toString();
                    
                    ////If transactioin has been failed, redirect FailedURL page- this page will be designed by developer
                    redirectUrl += "&cancel_return=https://localhost:8181/CarRentalSecurity/user/failure.jsf";
                    
                   

                              
                       
                       

        
                    
                    
                    
                       
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    externalContext.redirect(redirectUrl);
    return "";
        }
        else
        {
        return "finalsuccess.xhtml?faces-redirect=true";
        }
    }
   
    public Collection<Cars> showCarsCollection()
    {
        //   City c= adminSessionBean.searchCity(cityid);
      //return c.getCarsCollection();
           
//        FacesContext context = FacesContext.getCurrentInstance();
//         
//        if(PickDate.before(new Date()) ){
////            FacesMessage fmsg = new FacesMessage();
////            fmsg.setSeverity(FacesMessage.SEVERITY_ERROR);
////            fmsg.setSummary("Date is blank");
////            context.addMessage(null, fmsg);
//           
//                FacesMessage msg = new FacesMessage("Failure","PicupDate should");   
//	        FacesContext.getCurrentInstance().addMessage(null, msg); 
//            return null;
//        }
//        else if(PickDate.after(DropDate)==true){
//        
//             FacesMessage fmsg = new FacesMessage();
//            fmsg.setSeverity(FacesMessage.SEVERITY_ERROR);
//            fmsg.setSummary("Date is blank");
//            context.addMessage(null, fmsg);
//            return null;
//        }
       // else
        //{
      Collection<Cars> clist=  adminSessionBean.searchCarByDate(cityid, PickDate, DropDate);
      return clist;
          //      }
    }
        
    public String searchCars()
    {
      //  bpack=adminSessionBean.searchCarpackage(packid);
    
        return "viewuser_searchcars.xhtml?faces-redirect=true";
    }
    
    public List<Booking> showBookings()
    {
        return adminSessionBean.showBookings();
    }
    
    public String insertUser()
{
    //sessionBean.insertUser(fname, lname, gender, PAddress1, City, Pincode, State, Email, upassword)
    adminSessionBean.insertUser(fname, gender, PAddress1, cityid, State, Email, password);
return "viewbooking.xhtml?faces-redirect=true";
 }
}
