package co.edu.uniquindio.gimnasiouq.gimnasiouq.factory;


import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.*;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.util.DataUtil;

import java.util.ArrayList;

public class ModelFactory {
    private static ModelFactory instance;
    private GimnasioUQ gimnasioUQ;


    private ModelFactory() {
        gimnasioUQ = DataUtil.inicializarDatos();
        System.out.println("ModelFactory inicializada, gimnasioUQ: " + gimnasioUQ);
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }
    public GimnasioUQ getGimnasioUQ() {
        return gimnasioUQ;
    }

    public boolean autenticar(String usuario, String contrasenia, String rol) {
        // Antes de usar, verifica que gimnasioUQ no sea null (aunque no debería)
        if (gimnasioUQ == null) {
            throw new IllegalStateException("gimnasioUQ NO iniciado");
        }
        return gimnasioUQ.autenticar(usuario, contrasenia, rol);
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        return gimnasioUQ.getListaUsuarios();
    }

    public boolean agregarUsuario(String nombre, String apellido, String identificacion, int edad, String telefono, String correo, String tipoUsuario) {
        return gimnasioUQ.agregarUsuario(nombre, apellido, identificacion, edad, telefono, correo, tipoUsuario);
    }

    public Boolean eliminarUsuario(String identificacion) {
        return gimnasioUQ.eliminarUsuario(identificacion);
    }

    public boolean actualizarUsuario(Usuario usuarioSeleccionado, String nombre, String apellido, String identificacion, int edad, String telefono, String correo) {
        return gimnasioUQ.actualizarUsuario(usuarioSeleccionado, nombre, apellido, identificacion, edad, telefono, correo);
    }

    public boolean asignarClaseAEntrenador(Entrenador entrenadorSeleccionado, Clase claseSeleccionada) {
        return gimnasioUQ.asignarClaseAEntrenador(entrenadorSeleccionado, claseSeleccionada);
    }

    public ArrayList<Entrenador> obtenerEntrenadores() {
        return gimnasioUQ.obtenerEntrenadores();
    }

    public ArrayList<Clase> obtenerClases() {
        return gimnasioUQ.getListaClases();
    }

    public boolean registrarEntrenador(String id, String nombre, String telefono) {
        return gimnasioUQ.registrarEntrenador(id, nombre, telefono);
    }

    public boolean modificarEntrenador(Entrenador entrenadorSeleccionado, String id, String nombre, String telefono) {
        return gimnasioUQ.modificarEntrenador(entrenadorSeleccionado, id, nombre, telefono);
    }

    public boolean eliminarEntrenador(String identificacion) {
        return gimnasioUQ.eliminarEntrenador(identificacion);
    }
    public ArrayList<ReservaClase> getReporteAsistencias() {
        return gimnasioUQ.getReporteAsistencias();
    }
    public ArrayList<Membresia> getReporteIngresosMembresias() {
        return gimnasioUQ.getReporteIngresosMembresias();
    }
    public ArrayList<Clase> getClasesMasPopulares() {
        return gimnasioUQ.getClasesMasPopulares();
    }
    public ArrayList<Usuario> getUsuariosActivos() {
        return gimnasioUQ.getUsuariosActivos();
    }
    public ArrayList<Clase> getClasesMasReservadas() {
        return gimnasioUQ.getClasesMasReservadas();
    }
    public ArrayList<Membresia> getMembresiasPorVencer(int diasALimite) {
        return gimnasioUQ.getMembresiasPorVencer(diasALimite);
    }

    public boolean registrarReservaClase(Usuario usuario, Clase clase) {
        return gimnasioUQ.registrarReservaClase(usuario, clase);
    }

    public Clase buscarClasePorTipo(String tipoClase) {
        return gimnasioUQ.buscarClasePorTipo(tipoClase);
    }

    // devolver todas las membresías
    public ArrayList<Membresia> obtenerTodasLasMembresias() {
        return gimnasioUQ.obtenerTodasLasMembresias();
    }

    // crear y asignar membresía a usuario por id
    public Membresia crearMembresiaParaUsuario(String idUsuario, String tipoStr, TipoMembresia duracion) {
        Usuario u = gimnasioUQ.buscarUsuarioPorId(idUsuario);
        if (u == null) return null;
        return gimnasioUQ.crearMembresiaParaUsuario(u, tipoStr, duracion);
    }

    // buscar membresía por id de usuario
    public Membresia buscarMembresiaPorIdUsuario(String idUsuario) {
        return gimnasioUQ.buscarMembresiaPorIdUsuario(idUsuario);
    }

    // cambiar estado de membresía por idUsuario
    public boolean cambiarEstadoMembresiaPorUsuarioId(String idUsuario) {
        return gimnasioUQ.cambiarEstadoMembresiaPorUsuarioId(idUsuario);
    }

}

