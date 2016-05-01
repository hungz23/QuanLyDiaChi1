/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.AddressManagement;

import entity.AddressManagement.*;
import javax.persistence.*;
import java.util.*;
/**
 *
 * @author QuestionBoy
 */
public class Test {
    public  void main(String args[]){
        javax.persistence.EntityManager entity= javax.persistence.Persistence.createEntityManagerFactory("AddressManagementPU").createEntityManager();
        javax.persistence.Query query=entity.createNamedQuery("Address.findAll");
        java.util.List<Address> addressList=query.getResultList();
        for(Address address: addressList){
            String display= new String();
            display+=address.getName();
            query= entity.createNamedQuery("Ward.findByWardid").setParameter("wardid", address.getWardid());
            List<Ward> wardList=query.getResultList();
            for(Ward ward: wardList){
                display=display+","+ward.getName();
            }
            query= entity.createNamedQuery("District.findByDistrictid").setParameter("districtid", address.getDistrictid());
            List<District> districtList=query.getResultList();
            for(District district: districtList){
                display=display+","+district.getName();
            }
            query= entity.createNamedQuery("Province.findByProvinceid").setParameter("provinceid", address.getProvinceid());
            List<Province> provinceList=query.getResultList();
            for(Province province: provinceList){
                display=display+","+province.getName();
            }
            System.out.println(display);
        }
    }
}
