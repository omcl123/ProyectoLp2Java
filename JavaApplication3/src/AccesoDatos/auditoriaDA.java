/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Coneccion;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Oscar
 */
public class auditoriaDA {
    private Connection con;
    public auditoriaDA(){
    }
    
    public DefaultTableModel listaDoc(String nomCur, String fecha){
        DefaultTableModel modelo=new DefaultTableModel();
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "SELECT * FROM EMPLEADO";
            ResultSet rs = sentencia.executeQuery(instruccion);
            while(rs.next()){
                //modelo.addRow(rowData);
            }
            con.close();
        }catch (Exception e){}
        return modelo;
    }
    public DefaultTableModel listaMov(String nomCur, String fecha){
        DefaultTableModel modelo=new DefaultTableModel(new Object [][] {
                },
                new String [] {
                    "Tipo", "Nombre", "Fecha de Creacion"
                });
        try{
            CallableStatement cs = null;
            cs = this.con.prepareCall("{call BUSCAR_ID_CURSO(?,?)}");
            cs.setString(1, nomCur);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            int numCur=cs.getInt(2);
            cs=this.con.prepareCall("{call BUSCAR_CURSO_CARPETA(?,?)}");
            cs.setInt(1, numCur);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.execute();
            int numCarpeta=cs.getInt(2);
            cs=this.con.prepareCall("{call LISTA_DOCUMENTOS(?,?)}");
            cs.setInt(1, numCur);
            cs.setInt(2, numCarpeta);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                modelo.addRow(new Object[] {rs.getString("Tipo"),rs.getString("nombre"),rs.getString("fechaCreacion")});
                System.out.println(rs.getString("Tipo"));
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("fechaCreacion"));
            }
            con.close();
        }catch (Exception e){System.out.println("Error en query");}
        return modelo;
    }
    public DefaultTableModel usuariosMasActivos(String nomCur, String fecha){
        DefaultTableModel modelo=new DefaultTableModel();
        try{
            Statement sentencia = con.createStatement();
            String instruccion = "SELECT * FROM EMPLEADO";
            ResultSet rs = sentencia.executeQuery(instruccion);
            while(rs.next()){
                //modelo.addRow(rowData);
            }
            con.close();
        }catch (Exception e){}
        return modelo;
    }
}
