/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBid", query = "SELECT b FROM Booking b WHERE b.bid = :bid"),
    @NamedQuery(name = "Booking.findByBookDate", query = "SELECT b FROM Booking b WHERE b.bookDate = :bookDate"),
    @NamedQuery(name = "Booking.findByFname", query = "SELECT b FROM Booking b WHERE b.fname = :fname"),
    @NamedQuery(name = "Booking.findByLname", query = "SELECT b FROM Booking b WHERE b.lname = :lname"),
    @NamedQuery(name = "Booking.findByContactNo1", query = "SELECT b FROM Booking b WHERE b.contactNo1 = :contactNo1"),
    @NamedQuery(name = "Booking.findByContactNo2", query = "SELECT b FROM Booking b WHERE b.contactNo2 = :contactNo2"),
    @NamedQuery(name = "Booking.findByEmail", query = "SELECT b FROM Booking b WHERE b.email = :email"),
    @NamedQuery(name = "Booking.findByPAddress1", query = "SELECT b FROM Booking b WHERE b.pAddress1 = :pAddress1"),
    @NamedQuery(name = "Booking.findByPAddress2", query = "SELECT b FROM Booking b WHERE b.pAddress2 = :pAddress2"),
    @NamedQuery(name = "Booking.findByCity", query = "SELECT b FROM Booking b WHERE b.city = :city"),
    @NamedQuery(name = "Booking.findByPcode", query = "SELECT b FROM Booking b WHERE b.pcode = :pcode"),
    @NamedQuery(name = "Booking.findByState", query = "SELECT b FROM Booking b WHERE b.state = :state"),
    @NamedQuery(name = "Booking.findByBookNotes", query = "SELECT b FROM Booking b WHERE b.bookNotes = :bookNotes"),
    @NamedQuery(name = "Booking.findByPickDate", query = "SELECT b FROM Booking b WHERE b.pickDate = :pickDate"),
    @NamedQuery(name = "Booking.findByDropDate", query = "SELECT b FROM Booking b WHERE b.dropDate = :dropDate"),
    @NamedQuery(name = "Booking.findByPickTime", query = "SELECT b FROM Booking b WHERE b.pickTime = :pickTime"),
    @NamedQuery(name = "Booking.findByDropTime", query = "SELECT b FROM Booking b WHERE b.dropTime = :dropTime"),
    @NamedQuery(name = "Booking.findByAmount", query = "SELECT b FROM Booking b WHERE b.amount = :amount"),
    @NamedQuery(name = "Booking.findByUserid", query = "SELECT b FROM Booking b WHERE b.userid = :userid"),
    @NamedQuery(name = "Booking.findByStatus", query = "SELECT b FROM Booking b WHERE b.status = :status")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bid")
    private Integer bid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BookDate")
    @Temporal(TemporalType.DATE)
    private Date bookDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lname")
    private String lname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ContactNo1")
    private String contactNo1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ContactNo2")
    private String contactNo2;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PAddress1")
    private String pAddress1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PAddress2")
    private String pAddress2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Pcode")
    private String pcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "BookNotes")
    private String bookNotes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PickDate")
    @Temporal(TemporalType.DATE)
    private Date pickDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DropDate")
    @Temporal(TemporalType.DATE)
    private Date dropDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PickTime")
    private String pickTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DropTime")
    private String dropTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Userid")
    private int userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Status")
    private String status;
    @JoinColumn(name = "cpid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carpackage cpid;

    public Booking() {
    }

    public Booking(Integer bid) {
        this.bid = bid;
    }

    public Booking(Integer bid, Date bookDate, String fname, String lname, String contactNo1, String contactNo2, String email, String pAddress1, String pAddress2, String city, String pcode, String state, String bookNotes, Date pickDate, Date dropDate, String pickTime, String dropTime, int amount, int userid, String status) {
        this.bid = bid;
        this.bookDate = bookDate;
        this.fname = fname;
        this.lname = lname;
        this.contactNo1 = contactNo1;
        this.contactNo2 = contactNo2;
        this.email = email;
        this.pAddress1 = pAddress1;
        this.pAddress2 = pAddress2;
        this.city = city;
        this.pcode = pcode;
        this.state = state;
        this.bookNotes = bookNotes;
        this.pickDate = pickDate;
        this.dropDate = dropDate;
        this.pickTime = pickTime;
        this.dropTime = dropTime;
        this.amount = amount;
        this.userid = userid;
        this.status = status;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

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

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPAddress1() {
        return pAddress1;
    }

    public void setPAddress1(String pAddress1) {
        this.pAddress1 = pAddress1;
    }

    public String getPAddress2() {
        return pAddress2;
    }

    public void setPAddress2(String pAddress2) {
        this.pAddress2 = pAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBookNotes() {
        return bookNotes;
    }

    public void setBookNotes(String bookNotes) {
        this.bookNotes = bookNotes;
    }

    public Date getPickDate() {
        return pickDate;
    }

    public void setPickDate(Date pickDate) {
        this.pickDate = pickDate;
    }

    public Date getDropDate() {
        return dropDate;
    }

    public void setDropDate(Date dropDate) {
        this.dropDate = dropDate;
    }

    public String getPickTime() {
        return pickTime;
    }

    public void setPickTime(String pickTime) {
        this.pickTime = pickTime;
    }

    public String getDropTime() {
        return dropTime;
    }

    public void setDropTime(String dropTime) {
        this.dropTime = dropTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Carpackage getCpid() {
        return cpid;
    }

    public void setCpid(Carpackage cpid) {
        this.cpid = cpid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Booking[ bid=" + bid + " ]";
    }
    
}
