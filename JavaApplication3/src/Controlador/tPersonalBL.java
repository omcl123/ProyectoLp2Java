/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class tPersonalBL {
    private tPersonalDA accesoPersonalBD = new tPersonalDA();
    
    public DefaultTableModel modeloPersonal(JTable tablaUsuarios){
        return accesoPersonalBD.modeloPersonal(tablaUsuarios);
    }      
    
}
