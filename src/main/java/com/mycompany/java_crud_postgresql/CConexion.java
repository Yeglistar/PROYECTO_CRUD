/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_crud_postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Lohisbell
 */
public class CConexion {
    
    Connection conectar = null;
    
    String usuario = "postgres";
    String contraseña = "246810Lo.";
    String bd = "bdescuela";
    String ip = "localhost";
    String puerto = "5432";
    
    String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try {
            Class.forName("org.postgresql.Driver");
            
            conectar=DriverManager.getConnection(cadena,usuario,contraseña);
            
            //JOptionPane.showMessageDialog(null,"Se conectó correctamente a la base de datos");
        
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"ERROR: "+ e.toString());
        }
        
        return conectar;
    }
    
}
