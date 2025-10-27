package Dominio;

import Persistencia.*;
import java.util.ArrayList;

public class Principal {
    
    // Principal actúa como "puente" entre la interfaz (formulario)
    // y la persistencia (DAO o controller). 
    // Aquí no hay SQL, solo llamadas a métodos del DAO.

    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Reserva> listaReservas;

    public Principal() {
        listaUsuarios = new ArrayList();
        listaReservas = new ArrayList();
    }
    
    // Métodos de Usuarios:
    public ArrayList<Usuario> listarUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        listaUsuarios = dao.obtener();
        return listaUsuarios;
    }
    
    public void agregarUsuario(Usuario u) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.guardar(u);
    }
    
    public void eliminarUsuario(int id) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.eliminar(id);
    }
    
    public void modificarUsuario(Usuario u) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.modificar(u);
    }
    
    public int posicionUsuario(Usuario u){
        this.listaUsuarios = listarUsuarios();
        // Recorre la lista de usuarios:
        for (int i = 0; i < this.listaUsuarios.size(); i++) {
            // Compara el id de cada usuario con el usuario seleccionado:
            if(u.getId() == this.listaUsuarios.get(i).getId()){
                // Cuando lo encuentra, devuelve la posición:
                return i;
            }
        }
        return 0;
    }
    
    // Métodos de Reservas:
    public ArrayList<Reserva> listarReservas() {
        ReservaDAO dao = new ReservaDAO();
        listaReservas = dao.obtener();
        return listaReservas;
    }
    
    public void agregarReserva(Reserva r) {
        ReservaDAO dao = new ReservaDAO();
        dao.guardar(r);
    }
    
    public void eliminarReserva(int id) {
        ReservaDAO dao = new ReservaDAO();
        dao.eliminar(id);
    }
    
    public void modificarReserva(Reserva r) {
        ReservaDAO dao = new ReservaDAO();
        dao.modificar(r);
    }
    
    
    

    
}
