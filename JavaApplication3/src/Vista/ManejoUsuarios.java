/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.tAdminBL;
import Controlador.tAlumnoBL;
import Controlador.tDocenteBL;
import Controlador.tPersonalBL;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Oscar
 */
public class ManejoUsuarios extends javax.swing.JInternalFrame {

    private String userTypeSel;
    private frmBusqueda fBusq;
    private int modificando = 0;

    /**
     * Creates new form ManejoUsuarios
     */
    public ManejoUsuarios() {

        initComponents();
        estadoIni();
//        btnModificar.setVisible(false);
    }

    public void estadoModificar() {
        estadoBuscar();
        btnEliminar.setEnabled(false);
    }

    public void estadoIni() {
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnBuscar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
        cbUsers.setEnabled(true);
    }

    public void estadoNuevo() {
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnBuscar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
        cbUsers.setEnabled(false);
    }

    public void estadoBuscar() {
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnCancelar.setEnabled(true);
        cbUsers.setEnabled(false);
    }

    public void estadoUBase() {
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
        cbUsers.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpContenedor = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        cbUsers = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jdpContenedorLayout = new javax.swing.GroupLayout(jdpContenedor);
        jdpContenedor.setLayout(jdpContenedorLayout);
        jdpContenedorLayout.setHorizontalGroup(
            jdpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        jdpContenedorLayout.setVerticalGroup(
            jdpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        cbUsers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Docente", "Alumno", "Personal" }));

        jLabel1.setText("Tipo de usuario:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(39, 39, 39)
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdpContenedor))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jdpContenedor, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        estadoNuevo();
        userTypeSel = cbUsers.getSelectedItem().toString();
        if (cbUsers.getSelectedItem().toString() == "Administrador") {
            frmRegistrarAdmin f = new frmRegistrarAdmin();
            jdpContenedor.add(f);
            f.setVisible(true);
        } else if (cbUsers.getSelectedItem().toString() == "Docente") {
            frmRegistrarDocente f = new frmRegistrarDocente();
            jdpContenedor.add(f);
            f.setVisible(true);
        } else if (cbUsers.getSelectedItem().toString() == "Alumno") {
            frmRegistrarAlumno f = new frmRegistrarAlumno();
            jdpContenedor.add(f);
            f.setVisible(true);
        } else if (cbUsers.getSelectedItem().toString() == "Personal") {
            frmRegistrarPersonal f = new frmRegistrarPersonal();
            jdpContenedor.add(f);
            f.setVisible(true);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        repaint();
        jdpContenedor.removeAll();
        estadoIni();
        if (modificando == 1) {
            modificando = 0;
            btnBuscarActionPerformed(evt);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        estadoBuscar();
        if (cbUsers.getSelectedItem().toString() == "Administrador") {
            fBusq = new frmBusqueda("Administrador");
            jdpContenedor.add(fBusq);
            fBusq.setVisible(true);
        } else if (cbUsers.getSelectedItem().toString() == "Docente") {
            fBusq = new frmBusqueda("Docente");
            jdpContenedor.add(fBusq);
            fBusq.setVisible(true);
        } else if (cbUsers.getSelectedItem().toString() == "Alumno") {
            fBusq = new frmBusqueda("Alumno");
            jdpContenedor.add(fBusq);
            fBusq.setVisible(true);
        } else if (cbUsers.getSelectedItem().toString() == "Personal") {
            fBusq = new frmBusqueda("Personal");
            jdpContenedor.add(fBusq);
            fBusq.setVisible(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        String userType = fBusq.getUserType();
        String codigo = fBusq.getCodigoSel();
        if (codigo == null) {
            JOptionPane.showMessageDialog(null, "Seleccionar una fila!");
        } else {

            int reply = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar este usuario?", "Aviso", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                if (userType == "Administrador") {
                    tAdminBL accesoAdmin = new tAdminBL();
                    int id = accesoAdmin.getId(codigo);
                    accesoAdmin.eliminarAdmin(codigo,id);
                    jdpContenedor.removeAll();
                    fBusq = new frmBusqueda("Administrador");
                    jdpContenedor.add(fBusq);
                    fBusq.setVisible(true);
                } else if (userType == "Alumno") {
                    tAlumnoBL accesoAlumno = new tAlumnoBL();
                    int id = accesoAlumno.getId(codigo);
                    accesoAlumno.eliminarAlumno(codigo,id);
                    jdpContenedor.removeAll();
                    fBusq = new frmBusqueda("Alumno");
                    jdpContenedor.add(fBusq);
                    fBusq.setVisible(true);
                } else if (userType == "Docente") {
                    tDocenteBL accesoDocente = new tDocenteBL();
                    int id = accesoDocente.getId(codigo);
                    accesoDocente.eliminarDocente(codigo,id);
                    jdpContenedor.removeAll();
                    fBusq = new frmBusqueda("Docente");
                    jdpContenedor.add(fBusq);
                    fBusq.setVisible(true);
                } else if (userType == "Personal") {
                    tPersonalBL accesoPersonal = new tPersonalBL();
                    int id = accesoPersonal.getId(codigo);
                    accesoPersonal.eliminarPersonal(codigo,id);
                    jdpContenedor.removeAll();
                    fBusq = new frmBusqueda("Personal");
                    jdpContenedor.add(fBusq);
                    fBusq.setVisible(true);
                }
            }
        }
        System.out.println(codigo);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        int flag = 0;
        if (cbUsers.getSelectedItem().toString() == "Administrador") {
            frmRegistrarAdmin f = (frmRegistrarAdmin) jdpContenedor.getComponent(0);
            flag = f.guardarAdmin();
        } else if (cbUsers.getSelectedItem().toString() == "Docente") {
            frmRegistrarDocente f = (frmRegistrarDocente) jdpContenedor.getComponent(0);
            flag = f.guardarDocente();
        } else if (cbUsers.getSelectedItem().toString() == "Alumno") {
            frmRegistrarAlumno f = (frmRegistrarAlumno) jdpContenedor.getComponent(0);
            flag = f.guardarAlumno();
        } else if (cbUsers.getSelectedItem().toString() == "Personal") {
            frmRegistrarPersonal f = (frmRegistrarPersonal) jdpContenedor.getComponent(0);
            flag = f.guardarPersonal();
        }
        if (flag == 1) {
            repaint();
            jdpContenedor.removeAll();
            estadoIni();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
        modificando = 1;
        estadoModificar();
        String userType = fBusq.getUserType();
        String codigo = fBusq.getCodigoSel();
        frmModificarUsuario f = new frmModificarUsuario();
        f.setCodigo(codigo);
        if (codigo == null) {
            JOptionPane.showMessageDialog(null, "Seleccionar una fila!");
        } else {
            if (userType == "Administrador") {
                f.setTipoTabla("Admin_Sistema");
                jdpContenedor.removeAll();
                jdpContenedor.add(f);
            } else if (userType == "Alumno") {
                f.setTipoTabla("Alumno");
                jdpContenedor.removeAll();
                jdpContenedor.add(f);
            } else if (userType == "Docente") {
                f.setTipoTabla("Docente");
                jdpContenedor.removeAll();
                jdpContenedor.add(f);
            } else if (userType == "Personal") {
                f.setTipoTabla("Personal");
                jdpContenedor.removeAll();
                jdpContenedor.add(f);
            }
            Thread one = new Thread() {
                @Override
                public void run() {
                    try {
                        int a;
                        while (true) {
                            this.sleep(10);
                            a = f.getFin();
                            if (a == 1) {
                                estadoIni();
                                System.out.println("acabo");
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            };
            one.start();
            f.setVisible(true);
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(ManejoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManejoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManejoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManejoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManejoUsuarios().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cbUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JDesktopPane jdpContenedor;
    // End of variables declaration//GEN-END:variables

}
