package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Usuario {
    private String nombre;
    private String apellido;
    private String identificacion;
    private int edad;
    private String telefono;
    private String correo;
    private Membresia membresia;
    private ArrayList<ReservaClase> reservasClases;
    private boolean activo;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    public Membresia getMembresia() {return membresia;}
    public void setMembresia(Membresia membresia) {this.membresia = membresia;}
    public ArrayList<ReservaClase> getReservasClases() {return reservasClases;}

    public Usuario(String nombre, String apellido, String identificacion, int edad, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }
    public boolean isActivo() {
        return tieneMembresiaVigente();
    }

    public boolean tieneMembresiaVigente() {
        if (membresia == null) return false;
        LocalDate hoy = LocalDate.now();
        return membresia.getFechaFin() != null && membresia.getFechaFin().isAfter(hoy);
    }
}
