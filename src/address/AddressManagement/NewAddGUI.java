/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.AddressManagement;

/**
 *
 * @author QuestionBoy
 */
import entity.AddressManagement.Address;
import entity.AddressManagement.District;
import entity.AddressManagement.Province;
import entity.AddressManagement.Ward;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import javax.swing.*;
public class NewAddGUI extends JFrame{
    public NewAddGUI(){
        initComponents();
    }

    private void initComponents() {
        
        entity =  javax.persistence.Persistence.createEntityManagerFactory("AddressManagementPU").createEntityManager();

        province = new CustomTextField(20);
        district = new CustomTextField(20);
        ward = new CustomTextField(20);
        address = new CustomTextField(20);
        addButton = new javax.swing.JButton();
        home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        province.setPlaceholder("Tỉnh");

        district.setPlaceholder("Huyện");

        ward.setPlaceholder("Xã");

        address.setPlaceholder("Địa Chỉ");

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addButtonActionPerformed(evt);
            }
        });


        home.setText("Home");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home)
                    .addComponent(addButton)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(district, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(home)
                .addGap(18, 18, 18)
                .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(district, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(ward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(22, 22, 22))
        );

        pack();
    }
    
     private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:

        String provinceName=province.getText();
        String districtName=district.getText();
        String wardName=ward.getText();
        String addressName=address.getText();
        Address addressInfo= new Address();addressInfo.setName(addressName);
        boolean province=false,district=false,ward=false;
        //search provinceid
        
            javax.persistence.Query query=entity.createNamedQuery("Province.findByNameExact").setParameter("name", provinceName);
            java.util.List<Province> provinceList=query.getResultList();
            if(provinceList.size()==0){
                JOptionPane.showMessageDialog(super.rootPane,"Không có tỉnh mà bạn nhập hoặc bạn chưa nhập tên tỉnh","Lỗi nhập",JOptionPane.WARNING_MESSAGE);
                province=false;
            }else{
                addressInfo.setProvinceid(provinceList.get(0).getProvinceid());
                province=true;
            }
        
        //search districtid
            query=entity.createNamedQuery("District.findByNameAndProvince").setParameter("name", districtName).setParameter("provinceid", provinceList.get(0).getProvinceid());
            java.util.List<District> districtList=query.getResultList();
            if(districtList.size()==0){
                JOptionPane.showMessageDialog(super.rootPane,"huyện và tỉnh không khớp nhau hoặc tên huyện sai","Lỗi nhập",JOptionPane.WARNING_MESSAGE);
                district=false;
            }else{
                addressInfo.setDistrictid(districtList.get(0).getDistrictid());
                district=true;
            }

        //search wardid
        
            query=entity.createNamedQuery("Ward.findByNameAndDistrict").setParameter("name", wardName).setParameter("districtid", districtList.get(0).getDistrictid());
            java.util.List<Ward> wardList=query.getResultList();
            //System.out.println(wardList.get(0).getWardid());
            if(wardList.size()==0){
                JOptionPane.showMessageDialog(super.rootPane,"huyện và xã không khớp nhau hoặc tên xã sai","Lỗi nhập",JOptionPane.WARNING_MESSAGE);
                ward=false;
            }else{
                
                addressInfo.setWardid(wardList.get(0).getWardid());
                ward=true;
            }

        //search addressid
        if(province && district && ward){
            int dialogResult = JOptionPane.showConfirmDialog (super.rootPane, "Would You Like to Save your Previous Note First?","Warning",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(dialogResult==JOptionPane.YES_OPTION){
                //ystem.out.println("hung");
                entity.getTransaction().begin();
                entity.persist(addressInfo);
                entity.getTransaction().commit();
                NewAddGUI.this.setVisible(false);
                new AddressManagementGUI().setVisible(true);
            }
        }
        
    }             
    
    public void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewAddGUI().setVisible(true);
            }
        });
    }
    
    private CustomTextField province; 
    private CustomTextField district;
    private CustomTextField ward;
    private CustomTextField address;
    private javax.swing.JButton addButton;
    private javax.swing.JButton home;
    private javax.persistence.EntityManager entity;

}
