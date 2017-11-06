/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.CarpetaBL;
import Controlador.CursoBL;
import Controlador.GrupoBL;
import Controlador.PermisoBL;
import Modelo.Carpeta;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Oscar
 */
public class ManejoCarpetas extends javax.swing.JInternalFrame {

    private int nivelActual=0;
    private int profundidad=0;
    private ArrayList<Integer> buffNivel=new ArrayList<Integer>();
    private ArrayList<Carpeta> nivelCarpetaActual=new ArrayList<Carpeta>();
    private ImageIcon icon = new ImageIcon("/Imagenes/carpeta.png");
    private String [] col={"" ,"Nombre","Descripcion"};
    private CarpetaBL cBL=new CarpetaBL();
    /**
     * Creates new form ManejoCarpetas
     */
    public ManejoCarpetas() {
        setSize(990,700);
        buffNivel.add(0);
        setClosable(true);
        initComponents();
        if(nivelActual==0)BtnAnterior.setEnabled(false);
        BtnEliminar.setEnabled(false);
        TableCarpeta.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                BtnEliminar.setEnabled(true);
                if(nivelActual==0)BtnAnterior.setEnabled(false);
                if(nivelCarpetaActual.size()==0){
                BtnSiguiente.setEnabled(false);
                }
            }
         });
        PermisoBL pBL=new PermisoBL();
        CBoxNomGrupo.removeAllItems();
        ArrayList<String>listaPermiso=pBL.lecturaPermiso();
        for(int i=0;i<listaPermiso.size();i++){
            CBoxNomGrupo.addItem(listaPermiso.get(i));
        }
        nivelCarpetaActual=cBL.lecturaCurso(nivelActual);
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        
        for(int i=0;i<nivelCarpetaActual.size();i++){
            Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion()};
            tableModel.addRow(data);
        }
        TableCarpeta.setModel(tableModel);
        
        
//        TableCarpeta.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
//        public void valueChanged(ListSelectionEvent event) {
//            // do some actions here, for example
//            // print first column value from selected row
//            System.out.println(TableCarpeta.getValueAt(TableCarpeta.getSelectedRow(), 1).toString());
//            buffNivel.add(nivelCarpetaActual.get(TableCarpeta.getSelectedRow()).getId());
//            
//        }
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableCarpeta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        BtnNuevaCarpeta = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtADescripcion = new javax.swing.JTextArea();
        CheckCurso = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtNomGrupo = new javax.swing.JTextField();
        CBoxNomGrupo = new javax.swing.JComboBox<>();
        BtnNuevoGrupo = new javax.swing.JButton();
        BtnAnterior = new javax.swing.JButton();
        BtnSiguiente = new javax.swing.JButton();

        setClosable(true);

        TableCarpeta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TableCarpeta);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Carpeta"));

        jLabel1.setText("Nombre:");

        BtnNuevaCarpeta.setText("Nueva Carpeta");
        BtnNuevaCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevaCarpetaActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar Carpeta");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Descripcion:");

        TxtADescripcion.setColumns(20);
        TxtADescripcion.setRows(5);
        jScrollPane2.setViewportView(TxtADescripcion);

        CheckCurso.setText("Carpeta de Curso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNombre))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnEliminar)
                                    .addComponent(BtnNuevaCarpeta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CheckCurso)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckCurso)
                .addGap(18, 18, 18)
                .addComponent(BtnNuevaCarpeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnEliminar)
                .addGap(9, 9, 9))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Grupo"));

        jLabel2.setText("Nombre:");

        CBoxNomGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BtnNuevoGrupo.setText("Nuevo Grupo");
        BtnNuevoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBoxNomGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNomGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnNuevoGrupo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNomGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CBoxNomGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnNuevoGrupo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnAnterior.setText("Anterior");
        BtnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnteriorActionPerformed(evt);
            }
        });

        BtnSiguiente.setText("Siguiente");
        BtnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnSiguiente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAnterior)
                    .addComponent(BtnSiguiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSiguienteActionPerformed
        // TODO add your handling code here:
//        int nivelAux=nivelActual=nivelCarpetaActual.get(TableCarpeta.getSelectedRow()).getId();
//        ArrayList<Carpeta> nivelCarpetaAux=cBL.lecturaCurso(nivelAux);
//        if(nivelCarpetaAux.size()==0){
//            JOptionPane.showMessageDialog(null, "No hay carpetas dentro de esta carpeta","Error",DISPOSE_ON_CLOSE);
//        }else{
            buffNivel.add(nivelCarpetaActual.get(TableCarpeta.getSelectedRow()).getId());
            nivelActual=nivelCarpetaActual.get(TableCarpeta.getSelectedRow()).getId();
            if(nivelActual==0)BtnAnterior.setEnabled(false);
            else BtnAnterior.setEnabled(true);
            nivelCarpetaActual=cBL.lecturaCurso(nivelActual);
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);

            for(int i=0;i<nivelCarpetaActual.size();i++){
                Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion()};
                tableModel.addRow(data);
            }
            TableCarpeta.setModel(tableModel);
            profundidad++;
            if(nivelCarpetaActual.size()==0){
                BtnSiguiente.setEnabled(false);
            }
            
