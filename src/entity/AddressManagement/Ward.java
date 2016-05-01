/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.AddressManagement;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author QuestionBoy
 */
@Entity
@Table(name = "ward")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ward.findAll", query = "SELECT w FROM Ward w"),
    @NamedQuery(name = "Ward.findByWardid", query = "SELECT w FROM Ward w WHERE w.wardid = :wardid"),
    @NamedQuery(name = "Ward.findByName", query = "SELECT w FROM Ward w WHERE w.name = :name"),
    @NamedQuery(name = "Ward.findByType", query = "SELECT w FROM Ward w WHERE w.type = :type"),
    @NamedQuery(name = "Ward.findByLocation", query = "SELECT w FROM Ward w WHERE w.location = :location"),
    @NamedQuery(name = "Ward.findByDistrictid", query = "SELECT w FROM Ward w WHERE w.districtid = :districtid")})
public class Ward implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "wardid")
    private String wardid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @Column(name = "districtid")
    private String districtid;

    public Ward() {
    }

    public Ward(String wardid) {
        this.wardid = wardid;
    }

    public Ward(String wardid, String name, String type, String location, String districtid) {
        this.wardid = wardid;
        this.name = name;
        this.type = type;
        this.location = location;
        this.districtid = districtid;
    }

    public String getWardid() {
        return wardid;
    }

    public void setWardid(String wardid) {
        this.wardid = wardid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistrictid() {
        return districtid;
    }

    public void setDistrictid(String districtid) {
        this.districtid = districtid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wardid != null ? wardid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ward)) {
            return false;
        }
        Ward other = (Ward) object;
        if ((this.wardid == null && other.wardid != null) || (this.wardid != null && !this.wardid.equals(other.wardid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AddressManagement.Ward[ wardid=" + wardid + " ]";
    }
    
}
