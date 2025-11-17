package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

public abstract class Empleado {
    private String nombre;
    private int identificacion;
    private int telefono;

    public Empleado(String nombre, int identificacion, int telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }
    public Empleado() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
