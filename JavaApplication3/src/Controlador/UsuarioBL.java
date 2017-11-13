/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.UsuarioDA;
import Modelo.Usuario;
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
    
    public Usuario buscarUsuarioXcodigo(int codigo){
        return accesoUsuario.buscarUsuarioXcodigo(codigo);
    }
    
    public void registrarUser(int id,int cargo,String nombre,String aPaterno,String aMaterno,String email,int habilitado,
            String emailAlt,String password,int dni,String direccion,int telefono) {
        accesoUsuario.registrarUser(id, cargo,nombre, aPaterno, aMaterno, email, habilitado, emailAlt, password, dni, direccion, telefono);
    }
    
    public int generarID(){
        return accesoUsuario.generarID();
    }
    public void registrarCargo(int idUsuario, int idCargo){
        accesoUsuario.registrarCargo(idUsuario, idCargo);
    }
    public int verificarUsuarioEnUso(int idUsuario){
        return accesoUsuario.verificarUsuarioEnUso(idUsuario);
    }
}
