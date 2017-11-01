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
    public Connection con;
    public Coneccion(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282", 
                "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){}
    }
    public void closeConexion(){
        try{
            con.close();
        }catch (Exception e){}
    }
    public Statement createStatement(){
        try{
            return con.createStatement();
        }catch (Exception e);
        
    }
}
