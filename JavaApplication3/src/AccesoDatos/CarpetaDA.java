/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Carpeta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Oscar
 */
public class CarpetaDA {
    private Connection con;
    public ArrayList<Carpeta> listaCarpetas(int numPadre){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        ArrayList<Carpeta> lista = new ArrayList<Carpeta>();
        System.out.println(numPadre);
        try{
            Statement sentencia = con.createStatement();
            System.out.println("Ejecutando query");
            String instruccion = "select * from Carpeta where Carpeta_id="+numPadre+" and Sitio_id=1 and habilitado=0;";
            ResultSet rs = sentencia.executeQuery(instruccion);
            while(rs.next()){
                Carpeta c =new Carpeta();
                c.setId(rs.getInt("id"));
                System.out.println(rs.getInt("id"));
                c.setCarpetaPadre(rs.getInt("Carpeta_id"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setFechaCreacion(rs.getDate("fechaCreacion"));
                c.setNombre(rs.getString("nombre"));
                System.out.println(rs.getString("nombre"));
                c.setsitioId(rs.getInt("Sitio_id"));
                lista.add(c);
            }
            System.out.println("query ejecutado");
             con.close();
        }catch(Exception e){
           
        }
        return lista;
    }
}
