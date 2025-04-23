/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mycompany.login.fromMenuPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Janus
 */
public class CLogin {
    public void validarUsuario (JTextField usuario, JPasswordField contrasenia) {
        try {
            ResultSet rs=null;
            PreparedStatement ps= null;  
            
            Clases.CConexion objetoConexion = new Clases.CConexion();
            
            String Consulta="SELECT * FROM usuarios WHERE usuarios.ingresoUsuario = (?) AND usuarios.ingresoContrasenia= (?);";
            ps=objetoConexion.estableceConexion().prepareStatement(Consulta);
            
            
            String contra = String.valueOf(contrasenia.getPassword());
            ps.setString(1, usuario.getText());
            ps.setString(2,contra);
            
            rs= ps.executeQuery();
            
            if (rs.next()){
                
                JOptionPane.showMessageDialog(null, "el usuario es correcto");
                fromMenuPrincipal objetoMenu  = new fromMenuPrincipal();
                objetoMenu.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "el usuario es INCORRECTO");
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }       
    }
    
}
