/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Coneccion;
import Modelo.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Ruben
 */
public class UsuarioDA {

    private Coneccion con;

    public UsuarioDA() {
        con = new Coneccion();
    }

    public DefaultTableModel modeloUsuario(JTable tablaUsuarios) {
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        Object[] fila = new Object[5];
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT u.IdUsuario, u.Nombre, u.APaterno, u.AMaterno, u.Email, u.Habilitado,u.IdCargo FROM Usuario u ";

            ResultSet rs = sentencia.executeQuery(instruccion);

            while (rs.next()) {
                fila[0] = rs.getString("IdUsuario");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("APaterno");
                fila[3] = rs.getString("AMaterno");
                fila[4] = rs.getString("Email");
                int habilitado = rs.getInt("Habilitado");
                int cargo = rs.getInt("IdCargo");
                if (habilitado == 1 && cargo == -1) {
                    modelo.addRow(fila);
                }
            }
            con.closeConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return modelo;
    }

    public Usuario buscarUsuarioXcodigo(int codigo) {
        Usuario u = new Usuario();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5",
                    "inf282g5", "reFuKUxhUijfr8np");

            CallableStatement cs = conx.prepareCall("{call BUSCA_USUARIO_CODIGO(?)}");
            cs.setInt("CODIGO", codigo);
            ResultSet rs = cs.executeQuery();
            rs.next();
            u.setnEntidad(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setaPaterno(rs.getString("aP"));
            u.setaMaterno(rs.getString("aM"));
            System.out.println(u.getNombre());
            conx.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return u;
    }

    public void registrarUser(int id, int idCargo, String nombre, String aPaterno, String aMaterno, String email, int habilitado,
            String emailAlt, String password, int dni, String direccion, int telefono) {
        con = new Coneccion();
        try {
            Connection aux = con.getCon();
            CallableStatement csmt = aux.prepareCall("{call GUARDAR_USUARIO"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?)}");
            csmt.setInt("_ID", id);
            csmt.setInt("_CARGO", idCargo);
            csmt.setString("_NOMBRE", nombre);
            csmt.setString("_APATERNO", aPaterno);
            csmt.setString("_AMATERNO", aMaterno);
            csmt.setString("_EMAIL", email);
            csmt.setInt("_HABILITADO", habilitado);
            csmt.setString("_EMAILALT", emailAlt);
            csmt.setString("_PASSWORD", password);
            csmt.setInt("_DNI", dni);
            csmt.setString("_DIRECCION", direccion);
            csmt.setInt("_TELEFONO", telefono);
            csmt.execute();
            aux.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        con.closeConexion();
    }

    public int generarID() {
        con = new Coneccion();
        int id;
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT COUNT(*) FROM Usuario";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            id = rs.getInt("COUNT(*)");
        } catch (Exception e) {
            System.out.println(e.toString());
            return -1;
        }
        con.closeConexion();
        return id;
    }

    public void registrarCargo(int idUsuario, int idCargo) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario SET IdCargo ='" + idCargo + "' WHERE IdUsuario='" + idUsuario + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println("error en registrar caargo usuario");
            System.out.println(e.toString());
        }
        con.closeConexion();
    }

    public int verificarUsuarioEnUso(int idUsuario) {
        //al usar este metodo se asume que el usuario si existe dado que se selecciona de una tabla que extrae datos de la bd
        //-1=error
        //0=ok
        //1 a mas = usuario en uso
        int resultado = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://200.16.7.96/inf282g5",
                    "inf282g5", "reFuKUxhUijfr8np");

            CallableStatement cs = conx.prepareCall("{call VERIFICAR_USUARIO_EN_USO(?,?)}");
            cs.setInt("_ID", idUsuario);
            cs.registerOutParameter("_enUso", java.sql.Types.INTEGER);
            cs.execute();
            resultado = cs.getInt("_enUso");
            conx.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public void actualizarNombre(String nuevoNombre, String tipoTabla, String codigo) {
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET Nombre='" + nuevoNombre + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarAPaterno(String nuevoAP, String tipoTabla, String codigo) {
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET APaterno='" + nuevoAP + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarAMaterno(String nuevoAM, String tipoTabla, String codigo) {
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET AMaterno='" + nuevoAM + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarDNI(int nuevoDNI, String tipoTabla, String codigo) {
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET DNI='" + nuevoDNI + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarTelefono(int nuevotelf, String tipoTabla, String codigo) {
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET Telefono='" + nuevotelf + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarEmail(String nuevoEmail, String tipoTabla, String codigo) {
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET Email='" + nuevoEmail + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarEmailAlt(String nuevoEmailAlt, String tipoTabla, String codigo) {
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET EmailAlternativo='" + nuevoEmailAlt + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarPsw(String nuevaPsw, int id) {
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario SET Password='" + nuevaPsw + "' WHERE IdUsuario='"
                    + id + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarDireccion(String nuevaDir, String tipoTabla, String codigo) {
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET Direccion='" + nuevaDir + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet logeoUser(Coneccion con, String codUser) throws Exception {

        Statement sentencia = con.createStatement();
        String instruccion = "Select us.id as id, us.nombre as nombre ,us.apellidoP as aP,apellidoM as aM,cargo,us.password as Password from "
                + " ((Select u.IdUsuario as id,u.nombre as nombre,u.APaterno as apellidoP,u.AMaterno as apellidoM, u.IdCargo as cargo,u.Password as password "
                + " from Usuario u,Personal a where a.Usuario_IdUsuario=u.IdUsuario and a.Codigo=" + codUser + ") "
                + " union"
                + " (Select u.IdUsuario as id,u.nombre as nombre,u.APaterno as apellidoP,u.AMaterno as apellidoM, u.IdCargo as cargo,u.Password as password "
                + " from Usuario u,Admin_Sistema d where d.Usuario_IdUsuario=u.IdUsuario and d.Codigo=" + codUser + ")) us;";
        ResultSet rs = sentencia.executeQuery(instruccion);
        return rs;
    }

    public String obtenerEmail(int idUser) {
        String email = new String();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT u.Email FROM Usuario u WHERE IdUsuario ='" + idUser + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            email = rs.getString("Email");

            con.closeConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return email;
    }

    public String obtenerPassword(int idUser) {
        String password = new String();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT u.Passsword FROM Usuario u WHERE IdUsuario ='" + idUser + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            password = rs.getString("Email");

            con.closeConexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return password;

    }

    public void enviarEmailNuevoReg(String email, String codigo, String password) {
        try {
            String host = "smtp.gmail.com";
            String user = "sistemalp2@gmail.com";
            String pass = "chistema2017";
            String to = email;
            String from = "sistemalp2@gmail.com";
            String subject = "Datos nuevo usuario";
            String messageText = "Su usario es: " + codigo + " y su contraseña es: " + password + "\nPor favor cambiar su contraseña lo más pronto posible.";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void enviarEmailNuevaPass(String email, String password) {
        try {
            String host = "smtp.gmail.com";
            String user = "sistemalp2@gmail.com";
            String pass = "chistema2017";
            String to = email;
            String from = "sistemalp2@gmail.com";
            String subject = "Nueva Contraseña";
            String messageText = "Su nueva contraseña es: " + password;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cargarArchivos(File archivo) {
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while(true){
                String linea = br.readLine();
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
