/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Ronie Paolo
 */
public class ManejoGrupos extends javax.swing.JInternalFrame {

    public enum estado { Inicial, SelecGrupo, Guardar, Modificar, NuevoGrupo}
    
    public ManejoGrupos() {
        initComponents();
        setSize(990,700);
        estadoBotones(estado.Inicial);
    }
    
    public void estadoBotones(estado e) {
        switch (e) {
            case Inicial:
                txtNombre.setEnabled(false);
                cboxPermiso.setEnabled(false);
                bttnAgregar.setEnabled(false);
                bttnEliminar.setEnabled(false);
                tableUsuarios.setEnabled(false);
                bttnModificar.setEnabled(false);
                bttnGuardar.setEnabled(false);
                break;
            case SelecGrupo:
                //Al seleccionar debe pasar todos los datos a la descripcion
                //pero sin poder modificar los campos
                txtNombre.setEnabled(false);
                cboxPermiso.setEnabled(false);
                bttnAgregar.setEnabled(false);
                bttnEliminar.setEnabled(false);
                tableUsuarios.setEnabled(false);
                bttnModificar.setEnabled(true);
                bttnGuardar.setEnabled(false);
                break;
            case Modificar:
                txtNombre.setEnabled(true);
                cboxPermiso.setEnabled(true);
                bttnAgregar.setEnabled(true);
                bttnEliminar.setEnabled(true);
                tableUsuarios.setEnabled(true);
                bttnModificar.setEnabled(true);
                bttnGuardar.setEnabled(true);
                break;
            case Guardar:
                txtNombre.setEnabled(false);
                cboxPermiso.setEnabled(false);
                bttnAgregar.setEnabled(false);
                bttnEliminar.setEnabled(false);
                tableUsuarios.setEnabled(false);
                bttnModificar.setEnabled(false);
                bttnGuardar.setEnabled(false);
                break;
            case NuevoGrupo:
                limpiarCampos();
                txtNombre.setEnabled(true);
                cboxPermiso.setEnabled(true);
                bttnAgregar.setEnabled(true);
                bttnEliminar.setEnabled(true);
                tableUsuarios.setEnabled(true);
                bttnModificar.setEnabled(true);
                bttnGuardar.setEnabled(true);
                break;
        }
    }
    
    public void limpiarCampos() {
        txtNombre.setText("");
        cboxPermiso.setSelectedItem(null);
        //Aca la tabla debe refrescarse con un nuevo ArrayList sin elementos
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        bttnIr = new javax.swing.JButton();
        bttnCrearGrupo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGrupos = new javax.swing.JTable();
        bttnSeleccionar = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPermiso = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        cboxPermiso = new javax.swing.JComboBox<>();
        lblUsuarios = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        bttnEliminar = new javax.swing.JButton();
        bttnAgregar = new javax.swing.JButton();
        bttnGuardar = new javax.swing.JButton();
        bttnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Buscar:");

        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        bttnIr.setText("Ir");
        bttnIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnIrActionPerformed(evt);
            }
        });

        bttnCrearGrupo.setText("Crear nuevo grupo");
        bttnCrearGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCrearGrupoActionPerformed(evt);
            }
        });

        tableGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableGrupos);

        bttnSeleccionar.setText("Seleccionar");
        bttnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnSeleccionarActionPerformed(evt);
            }
        });

        lblDescripcion.setText("Descripcion");

        lblNombre.setText("Nombre:");

        lblPermiso.setText("Permiso:");

        jScrollPane2.setViewportView(txtNombre);

        cboxPermiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblUsuarios.setText("Usuarios:");

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableUsuarios);

        bttnEliminar.setText("Eliminar");

        bttnAgregar.setText("Agregar");

        bttnGuardar.setText("Guardar");
        bttnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnGuardarActionPerformed(evt);
            }
        });

        bttnModificar.setText("Modificar");
        bttnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttnIr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bttnCrearGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(bttnSeleccionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttnGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(79, 79, 79)
                                .addComponent(jScrollPane2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPermiso)
                                .addGap(78, 78, 78)
                                .addComponent(cboxPermiso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUsuarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bttnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttnEliminar))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bttnCrearGrupo)
                        .addGap(11, 11, 11)
                        .addComponent(lblDescripcion)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(18, 18, 18)
                                .addComponent(lblPermiso))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuarios)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bttnAgregar)
                                .addComponent(bttnEliminar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bttnIr))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bttnSeleccionar)
                            .addComponent(bttnModificar)
                            .addComponent(bttnGuardar))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void bttnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnIrActionPerformed
        
    }//GEN-LAST:event_bttnIrActionPerformed

    private void bttnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnModificarActionPerformed
        estadoBotones(estado.Modificar);
    }//GEN-LAST:event_bttnModificarActionPerformed

    private void bttnCrearGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCrearGrupoActionPerformed
        estadoBotones(estado.NuevoGrupo);
    }//GEN-LAST:event_bttnCrearGrupoActionPerformed

    private void bttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnGuardarActionPerformed
        estadoBotones(estado.Guardar);
    }//GEN-LAST:event_bttnGuardarActionPerformed

    private void bttnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnSeleccionarActionPerformed
        estadoBotones(estado.SelecGrupo);
    }//GEN-LAST:event_bttnSeleccionarActionPerformed

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
//            java.util.logging.Logger.getLogger(ManejoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManejoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManejoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManejoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManejoGrupos().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAgregar;
    private javax.swing.JButton bttnCrearGrupo;
    private javax.swing.JButton bttnEliminar;
    private javax.swing.JButton bttnGuardar;
    private javax.swing.JButton bttnIr;
    private javax.swing.JButton bttnModificar;
    private javax.swing.JButton bttnSeleccionar;
    private javax.swing.JComboBox<String> cboxPermiso;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPermiso;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JTable tableGrupos;
    private javax.swing.JTable tableUsuarios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextPane txtNombre;
    // End of variables declaration//GEN-END:variables
}
