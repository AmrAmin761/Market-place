/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client.version;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Change_Password extends javax.swing.JFrame {

    /**
     * Creates new form Change_Password
     */
    public Change_Password() {  
        initComponents();
        EMAIL.setText(ClientVersion.b.getEmail());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NEWPASS2 = new javax.swing.JTextField();
        NEWPASS1 = new javax.swing.JTextField();
        OLDPASS = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        EMAIL = new javax.swing.JLabel();
        CNFRM = new javax.swing.JButton();
        CANCEL = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CART = new javax.swing.JLabel();
        BROWSER = new javax.swing.JLabel();
        LOGOUT = new javax.swing.JLabel();
        ACC_INFO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Change password");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Old password:");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("New password:");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Confirm password:");

        NEWPASS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEWPASS2ActionPerformed(evt);
            }
        });

        NEWPASS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEWPASS1ActionPerformed(evt);
            }
        });

        OLDPASS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OLDPASSActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("Email:");

        EMAIL.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        EMAIL.setText("jLabel9");

        CNFRM.setBackground(new java.awt.Color(20, 214, 174));
        CNFRM.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        CNFRM.setText("Confrim");
        CNFRM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CNFRMMouseClicked(evt);
            }
        });

        CANCEL.setBackground(new java.awt.Color(20, 214, 174));
        CANCEL.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        CANCEL.setText("Cancel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NEWPASS1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(OLDPASS, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(CNFRM)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CANCEL))
                                    .addComponent(NEWPASS2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OLDPASS))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NEWPASS1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NEWPASS2))
                .addGap(115, 115, 115)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CANCEL)
                    .addComponent(CNFRM))
                .addGap(172, 172, 172))
        );

        jPanel1.setBackground(new java.awt.Color(20, 214, 174));

        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\Market place system\\Client\\Icons\\Capture-modified_180x180 (1).png")); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setText("Second walk clothes store");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel7.setText("Online store solution ");

        CART.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        CART.setForeground(new java.awt.Color(255, 255, 255));
        CART.setIcon(new javax.swing.ImageIcon("D:\\Market place system\\Client\\Icons\\Cart-03-modified_1_60x60.png")); // NOI18N
        CART.setText("Cart");
        CART.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CARTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CARTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CARTMouseExited(evt);
            }
        });

        BROWSER.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        BROWSER.setForeground(new java.awt.Color(255, 255, 255));
        BROWSER.setIcon(new javax.swing.ImageIcon("D:\\Market place system\\Client\\Icons\\emyller-magnifying-glass-modified_60x60.png")); // NOI18N
        BROWSER.setText("Browser");
        BROWSER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BROWSERMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BROWSERMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BROWSERMouseExited(evt);
            }
        });

        LOGOUT.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        LOGOUT.setForeground(new java.awt.Color(255, 255, 255));
        LOGOUT.setIcon(new javax.swing.ImageIcon("D:\\Market place system\\Client\\Icons\\LogOut.png")); // NOI18N
        LOGOUT.setText("Logout");
        LOGOUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LOGOUTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LOGOUTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOGOUTMouseExited(evt);
            }
        });

        ACC_INFO.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        ACC_INFO.setForeground(new java.awt.Color(255, 255, 255));
        ACC_INFO.setIcon(new javax.swing.ImageIcon("D:\\Market place system\\Client\\Icons\\account info.png")); // NOI18N
        ACC_INFO.setText("Account info");
        ACC_INFO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ACC_INFOMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ACC_INFOMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ACC_INFOMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CART, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BROWSER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ACC_INFO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CART, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BROWSER, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(ACC_INFO, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LOGOUT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CARTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CARTMouseClicked
        new Cart().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CARTMouseClicked

    private void CARTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CARTMouseEntered
        CART.setForeground(Color.BLACK);
    }//GEN-LAST:event_CARTMouseEntered

    private void CARTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CARTMouseExited
        CART.setForeground(Color.WHITE);
    }//GEN-LAST:event_CARTMouseExited

    private void BROWSERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BROWSERMouseClicked
        new Browser().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BROWSERMouseClicked

    private void BROWSERMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BROWSERMouseEntered
        BROWSER.setForeground(Color.BLACK);
    }//GEN-LAST:event_BROWSERMouseEntered

    private void BROWSERMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BROWSERMouseExited
        BROWSER.setForeground(Color.WHITE);
    }//GEN-LAST:event_BROWSERMouseExited

    private void LOGOUTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LOGOUTMouseClicked

    private void LOGOUTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseEntered
        LOGOUT.setForeground(Color.BLACK);
    }//GEN-LAST:event_LOGOUTMouseEntered

    private void LOGOUTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGOUTMouseExited
        LOGOUT.setForeground(Color.WHITE);
    }//GEN-LAST:event_LOGOUTMouseExited

    private void ACC_INFOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACC_INFOMouseClicked
        //new Account_Info().setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_ACC_INFOMouseClicked

    private void ACC_INFOMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACC_INFOMouseEntered
        // ACC_INFO.setForeground(Color.BLACK);
    }//GEN-LAST:event_ACC_INFOMouseEntered

    private void ACC_INFOMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACC_INFOMouseExited
        //ACC_INFO.setForeground(Color.WHITE);
    }//GEN-LAST:event_ACC_INFOMouseExited

    private void CNFRMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CNFRMMouseClicked
        try {
            if(Logic.functions.Login(EMAIL.getText(), OLDPASS.getText()))
            {   System.out.println("entering changing pass1");
                String pass1=NEWPASS1.getText();
                String pass2=NEWPASS2.getText();
                if(pass1.equals(pass2))
                {
                    System.out.println("entering changing pass2");
                    Logic.functions.ChangePassword(EMAIL.getText(), pass2);
                    JOptionPane.showMessageDialog(this, "Password Changed!");
                            try {
                             new Account_Info().setVisible(true);
                                } catch (SQLException ex) {
                            Logger.getLogger(Clothes_browser.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Clothes_browser.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Clothes_browser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        this.dispose();
                }
                else
                {
                   JOptionPane.showMessageDialog(this, "not matching!"); 
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "incorrect old passwords"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Change_Password.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Change_Password.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CNFRMMouseClicked

    private void OLDPASSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OLDPASSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OLDPASSActionPerformed

    private void NEWPASS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEWPASS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NEWPASS1ActionPerformed

    private void NEWPASS2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEWPASS2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NEWPASS2ActionPerformed

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
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_Password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACC_INFO;
    private javax.swing.JLabel BROWSER;
    private javax.swing.JButton CANCEL;
    private javax.swing.JLabel CART;
    private javax.swing.JButton CNFRM;
    private javax.swing.JLabel EMAIL;
    private javax.swing.JLabel LOGOUT;
    private javax.swing.JTextField NEWPASS1;
    private javax.swing.JTextField NEWPASS2;
    private javax.swing.JTextField OLDPASS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
