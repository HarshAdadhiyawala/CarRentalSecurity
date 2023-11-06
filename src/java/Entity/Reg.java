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
@Table(name = "reg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reg.findAll", query = "SELECT r FROM Reg r"),
    @NamedQuery(name = "Reg.findByUserid", query = "SELECT r FROM Reg r WHERE r.userid = :userid"),
    @NamedQuery(name = "Reg.findByGroupname", query = "SELECT r FROM Reg r WHERE r.groupname = :groupname"),
    @NamedQuery(name = "Reg.findByUsername", query = "SELECT r FROM Reg r WHERE r.username = :username"),
    @NamedQuery(name = "Reg.findByGender", query = "SELECT r FROM Reg r WHERE r.gender = :gender"),
    @NamedQuery(name = "Reg.findByAddress", query = "SELECT r FROM Reg r WHERE r.address = :address"),
    @NamedQuery(name = "Reg.findByCityid", query = "SELECT r FROM Reg r WHERE r.cityid = :cityid"),
    @NamedQuery(name = "Reg.findByContactno", query = "SELECT r FROM Reg r WHERE r.contactno = :contactno"),
    @NamedQuery(name = "Reg.findByEmail", query = "SELECT r FROM Reg r WHERE r.email = :email"),
    @NamedQuery(name = "Reg.findByPassword", query = "SELECT r FROM Reg r WHERE r.password = :password"),
    @NamedQuery(name = "Reg.findByRegistrationdatetime", query = "SELECT r FROM Reg r WHERE r.registrationdatetime = :registrationdatetime")})
public class Reg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    @Size(max = 50)
    @Column(name = "groupname")
    private String groupname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Size(max = 30)
    @Column(name = "gender")
    private String gender;
    @Size(max = 500)
    @Column(name = "address")
    private String address;
    @Column(name = "cityid")
    private Integer cityid;
    @Size(max = 30)
    @Column(name = "contactno")
    private String contactno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 300)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registrationdatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationdatetime;

    public Reg() {
    }

    public Reg(Integer userid) {
        this.userid = userid;
    }

    public Reg(Integer userid, String username, String password, Date registrationdatetime) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.registrationdatetime = registrationdatetime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationdatetime() {
        return registrationdatetime;
    }

    public void setRegistrationdatetime(Date registrationdatetime) {
        this.registrationdatetime = registrationdatetime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reg)) {
            return false;
        }
        Reg other = (Reg) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Reg[ userid=" + userid + " ]";
    }
    
}
