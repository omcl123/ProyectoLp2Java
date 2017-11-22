/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.tAdminDA;
import Modelo.Administrador;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class tAdminBL {
    private tAdminDA accesoAdminBD = new tAdminDA();
    
    public DefaultTableModel modeloAdmin(JTable tablaUsuarios){
        return accesoAdminBD.modeloAdmin(tablaUsuarios);
    }      
    public void registrarAdmin(int id, int cargo, String codigo) {
        accesoAdminBD.registrarAdmin(id, cargo, codigo);
    }
    
    public void eliminarAdmin(String codigo,int id){
        accesoAdminBD.eliminarAdmin(codigo, id);
    }
    
    public int getId(String codigo){
        return accesoAdminBD.getId(codigo);
    }
}