/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class CConexion {
    Connection conectar;
    
    String usuario="root";
    String contrasenia="";
    String bd="login ";
    String ip="localhost";
    String puerto="3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            JOptionPane.showMessageDialog(null, "Se conecto a la base de datos");
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "probelamas en la conexion"+ e.toString());
        }
        return conectar;
    }

    PreparedStatement estableceConexion(double d) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
            
}
