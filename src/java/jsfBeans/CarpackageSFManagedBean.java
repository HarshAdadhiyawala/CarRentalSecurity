/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package jsfBeans;
 
import Entity.Carpackage;
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
@Named(value = "carpackageJSFManagedBean")
@SessionScoped
//@RequestScoped
public class CarpackageSFManagedBean implements Serializable { 
    
    @EJB
    private AdminSessionBeanLocal adminSessionBean;

    

    
    
    //SecureClient njc=new SecureClient();
   NewJerseyClient njc = new NewJerseyClient();
    String pname;
int id,cid,price;
    
    public void clear()
    { 
    }
    
    
 
    //City
    public String insertcarpackage()
    {
       // Carpackage c=new Carpackage();
       //c.setTypename(name);
       
       String successmsg1 = njc.InsertCarpackage(cid,pname,price);
//       if(successmsg1.length()==0)
//       {
//           msg2 = "true";
//       }
       clear();
//       return "addcity.xhtml?faces-redirect=true";
       return "viewcarpackage.xhtml?faces-redirect=true";
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

     

     
    
    
    public List<Carpackage> showcarpackage()
    {
        Response rs= njc.ShowCarpackage(Response.class);
        ArrayList<Carpackage> clist = new ArrayList<Carpackage>();
        GenericType<Collection<Carpackage>> gctype = new GenericType<Collection<Carpackage>>() { };
        clist = ( ArrayList<Carpackage> ) rs.readEntity( gctype);
        return clist;
    }          
    
    public String deletecarpackage(int id)
    {
        njc.DeleteCarpackage(id);
        return "viewcarpackage.xhtml?faces-redirect=true";
    }
    
    public String searchcarpackage(int tid)
    {    
        Response rs = njc.SearchCarpackage(Response.class, tid);   
        GenericType<Carpackage> gctype = new GenericType<Carpackage>(){ };
        Carpackage cp= rs.readEntity(gctype);
        id= cp.getId();
        pname = cp.getPname();
         price=cp.getPrice();
         cid=cp.getCarid().getId();
        return "editcarpackage.xhtml?faces-redirect=true";       
    }
    
    public String updatecarpackage()
    {
//       Carpackage c=new Carpackage();
//       c.setId(id);
//       c.setTypename(name);
       njc.UpdateCarpackage(id, cid,pname,price);
       return "viewcarpackage.xhtml?faces-redirect=true";
    }

 
}