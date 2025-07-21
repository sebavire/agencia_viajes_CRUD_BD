package Dominio;

import java.util.ArrayList;

public class Agencia {

    private ArrayList<Usuario> listaUsuarios = new ArrayList();
    
    public void eliminarUsuario(int posicion) {
        listaUsuarios.remove(posicion);
    }
    
    public void modificarUsuario(int posicion, Usuario u) {
        listaUsuarios.get(posicion).setNombre(u.getNombre());
    }
    
    public void agregarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }
    
    public ArrayList<Usuario> listarUsuarios() {
        return listaUsuarios;
    }
    
}
