/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Sitio {

    private int id;
    private String nombre;
    private String descripcion;
    private ArrayList<Carpeta> listaCarpetas;
    private ArrayList<Grupo> listGrupos;
    
    public Sitio(){
        listaCarpetas = new ArrayList<Carpeta>();
        listGrupos = new ArrayList<Grupo>();
    }
    
    public Sitio(int id, String nombre, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        listaCarpetas = new ArrayList<Carpeta>();
        listGrupos = new ArrayList<Grupo>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Carpeta> getListaCarpetas() {
        return listaCarpetas;
    }

    public void setListaCarpetas(ArrayList<Carpeta> listaCarpetas) {
        this.listaCarpetas = listaCarpetas;
    }

    public ArrayList<Grupo> getListGrupos() {
        return listGrupos;
    }

    public void setListGrupos(ArrayList<Grupo> listGrupos) {
        this.listGrupos = listGrupos;
    }

    
}
