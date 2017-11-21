/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import AccesoDatos.auditoriaDA;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Oscar
 */
public class auditoriaBL {
    private auditoriaDA aDA;
    public auditoriaBL(){
        aDA=new auditoriaDA();
    }
    public void listaDoc(String nomCur, String fecha){
        System.out.println("Generando Reporte");
        aDA.listaDoc(nomCur, fecha);
    }
    public void listaMov(String nomCur, String fecha){
        aDA.listaMov(nomCur, fecha);
    }
    public void usuariosMasActivos(String nomCur, String fecha){
        aDA.usuariosMasActivos(nomCur, fecha);
    }
}
