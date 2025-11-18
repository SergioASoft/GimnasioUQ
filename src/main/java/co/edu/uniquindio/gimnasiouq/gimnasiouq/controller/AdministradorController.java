package co.edu.uniquindio.gimnasiouq.gimnasiouq.controller;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.factory.ModelFactory;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Clase;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Entrenador;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Membresia;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.ReservaClase;

import java.util.ArrayList;

public class AdministradorController {
    ModelFactory modelFactory;
    public AdministradorController() {
        modelFactory = ModelFactory.getInstance();
    }

    public boolean asignarClaseAEntrenador(Entrenador entrenadorSeleccionado, Clase claseSeleccionada) {
        return modelFactory.asignarClaseAEntrenador(entrenadorSeleccionado, claseSeleccionada);
    }

    public ArrayList<Entrenador> obtenerEntrenadores() {
        return modelFactory.obtenerEntrenadores();
    }

    public ArrayList<Clase> obtenerClases() {
        return modelFactory.obtenerClases();
    }

    public boolean registrarEntrenador(String id, String nombre, String telefono) {
        return modelFactory.registrarEntrenador(id, nombre, telefono);
    }

    public boolean modificarEntrenador(Entrenador entrenadorSeleccionado, String id, String nombre, String telefono) {
        return modelFactory.modificarEntrenador(entrenadorSeleccionado, id, nombre, telefono);
    }

    public boolean eliminarEntrenador(String identificacion) {
        return modelFactory.eliminarEntrenador(identificacion);
    }

        public ArrayList<ReservaClase> getReporteAsistencias() {
            return ModelFactory.getInstance().getReporteAsistencias();
        }
        public ArrayList<Membresia> getReporteIngresosMembresias() {
            return ModelFactory.getInstance().getReporteIngresosMembresias();
        }
        public ArrayList<Clase> getClasesMasPopulares() {
            return ModelFactory.getInstance().getClasesMasPopulares();
        }
    }



