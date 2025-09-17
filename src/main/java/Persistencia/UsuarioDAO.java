package Persistencia;

import Dominio.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {
    private String url;
    private String usuario;
    private String contraseña;
    
    // Parametros de conexion a la base de datos.
    public UsuarioDAO(){
        url = "jdbc:mysql://localhost:3306/agencia";
        usuario = "root";
        contraseña = "";
    }
    
    // Función para obtener datos de la base.
    public ArrayList<Usuario> obtener(){
        ArrayList<Usuario> lista = new ArrayList<>();
        // Sentencia SQL
        String sql = "SELECT * FROM usuarios;";
        try {
            // Driver Manager: establece la conexión a la base de datos.
            Connection conexion = 
                    DriverManager.getConnection(url, usuario, contraseña);
            
            // Statement permite ejecutar sentencias SQL sobre la base
            Statement sentencia = conexion.createStatement();
            // ResultSet: representa el resuiltado de ejecutar la consulta SQL
            // Contiene los datos devueltos por la base de datos.
            // Es como una "tabla temporal en memoria" con las filas obtenidas.
            ResultSet rs = sentencia.executeQuery(sql);

            // Se recorre el ResultSet fila por fila 
            // y se crean objetos Usuario con los datos de cada fila.
            while (rs.next()) {
                // Cada fila del ResultSet se convierte en un usuario
                Usuario unUsuario = new Usuario(rs.getInt("id"), 
                        rs.getString("nombre"), rs.getString("mail"));
                // Y se agrega al ArrayList para devolver
                lista.add(unUsuario);
            }
            // Se cierra la conexión
            conexion.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // Se devuelve el ArrayList creado con los datos de la base.
        return lista;
    }
    
    // Método para insertar datos en la base.
    public void guardar(Usuario u){
        // Sentencia SQL para insertar:
        String sql = "INSERT INTO usuarios (nombre, mail) VALUES (?, ?)";
        try{
            // Se crea la conexión:
            Connection conexion = 
                    DriverManager.getConnection(url, usuario, contraseña);
            
            // PreparedStatement representa una sentencia sql con parámetros. 
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            // Se cargan los valores del usuario en la sentencia:
            // Los signos de interrogación (?) son "marcadores de posición".
            // setString(1, ...) carga el primer ?, setString(2, ...) el segundo.
            sentencia.setString(1, u.getNombre());
            sentencia.setString(2, u.getMail());
            
            //Se ejecuta la sentencia:
            sentencia.executeUpdate();
            
            //Se cierra la conexión:
            conexion.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    // Método para eliminar un registro de la base.
    public void eliminar(int id){
         //Sentencia SQL para insertar:
        String sql = "DELETE FROM usuarios WHERE id=?;";
        try{
            //Se crea la conexión:
            Connection conexion = 
                    DriverManager.getConnection(url, usuario, contraseña);
            
            // PreparedStatement representa una sentencia sql con parámetros.
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            //Se cargan el parámetro id, en la sentencia sql:
            sentencia.setInt(1, id);
            
            //Se ejecuta la sentencia:
            sentencia.executeUpdate();
            
            //Se cierra la conexión:
            conexion.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    // Método para modificar un registro de la base.
    public void modificar(Usuario u){
         // Sentencia SQL para modificar:
        String sql = "UPDATE usuarios SET nombre=?, mail=? WHERE id=?;";
        try{
            //Se crea la conexión:
            Connection conexion = 
                    DriverManager.getConnection(url, usuario, contraseña);
            
            // PreparedStatement representa una sentencia sql con parámetros.
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            // Se cargan los valores del usuario en la sentencia:
            sentencia.setString(1, u.getNombre());
            sentencia.setString(2, u.getMail());
            sentencia.setInt(3, u.getId());
            
            //Se ejecuta la sentencia:
            sentencia.executeUpdate();
            
            //Se cierra la conexión:
            conexion.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
