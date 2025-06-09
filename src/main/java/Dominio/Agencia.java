package Dominio;

import java.util.ArrayList;

public class Agencia {
    private ArrayList<Usuario> listaUsuarios = new ArrayList();
    
    public void agregarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }

    public ArrayList<Usuario> listarUsuarios() {
        return listaUsuarios;
    }
    
}
