/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.AddressManagement;

import entity.AddressManagement.Address;
import entity.AddressManagement.District;
import static entity.AddressManagement.District_.provinceid;
import entity.AddressManagement.Province;
import entity.AddressManagement.Ward;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author QuestionBoy
 */
public class AddAddressGUI extends javax.swing.JFrame {

    /**
     * Creates new form AddAddressGUI
     */
    public AddAddressGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entity = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("AddressManagementPU").createEntityManager();
        addButton = new javax.swing.JButton();
        province = new javax.swing.JTextField();
        district = new javax.swing.JTextField();
        ward = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        province.setForeground(Color.LIGHT_GRAY);
        province.setText("Tỉnh");
        province.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                provinceMouseClicked(evt);
            }
        });
        province.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provinceActionPerformed(evt);
            }
        });

        district.setForeground(Color.LIGHT_GRAY);
        district.setText("Huyện");
        district.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                districtMouseClicked(evt);
            }
        });
        district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                districtActionPerformed(evt);
            }
        });

        ward.setForeground(Color.LIGHT_GRAY);
        ward.setText("Xã, Phường");
        ward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wardMouseClicked(evt);
            }
        });
        ward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wardActionPerformed(evt);
            }
        });

        address.setForeground(Color.LIGHT_GRAY);
        address.setText("Địa Chỉ");
        address.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressMouseClicked(evt);
            }
        });

        jLabel1.setText("Tỉnh");

        jLabel2.setText("Huyện");

        jLabel3.setText("Xã");

        jLabel4.setText("Địa chỉ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ward, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(district, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(addButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(province, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(district, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
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
            if(wardList.size()==0){
                JOptionPane.showMessageDialog(super.rootPane,"huyện và xã không khớp nhau hoặc tên xã sai","Lỗi nhập",JOptionPane.WARNING_MESSAGE);
                ward=false;
            }else{
                System.out.println(wardList.get(0).getName());
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
                AddAddressGUI.this.setVisible(false);
                new AddressManagementGUI().setVisible(true);
            }
        }
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_districtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_districtActionPerformed

    private void wardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wardActionPerformed

    private void provinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provinceActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_provinceActionPerformed

    private void provinceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_provinceMouseClicked
        // TODO add your handling code here:
        if(province.getForeground()==Color.LIGHT_GRAY){
            province.setText("");
        }
        province.setForeground(Color.black);
    }//GEN-LAST:event_provinceMouseClicked

    private void districtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_districtMouseClicked
        // TODO add your handling code here:
        if(district.getForeground()==Color.LIGHT_GRAY){
            district.setText("");
        }
        district.setForeground(Color.black);
    }//GEN-LAST:event_districtMouseClicked

    private void wardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wardMouseClicked
        // TODO add your handling code here:
        if(ward.getForeground()==Color.LIGHT_GRAY){
            ward.setText("");
        }
        ward.setForeground(Color.black);
    }//GEN-LAST:event_wardMouseClicked

    private void addressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressMouseClicked
        // TODO add your handling code here:
        if(address.getForeground()==Color.LIGHT_GRAY){
            address.setText("");
        }
        address.setForeground(Color.black);
    }//GEN-LAST:event_addressMouseClicked

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddAddressGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAddressGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAddressGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAddressGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAddressGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField address;
    private javax.swing.JTextField district;
    private javax.persistence.EntityManager entity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField province;
    private javax.swing.JTextField ward;
    // End of variables declaration//GEN-END:variables
}
