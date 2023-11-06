/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

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
public interface UserSessionBeanLocal {

    public String InsertBooking(int packid, String fname, String lname, String Cno1, String Cno2, String email, String PAddress1, String PAddress2, String city, String pincode, String state, String bnotes, Date pickdate, Date dropdate, String picktime, String droptime, int amt, int uid);

     
         
}