//        }
    }//GEN-LAST:event_BtnSiguienteActionPerformed

    private void BtnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnteriorActionPerformed
        // TODO add your handling code here:
        buffNivel.remove(profundidad);
        profundidad--;
        nivelActual=buffNivel.get(profundidad);
        if(nivelActual==0)BtnAnterior.setEnabled(false);
        else BtnAnterior.setEnabled(true);
        System.out.println(nivelActual);
        nivelCarpetaActual=cBL.lecturaCurso(nivelActual);
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        
        for(int i=0;i<nivelCarpetaActual.size();i++){
            Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion()};
            tableModel.addRow(data);
        }
        TableCarpeta.setModel(tableModel);
        BtnSiguiente.setEnabled(true);
        BtnEliminar.setEnabled(false);
    }//GEN-LAST:event_BtnAnteriorActionPerformed

    private void BtnNuevaCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevaCarpetaActionPerformed
        // TODO add your handling code here:
        if(TxtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No ha escrito un nombre para la carpeta","Error",DISPOSE_ON_CLOSE);
        }else{
            Carpeta c=new Carpeta();
            CarpetaBL caBL=new CarpetaBL();
            c.setNombre(TxtNombre.getText());
            c.setDescripcion(TxtADescripcion.getText());
            c.setCarpetaPadre(nivelActual);
            if(CheckCurso.isSelected()){
                CursoBL cBL=new CursoBL();
                c.setCurso(cBL.obtieneIdCurso(TxtNombre.getText()));
                System.out.println(c.getCurso());
                caBL.registraCarpeta(c, 1);
            }else{
                caBL.registraCarpeta(c, 0);
            }
            nivelCarpetaActual.add(c);
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);

            for(int i=0;i<nivelCarpetaActual.size();i++){
                Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion()};
                tableModel.addRow(data);
            }
            TableCarpeta.setModel(tableModel);
            BtnEliminar.setEnabled(false);
        }
        
    }//GEN-LAST:event_BtnNuevaCarpetaActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        int reply = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta carpeta?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          System.out.println("SI");
          CarpetaBL cBL=new CarpetaBL();
          cBL.eliminarCarpeta(nivelCarpetaActual.get(TableCarpeta.getSelectedRow()));
          nivelCarpetaActual.remove(nivelCarpetaActual.size()-1);
          DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        
            for(int i=0;i<nivelCarpetaActual.size();i++){
                Object[] data={icon,nivelCarpetaActual.get(i).getNombre(),nivelCarpetaActual.get(i).getDescripcion()};
                tableModel.addRow(data);
            }
            TableCarpeta.setModel(tableModel);
        }
        else {
           System.out.println("NO");
        }
        BtnEliminar.setEnabled(false);
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnNuevoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoGrupoActionPerformed
        // TODO add your handling code here:
        GrupoBL gBL=new GrupoBL();
        gBL.creaGrupo(nivelCarpetaActual.get(TableCarpeta.getSelectedRow()).getId(), TxtNomGrupo.getText(), CBoxNomGrupo.getSelectedItem().toString());
    }//GEN-LAST:event_BtnNuevoGrupoActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnterior;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnNuevaCarpeta;
    private javax.swing.JButton BtnNuevoGrupo;
    private javax.swing.JButton BtnSiguiente;
    private javax.swing.JComboBox<String> CBoxNomGrupo;
    private javax.swing.JCheckBox CheckCurso;
    private javax.swing.JTable TableCarpeta;
    private javax.swing.JTextArea TxtADescripcion;
    private javax.swing.JTextField TxtNomGrupo;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}