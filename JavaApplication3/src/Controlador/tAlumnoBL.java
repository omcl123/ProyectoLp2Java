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
public class tAlumnoBL {
    private tAlumnoDA accesoAlumnoBD = new tAlumnoDA();
    
    public DefaultTableModel modeloAlumno(JTable tablaUsuarios){
        return accesoAlumnoBD.modeloAlumno(tablaUsuarios);
    }      
    
}
