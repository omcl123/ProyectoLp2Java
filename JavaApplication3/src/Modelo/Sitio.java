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
    private ArrayList<MovimientoAuditoria> listaAuditorias;
    private ArrayList<Grupo> listGrupos;
    private ArrayList<Usuario> listUsuarios;
    
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

    public ArrayList<MovimientoAuditoria> getListaAuditorias() {
        return listaAuditorias;
    }

    public void setListaAuditorias(ArrayList<MovimientoAuditoria> listaAuditorias) {
        this.listaAuditorias = listaAuditorias;
    }

    public ArrayList<Grupo> getListGrupos() {
        return listGrupos;
    }

    public void setListGrupos(ArrayList<Grupo> listGrupos) {
        this.listGrupos = listGrupos;
    }

    public ArrayList<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(ArrayList<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }
   
}
