/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.CargoDA;
import Modelo.Cargo;
import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class CargoBL {
    private CargoDA accesoCargo = new CargoDA();
    
    public ArrayList<Cargo> listarCargos(){
        return accesoCargo.listarCargos();
    }
}
