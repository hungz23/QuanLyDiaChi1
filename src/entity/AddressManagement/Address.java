/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.AddressManagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author QuestionBoy
 */
@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressid", query = "SELECT a FROM Address a WHERE a.addressid = :addressid"),
    @NamedQuery(name = "Address.findByName", query = "SELECT a FROM Address a WHERE a.name = :name"),
    @NamedQuery(name = "Address.findByWardid", query = "SELECT a FROM Address a WHERE a.wardid = :wardid"),
    @NamedQuery(name = "Address.findByDistrictid", query = "SELECT a FROM Address a WHERE a.districtid = :districtid"),
    @NamedQuery(name = "Address.findByProvinceid", query = "SELECT a FROM Address a WHERE a.provinceid = :provinceid")})
public class Address implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "addressid")
    private Integer addressid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "wardid")
    private String wardid;
    @Basic(optional = false)
    @Column(name = "districtid")
    private String districtid;
    @Basic(optional = false)
    @Column(name = "provinceid")
    private String provinceid;

    public Address() {
    }

    public Address(Integer addressid) {
        this.addressid = addressid;
    }

    public Address(Integer addressid, String name, String wardid, String districtid, String provinceid) {
        this.addressid = addressid;
        this.name = name;
        this.wardid = wardid;
        this.districtid = districtid;
        this.provinceid = provinceid;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        Integer oldAddressid = this.addressid;
        this.addressid = addressid;
        changeSupport.firePropertyChange("addressid", oldAddressid, addressid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getWardid() {
        return wardid;
    }

    public void setWardid(String wardid) {
        String oldWardid = this.wardid;
        this.wardid = wardid;
        changeSupport.firePropertyChange("wardid", oldWardid, wardid);
    }

    public String getDistrictid() {
        return districtid;
    }

    public void setDistrictid(String districtid) {
        String oldDistrictid = this.districtid;
        this.districtid = districtid;
        changeSupport.firePropertyChange("districtid", oldDistrictid, districtid);
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        String oldProvinceid = this.provinceid;
        this.provinceid = provinceid;
        changeSupport.firePropertyChange("provinceid", oldProvinceid, provinceid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AddressManagement.Address[ addressid=" + addressid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
