/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.EspecialidadDA;
import Modelo.Especialidad;
import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class EspecialidadBL {
    private EspecialidadDA accesoEsp=new EspecialidadDA();
    public ArrayList<Especialidad> listarEspecialidades(){
        return accesoEsp.listarEspecialidades();
    } 
}
