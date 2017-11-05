/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Coneccion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class UsuarioDA {

    private Coneccion con;

    public UsuarioDA() {
        con = new Coneccion();
    }

    public DefaultTableModel modeloUsuario(JTable tablaUsuarios) {
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        Object[] fila = new Object[5];
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT u.IdUsuario, u.Nombre, u.APaterno, u.AMaterno, u.Email FROM Usuario u ";

            ResultSet rs = sentencia.executeQuery(instruccion);

            while (rs.next()) {
                fila[0]=rs.getString("IdUsuario");
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
    
}
