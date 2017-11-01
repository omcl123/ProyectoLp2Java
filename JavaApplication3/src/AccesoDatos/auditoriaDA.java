/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Coneccion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Oscar
 */
public class auditoriaDA {
    private Coneccion con;
    public auditoriaDA(){
        con=new Coneccion();
    }
    public DefaultTableModel listaDoc(String nomCur, String fecha){
        DefaultTableModel modelo=new DefaultTableModel();
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "SELECT * FROM EMPLEADO";
            ResultSet rs = sentencia.executeQuery(instruccion);
            while(rs.next()){
                //modelo.addRow(rowData);
            }
            con.closeConexion();
        }catch (Exception e){}
        return modelo;
    }
    public DefaultTableModel listaMov(String nomCur, String fecha){
        DefaultTableModel modelo=new DefaultTableModel();
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "SELECT * FROM EMPLEADO";
            ResultSet rs = sentencia.executeQuery(instruccion);
            while(rs.next()){
                //modelo.addRow(rowData);
            }
            con.closeConexion();
        }catch (Exception e){}
        return modelo;
    }
    public DefaultTableModel usuariosMasActivos(String nomCur, String fecha){
        DefaultTableModel modelo=new DefaultTableModel();
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "SELECT * FROM EMPLEADO";
            ResultSet rs = sentencia.executeQuery(instruccion);
            while(rs.next()){
                //modelo.addRow(rowData);
            }
            con.closeConexion();
        }catch (Exception e){}
        return modelo;
    }
}
