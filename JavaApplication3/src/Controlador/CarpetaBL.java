/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.CarpetaDA;
import Modelo.Carpeta;
import java.util.ArrayList;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author Oscar
 */
public class CarpetaBL {
    private CarpetaDA dDA;
    public CarpetaBL(){
        dDA=new CarpetaDA();
    }
    public ArrayList<Carpeta> lecturaCurso(int numPadre){
        return dDA.listaCarpetas(numPadre);
    }
     public void registraCarpeta(Carpeta c,int opcion,int maestro){
         dDA.registraCarpeta(c, opcion, maestro);
     }
     public void eliminarCarpeta(Carpeta c){
         dDA.eliminarCarpeta(c);
     }     
     public Carpeta getCarpetaActual(int nivel){
         return dDA.getCarpetaActual(nivel);
     }
     public void habilitarCarpeta(int idCarpeta){
        dDA.habilitarCarpeta(idCarpeta);
     }
}
