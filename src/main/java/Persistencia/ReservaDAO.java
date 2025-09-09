package Persistencia;

import Dominio.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReservaDAO {
    private String url;
    private String usuario;
    private String contraseña;
    
    public ReservaDAO(){
        url = "jdbc:mysql://localhost:3306/agencia";
        usuario = "root";
        contraseña = "";
    }
    
    public ArrayList<Reserva> obtener(){
        ArrayList<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservas;";
        try {
            Connection conexion = 
                    DriverManager.getConnection(url, usuario, contraseña);
            
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            //Recorre la tabla resultado 
            //y crea un ArrayList con los elementos
            while (rs.next()) {
                //Hay que obtener al usuario mediante la clave foranea:
                int idUsuario = rs.getInt("id_usuario");
                sql = "SELECT * FROM usuarios WHERE id=?";
                PreparedStatement sentencia2 = conexion.prepareStatement(sql);
                sentencia2.setInt(1, idUsuario);
                ResultSet rsUsuario = sentencia2.executeQuery();
                
                Usuario usuarioReserva = new Usuario();
                while (rsUsuario.next()) {
                    usuarioReserva = new Usuario(rsUsuario.getInt("id"), 
                        rsUsuario.getString("nombre"), rsUsuario.getString("mail"));
                }
                
                //Luego se crea la reserva con el usuario obtenido:
                Reserva unaReserva = new Reserva(rs.getInt("id"), 
                        rs.getString("pais"), rs.getString("ciudad"),
                        usuarioReserva);
                lista.add(unaReserva);
            }
            conexion.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return lista;
    }
    
    public void guardar(Reserva r){
        //Sentencia SQL para insertar:
        String sql = "INSERT INTO reservas (pais, ciudad, id_usuario) VALUES (?, ?, ?)";
        try{
            //Se crea la conexión:
            Connection conexion = 
                    DriverManager.getConnection(url, usuario, contraseña);
            
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            //Se cargan los valores del usuario:
            sentencia.setString(1, r.getPais());
            sentencia.setString(2, r.getCiudad());
            sentencia.setInt(3, r.getUsuario().getId());
            
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
        String sql = "DELETE FROM reservas WHERE id=?;";
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
    
    public void modificar(Reserva r){
         //Sentencia SQL para insertar:
        String sql = "UPDATE reservas SET pais=?, ciudad=?, id_usuario=? WHERE id=?;";
        try{
            //Se crea la conexión:
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            //Se cargan los valores del usuario:
            sentencia.setString(1, r.getPais());
            sentencia.setString(2, r.getCiudad());
            sentencia.setInt(3, r.getUsuario().getId());
            sentencia.setInt(4, r.getId());
            
            //Se ejecuta la sentencia:
            sentencia.executeUpdate();
            
            //Se cierra la conexión:
            conexion.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
}
