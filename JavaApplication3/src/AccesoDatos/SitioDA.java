/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Coneccion;
import Modelo.Sitio;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alulab14
 */
public class SitioDA {
    private Coneccion con;
    
    public SitioDA(){
        con = new Coneccion();
    }
    
    public ArrayList<Sitio> lecturaSitio(){
        ArrayList<Sitio> lista = new ArrayList<Sitio>();
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "SELECT * FROM Sitio";
            ResultSet rs = sentencia.executeQuery(instruccion);
            while(rs.next()){
                int id = Integer.parseInt(rs.getString("id"));
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Sitio s = new Sitio(id,nombre,descripcion);
                lista.add(s);
            }
        }catch(Exception e){
            
        }
        return lista;
    }
}
