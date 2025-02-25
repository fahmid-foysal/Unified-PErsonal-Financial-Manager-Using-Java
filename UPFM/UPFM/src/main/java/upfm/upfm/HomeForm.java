/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package upfm.upfm;

/**
 *
 * @author User
 */
import javax.swing.JOptionPane;
public class HomeForm extends javax.swing.JFrame {

    /**
     * Creates new form HomeForm
     */
    public static User loggedInUser;
    public HomeForm(User user) {
        initComponents();
        this.loggedInUser=user;
        
    }
    User pasUser = this.loggedInUser;
    DatabaseManager db = new DatabaseManager();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    String[] sendMoneyOptions = { "Mobile Banking","Banks"};
    String [] addAccOptions= {"Bkash","Nagad","Rocket","Bank"};
    @SuppressWarnings("unchecked")
    Bkash bkashInstance= new Bkash(loggedInUser.getUsername(),loggedInUser.getPhoneNumber());
    Nagad nagadInstance= new Nagad(loggedInUser.getUsername(),loggedInUser.getPhoneNumber());
    Rocket rocketInstance= new Rocket(loggedInUser.getUsername(),loggedInUser.getPhoneNumber());
    BankAccount bankInstance = new BankAccount(loggedInUser.getUsername());

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        report_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        add_account_button = new javax.swing.JButton();
        send_money_button = new javax.swing.JButton();
        extra_feature_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        report_button.setText("Generate Report");
        report_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_buttonMouseClicked(evt);
            }
        });
        report_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                report_buttonActionPerformed(evt);
            }
        });

        jLabel1.setText("Add Accounts");

        add_account_button.setText("Add Accounts");
        add_account_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_account_buttonMouseClicked(evt);
            }
        });
        add_account_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_account_buttonActionPerformed(evt);
            }
        });

        send_money_button.setText("Send Money");
        send_money_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_money_buttonActionPerformed(evt);
            }
        });

        extra_feature_button.setText("Extra Feature");
        extra_feature_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                extra_feature_buttonMouseClicked(evt);
            }
        });
        extra_feature_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extra_feature_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(extra_feature_button, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(151, 151, 151)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add_account_button, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(send_money_button, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_account_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(249, 249, 249)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send_money_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extra_feature_button, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void report_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_report_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_report_buttonActionPerformed

    private void add_account_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_account_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_account_buttonActionPerformed

    private void send_money_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_money_buttonActionPerformed
        // TODO add your handling code here9
        int choice = JOptionPane.showOptionDialog(
    null,
    "Choose an option:",
    "Custom Dialog",
    JOptionPane.DEFAULT_OPTION,
    JOptionPane.INFORMATION_MESSAGE,
    null,
    sendMoneyOptions,
    sendMoneyOptions[0]
                    );
        
        if (sendMoneyOptions[choice]=="Mobile Banking"){
        new mbSendForm().setVisible(true);
    }
        else if(sendMoneyOptions[choice]=="Banks"){
            new bankSendForm().setVisible(true);
        }
    }//GEN-LAST:event_send_money_buttonActionPerformed

    private void extra_feature_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extra_feature_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_extra_feature_buttonActionPerformed

    private void add_account_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_account_buttonMouseClicked
        // TODO add your handling code here:
        
            int choice = JOptionPane.showOptionDialog(
    null,
    "Choose an option:",
    "Custom Dialog",
    JOptionPane.DEFAULT_OPTION,
    JOptionPane.INFORMATION_MESSAGE,
    null,
    addAccOptions,
    addAccOptions[0]
                    );
        
        if (addAccOptions[choice]=="Bkash"){
            bkashInstance.addAccount(db);
            JOptionPane.showMessageDialog(this, "Bkash account added", "Success", JOptionPane.INFORMATION_MESSAGE);
            
           
    }
        else if(addAccOptions[choice]=="Nagad"){
            nagadInstance.addAccount(db);
            JOptionPane.showMessageDialog(this, "Nagad account added", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        }
        else if(addAccOptions[choice]=="Rocket"){
            rocketInstance.addAccount(db);
            JOptionPane.showMessageDialog(this, "Rocket account added", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        }
        else if (addAccOptions[choice]=="Bank"){
            new addBankForm().setVisible(true);
        }
        
    }//GEN-LAST:event_add_account_buttonMouseClicked

    private void report_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_buttonMouseClicked
        // TODO add your handling code here:
        new reportFrame().setVisible(true);
        
    }//GEN-LAST:event_report_buttonMouseClicked

    private void extra_feature_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_extra_feature_buttonMouseClicked
        // TODO add your handling code here:
        new extrafeatureFrame().setVisible(true);
        
    }//GEN-LAST:event_extra_feature_buttonMouseClicked

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
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeForm(loggedInUser).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_account_button;
    private javax.swing.JButton extra_feature_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton report_button;
    private javax.swing.JButton send_money_button;
    // End of variables declaration//GEN-END:variables
}
