/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.UsuarioDA;
import Modelo.Coneccion;
import Modelo.Usuario;
import java.io.File;
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

    public Usuario buscarUsuarioXcodigo(int codigo) {
        return accesoUsuario.buscarUsuarioXcodigo(codigo);
    }

    public void registrarUser(int id, int cargo, String nombre, String aPaterno, String aMaterno, String email, int habilitado,
            String emailAlt, String password, int dni, String direccion, int telefono) {
        accesoUsuario.registrarUser(id, cargo, nombre, aPaterno, aMaterno, email, habilitado, emailAlt, password, dni, direccion, telefono);
    }

    public int generarID() {
        return accesoUsuario.generarID();
    }

    public void registrarCargo(int idUsuario, int idCargo) {
        accesoUsuario.registrarCargo(idUsuario, idCargo);
    }

    public int verificarUsuarioEnUso(int idUsuario) {
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

    public void actualizarPsw(String nuevaPsw, int id) {
        accesoUsuario.actualizarPsw(nuevaPsw, id);
    }

    public void actualizarDireccion(String nuevaDir, String tipoTabla, String codigo) {
        accesoUsuario.actualizarDireccion(nuevaDir, tipoTabla, codigo);
    }

    public ResultSet logeoUser(Coneccion con, String codUser) throws Exception {
        return accesoUsuario.logeoUser(con, codUser);
    }

    public void enviarEmailNuevoReg(String email, String codigo, String password) {
        accesoUsuario.enviarEmailNuevoReg(email, codigo, password);
    }

    public void enviarEmailNuevaPass(String email, String password) {
        accesoUsuario.enviarEmailNuevaPass(email, password);
    }

    public String obtenerPassword(int idUser) {
        return accesoUsuario.obtenerPassword(idUser);
    }

    public String obtenerEmail(int idUser) {
        return accesoUsuario.obtenerEmail(idUser);
    }

    public void cargarArchivos(File archivo) {
        accesoUsuario.cargarArchivos(archivo);
    }

    public String obtenerNombre(String tipoTabla, String codigo) {
        return accesoUsuario.obtenerNombre(tipoTabla, codigo);
    }

    public String obtenerAPaterno(String tipoTabla, String codigo) {
        return accesoUsuario.obtenerAPaterno(tipoTabla, codigo);
    }

    public String obtenerAMaterno(String tipoTabla, String codigo) {
        return accesoUsuario.obtenerAMaterno(tipoTabla, codigo);
    }

    public int obtenerDNI(String tipoTabla, String codigo) {
        return accesoUsuario.obtenerDNI(tipoTabla, codigo);
    }
    
    public String obtenerEmail(String tipoTabla, String codigo) {
        return accesoUsuario.obtenerEmail(tipoTabla, codigo);
    }
    
    public String obtenerEmailAlt(String tipoTabla, String codigo) {
        return accesoUsuario.obtenerEmailAlt(tipoTabla, codigo);
    }
    
    public String obtenerDireccion(String tipoTabla, String codigo) {
        return accesoUsuario.obtenerDireccion(tipoTabla, codigo);
    }
    
    public int obtenerTelefono(String tipoTabla, String codigo){
        return accesoUsuario.obtenerTelefono(tipoTabla, codigo);
    }
    
    public void enviarPassRecuperacion(String email){
        accesoUsuario.enviarPassRecuperacion(email);
    }
}
