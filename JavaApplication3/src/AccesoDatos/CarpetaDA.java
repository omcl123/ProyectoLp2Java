/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Carpeta;
import Modelo.Curso;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Oscar
 */
public class CarpetaDA {
    private Connection con;
    public Carpeta getCarpetaActual(int nivel){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        try{
            Statement sentencia = con.createStatement();
            System.out.println("Ejecutando query");
            String instruccion = "select * from Carpeta where id="+nivel;
            ResultSet rs = sentencia.executeQuery(instruccion);
            rs.next();
            Carpeta c =new Carpeta();
            c.setId(rs.getInt("id"));
            System.out.println(rs.getInt("id"));
            c.setCarpetaPadre(rs.getInt("Carpeta_id"));
            c.setDescripcion(rs.getString("descripcion"));
            c.setFechaCreacion(rs.getDate("fechaCreacion"));
            c.setNombre(rs.getString("nombre"));
            System.out.println(rs.getString("nombre"));
            c.setsitioId(rs.getInt("Sitio_id"));
            c.setMaestro(rs.getInt("Maestro"));
          
            System.out.println("query ejecutado");
             con.close();
             return c;
        }catch(Exception e){
           
        }
        return null;
    }
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
    public void registraCarpeta(Carpeta c,int opcion,int maestro){
        CursoDA cDA=new CursoDA();
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
        try{
            int nextId=cDA.getNextId();
            Statement sentencia = con.createStatement();
            if(opcion==1){
                //System.out.println("creando carpeta ");
                String instruccion = "INSERT INTO Carpeta VALUES (?,?,?,sysdate(),?,?,0,1,?);";
                PreparedStatement ps=con.prepareStatement(instruccion);
                ps.setInt(1, nextId);
                ps.setInt(2, c.getCarpetaPadre());
                ps.setString(3, c.getNombre());
                ps.setString(4, c.getDescripcion());
                ps.setInt(5, c.getCurso());
                ps.setInt(6, maestro);
                ps.execute();
                
                //int i=sentencia.executeUpdate(instruccion);
            }
            else{
                String instruccion = "INSERT INTO Carpeta VALUES (?,?,?,sysdate(),?,NULL,0,1,?);";
                PreparedStatement ps=con.prepareStatement(instruccion);
                ps.setInt(1, nextId);
                ps.setInt(2, c.getCarpetaPadre());
                ps.setString(3, c.getNombre());
                ps.setString(4, c.getDescripcion());
                ps.setInt(5, maestro);
                ps.execute();
            }
            con.close();
        }catch(Exception e){
           System.out.println("fallo en query ");
        }
    }
    public void eliminarCarpeta(Carpeta c){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
        try{
//            String lineaCarpetas="select id from (select * from Carpeta" +
//                        "	order by Carpeta_id, id) Carpeta_sorted," +
//                        "	(select @pv := "+c.getId()+") initialisation" +
//                        "where find_in_set(Carpeta_id, @pv) > 0 and @pv := concat(@pv, ',', id);";
//            PreparedStatement ps1=con.prepareStatement(lineaCarpetas);
//            ResultSet rs=ps1.executeQuery();
            CallableStatement cs=con.prepareCall("{call OBTENER_HIJOS_CARPETA(?)}");
            cs.setInt("ID_PADRE", c.getId());
            ResultSet rs=cs.executeQuery();
            System.out.println(c.getId());
            while(rs.next()){
                String instruccion = "UPDATE Carpeta set habilitado=1 WHERE id = ?;";
                PreparedStatement ps=con.prepareStatement(instruccion);
                ps.setInt(1, rs.getInt(1));
                System.out.println(rs.getInt(1));
                ps.execute();
            }
            String instruccion = "UPDATE Carpeta set habilitado=1 WHERE id = ?;";
            PreparedStatement ps=con.prepareStatement(instruccion);
            ps.setInt(1, c.getId());
            ps.execute();
            con.close();
        }catch(Exception e){
           System.out.println(e);
        }
    }
}
