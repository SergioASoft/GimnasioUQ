package co.edu.uniquindio.gimnasiouq.gimnasiouq.controller;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.factory.*;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.*;

import java.util.ArrayList;

public class RecepcionistaController {
    ModelFactory modelFactory;
    public RecepcionistaController() {
        modelFactory = ModelFactory.getInstance();
    }



    public ArrayList<Usuario> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }

    public boolean agregarUsuario(String nombre, String apellido, String identificacion, int edad, String telefono, String correo, String tipoUsuario) {
        return modelFactory.agregarUsuario(nombre, apellido, identificacion, edad, telefono, correo, tipoUsuario);
    }

    public Boolean eliminarUsuario(String identificacion) {
        return modelFactory.eliminarUsuario(identificacion);
    }

    public boolean actualizarUsuario(Usuario usuarioSeleccionado, String nombre, String apellido, String identificacion, int edad, String telefono, String correo) {
        return modelFactory.actualizarUsuario(usuarioSeleccionado, nombre, apellido, identificacion, edad, telefono, correo);
    }
    public ArrayList<Usuario> getUsuariosActivos() {
        return ModelFactory.getInstance().getUsuariosActivos();
    }
    public ArrayList<Clase> getClasesMasReservadas() {
        return ModelFactory.getInstance().getClasesMasReservadas();
    }
    public ArrayList<Membresia> getMembresiasPorVencer(int diasALimite) {
        return ModelFactory.getInstance().getMembresiasPorVencer(diasALimite);
    }
    public static boolean registrarAsistenciaAClase(Usuario usuario, Clase clase) {
        return ModelFactory.getInstance().registrarReservaClase(usuario, clase);
    }
    public static Clase buscarClasePorTipo(String tipoClase) {
        return ModelFactory.getInstance().buscarClasePorTipo(tipoClase);
    }

    // en RecepcionistaController (tu clase existente)
    public ArrayList<Membresia> obtenerTodasLasMembresias() {
        return modelFactory.obtenerTodasLasMembresias();
    }

    public Membresia crearMembresiaParaUsuario(String idUsuario, String tipoStr, TipoMembresia duracion) {
        return modelFactory.crearMembresiaParaUsuario(idUsuario, tipoStr, duracion);
    }

    public Membresia buscarMembresiaPorIdUsuario(String idUsuario) {
        return modelFactory.buscarMembresiaPorIdUsuario(idUsuario);
    }

    public boolean cambiarEstadoMembresiaPorUsuarioId(String idUsuario) {
        return modelFactory.cambiarEstadoMembresiaPorUsuarioId(idUsuario);
    }



}
