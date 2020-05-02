    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in ttablahe editor.
 */
package Metodos_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Carlos Felipe
 */
public class Metodos_sql {
    
    public static ConexionBD conexion = new ConexionBD();
    
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero=0;
    
    
    public int guardar(String nombre, String apellidos, String correo , String contraseña){
        
        int resultado =0;
        Connection conexion = null;
        
        String sentencia_guardar = ("INSERT INTO login_bd(nombre,apellidos,correo,contraseña) VALOES (?,?,?,?)");
    
    
        try{
        
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1,nombre);
            sentencia_preparada.setString(2,apellidos);
            sentencia_preparada.setString(3,correo);
            sentencia_preparada.setString(4,contraseña);
            
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
                
        
        }catch(Exception e){
        
            System.out.println(e);
        
        
        
        }return resultado;
    }
    
    public static String buscarNombre (String correo){
        
        String busqueda_nombre = null;
        Connection conexion = null;

        
                try{
        
            conexion = ConexionBD.conectar();
            String sentencia_buscar=("SELECT nombre,apellidos FROM login_bd WHERE correo = '"+ correo +"'");

            if(resultado.next()){
            
            String nombre = resultado.getString("nombre");
            String apellidos = resultado.getString("apellidos");
            busqueda_nombre = (nombre +""+ apellidos);
            
            }
            
            conexion.close();
        
        }catch(Exception e){
        
            System.out.println(e);
        
        
        
        }
                return busqueda_nombre;
    }
                
    public static String buscarUsarioregistrado (String correo,String contraseña){
        
        String busqueda_usuario = null;
        Connection conexion = null;
               try{
        
            conexion = ConexionBD.conectar();
            String sentencia_buscar_usuario =("SELECT nombre,correo,contraseña FROM login_bd WHERE correo = '"+ correo +"' && contraseña"+contraseña+"'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){   
                busqueda_usuario = "usuario encontrado"; 
            }else{
                busqueda_usuario = "usuario no encontrado"; 
            }
            
      
            sentencia_preparada.close();
                
        
        }catch(Exception e){
        
            System.out.println(e);
        
        
        
        }
        return busqueda_usuario;
        
        
        
        
        
        
        
    }
        
        
}
    
    
    
    

