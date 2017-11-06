/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Curso;
import AccesoDatos.CursoDA;
import java.util.ArrayList;
/**
 *
 * @author Oscar
 */
public class CursoBL {
    private CursoDA dDA;
    public CursoBL(){
        dDA=new CursoDA();
    }
    public ArrayList<String> lecturaCurso(){
        return dDA.lecturaCurso();
    }
}
