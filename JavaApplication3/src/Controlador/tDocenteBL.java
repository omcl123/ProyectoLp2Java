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
public class tDocenteBL {
    private tDocenteDA accesoDocenteBD = new tDocenteDA();
    
    public DefaultTableModel modeloDocente(JTable tablaUsuarios){
        return accesoDocenteBD.modeloDocente(tablaUsuarios);
    }      
    
}
