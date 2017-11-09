/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.GrupoDA;
import Modelo.Carpeta;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oscar
 */
public class GrupoBL {

    private GrupoDA gDA;

    public GrupoBL() {
        gDA = new GrupoDA();
    }

    public void creaGrupo(int carpetaID, String nomGrupo, String permiso) {
        gDA.creaGrupo(carpetaID, nomGrupo, permiso);
    }

    public DefaultTableModel listaGrupoXcarpeta(Carpeta c) {
        return gDA.listaGrupoXcarpeta(c);
    }

    public void eliminaGrupo(int id) {
        gDA.eliminaGrupo(id);
    }

    public DefaultTableModel listaTotalGrupo() {
        return gDA.listaTotalGrupo();
    }

    public DefaultTableModel listaUsuariosXGrupo(int idGrupo) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            modelo = gDA.listaUsuariosXGrupo(idGrupo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelo;
    }
    
    public void asignarUsuario(int idUsuario,int idGrupo){
        gDA.asignarUsuario(idUsuario, idGrupo);
    }
    
    public void eliminarUsuarioGrupo(int idUsuario,int idGrupo){
        gDA.eliminarUsuarioGrupo(idUsuario, idGrupo);
    }
}
