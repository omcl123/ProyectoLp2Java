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
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class UsuarioDA {

    private Coneccion con;

    public UsuarioDA() {
//        con = new Coneccion();
    }

    public DefaultTableModel modeloUsuario(JTable tablaUsuarios) {
        con = new Coneccion();
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
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET Nombre='" + nuevoNombre + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        con.closeConexion();
    }

    public void actualizarAPaterno(String nuevoAP, String tipoTabla, String codigo) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET APaterno='" + nuevoAP + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        con.closeConexion();
    }

    public void actualizarAMaterno(String nuevoAM, String tipoTabla, String codigo) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET AMaterno='" + nuevoAM + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        con.closeConexion();
    }

    public void actualizarDNI(int nuevoDNI, String tipoTabla, String codigo) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET DNI='" + nuevoDNI + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        con.closeConexion();
    }

    public void actualizarTelefono(int nuevotelf, String tipoTabla, String codigo) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET Telefono='" + nuevotelf + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        con.closeConexion();
    }

    public void actualizarEmail(String nuevoEmail, String tipoTabla, String codigo) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET Email='" + nuevoEmail + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        con.closeConexion();
    }

    public void actualizarEmailAlt(String nuevoEmailAlt, String tipoTabla, String codigo) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET EmailAlternativo='" + nuevoEmailAlt + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        con.closeConexion();
    }

    public void actualizarPsw(String nuevaPsw, int id) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario SET Password='" + nuevaPsw + "' WHERE IdUsuario='"
                    + id + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        con.closeConexion();
    }

    public void actualizarDireccion(String nuevaDir, String tipoTabla, String codigo) {
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();
            String instruccion = "UPDATE Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario)" + "SET Direccion='" + nuevaDir + "' WHERE Codigo='"
                    + codigo + "'";
            sentencia.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        con.closeConexion();
    }

    public ResultSet logeoUser(Coneccion con, String codUser) throws Exception {
        con = new Coneccion();
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
        con = new Coneccion();
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
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT u.Password FROM Usuario u WHERE IdUsuario ='" + idUser + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            password = rs.getString("Password");

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
            while (true) {
                String linea = br.readLine();
                if (linea == null) {
                    break;
                }
                String[] datos = linea.split("\\,");
                int id = generarID();
                int idCargo = -1;
                String nombre = datos[0];
                String aPaterno = datos[1];
                String aMaterno = datos[2];
                String email = datos[3];
                int habilitado = 1;
                String emailAlt = datos[4];
                String password = datos[5];
                int dni = Integer.parseInt(datos[6]);
                String direccion = datos[7];
                int telefono = Integer.parseInt(datos[8]);
                registrarUser(id, idCargo, nombre, aPaterno, aMaterno, email, habilitado,
                        emailAlt, password, dni, direccion, telefono);
            }
            JOptionPane.showMessageDialog(null, "Carga de datos exitosa");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en la carga de datos: " + e.getMessage());
        }
    }

    public String obtenerNombre(String tipoTabla, String codigo) {
        String nombre = new String();
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT Nombre FROM Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario) WHERE Codigo ='" + codigo + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            nombre = rs.getString("Nombre");

            con.closeConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nombre;
    }

    public String obtenerAPaterno(String tipoTabla, String codigo) {
        String aPaterno = new String();
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT APaterno FROM Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario) WHERE Codigo ='" + codigo + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            aPaterno = rs.getString("APaterno");

            con.closeConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return aPaterno;
    }

    public String obtenerAMaterno(String tipoTabla, String codigo) {
        String aMaterno = new String();
        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT AMaterno FROM Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario) WHERE Codigo ='" + codigo + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            aMaterno = rs.getString("AMaterno");

            con.closeConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return aMaterno;
    }

    public int obtenerDNI(String tipoTabla, String codigo) {
        int dni = 0;
        con = new Coneccion();
//        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT DNI FROM Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario) WHERE Codigo ='" + codigo + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            dni = rs.getInt("DNI");

            con.closeConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dni;
    }

    public String obtenerEmail(String tipoTabla, String codigo) {
        String email = new String();
        con = new Coneccion();
//        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT Email FROM Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario) WHERE Codigo ='" + codigo + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            email = rs.getString("Email");

            con.closeConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return email;
    }

    public String obtenerEmailAlt(String tipoTabla, String codigo) {
        String emailAlt = new String();
        con = new Coneccion();
//        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT EmailAlternativo FROM Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario) WHERE Codigo ='" + codigo + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            emailAlt = rs.getString("EmailAlternativo");

            con.closeConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return emailAlt;
    }

    public String obtenerDireccion(String tipoTabla, String codigo) {
        String direccion = new String();
        con = new Coneccion();
//        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT Direccion FROM Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario) WHERE Codigo ='" + codigo + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            direccion = rs.getString("Direccion");

            con.closeConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return direccion;
    }

    public int obtenerTelefono(String tipoTabla, String codigo) {
        int telefono = 0;
        con = new Coneccion();
//        con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT Telefono FROM Usuario INNER JOIN " + tipoTabla + " ON (Usuario.IdUsuario="
                    + tipoTabla + ".Usuario_IdUsuario) WHERE Codigo ='" + codigo + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            telefono = rs.getInt("Telefono");

            con.closeConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return telefono;
    }

    public void enviarPassRecuperacion(String email) {
        String password = new String();
        Coneccion con = new Coneccion();
        try {
            Statement sentencia = con.createStatement();

            String instruccion = "SELECT Password FROM Usuario WHERE Email ='" + email + "'";

            ResultSet rs = sentencia.executeQuery(instruccion);

            rs.next();

            password = rs.getString("Password");

            con.closeConexion();

            try {
                String host = "smtp.gmail.com";
                String user = "sistemalp2@gmail.com";
                String pass = "chistema2017";
                String to = email;
                String from = "sistemalp2@gmail.com";
                String subject = "Solicitud de contraseña";
                String messageText = "Su contraseña es: " + password;
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void logueoExito(int userID) throws Exception {
        con = new Coneccion();
        Statement s3 = con.createStatement();
        String i2 = "select Max(idRegistroLogin) as next from RegistroLogin";
        ResultSet rs2 = s3.executeQuery(i2);
        rs2.next();
        int nextLog = rs2.getInt("next") + 1;
        System.out.println(nextLog);
        con.closeConexion();
        con = new Coneccion();
        Statement s4 = con.createStatement();
        String i4 = "INSERT INTO RegistroLogin VALUES (" + nextLog + "," + userID + ",sysdate())";
        s4.executeUpdate(i4);
        con.closeConexion();
    }

    public ResultSet rsIdUsuario(int idUsuario) throws Exception {
        con = new Coneccion();
        Statement s2 = con.createStatement();
        String i2 = "SELECT * from Usuario where idUsuario=" + idUsuario;
        ResultSet rs2 = s2.executeQuery(i2);
        return rs2;
    }

    public void actualizarUsuarioActual(String email2, String direccion, String telefono, int idUsuario) throws Exception {
        con = new Coneccion();
        Statement s2 = con.createStatement();
        String i2 = "UPDATE Usuario SET EmailAlternativo='" + email2 + "',Direccion='" + direccion + "',Telefono=" + telefono
                + " WHERE IdUsuario=" + idUsuario;
        s2.executeUpdate(i2);
        con.closeConexion();
    }
}
