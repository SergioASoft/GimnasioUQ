package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

import java.util.ArrayList;

public class Entrenador extends Empleado{
    private ArrayList<Clase> listaClases;
    public Entrenador(String nombre, String identificacion, String telefono) {
        super(nombre, identificacion, telefono);
        this.listaClases = new ArrayList<Clase>();
    }

    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }

}
