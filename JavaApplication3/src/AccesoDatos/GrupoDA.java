/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Grupo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Oscar
 */
public class GrupoDA {
    private Connection con;
    public void creaGrupo(int carpetaID,String nomGrupo,String permiso){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
        try{
            PermisoDA pDA=new PermisoDA();
            int idPermiso=pDA.devuelveIDPermiso(permiso);
            String instruccion = "INSERT INTO Grupo VALUES (?,?,?,?);";
            PreparedStatement ps=con.prepareStatement(instruccion);
            ps.setInt(1, getNextId());
            ps.setInt(2, idPermiso);
            ps.setString(3, nomGrupo);
            ps.setInt(4,carpetaID);
            ps.execute();
            con.close();
        }catch(Exception e){
           System.out.println("fallo en query ");
        }
    }
    public int getNextId(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "select MAX(id) as next from Grupo;";
            ResultSet rs=sentencia.executeQuery(instruccion);
            rs.next();
            int nextId=rs.getInt("next")+1;
            System.out.println(nextId);
            return nextId;
        }catch(Exception e){
           
        }
        return -1;
    }
}
