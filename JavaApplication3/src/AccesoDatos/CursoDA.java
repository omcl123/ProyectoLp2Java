/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Curso;
import Modelo.Sitio;
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
}
