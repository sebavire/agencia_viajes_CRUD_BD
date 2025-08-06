package Dominio;

import java.util.ArrayList;

public class Principal {

    private ArrayList<Usuario> listaUsuarios;

    public Principal() {
        listaUsuarios = new ArrayList();
        Usuario unUsuario = new Usuario(1, "asdasdasd");
        agregarUsuario(unUsuario);
        unUsuario = new Usuario(2, "zzxczxc");
        agregarUsuario(unUsuario);
        unUsuario = new Usuario(3, "qweqwrqerqwe");
        agregarUsuario(unUsuario);
        
    }
    
    public void modificarUsuario(int posicion, Usuario u) {
        listaUsuarios.set(posicion, u);
    }
    
    
    
    public void eliminarUsuario(int posicion) {
        listaUsuarios.remove(posicion);
    }
    
    
    
    public void agregarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }
    
    public ArrayList<Usuario> listarUsuarios() {
        return listaUsuarios;
    }
    
    
    
}
