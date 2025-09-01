package Dominio;

import Persistencia.UsuarioDAO;
import java.util.ArrayList;

public class Principal {

    private ArrayList<Usuario> listaUsuarios;

    public Principal() {
        listaUsuarios = new ArrayList();
    }
    
    public ArrayList<Usuario> listarUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        listaUsuarios = dao.obtener();
        return listaUsuarios;
    }
    
    public void agregarUsuario(Usuario u) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.guardar(u);
    }
    
    public void eliminarUsuario(int posicion) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.eliminar(posicion);
    }
    
    public void modificarUsuario(Usuario u) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.modificar(u);
    }

    
}
