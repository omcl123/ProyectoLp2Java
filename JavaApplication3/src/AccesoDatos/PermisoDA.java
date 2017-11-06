/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Permiso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Oscar
 */
public class PermisoDA {
    private Connection con;
    public ArrayList<String> lecturaPermiso(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        ArrayList<String> lista = new ArrayList<String>();
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "SELECT * FROM Permiso";
            ResultSet rs = sentencia.executeQuery(instruccion);
            while(rs.next()){
                lista.add(rs.getString("Nombre"));
            }
             con.close();
        }catch(Exception e){
           
        }
        return lista;
    }
    public int devuelveIDPermiso(String nomPermiso){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "select idPermiso from Permiso where Nombre like'"+nomPermiso+"';";
            ResultSet rs=sentencia.executeQuery(instruccion);
            rs.next();
            int nextId=rs.getInt("idPermiso");
            System.out.println(nextId);
            return nextId;
        }catch(Exception e){
           
        }
        return -1;
    }
}
