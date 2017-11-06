/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.*;
import Modelo.Coneccion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class EspecialidadDA {

    private Coneccion con;

    public EspecialidadDA() {
        con = new Coneccion();
    }

    public ArrayList<Especialidad> listarEspecialidades() {
        ArrayList<Especialidad> lista = new ArrayList<Especialidad>();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT * FROM Especialidad";

            ResultSet rs = sentencia.executeQuery(instruccion);

            while (rs.next()) {
                Especialidad e = new Especialidad();
                e.setId(rs.getInt("idEspecialidad"));
                e.setNombre(rs.getString("Nombre"));
                lista.add(e);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
}
