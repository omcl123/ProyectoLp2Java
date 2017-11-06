/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.PermisoDA;
import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class PermisoBL {
    private PermisoDA pDA;
    public PermisoBL(){
        pDA=new PermisoDA();
    }
    public ArrayList<String> lecturaPermiso(){
        return pDA.lecturaPermiso();
    }
}
