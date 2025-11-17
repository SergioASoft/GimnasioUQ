

package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class GimnasioUQ {

    private static GimnasioUQ instance;

    private String nombre;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Membresia> listaMembresias;
    private ArrayList<Clase> listaClases;
    private ArrayList<ReservaClase> listaReservasClases;
    private ArrayList<Empleado> listaEmpleados;


    public GimnasioUQ() {
        this.listaUsuarios = new ArrayList<>();
        this.listaMembresias = new ArrayList<>();
        this.listaClases = new ArrayList<>();
        this.listaReservasClases = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();
    }

    public static GimnasioUQ getInstance() {
        if (instance == null) {
            instance = new GimnasioUQ();
        }
        return instance;
    }


    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Membresia> getListaMembresias() {
        return listaMembresias;
    }

    public void setListaMembresias(ArrayList<Membresia> listaMembresias) {
        this.listaMembresias = listaMembresias;
    }

    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    public ArrayList<ReservaClase> getListaReservasClases() {
        return listaReservasClases;
    }

    public void setListaReservasClases(ArrayList<ReservaClase> listaReservasClases) {
        this.listaReservasClases = listaReservasClases;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }


    public boolean autenticar(String usuario, String contrasenia, String rol) {
        if ("Administrador".equals(rol)) {
            return "123".equals(usuario) && "1234".equals(contrasenia);
        } else if ("Recepcionista".equals(rol)) {
            return "232454".equals(usuario) && "johangracioso".equals(contrasenia);
        }
        return false;
    }

}


   // public Collection<Estudiante> getListaEstudiantes() {
   // }

   // public Collection<Trabajador> getListaTrabajadores() {
   // }

    //public Collection<Externo> getListaExternos() {
    //}}