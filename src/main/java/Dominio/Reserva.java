package Dominio;

public class Reserva {
    private int id;
    private String pais;
    private String ciudad;
    private Usuario usuario;

    public Reserva(int id, String pais, String ciudad, Usuario usuario) {
        this.id = id;
        this.pais = pais;
        this.ciudad = ciudad;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    
}
