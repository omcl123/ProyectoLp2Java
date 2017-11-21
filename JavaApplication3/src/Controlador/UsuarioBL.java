/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.UsuarioDA;
import Modelo.Coneccion;
import Modelo.Usuario;
import java.sql.ResultSet;
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
    
    public void actualizarNombre(String nuevoNombre, String tipoTabla, String codigo) {
        accesoUsuario.actualizarNombre(nuevoNombre, tipoTabla, codigo);
    }

    public void actualizarAPaterno(String nuevoAP, String tipoTabla, String codigo) {
        accesoUsuario.actualizarAPaterno(nuevoAP, tipoTabla, codigo);
    }

    public void actualizarAMaterno(String nuevoAM, String tipoTabla, String codigo) {
        accesoUsuario.actualizarAMaterno(nuevoAM, tipoTabla, codigo);
    }

    public void actualizarDNI(int nuevoDNI, String tipoTabla, String codigo) {
        accesoUsuario.actualizarDNI(nuevoDNI, tipoTabla, codigo);
    }

    public void actualizarTelefono(int nuevotelf, String tipoTabla, String codigo) {
        accesoUsuario.actualizarTelefono(nuevotelf, tipoTabla, codigo);
    }

    public void actualizarEmail(String nuevoEmail, String tipoTabla, String codigo) {
        accesoUsuario.actualizarEmail(nuevoEmail, tipoTabla, codigo);
    }

    public void actualizarEmailAlt(String nuevoEmailAlt, String tipoTabla, String codigo) {
        accesoUsuario.actualizarEmailAlt(nuevoEmailAlt, tipoTabla, codigo);
    }

    public void actualizarPsw(String nuevaPsw, String tipoTabla, String codigo) {
        accesoUsuario.actualizarPsw(nuevaPsw, tipoTabla, codigo);
    }

    public void actualizarDireccion(String nuevaDir, String tipoTabla, String codigo) {
        accesoUsuario.actualizarDireccion(nuevaDir, tipoTabla, codigo);
    }
    
    public ResultSet logeoUser(Coneccion con,String codUser) throws Exception{
            return accesoUsuario.logeoUser(con, codUser);
    }
    
    public void enviarEmail(String email){
        accesoUsuario.enviarEmail(email);
    }
}
