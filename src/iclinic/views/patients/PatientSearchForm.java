/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iclinic.views.patients;

import iclinic.models.Patient;
import iclinic.models.PatientComboBoxModel;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.Icon;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author obiero
 */
public class PatientSearchForm extends javax.swing.JDialog {

    /**
     * Creates new form AddPatient
     * @param parent
     * @param modal
     */
    
    static PatientComboBoxModel patientComboBoxModel;
    Icon icon = null;
    
    public PatientSearchForm(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Search Patient");
       
        initComponents();
    }
    
    public static void refreshPatientsListForCombo(javax.swing.JComboBox jCombo)
    {
        jCombo.removeAllItems();
        ArrayList<Patient> patients = iclinic.models.Patient.find("");

        patientComboBoxModel = new PatientComboBoxModel(patients);
        jCombo.setModel(patientComboBoxModel);

        /*
        for (Patient patient: patients)
        {
            jCombo.addItem( patient );
            //System.out.println( patient.getSurname() );
        } */
    }
    
    public void setSaveNotificationText(String m, Color color)
    {
        jLabelSaveNotification.setText(m);
        jLabelSaveNotification.setForeground(color);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IconFontSwing.register(FontAwesome.getIconFont());
        icon = IconFontSwing.buildIcon(FontAwesome.SEARCH, 19, new Color(0, 150, 0));
        jLabel1 = new javax.swing.JLabel(icon);
        jComboPatientsList = new javax.swing.JComboBox<>();
        icon = IconFontSwing.buildIcon(FontAwesome.REFRESH, 18, new Color(0, 150, 0));
        jButtonRefreshPatientsList = new javax.swing.JButton(icon);
        IconFontSwing.register(FontAwesome.getIconFont());
        icon = IconFontSwing.buildIcon(FontAwesome.USER, 18, new Color(0, 150, 0));
        jButtonAddNewPatient = new javax.swing.JButton(icon);
        IconFontSwing.register(FontAwesome.getIconFont());
        icon = IconFontSwing.buildIcon(FontAwesome.CALENDAR, 18, new Color(0, 150, 0));
        jButtonAddPatientVisit = new javax.swing.JButton(icon);
        jLabelSaveNotification = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Select Patient");

        //jComboPatientsList.setModel(patientComboBoxModel);

        jButtonRefreshPatientsList.setText("Refresh");
        jButtonRefreshPatientsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshPatientsListActionPerformed(evt);
            }
        });

        jButtonAddNewPatient.setText("Add New");
        jButtonAddNewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewPatientActionPerformed(evt);
            }
        });

        jButtonAddPatientVisit.setText("Add Visit");
        jButtonAddPatientVisit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPatientVisitActionPerformed(evt);
            }
        });

        jLabelSaveNotification.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSaveNotification.setMaximumSize(new java.awt.Dimension(500, 55));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSaveNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAddNewPatient, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboPatientsList, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonRefreshPatientsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAddPatientVisit, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboPatientsList, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRefreshPatientsList, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAddNewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddPatientVisit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jLabelSaveNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        //refreshPatientsListForCombo(jComboPatientsList);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshPatientsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshPatientsListActionPerformed
        // TODO add your handling code here:
        refreshPatientsListForCombo(jComboPatientsList);
    }//GEN-LAST:event_jButtonRefreshPatientsListActionPerformed

    private void jButtonAddNewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewPatientActionPerformed
        // TODO add your handling code here:
        iclinic.controller.PatientController.Add();
    }//GEN-LAST:event_jButtonAddNewPatientActionPerformed

    private void jButtonAddPatientVisitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPatientVisitActionPerformed
        //Patient patient = jComboPatientsList.getSelectedObjects();
        Object m = jComboPatientsList.getSelectedItem();
        //m.
        //m.getId();
        //System.out.print(m);
        //Patient patient = jComboPatientsList.getSelectionModel().getSelectedItem();
       // iclinic.controller.PatientVisitController.Save( patient );
        
    }//GEN-LAST:event_jButtonAddPatientVisitActionPerformed

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
            java.util.logging.Logger.getLogger(PatientSearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientSearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientSearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientSearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PatientSearchForm dialog = new PatientSearchForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void setjT(String m)
    {
        //jTextField1.setText(m);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonAddNewPatient;
    private javax.swing.JButton jButtonAddPatientVisit;
    private javax.swing.JButton jButtonRefreshPatientsList;
    public javax.swing.JComboBox<String> jComboPatientsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelSaveNotification;
    // End of variables declaration//GEN-END:variables
}
