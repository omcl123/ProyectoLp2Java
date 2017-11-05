/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.SitioDA;
import Modelo.Sitio;
import java.util.ArrayList;

/**
 *
 * @author alulab14
 */
public class SitioBL {
    private SitioDA accesoDato;
    private ArrayList<Sitio> lista ;
    public SitioBL(){
        accesoDato = new SitioDA();
    }
    
    public ArrayList<Sitio> lecturaSitio(){
        lista = new ArrayList<Sitio>();
        lista = accesoDato.lecturaSitio();
        return lista;
    }
    
    public ArrayList<Sitio> busquedaXNombre(String nombre){
        ArrayList<Sitio> sublista = new ArrayList<Sitio>();
        for(int i = 0;i<lista.size();i++){
            if(lista.get(i).getNombre().indexOf(nombre)!=-1){
                Sitio s = new Sitio(lista.get(i).getId(),lista.get(i).getNombre(),lista.get(i).getDescripcion());
                sublista.add(s);
            }
        }
        return sublista;
    }
}
