/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author alulab14
 */
public class Coneccion {

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }
    private Connection con;
    public Coneccion(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
    }
    public void closeConexion(){
        try{
            getCon().close();
        }catch (Exception e){}
    }
    
    public Statement createStatement()throws Exception{
        return getCon().createStatement();
    }
}
