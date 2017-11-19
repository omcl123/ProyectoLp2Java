/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Curso;
import Modelo.Sitio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Oscar
 */
public class CursoDA {
    private Connection con;
    public ArrayList<String> lecturaCurso(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        ArrayList<String> lista = new ArrayList<String>();
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "SELECT * FROM Curso";
            ResultSet rs = sentencia.executeQuery(instruccion);
            while(rs.next()){
                lista.add(rs.getString("Nombre"));
            }
             con.close();
        }catch(Exception e){
           
        }
        return lista;
    }
    public int obtieneIdCurso(String nomCur){
        int idCurso;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "SELECT idCurso FROM Curso where Nombre like '"+nomCur+"'";
            ResultSet rs = sentencia.executeQuery(instruccion);
            rs.next();
            idCurso=rs.getInt("idCurso");
            con.close();
            return idCurso;
        }catch(Exception e){
           
        }
        return -1;
    }
    
    public int getNextId(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "select MAX(id) as next from Carpeta;";
            ResultSet rs=sentencia.executeQuery(instruccion);
            rs.next();
            int nextId=rs.getInt("next")+1;
            System.out.println(nextId);
            return nextId;
        }catch(Exception e){
           
        }
        return -1;
    }
    public Curso buscaCursoPorCodigo(String codigo){
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
        try{
            CallableStatement cs=con.prepareCall("{call BUSCAR_CURSO_POR_CODIGO(?)}");
            cs.setString("_CODIGO", codigo);
            ResultSet rs=cs.executeQuery();
            rs.next();
            Curso c=new Curso();
            c.setId(rs.getInt("idCurso"));
            c.setNombre(rs.getString("Nombre"));
            c.setCodCurso(rs.getString("Codigo"));
            return c;
        }catch(Exception e){
           
        }
        return null;
    }
}
