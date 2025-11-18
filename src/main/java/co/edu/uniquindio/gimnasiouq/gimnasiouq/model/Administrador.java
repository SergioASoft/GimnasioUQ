package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

public class Administrador extends Empleado{
    private String password;

    public Administrador() {

    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Administrador(String nombre, String identificacion, String telefono, String password) {
        super(nombre, identificacion, telefono);
        this.password = password;
    }
}
