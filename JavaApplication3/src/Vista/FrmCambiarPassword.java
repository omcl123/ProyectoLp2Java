/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import Controlador.*;

/**
 *
 * @author Oscar
 */
public class FrmCambiarPassword extends javax.swing.JDialog {

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    private UsuarioBL accesoUser = new UsuarioBL();
    private String email;
    private int clickCA = 0;
    private int clickNC = 0;
    private int clickRC = 0;

    public FrmCambiarPassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setLocation(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnCambiar = new javax.swing.JButton();
        txtPasso = new javax.swing.JPasswordField();
        txtPassN = new javax.swing.JPasswordField();
        txtPassr = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Contraseña actual: ");

        jLabel2.setText("Nueva contraseña:");

        jLabel3.setText("Repetir contraseña:");

        BtnCambiar.setBackground(new java.awt.Color(204, 204, 204));
        BtnCambiar.setText("Cambiar Contraseña");
        BtnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCambiarActionPerformed(evt);
            }
        });

        txtPasso.setText("jPasswordField1");
        txtPasso.setBorder(null);
        txtPasso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassoMouseClicked(evt);
            }
        });

        txtPassN.setText("jPasswordField2");
        txtPassN.setBorder(null);
        txtPassN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassNMouseClicked(evt);
            }
        });

        txtPassr.setText("jPasswordField3");
        txtPassr.setBorder(null);
        txtPassr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassrMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPasso))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator2)
                                        .addComponent(txtPassN, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator3)
                                        .addComponent(txtPassr)))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addComponent(BtnCambiar))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPasso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnCambiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCambiarActionPerformed
        // TODO add your handling code here:
        if (!String.valueOf(txtPasso.getPassword()).equals(frmPrincipal.password)) {
            JOptionPane.showMessageDialog(this, "La contraseña actual no coincide");
            return;
        }
        if (!String.valueOf(txtPassr.getPassword()).equals(String.valueOf(txtPassN.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Deben coincidir las nuevas contraseñas");
            return;
        }
        accesoUser.actualizarPsw(frmPrincipal.password, frmPrincipal.idUsuario);
        frmPrincipal.password = String.valueOf(txtPasso.getPassword());
        JOptionPane.showMessageDialog(this, "Contraseña Actualizada");
//        accesoUser.enviarEmailNuevaPass(email, frmPrincipal.password);
        this.dispose();
    }//GEN-LAST:event_BtnCambiarActionPerformed

    private void txtPassoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassoMouseClicked
        // TODO add your handling code here:
        if (clickCA == 0) {
            this.txtPasso.setText("");
            clickCA = 1;
        }
    }//GEN-LAST:event_txtPassoMouseClicked

    private void txtPassNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassNMouseClicked
        // TODO add your handling code here:
        if (clickNC == 0) {
            this.txtPassN.setText("");
            clickNC = 1;
        }
    }//GEN-LAST:event_txtPassNMouseClicked

    private void txtPassrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassrMouseClicked
        // TODO add your handling code here:
        if (clickRC == 0) {
            this.txtPassr.setText("");
            clickRC = 1;
        }
    }//GEN-LAST:event_txtPassrMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCambiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField txtPassN;
    private javax.swing.JPasswordField txtPasso;
    private javax.swing.JPasswordField txtPassr;
    // End of variables declaration//GEN-END:variables
}
