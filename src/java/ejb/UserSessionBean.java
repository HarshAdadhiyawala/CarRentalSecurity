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
public class UserSessionBean implements UserSessionBeanLocal {

    @PersistenceContext(unitName = "Demo1PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public String InsertBooking(int packid,String fname,String lname,String Cno1,String Cno2,String email,String PAddress1,String PAddress2,String city,String pincode,String state,String bnotes,Date pickdate,Date dropdate,String picktime,String droptime,int amt,int uid)
{

    try
    {
        Booking b=new Booking();
        b.setBid(0);
        Carpackage cp=em.find(Carpackage.class, packid);
        b.setCpid(cp);
        b.setBookDate(new Date());
        b.setFname(fname);
        b.setLname(lname);
        b.setContactNo1(Cno1);
        b.setContactNo2(Cno2);
        b.setEmail(email);
        b.setPAddress1(PAddress1);
        b.setPAddress2(PAddress2);
        b.setCity(city);
        b.setPcode(pincode);
        b.setState(state);
        b.setBookNotes(bnotes);
        b.setPickDate(pickdate);
        b.setDropDate(dropdate);
        b.setAmount(amt);
        b.setPickTime(picktime);
        b.setDropTime(droptime);
        b.setUserid(uid);
        b.setStatus("Booked");
        em.persist(b);
//        Reg r=new Reg();
//        r.setUsername(fname);
//        r.setAddress(PAddress1);
//        r.setContactno(Cno1);
//        r.setEmail(email);
//        r.setGender("male");
//        r.setPassword(pincode);
        return "Inserted";
    }
    catch(Exception ex)
    {
     
        return ex.getMessage();
    }
}
}
