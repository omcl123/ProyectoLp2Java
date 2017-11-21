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
import java.util.HashMap;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Oscar
 */
public class auditoriaDA {
    private Connection con;
    public auditoriaDA(){
    }
    
    public void listaMov(String nomCur, String fecha){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                        "inf282g5", "reFuKUxhUijfr8np");
            JasperReport jr = (JasperReport)JRLoader.loadObjectFromFile(auditoriaDA.class.getResource
                         ("/Reportes/ListaD.jasper").getFile());
            JasperPrint impresion =JasperFillManager.fillReport(jr, null, con);
            JasperViewer viewer = new JasperViewer(impresion);
            viewer.setVisible(true);
            con.close();
        }catch(Exception e){System.out.println("fallo en coneccion ");}
        
    }
    public void listaDoc(String nomCur, String fecha){
        try{
            System.out.println('1');
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println('2');
            con = (Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                    "inf282g5", "reFuKUxhUijfr8np");
            System.out.println('3');
            JasperReport jr = (JasperReport)JRLoader.loadObjectFromFile(auditoriaDA.class.getResource
                     ("/Reportes/ListaD.jasper").getFile());
            HashMap parametros = new HashMap();
            System.out.println(nomCur);
            CallableStatement cs = this.con.prepareCall("{call BUSCAR_ID_CURSO(?)}");
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
            parametros.put("NUM_CURSO", numCur);
            parametros.put("NOM_CURSO",nomCur);
            parametros.put("NUM_CARPETA",numCarpeta);
            JasperPrint impresion =JasperFillManager.fillReport(jr, parametros, con);
            JasperViewer viewer = new JasperViewer(impresion);
            viewer.setVisible(true);
            con.close();
        }catch(Exception e)
        {System.out.println(e);}
        
    }
    public void usuariosMasActivos(String nomCur, String fecha){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5", 
                        "inf282g5", "reFuKUxhUijfr8np");
            JasperReport jr = (JasperReport)JRLoader.loadObjectFromFile(auditoriaDA.class.getResource
                         ("/Reportes/ListaU.jasper").getFile());
            JasperPrint impresion =JasperFillManager.fillReport(jr, null, con);
            JasperViewer viewer = new JasperViewer(impresion);
            viewer.setVisible(true);
            con.close();
        }catch(Exception e){System.out.println("fallo en coneccion ");}
    }
}
