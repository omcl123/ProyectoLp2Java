/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.auditoriaBL;
import Controlador.CursoBL;
import java.awt.Color;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Oscar
 */
public class ManejoAuditorias extends javax.swing.JInternalFrame {

    /**
     * Creates new form ManejoAuditorias
     */
    public ManejoAuditorias() {
        initComponents();
        //setSize(990,700);
        setClosable(true);
        CursoBL cBL=new CursoBL();
        ArrayList<String>listaCurso=cBL.lecturaCurso();
        CBoxCursos.removeAllItems();
        for(int i=0;i<listaCurso.size();i++){
            CBoxCursos.addItem(listaCurso.get(i));
        }
        CBoxTipoReporte.setModel(new javax.swing.DefaultComboBoxModel<>
        (new String[] { "Lista de Documentos","Lista de Movimientos","Usuarios más activos"}));
        //CBoxCursos.setModel(new javax.swing.DefaultComboBoxModel<>
        //(new String[] { "Curso 1","Curso 2","Curso 3"}));
        CBoxPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>
        (new String[] { "El dia anterior", "Semana pasada", "Mes Pasado","Comienzo del ciclo"}));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        btnGeneraReporte = new javax.swing.JButton();
        BtnExportar = new javax.swing.JButton();
        Imagen = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CBoxTipoReporte = new javax.swing.JComboBox<>();
        CBoxPeriodo = new javax.swing.JComboBox<>();
        CBoxCursos = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));

        btnGeneraReporte.setText("Generar Reporte");
        btnGeneraReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneraReporteActionPerformed(evt);
            }
        });

        BtnExportar.setText("Exportar");
        BtnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExportarActionPerformed(evt);
            }
        });

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/auditoria_logo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Auditoria"));

        jLabel1.setText("Seleccionar el tipo de reporte:");

        jLabel5.setText("Seleccionar el periodo a evaluar:");

        jLabel2.setText("Seleccionar el curso a auditar:");

        CBoxTipoReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBoxTipoReporte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBoxTipoReporteItemStateChanged(evt);
            }
        });

        CBoxPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBoxCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CBoxTipoReporte, 0, 288, Short.MAX_VALUE)
                    .addComponent(CBoxPeriodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CBoxCursos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBoxTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CBoxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(BtnExportar)
                        .addGap(76, 76, 76)
                        .addComponent(btnGeneraReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(Imagen)
                        .addGap(59, 59, 59)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGeneraReporte)
                    .addComponent(BtnExportar))
                .addContainerGap(335, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExportarActionPerformed
        // TODO add your ha
//        HSSFWorkbook wb = new HSSFWorkbook();
//        if(CBoxTipoReporte.getSelectedItem().toString().equals("Lista de Documentos")){
//            HSSFSheet sheet = wb.createSheet("Excel Sheet");
//            HSSFRow rowhead = sheet.createRow(0);
//            rowhead.createCell(0).setCellValue("Tipo");
//            rowhead.createCell(1).setCellValue("Nombre");
//            rowhead.createCell(2).setCellValue("Fecha de Creación");
//            for(int i=0;i<TableAudit.getRowCount();i++){
//                HSSFRow row = sheet.createRow(i+1);
//                row.createCell(0).setCellValue(TableAudit.getValueAt(i, 0).toString());
//                row.createCell(1).setCellValue(TableAudit.getValueAt(i, 1).toString());
//                row.createCell(2).setCellValue(TableAudit.getValueAt(i, 2).toString());
//            }   
//            try {
//                FileOutputStream  fileOut = new FileOutputStream("Reportes/Lista_de_documentos.xls",false);
//                wb.write(fileOut);
//                fileOut.close();
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(ManejoAuditorias.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(ManejoAuditorias.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_BtnExportarActionPerformed

    private void CBoxTipoReporteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBoxTipoReporteItemStateChanged
        // TODO add your handling code here:
        if(evt.getItem().toString().equals("Lista de Documentos")){
            
            CBoxCursos.setEnabled(true);
        }
        else if(evt.getItem().toString().equals("Lista de Movimientos")){
            
            CBoxCursos.setEnabled(false);
        }
        else if(evt.getItem().toString().equals("Usuarios más activos")){
            
            CBoxCursos.setEnabled(false);
        }
    }//GEN-LAST:event_CBoxTipoReporteItemStateChanged

    private void btnGeneraReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneraReporteActionPerformed
        // TODO add your handling code here:
        auditoriaBL aBL=new auditoriaBL();
        System.out.println(CBoxTipoReporte.getSelectedItem().toString());
         if(CBoxTipoReporte.getSelectedItem().toString().equals("Lista de Documentos")){
            aBL.listaDoc(CBoxCursos.getSelectedItem().toString(), CBoxPeriodo.getSelectedItem().toString());
        }
        else if(CBoxTipoReporte.getSelectedItem().toString().equals("Lista de Movimientos")){
            aBL.listaMov(CBoxCursos.getSelectedItem().toString(), CBoxPeriodo.getSelectedItem().toString());
        }
        else if(CBoxTipoReporte.getSelectedItem().toString().equals("Usuarios más activos")){
            System.out.println("Generando reporte");
            aBL.usuariosMasActivos(CBoxCursos.getSelectedItem().toString(), CBoxPeriodo.getSelectedItem().toString());
        }
    }//GEN-LAST:event_btnGeneraReporteActionPerformed

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
//            java.util.logging.Logger.getLogger(ManejoAuditorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManejoAuditorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManejoAuditorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManejoAuditorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManejoAuditorias().setVisible(true);
//                
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnExportar;
    private javax.swing.JComboBox<String> CBoxCursos;
    private javax.swing.JComboBox<String> CBoxPeriodo;
    private javax.swing.JComboBox<String> CBoxTipoReporte;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton btnGeneraReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
