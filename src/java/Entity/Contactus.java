/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "contactus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactus.findAll", query = "SELECT c FROM Contactus c"),
    @NamedQuery(name = "Contactus.findByContacustid", query = "SELECT c FROM Contactus c WHERE c.contacustid = :contacustid"),
    @NamedQuery(name = "Contactus.findByName", query = "SELECT c FROM Contactus c WHERE c.name = :name"),
    @NamedQuery(name = "Contactus.findByEmail", query = "SELECT c FROM Contactus c WHERE c.email = :email"),
    @NamedQuery(name = "Contactus.findByContactno", query = "SELECT c FROM Contactus c WHERE c.contactno = :contactno"),
    @NamedQuery(name = "Contactus.findBySubject", query = "SELECT c FROM Contactus c WHERE c.subject = :subject"),
    @NamedQuery(name = "Contactus.findByMessage", query = "SELECT c FROM Contactus c WHERE c.message = :message")})
public class Contactus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contacustid")
    private Integer contacustid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "contactno")
    private String contactno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "message")
    private String message;

    public Contactus() {
    }

    public Contactus(Integer contacustid) {
        this.contacustid = contacustid;
    }

    public Contactus(Integer contacustid, String name, String email, String contactno, String subject, String message) {
        this.contacustid = contacustid;
        this.name = name;
        this.email = email;
        this.contactno = contactno;
        this.subject = subject;
        this.message = message;
    }

    public Integer getContacustid() {
        return contacustid;
    }

    public void setContacustid(Integer contacustid) {
        this.contacustid = contacustid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contacustid != null ? contacustid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactus)) {
            return false;
        }
        Contactus other = (Contactus) object;
        if ((this.contacustid == null && other.contacustid != null) || (this.contacustid != null && !this.contacustid.equals(other.contacustid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Contactus[ contacustid=" + contacustid + " ]";
    }
    
}
