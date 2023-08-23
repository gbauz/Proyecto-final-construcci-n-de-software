/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Este archivo es parte de un paquete llamado "controlador" y define una clase "Conexion".
 * La clase se utiliza para establecer una conexión a una base de datos MySQL.
 */

package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;

/**
 *
 * @author gerne
 */

/**
 * La clase "Conexion" proporciona métodos para establecer y obtener una conexión a la base de datos MySQL.
 * Utiliza el controlador JDBC de MySQL para administrar la conexión.
 */
public class Conexion {
    Connection con;
    
    /**
     * Constructor de la clase "Conexion".
     * En este constructor, se carga el controlador JDBC de MySQL y se establece la conexión a la base de datos.
     */
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_arbitros","root","");   
        }
        catch (Exception e){
            // En caso de algún error durante la conexión, no se maneja adecuadamente en este código
        }
      } 
  
    /**
     * Método para obtener la conexión a la base de datos.
     * @return La conexión establecida a la base de datos.
     */
    public Connection getConnection(){
        return con;
    }
 
}
