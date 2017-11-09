/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Coneccion;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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
    public Usuario buscarUsuarioXcodigo(int codigo){
        Usuario u=new Usuario();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conx = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                        "inf282g5", "reFuKUxhUijfr8np");
       
            CallableStatement cs=conx.prepareCall("{call BUSCA_USUARIO_CODIGO(?)}");
            cs.setInt("CODIGO", codigo);
            ResultSet rs=cs.executeQuery();
            rs.next();
            u.setnEntidad(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setaPaterno(rs.getString("aP"));
            u.setaMaterno(rs.getString("aM"));
            System.out.println(u.getNombre());
            conx.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return u;
    }
    
    public void registrarUser(int id,String nombre,String aPaterno,String aMaterno,String email,int habilitado,
            String emailAlt,String password,int dni,String direccion,int telefono) {
        con = new Coneccion();
        try {
            Connection aux = con.getCon();
            CallableStatement csmt = aux.prepareCall("{call GUARDAR_USUARIO"
                    + "(?,?,?,?,?,?,?,?,?,?,?)}");
            csmt.setInt("_ID", id);
            csmt.setString("_NOMBRE", nombre);
            csmt.setString("_APATERNO", aPaterno);
            csmt.setString("_AMATERNO", aMaterno);
            csmt.setString("_EMAIL", email);
            csmt.setInt("_HABILITADO", habilitado);
            csmt.setString("_EMAILALT", emailAlt);
            csmt.setString("_PASSWORD", password);
            csmt.setInt("_DNI", dni);
            csmt.setString("_DIRECCION", direccion);
            csmt.setInt("_TELEFONO", telefono);
            csmt.execute();
            aux.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        con.closeConexion();
    }
}
