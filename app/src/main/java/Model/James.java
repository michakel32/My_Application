package Model;

public class James {

    private String Nombre, contraseñas, telefonos;



    public James(String nombre, String contraseña, String telefono) {
        Nombre = nombre;
        this.contraseñas = contraseña;
        this.telefonos = telefono;
    }
    public James(){


    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getContraseña() {
        return contraseñas;
    }

    public void setContraseña(String contraseña) {
        this.contraseñas = contraseña;
    }

    public String getTelefono() {
        return telefonos;
    }

    public void setTelefono(String telefono) {
        this.telefonos = telefono;
    }

}
