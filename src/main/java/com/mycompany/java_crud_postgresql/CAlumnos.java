/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_crud_postgresql;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lohisbell
 */
public class CAlumnos {
    
    int codigo;
    String nombreAlumno;
    String apellidoAlumno;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }
    
    public void MostrarAlumnos(JTable paramTablaTotalAlumnos){
        
    CConexion objetoConexion = new CConexion();
    
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    String sql="";
    
    modelo.addColumn("Id");
    modelo.addColumn("Nombres");
    modelo.addColumn("Apellidos");
    
    paramTablaTotalAlumnos.setModel(modelo);
    
    sql="SELECT * FROM Alumnos;";
    
    String [] datos = new String[3];
    
    Statement st;
    
        try {
            
            st=objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                
                
                modelo.addRow(datos);
        
            }
            
            paramTablaTotalAlumnos.setModel(modelo);
                    
                    
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.toString());
        }
    
        
        
    
    }
    
    public void insertarAlumno(JTextField paramNombres, JTextField paramApellidos){
        
        setNombreAlumno(paramNombres.getText());
        setApellidoAlumno(paramApellidos.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO Alumnos (nombres, apellidos) values (?,?);";
        
        try {
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            
            cs.setString(1, getNombreAlumno());
            cs.setString(2, getApellidoAlumno());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se insertó correctamente");
            
            
        
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.toString());
            
        }
        
    }
    
    public void seleccionarAlumno(JTable paramTablaAlumno, JTextField paramCodigo, JTextField paramNombres, JTextField paramApellidos){
        
        try {
            
            int fila = paramTablaAlumno.getSelectedRow();
            
            if (fila>=0){
                
                paramCodigo.setText(paramTablaAlumno.getValueAt(fila, 0).toString());
                paramNombres.setText(paramTablaAlumno.getValueAt(fila, 1).toString());
                paramApellidos.setText(paramTablaAlumno.getValueAt(fila, 2).toString());  
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Fila no seleccionada");
            }
            
            
            
            
        
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(null,"ERROR: "+ e.toString());
            
            
        }
        
        
        
        
    }
    
    public void ModificarAlumno(JTextField paramCodigo, JTextField paramNombres, JTextField paramApellidos){
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombreAlumno(paramNombres.getText());
        setApellidoAlumno(paramApellidos.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE Alumnos SET nombres=?, apellidos=? WHERE Alumnos.id=?;";
        
        try {
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            
            cs.setString(1, getNombreAlumno());
            cs.setString(2, getApellidoAlumno());
            cs.setInt(3, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modificó correctamente");
            
            
        
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.toString());
            
        }
        
    }
    
    public void EliminarAlumno(JTextField paramCodigo){
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM Alumnos WHERE Alumnos.id=?;";
        
        try {
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            
            cs.setInt(1, getCodigo());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
            
            
        
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.toString());
            
        }
        
    }
}
