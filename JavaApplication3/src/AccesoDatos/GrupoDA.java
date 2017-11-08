/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Carpeta;
import Modelo.Grupo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
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
            String instruccion = "INSERT INTO Grupo VALUES (?,?,?);";
            PreparedStatement ps=con.prepareStatement(instruccion);
            int idGrupo=getNextId();
            ps.setInt(1, getNextId());
            ps.setInt(2, idPermiso);
            ps.setString(3, nomGrupo);
            ps.execute();
            String i1 = "INSERT INTO GrupoXCarpeta VALUES(?,?)";
            PreparedStatement ps1=con.prepareStatement(i1);
            ps1.setInt(1, idGrupo);
            ps1.setInt(2, carpetaID);
            System.out.println(carpetaID);
            ps1.execute();
            CallableStatement cs=con.prepareCall("{call OBTENER_HIJOS_CARPETA(?)}");
            cs.setInt("ID_PADRE", carpetaID);
            ResultSet rs=cs.executeQuery();
            System.out.println(carpetaID);
            while(rs.next()){
                String i2 = "INSERT INTO GrupoXCarpeta VALUES(?,?)";
                PreparedStatement ps2=con.prepareStatement(i2);
                ps2.setInt(1, idGrupo);
                ps2.setInt(2, rs.getInt(1));
                System.out.println(rs.getInt(1));
                ps2.execute();
            }
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
    public DefaultTableModel listaGrupoXcarpeta(Carpeta c){
        String []col={"Id","Nombre","Permiso"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "select g.Id as id, g.Nombre as nombre,p.Nombre as permiso from Grupo g, GrupoXCarpeta gc,Permiso p "
                    + "where gc.Grupo_Id=g.Id and g.Permiso_idPermiso=p.idPermiso " +
                    " and gc.Carpeta_id="+c.getId();
            ResultSet rs=sentencia.executeQuery(instruccion);
            while(rs.next()){
                Object[] data={rs.getInt("id"),rs.getString("nombre"),rs.getString("permiso")};
                tableModel.addRow(data);
            }
            
        }catch(Exception e){
           
        }
        return tableModel;
    }
    public void eliminaGrupo(int id){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
        try{
            String instruccion = "DELETE FROM GrupoXCarpeta WHERE Carpeta_id=?";
            PreparedStatement ps=con.prepareStatement(instruccion);
            ps.setInt(1, id);
            ps.execute();
            String i2="DELETE FROM Grupo WHERE Id=?";
            PreparedStatement ps1=con.prepareStatement(i2);
            ps1.setInt(1, id);
            ps1.execute();
            con.close();
        }catch(Exception e){
           System.out.println("fallo en query ");
        }
    }
}
