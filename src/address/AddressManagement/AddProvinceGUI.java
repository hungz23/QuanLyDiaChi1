/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.AddressManagement;

import static address.AddressManagement.Level.province;
import entity.AddressManagement.District;
import entity.AddressManagement.Province;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author QuestionBoy
 */
public class AddProvinceGUI extends javax.swing.JFrame {

    /**
     * Creates new form AddProvinceGUI
     */
    public AddProvinceGUI() {
        initComponents();
        this.setLocationRelativeTo(null);   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddressManagementPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("AddressManagementPU").createEntityManager();
        provinceText = new CustomTextField(20);
        searchProvince = new javax.swing.JButton();
        infoListView = new javax.swing.JScrollPane();
        infoList = new javax.swing.JList<>();
        back = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        provinceText.setText("");
        provinceText.setPlaceholder("Tìm kiếm");

        searchProvince.setText("Search");
        searchProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProvinceActionPerformed(evt);
            }
        });

        infoList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        infoList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel model = new DefaultListModel();
        for(String item: alphaList){
            javax.persistence.Query query=AddressManagementPUEntityManager.createNamedQuery("Province.findByName").setParameter("name", item+"%");
            java.util.List<Province> result=query.getResultList();
            if(!result.isEmpty()) model.addElement(item);
            for(Province a:result){
                model.addElement(a.getName());
            }
        }
        infoList=new JList(model);
        infoList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                infoListMouseClicked(evt);
            }
        });
        infoListView.setViewportView(infoList);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoListView)
                    .addComponent(provinceText, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchProvince)
                    .addComponent(jButton1)
                    .addComponent(back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(provinceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchProvince))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoListView, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(back)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProvinceActionPerformed
        // TODO add your handling code here:
        String provinceName=provinceText.getText();
            javax.persistence.Query query=AddressManagementPUEntityManager.createNamedQuery("Province.findByName").setParameter("name", provinceName+"%");
            java.util.List<Province> result=query.getResultList();
            DefaultListModel model= new DefaultListModel();
            for(Province a:result){
                model.addElement(a.getName());
            }
            infoList=new JList(model);
            infoListView.setViewportView(infoList);
    }//GEN-LAST:event_searchProvinceActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AddProvinceGUI().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void infoListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_infoListMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() >=2){
            //provinceidGlobal=new String();
            String provinceName=(String) infoList.getSelectedValue();
            if(Arrays.asList(alphaList).contains(provinceName)) return;
            javax.persistence.Query query=AddressManagementPUEntityManager.createNamedQuery("Province.findByName").setParameter("name", provinceName);
            java.util.List<Province> provinceList=query.getResultList();
            for(Province province: provinceList){
                AddAddressGUI.provinceid=province.getProvinceid();
                AddAddressGUI.provinceName=province.getName();
            }
            this.setVisible(false);
            AddAddressGUI new1=new AddAddressGUI();
            new1.province.setText(AddAddressGUI.provinceName);new1.province.setForeground(Color.BLACK);
            new1.setVisible(true);
        }
    }//GEN-LAST:event_infoListMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AddProvinceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProvinceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProvinceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProvinceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProvinceGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager AddressManagementPUEntityManager;
    private javax.swing.JButton back;
    private javax.swing.JList<String> infoList;
    private javax.swing.JScrollPane infoListView;
    private javax.swing.JButton jButton1;
    private CustomTextField provinceText;
    private javax.swing.JButton searchProvince;
    // End of variables declaration//GEN-END:variables
    public static String[] alphaList={"A","B","C","D","Đ","E","Ê","G","H","I","K","L","M","N","O","Ô","Ơ","R","S","T","U","Ư","V","X","Y"};
    private String provinceidGlobal;
    private String provinceGlobal;
}
