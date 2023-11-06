/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsfBeans;

import Entity.Booking;
import Entity.Reg;
import ejb.AdminSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import restclient.NewJerseyClient;

/**
 *
 * @author Admin
 */
@Named(value = "customerJSFManagedBean")
@SessionScoped
    public class CustomerJSFManagedBean implements Serializable {
 NewJerseyClient njc = new NewJerseyClient();
    /**
     * Creates a new instance of UserJSFManagedBean
     */
    public CustomerJSFManagedBean() {
//        uemail=null;
//        upassword=null;
    }
    
    boolean flag=false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    
String loginuseremailid;    
String fmessage;
    public String getLoginuseremailid() {
        return loginuseremailid;
    }

    public void setLoginuseremailid(String loginuseremailid) {
        this.loginuseremailid = loginuseremailid;
    }
    String uemail,upassword;
String errmsg;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
       public String checkuserlogin2()
    {
        String m;
               FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            
 
        
              Response rs = njc.CheckUserLogin(Response.class, uemail, upassword);
            GenericType<Reg> gc = new GenericType<Reg>() { };
            Reg u = rs.readEntity(gc);
            if (u==null)
            {
                errmsg="Invalid Credentials";
                return "userlogin.jsf?faces-redirect=true";
            }
            else
            {
                flag=true;
                session.setAttribute("uid",u.getUserid());
                  session.setAttribute("user",u);
             return "viewuserhome.xhtml?faces-redirect=true"  ; 
            }
 
   }
       
         @EJB
    private AdminSessionBeanLocal adminSessionBean;

     public String checkuserlogin()
    {
        String m;
               FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            
 
        
              Response rs = njc.CheckUserLogin(Response.class, uemail, upassword);
            GenericType<Reg> gc = new GenericType<Reg>() { };
            Reg u = rs.readEntity(gc);
            if (u==null)
            {
                errmsg="Invalid Credentials";
                return "userlogin.jsf?faces-redirect=true";
            }
            else
            {
                flag=true;
                session.setAttribute("uid",u.getUserid());
                  session.setAttribute("user",u);
             return "viewbooking.xhtml?faces-redirect=true"  ; 
            }
 
   }
    
    public String logout()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
       Reg utbl = (Reg) session.getAttribute("user");
       if(utbl!=null)
       {
          uemail=null;
          upassword=null;
          flag=false;
        session.removeAttribute("user");
        session.removeAttribute("uid");
         session.invalidate();
       }
       return "viewuserhome.xhtml?faces-redirect=true";
    }
    
       public String adminlogout()
    {

       return "/CarRentalSecurity/";
    }
      List<Booking> olist;

    public List<Booking> getOlist() {
        return olist;
    }

    public void setOlist(List<Booking> olist) {
        this.olist = olist;
    }

     
    
    public String mybookings()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
       Reg utbl = (Reg) session.getAttribute("user");
       int uid=utbl.getUserid();
      olist=  adminSessionBean.showBookingByUser(uid);
       return "viewmybooking.xhtml?faces-redirect=true";
    }
    
}
