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
@Table(name = "cars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c"),
    @NamedQuery(name = "Cars.findById", query = "SELECT c FROM Cars c WHERE c.id = :id"),
    @NamedQuery(name = "Cars.findByModelname", query = "SELECT c FROM Cars c WHERE c.modelname = :modelname"),
    @NamedQuery(name = "Cars.findByType", query = "SELECT c FROM Cars c WHERE c.type = :type"),
    @NamedQuery(name = "Cars.findByDrivemode", query = "SELECT c FROM Cars c WHERE c.drivemode = :drivemode"),
    @NamedQuery(name = "Cars.findByPasscapacity", query = "SELECT c FROM Cars c WHERE c.passcapacity = :passcapacity"),
    @NamedQuery(name = "Cars.findByLuggagecapacity", query = "SELECT c FROM Cars c WHERE c.luggagecapacity = :luggagecapacity"),
    @NamedQuery(name = "Cars.findByImage", query = "SELECT c FROM Cars c WHERE c.image = :image")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "modelname")
    private String modelname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "drivemode")
    private String drivemode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "passcapacity")
    private int passcapacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Luggagecapacity")
    private int luggagecapacity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 59)
    @Column(name = "Image")
    private String image;
    @JoinColumn(name = "cartypeid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cartype cartypeid;
    @JoinColumn(name = "cityid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private City cityid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carid")
    private Collection<Carpackage> carpackageCollection;

    public Cars() {
    }

    public Cars(Integer id) {
        this.id = id;
    }

    public Cars(Integer id, String modelname, String type, String drivemode, int passcapacity, int luggagecapacity, String image) {
        this.id = id;
        this.modelname = modelname;
        this.type = type;
        this.drivemode = drivemode;
        this.passcapacity = passcapacity;
        this.luggagecapacity = luggagecapacity;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDrivemode() {
        return drivemode;
    }

    public void setDrivemode(String drivemode) {
        this.drivemode = drivemode;
    }

    public int getPasscapacity() {
        return passcapacity;
    }

    public void setPasscapacity(int passcapacity) {
        this.passcapacity = passcapacity;
    }

    public int getLuggagecapacity() {
        return luggagecapacity;
    }

    public void setLuggagecapacity(int luggagecapacity) {
        this.luggagecapacity = luggagecapacity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Cartype getCartypeid() {
        return cartypeid;
    }

    public void setCartypeid(Cartype cartypeid) {
        this.cartypeid = cartypeid;
    }

    public City getCityid() {
        return cityid;
    }

    public void setCityid(City cityid) {
        this.cityid = cityid;
    }

    @XmlTransient
    public Collection<Carpackage> getCarpackageCollection() {
        return carpackageCollection;
    }

    public void setCarpackageCollection(Collection<Carpackage> carpackageCollection) {
        this.carpackageCollection = carpackageCollection;
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
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Cars[ id=" + id + " ]";
    }
    
}
