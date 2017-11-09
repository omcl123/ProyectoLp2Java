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
public class tDocenteDA {

    private Coneccion con;

    public tDocenteDA() {
        con = new Coneccion();
    }

    public DefaultTableModel modeloDocente(JTable tablaUsuarios) {
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        Object[] fila = new Object[5];
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT a.Codigo, u.Nombre, u.APaterno, u.AMaterno, u.Email FROM Docente a, Usuario u "
                    + "WHERE a.Usuario_IdUsuario=u.IdUsuario";

            ResultSet rs = sentencia.executeQuery(instruccion);

            while (rs.next()) {
                fila[0]=rs.getString("Codigo");
                fila[1]=rs.getString("Nombre");
                fila[2]=rs.getString("APaterno");
                fila[3]=rs.getString("AMaterno");
                fila[4]=rs.getString("Email");
                modelo.addRow(fila);
            }
            con.closeConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return modelo;
    }
    
     public void registrarDocente(int id, int especialidad, String codigo) {
        con = new Coneccion();
        try {
            Connection aux = con.getCon();
            CallableStatement csmt = aux.prepareCall("{call GUARDAR_DOCENTE"
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

    public void eliminarDocente(String codigo) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "DELETE FROM Docente WHERE Codigo='" + codigo + "'";
            sentencia.executeUpdate(instruccion);
            con.closeConexion();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        con.closeConexion();
    }
}
