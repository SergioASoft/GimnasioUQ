package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

public class Recepcionista extends Empleado{
    private String password;
    public Recepcionista(String nombre, String identificacion, String telefono, String password) {
        super(nombre, identificacion, telefono);
        this.password=password;
    }
    public Recepcionista(){}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}



}
