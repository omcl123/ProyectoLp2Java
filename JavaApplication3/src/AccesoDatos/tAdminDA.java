/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Administrador;
import Modelo.Coneccion;
import Vista.frmBusqueda;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class tAdminDA {

    private Coneccion con;

    public DefaultTableModel modeloAdmin(JTable tablaUsuarios) {
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        Object[] fila = new Object[5];
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT a.Codigo, u.Nombre, u.APaterno, u.AMaterno, u.Email FROM Admin_Sistema a, Usuario u "
                    + "WHERE a.Usuario_IdUsuario=u.IdUsuario";

            ResultSet rs = sentencia.executeQuery(instruccion);

            while (rs.next()) {
                fila[0] = rs.getString("Codigo");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("APaterno");
                fila[3] = rs.getString("AMaterno");
                fila[4] = rs.getString("Email");
                modelo.addRow(fila);
            }
            con.closeConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return modelo;
    }

    public void registrarAdmin(int id, int cargo, String codigo) {
        con = new Coneccion();
        try {
            Connection aux = con.getCon();
            CallableStatement csmt = aux.prepareCall("{call GUARDAR_ADMIN"
                    + "(?,?,?)}");
            csmt.setInt("_U_IDU", id);
            csmt.setInt("_C_IDCARGO", cargo);
            csmt.setString("_CODIGO", codigo);
            aux.close();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        con.closeConexion();
    }
    
    public void eliminarAdmin(String codigo){
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "DELETE FROM Admin_Sistema WHERE Codigo='"+codigo+"'";
            sentencia.executeUpdate(instruccion);
            con.closeConexion();            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        con.closeConexion();
    }
}
