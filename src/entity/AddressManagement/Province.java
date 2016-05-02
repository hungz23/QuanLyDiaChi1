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
@Table(name = "province")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Province.findByNameExact", query = "SELECT p FROM Province p WHERE p.name = :name"),
    @NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p"),
    @NamedQuery(name = "Province.findByProvinceid", query = "SELECT p FROM Province p WHERE p.provinceid = :provinceid"),
    @NamedQuery(name = "Province.findByName", query = "SELECT p FROM Province p WHERE p.name LIKE :name"),
    @NamedQuery(name = "Province.findByType", query = "SELECT p FROM Province p WHERE p.type = :type")})
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "provinceid")
    private String provinceid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    public Province() {
    }

    public Province(String provinceid) {
        this.provinceid = provinceid;
    }

    public Province(String provinceid, String name, String type) {
        this.provinceid = provinceid;
        this.name = name;
        this.type = type;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceid != null ? provinceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.provinceid == null && other.provinceid != null) || (this.provinceid != null && !this.provinceid.equals(other.provinceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AddressManagement.Province[ provinceid=" + provinceid + " ]";
    }
    
}
