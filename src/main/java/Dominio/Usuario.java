package Dominio;

public class Usuario {
    private int id;
    private String nombre;
    private String mail;
    //... Los demás atributos

    public Usuario(int id, String nombre, String mail) {
        this.id = id;
        this.nombre = nombre;
        this.mail = mail;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "id: " + id + ", nombre: " + nombre;
    }
    
    
}
