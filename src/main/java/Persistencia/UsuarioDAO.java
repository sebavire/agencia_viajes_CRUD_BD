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
    
    public UsuarioDAO(){
        url = "jdbc:mysql://localhost:3306/agencia";
        usuario = "root";
        contraseña = "";
    }
    
    public ArrayList<Usuario> obtener(){
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios;";
        try {
            Connection conexion = 
                    DriverManager.getConnection(url, usuario, contraseña);
            
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            //Recorre la tabla resultado 
            //y crea un ArrayList con los elementos
            while (rs.next()) {
                Usuario unUsuario = new Usuario(rs.getInt("id"), 
                        rs.getString("nombre"), rs.getString("mail"));
                lista.add(unUsuario);
            }
            conexion.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return lista;
    }
    
    public void guardar(Usuario u){
        //Sentencia SQL para insertar:
        String sql = "INSERT INTO usuarios (nombre, mail) VALUES (?, ?)";
        try{
            //Se crea la conexión:
            Connection conexion = 
                    DriverManager.getConnection(url, usuario, contraseña);
            
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            //Se cargan los valores del usuario:
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
    
    public void eliminar(int id){
         //Sentencia SQL para insertar:
        String sql = "DELETE FROM usuarios WHERE id=?;";
        try{
            //Se crea la conexión:
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            //Se cargan los valores del usuario:
            sentencia.setInt(1, id);
            
            //Se ejecuta la sentencia:
            sentencia.executeUpdate();
            
            //Se cierra la conexión:
            conexion.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void modificar(Usuario u){
         //Sentencia SQL para insertar:
        String sql = "UPDATE usuarios SET nombre=?, mail=? WHERE id=?;";
        try{
            //Se crea la conexión:
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            //Se cargan los valores del usuario:
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
