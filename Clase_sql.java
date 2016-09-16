package sistema_supermercado;

import java.sql.*;
import javax.swing.JOptionPane;


public class Clase_sql {
    
    Connection conexion = null;
    Statement sentencia = null;
    
    public void CrearBaseDeDatos() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Base de datos creada!!!");
                
    }
    
    public void CrearTablaProducto() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            sentencia = (Statement) conexion.createStatement();
            
            String SQL= "CREATE TABLE PRODUCTOS" +
                    "(ID INT PRIMARY KEY NOT NULL,"+
                    "PRODUCTO TEXT NOT NULL,"+
                    "PRECIO INT NOT NULL)";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {   
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "tabla productos creada con exito!!! ");
    }
    
    public void CrearTablaCliente()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            sentencia = (Statement) conexion.createStatement();
            
            String SQL= "CREATE TABLE CLIENTES" +
                    "(RUT INT PRIMARY KEY NOT NULL,"+
                    "NOMBRE TEXT NOT NULL,"+
                    "EDAD INT NOT NULL)";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {   
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "tabla clientes creada con exito!!! ");
    }
    
    public void InsertarProducto(int id, String producto, int precio) throws ClassNotFoundException, SQLException
    {
        
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            System.out.println("base de datos abierta");
            sentencia = conexion.createStatement();
        
            String sql= "INSERT INTO PRODUCTOS"+
                    "(ID, PRODUCTO, PRECIO)"+
                    "VALUES('"+id+"', '"+producto+"', '"+precio+"')";
            sentencia.executeUpdate(sql);
        
            sentencia.close();
            conexion.commit();
            conexion.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos ingresados con exito!!!");
    }
    
    public void InsertarCliente(int rut, String nombre, int edad)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            System.out.println("base de datos abierta");
            sentencia = conexion.createStatement();
        
            String sql= "INSERT INTO CLIENTES"+
                    "(RUT, NOMBRE, EDAD)"+
                    "VALUES('"+rut+"', '"+nombre+"', '"+edad+"')";
            sentencia.executeUpdate(sql);
        
            sentencia.close();
            conexion.commit();
            conexion.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos ingresados con exito!!!");
    }
    
    public void ActualizarProducto(int id, String producto, int precio) throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL= "UPDATE PRODUCTOS SET PRODUCTO='"+producto+"',PRECIO='"+precio+"' WHERE ID='"+id+"'"; 
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(null, "Actualizacion realizada con exito!!");
        
    }
    
    public void ActualizarCliente(int rut, String nombre, int edad)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL= "UPDATE CLIENTES SET NOMBRE='"+nombre+"',EDAD='"+edad+"' WHERE RUT='"+rut+"'"; 
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(null, "Actualizacion realizada con exito!!");
    }
    
    public void EliminarProducto(int id, String producto, int precio)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL= "DELETE FROM PRODUCTOS WHERE ID='"+id+"'";
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(null, "dato eliminado con exito!!");
    }
    
    public void EliminarCliente(int rut, String nombre, int edad)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL= "DELETE FROM CLIENTES WHERE RUT='"+rut+"'";
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(null, "dato eliminado con exito!!");
    }
    
}
