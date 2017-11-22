/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Coneccion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class tAlumnoDA {

    private Coneccion con;

    public tAlumnoDA() {
        con = new Coneccion();
    }

    public DefaultTableModel modeloAlumno(JTable tablaUsuarios) {
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        Object[] fila = new Object[5];
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT a.Codigo, u.Nombre, u.APaterno, u.AMaterno, u.Email, u.Habilitado FROM Alumno a, Usuario u "
                    + "WHERE a.Usuario_IdUsuario=u.IdUsuario";

            ResultSet rs = sentencia.executeQuery(instruccion);

            while (rs.next()) {
                fila[0] = rs.getString("Codigo");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("APaterno");
                fila[3] = rs.getString("AMaterno");
                fila[4] = rs.getString("Email");
                int habilitado = rs.getInt("Habilitado");
                if (habilitado == 1) modelo.addRow(fila);
            }
            con.closeConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return modelo;
    }

    public void registrarAlumno(int id, int especialidad, String codigo) {
        con = new Coneccion();
        try {
            Connection aux = con.getCon();
            CallableStatement csmt = aux.prepareCall("{call GUARDAR_ALUMNO"
                    + "(?,?,?)}");
            csmt.setInt("_ID", id);
            csmt.setInt("_ESPECIALIDAD", especialidad);
            csmt.setString("_CODIGO", codigo);
            csmt.execute();
            aux.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        con.closeConexion();
    }

    public void eliminarAlumno(String codigo,int id) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN Alumno ON (Usuario.IdUsuario=Alumno.Usuario_IdUsuario)"+
                    "SET Habilitado = 0, IdCargo = -1 WHERE Codigo='" 
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);            
            
            Statement sentencia2 = con.createStatement();
            String instruccion2 = "DELETE FROM GrupoXUsuario WHERE Usuario_IdUsuario = "+id;
            sentencia.executeUpdate(instruccion2);
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        con.closeConexion();
    }
    
    public int getId(String codigo){
        int id = -1;
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT a.Usuario_IdUsuario,a.Codigo FROM Alumno a "
                    + "WHERE a.Codigo='"+codigo+"'";

            ResultSet rs = sentencia.executeQuery(instruccion);
            
            rs.next();
            
            id = rs.getInt("Usuario_IdUsuario");
                    
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        con.closeConexion();
        return id;
    }
}
