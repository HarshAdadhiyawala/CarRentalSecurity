/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "carpackage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carpackage.findAll", query = "SELECT c FROM Carpackage c"),
    @NamedQuery(name = "Carpackage.findById", query = "SELECT c FROM Carpackage c WHERE c.id = :id"),
    @NamedQuery(name = "Carpackage.findByPname", query = "SELECT c FROM Carpackage c WHERE c.pname = :pname"),
    @NamedQuery(name = "Carpackage.findByPrice", query = "SELECT c FROM Carpackage c WHERE c.price = :price")})
public class Carpackage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "pname")
    private String pname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cpid")
    private Collection<Booking> bookingCollection;
    @JoinColumn(name = "carid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cars carid;

    public Carpackage() {
    }

    public Carpackage(Integer id) {
        this.id = id;
    }

    public Carpackage(Integer id, String pname, int price) {
        this.id = id;
        this.pname = pname;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    public Cars getCarid() {
        return carid;
    }

    public void setCarid(Cars carid) {
        this.carid = carid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carpackage)) {
            return false;
        }
        Carpackage other = (Carpackage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Carpackage[ id=" + id + " ]";
    }
    
}
