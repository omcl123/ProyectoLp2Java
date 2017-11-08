/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Carpeta {
    
    private int id;
    private String nombre;
    private String descripcion;
    private ArrayList<Grupo> grupos;
    private ArrayList<Documento> documentos;
    private Date fechaCreacion;
    private int carpetaPadre;
    private int sitioId;
    private int curso;
    private int Maestro;
    public int getMaestro() {
        return Maestro;
    }

    public void setMaestro(int Maestro) {
        this.Maestro = Maestro;
    }
    
    
    
    public int getSitioId() {
        return sitioId;
    }

    public void setSitioId(int sitioId) {
        this.sitioId = sitioId;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
    
    
    public int getsitioId() {
        return sitioId;
    }

    public void setsitioId(int sitioId) {
        this.sitioId = sitioId;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
    public int getCarpetaPadre() {
        return carpetaPadre;
    }

    public void setCarpetaPadre(int carpetaPadre) {
        this.carpetaPadre = carpetaPadre;
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

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }
    
}
