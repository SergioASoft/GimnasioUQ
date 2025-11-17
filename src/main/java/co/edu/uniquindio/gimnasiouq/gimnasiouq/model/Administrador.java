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
    public Administrador(String nombre, int identificacion, int telefono, String password) {
        super(nombre, identificacion, telefono);
        this.password = password;
    }
}
