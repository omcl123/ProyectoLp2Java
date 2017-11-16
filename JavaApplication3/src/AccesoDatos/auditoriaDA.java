/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Coneccion;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
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
    
    public DefaultTableModel listaMov(String nomCur, String fecha){
        DefaultTableModel modelo=new DefaultTableModel(new Object [][] {
                },
                new String [] {
                    "Codigo", "Nombre","Movimiento" ,"Documento","Fecha de Creacion"
                });
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        try{
            CallableStatement cs = null;
            cs = this.con.prepareCall("{call LISTA_MOVIMIENTOS}");
            ResultSet rs1=cs.executeQuery();
            while(rs1.next()){
                modelo.addRow(new Object[] {rs1.getInt("codigo"),rs1.getString("nombre"),rs1.getString("movimiento"),rs1.getString("documento")
                ,rs1.getDate("fecha")});
                System.out.println(rs1.getInt("codigo"));
            }
            con.close();
        }catch (Exception e){System.out.println(e);}
        return modelo;
    }
    public DefaultTableModel listaDoc(String nomCur, String fecha){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        DefaultTableModel modelo=new DefaultTableModel(new Object [][] {
                },
                new String [] {
                    "Tipo", "Nombre", "Fecha de Creacion"
                });
        try{
            CallableStatement cs = null;
            cs = this.con.prepareCall("{call BUSCAR_ID_CURSO(?)}");
            System.out.println(nomCur);
            cs.setString(1, nomCur);
            ResultSet rs1=cs.executeQuery();
            rs1.next();
            int numCur=rs1.getInt(1);
            System.out.println(numCur);
            cs=this.con.prepareCall("{call BUSCAR_CURSO_CARPETA(?)}");
            cs.setInt(1, numCur);
            ResultSet rs2=cs.executeQuery();
            rs2.next();
            int numCarpeta=rs2.getInt(1);
            System.out.println(numCarpeta);
            cs=this.con.prepareCall("{call OBTENER_HIJOS_CARPETA(?)}");
            cs.setInt("ID_PADRE", numCarpeta);
            ResultSet rs = cs.executeQuery();
            
            while(rs.next()){
                modelo.addRow(new Object[] {"Carpeta",rs.getString("nombre"),rs.getDate("fechaCreacion")});
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getDate("fechaCreacion"));
                Statement sentencia = con.createStatement();
                String instruccion = "Select 'Evaluacion' as Tipo, d.Nombre,d.FechaCreacion "
                        + "from Documentos d,Doc_Evaluacion e "
                        + "where d.Id=e.Documentos_Id and d.habilitado=1 and d.Carpeta_id="+rs.getInt("id");
                ResultSet rs3 = sentencia.executeQuery(instruccion);
                while(rs3.next()){
                    modelo.addRow(new Object[] {"Evaluacion",rs3.getString(2),rs3.getDate(3)});
                }
                String i3 = "Select 'Documento' as Tipo, d.Nombre,d.FechaCreacion "
                        + "from Documentos d,Doc_docente e "
                        + "where d.Id=e.Documentos_Id and d.habilitado=1 and d.Carpeta_id="+rs.getInt("id");
                ResultSet rs4 = sentencia.executeQuery(i3);
                while(rs4.next()){
                    modelo.addRow(new Object[] {"Documento",rs4.getString(2),rs4.getDate(3)});
                }
            }
            con.close();
        }catch (Exception e){System.out.println("Error en query");}
        return modelo;
    }
    public DefaultTableModel usuariosMasActivos(String nomCur, String fecha){
        DefaultTableModel modelo=new DefaultTableModel(new Object [][] {
                },
                new String [] {
                    "Codigo", "Nombre","Movimientos"
                });
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                        "inf282g5", "reFuKUxhUijfr8np");
            }catch(Exception e){System.out.println("fallo en coneccion ");}
        try{
            
            CallableStatement cs = this.con.prepareCall("{call USUARIOS_MAS_ACTIVOS}");
            ResultSet rs1=cs.executeQuery();
            //rs1.next();
            
            while(rs1.next()){
                modelo.addRow(new Object[] {rs1.getInt("codigo"),rs1.getString("nombre"),rs1.getInt("Total_Movimientos")});
                System.out.println(rs1.getInt("codigo"));
                System.out.println(rs1.getInt("nombre"));
                System.out.println(rs1.getInt("Total_Movimientos"));
            }
            con.close();
        }catch (Exception e){System.out.println(e);}
        return modelo;
    }
}
