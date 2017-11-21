/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alulab14
 */
public class frmPrincipal extends javax.swing.JFrame {
    private String UserName;
    public static int idUsuario;
    public static int cargo;
    public static String codUsuario;
    /**
     * @return the UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param UserName the UserName to set
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        setTitle("Gestor de documentos PUCP");
        System.out.println(cargo);
        if(cargo==2){
            jmUsuarios.setVisible(false);
            barrita2.setVisible(false);
        }
    }
    
    public void setNombreUsuario(){
        nameLabel.setText(UserName);        
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
        nameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        PrincDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAuditorias = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jmGrupos = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jmUsuarios = new javax.swing.JMenu();
        barrita2 = new javax.swing.JMenu();
        MenuCarpetas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 97, 129));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/100pucp.png"))); // NOI18N

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("jLabel2");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir2.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir3.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("(Ver Perfil)");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(nameLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(jLabel2))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout PrincDesktopPaneLayout = new javax.swing.GroupLayout(PrincDesktopPane);
        PrincDesktopPane.setLayout(PrincDesktopPaneLayout);
        PrincDesktopPaneLayout.setHorizontalGroup(
            PrincDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );
        PrincDesktopPaneLayout.setVerticalGroup(
            PrincDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );

        jmAuditorias.setText("Manejo auditorias");
        jmAuditorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmAuditoriasMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmAuditorias);

        jMenu2.setForeground(new java.awt.Color(153, 153, 153));
        jMenu2.setText("|");
        jMenuBar1.add(jMenu2);

        jmGrupos.setText("Manejo Grupos");
        jmGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmGruposMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmGrupos);

        jMenu4.setForeground(new java.awt.Color(153, 153, 153));
        jMenu4.setText("|");
        jMenuBar1.add(jMenu4);

        jmUsuarios.setText("Manejo Usuarios");
        jmUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmUsuariosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmUsuarios);

        barrita2.setForeground(new java.awt.Color(153, 153, 153));
        barrita2.setText("|");
        jMenuBar1.add(barrita2);

        MenuCarpetas.setText("Manejo Carpetas");
        MenuCarpetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuCarpetasMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuCarpetas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PrincDesktopPane)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrincDesktopPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jmAuditoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmAuditoriasMouseClicked
        PrincDesktopPane.removeAll();
        ManejoAuditorias f = new ManejoAuditorias();
        PrincDesktopPane.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jmAuditoriasMouseClicked

    private void jmGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmGruposMouseClicked
        PrincDesktopPane.removeAll();
        ManejoGrupos f = new ManejoGrupos();
        PrincDesktopPane.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jmGruposMouseClicked

    private void jmUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmUsuariosMouseClicked
        PrincDesktopPane.removeAll();
        ManejoUsuarios f = new ManejoUsuarios();
        PrincDesktopPane.add(f);
        f.setVisible(true);
    }//GEN-LAST:event_jmUsuariosMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        PrincDesktopPane.removeAll();
        ModificacionUsuario f;
        try {
            f = new ModificacionUsuario();
            PrincDesktopPane.add(f);
            f.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void MenuCarpetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuCarpetasMouseClicked
        // TODO add your handling code here:
        PrincDesktopPane.removeAll();
        ManejoCarpetas f;
        try{
            f= new ManejoCarpetas();
            PrincDesktopPane.add(f);
            f.setVisible(true);
        }catch (Exception ex){}
    }//GEN-LAST:event_MenuCarpetasMouseClicked

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCarpetas;
    private javax.swing.JDesktopPane PrincDesktopPane;
    private javax.swing.JMenu barrita2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jmAuditorias;
    private javax.swing.JMenu jmGrupos;
    private javax.swing.JMenu jmUsuarios;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
