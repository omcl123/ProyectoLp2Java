/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruben
 */
public class CargoDA {

    private Coneccion con;

    public CargoDA() {
        con = new Coneccion();
    }

    public ArrayList<Cargo> listarCargos() {
        ArrayList<Cargo> lista = new ArrayList<Cargo>();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT * FROM Cargo";

            ResultSet rs = sentencia.executeQuery(instruccion);

            while (rs.next()) {
                Cargo c = new Cargo();
                c.setIdCargo(rs.getInt("idCargo"));
                c.setNombre(rs.getString("Nombre"));
                lista.add(c);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
}
