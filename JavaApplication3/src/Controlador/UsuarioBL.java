/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.UsuarioDA;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class UsuarioBL {
    private UsuarioDA accesoUsuario = new UsuarioDA();
    
    public DefaultTableModel modeloUsuario(JTable tablaUsuarios) {
        return accesoUsuario.modeloUsuario(tablaUsuarios);
    }
}
