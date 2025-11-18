

package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public boolean agregarUsuario(String nombre, String apellido, String identificacion, int edad, String telefono, String correo, String tipoUsuario) {
        if (tipoUsuario.equals("Estudiante")) {
            Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, identificacion, edad, telefono, correo);
            return listaUsuarios.add(nuevoEstudiante);
        } else if (tipoUsuario.equals("Trabajador")) {
            Trabajador nuevoTrabajador = new Trabajador(nombre, apellido, identificacion, edad, telefono, correo);
            return listaUsuarios.add(nuevoTrabajador);
        } else if (tipoUsuario.equals("Externo")) {
            Externo nuevoExterno = new Externo(nombre, apellido, identificacion, edad, telefono, correo);
            return listaUsuarios.add(nuevoExterno);
        }else{
            return false;
        }
    }

    public Boolean eliminarUsuario(String identificacion) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdentificacion().equals(identificacion)) {
                listaUsuarios.remove(usuario);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarUsuario(Usuario usuarioSeleccionado, String nombre, String apellido, String identificacion, int edad, String telefono, String correo) {
        if (usuarioSeleccionado != null) {
            usuarioSeleccionado.setNombre(nombre);
            usuarioSeleccionado.setApellido(apellido);
            usuarioSeleccionado.setIdentificacion(identificacion);
            usuarioSeleccionado.setEdad(edad);
            usuarioSeleccionado.setTelefono(telefono);
            usuarioSeleccionado.setCorreo(correo);
            return true;
        }
        return false;
    }

    public boolean asignarClaseAEntrenador(Entrenador entrenadorSeleccionado, Clase claseSeleccionada) {
        if (claseSeleccionada.getEntrenador() != null) {
            return false; // ya tiene entrenador → no se puede reasignar
        }

        // Asignar el entrenador
        claseSeleccionada.setEntrenador(entrenadorSeleccionado);

        // Agregar la clase al entrenador (si tienes esa lista)
        entrenadorSeleccionado.getListaClases().add(claseSeleccionada);

        return true;
    }

    public ArrayList<Entrenador> obtenerEntrenadores() {
        ArrayList<Entrenador> entrenadores = new ArrayList<>();
        for (Empleado empleado : listaEmpleados) {
            if (empleado instanceof Entrenador) {
                entrenadores.add((Entrenador) empleado);
            }
        }
        return entrenadores;
    }

    public boolean registrarEntrenador(String id, String nombre, String telefono) {
        Entrenador nuevoEntrenador = new Entrenador(id, nombre, telefono);
        return listaEmpleados.add(nuevoEntrenador);
    }

    public boolean modificarEntrenador(Entrenador entrenadorSeleccionado, String id, String nombre, String telefono) {
        if (entrenadorSeleccionado != null) {
            entrenadorSeleccionado.setIdentificacion(id);
            entrenadorSeleccionado.setNombre(nombre);
            entrenadorSeleccionado.setTelefono(telefono);
            return true;
        }
        return false;
    }

    public boolean eliminarEntrenador(String identificacion) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado instanceof Entrenador && empleado.getIdentificacion().equals(identificacion)) {
                listaEmpleados.remove(empleado);
                return true;
            }
        }
        return false;
    }

    public ArrayList<ReservaClase> getReporteAsistencias() {
        return listaReservasClases;
    }

    // Reporte ingresos
    public ArrayList<Membresia> getReporteIngresosMembresias() {
        return listaMembresias;
    }

    // Reporte clases populares
    public ArrayList<Clase> getClasesMasPopulares() {
        return listaClases;
    }

    public boolean reservarClase(Usuario usuario, Clase clase) {
        if (usuario == null || clase == null) return false;
        ReservaClase reserva = new ReservaClase("R" + (listaReservasClases.size()+1), usuario.getNombre(), clase.getNombre());
        listaReservasClases.add(reserva);
        clase.incrementarReserva();
        return true;
    }
    public ArrayList<Usuario> getUsuariosActivos() {
        ArrayList<Usuario> activos = new ArrayList<>();
        for (Usuario u : listaUsuarios) {
            if (u.isActivo()) activos.add(u);
        }
        return activos;
    }

    public ArrayList<Clase> getClasesMasReservadas() {
        return listaClases;
    }

    // Membresías próximas a vencer (ejemplo: menos de 10 días)
    public ArrayList<Membresia> getMembresiasPorVencer(int diasALimite) {
        ArrayList<Membresia> porVencer = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for (Membresia m : listaMembresias) {
            if (m.getFechaFin() != null && !m.getFechaFin().isBefore(hoy)) {
                long dias = ChronoUnit.DAYS.between(hoy, m.getFechaFin());
                if (dias <= diasALimite) porVencer.add(m);
            }
        }
        return porVencer;
    }
    public boolean registrarReservaClase(Usuario usuario, Clase clase) {
        if (usuario == null || clase == null) return false;
        String numReserva = "R" + (listaReservasClases.size() + 1);
        ReservaClase reserva = new ReservaClase(numReserva, usuario.getNombre(), clase.getNombre());
        listaReservasClases.add(reserva);
        clase.incrementarReserva();
        return true;
    }


    public Clase buscarClasePorTipo(String tipoClase) {
        for (Clase c : listaClases) if (c.getTipoClase().equals(tipoClase)) return c;
        return null;
    }

    public boolean asignarMembresiaAUsuario(Usuario usuario, Membresia membresia) {

        if (usuario == null || membresia == null) return false;

        // Asignar relación bidireccional
        usuario.setMembresia(membresia);
        membresia.setUsuario(usuario);

        // Activar membresía
        membresia.setEstado(true);
        membresia.setFechaInicio(LocalDate.now());
        membresia.setFechaFin(LocalDate.now().plusMonths(membresia.getTipoMembresia().getMeses()));

        return true;
    }

    // dentro de GimnasioUQ (ya existente), agrega:

    // buscar usuario por id
    public Usuario buscarUsuarioPorId(String id) {
        if (id == null) return null;
        for (Usuario u : listaUsuarios) {
            if (id.equals(u.getIdentificacion())) return u;
        }
        return null;
    }

    // crear membresía para usuario y asignarla (devuelve la membresía creada)
    public Membresia crearMembresiaParaUsuario(Usuario usuario, String tipoStr, TipoMembresia duracion) {
        if (usuario == null || tipoStr == null || duracion == null) return null;

        // normalizar tipoStr
        String t = tipoStr.trim().toUpperCase();

        double costoBase;
        Membresia nueva;
        switch (t) {
            case "PREMIUM" -> { costoBase = 70000; nueva = new MembresiaPremium(duracion, costoBase, null, null, false); }
            case "VIP", "VIP " -> { costoBase = 120000; nueva = new MembresiaVip(duracion, costoBase, null, null, false); }
            default -> { costoBase = 40000; nueva = new MembresiaBasica(duracion, costoBase, null, null, false); }
        }

        // asignar tipo y activar según duracion
        nueva.setTipoMembresia(duracion);
        nueva.activarSegunTipo();           // set fechaInicio, fechaFin y estado = true
        nueva.setUsuario(usuario);

        // asignar a usuario y registrar en lista global
        usuario.setMembresia(nueva);
        listaMembresias.add(nueva);

        return nueva;
    }

    // obtener todas las membresías existentes
    public ArrayList<Membresia> obtenerTodasLasMembresias() {
        return listaMembresias;
    }

    // buscar la membresía por id de usuario (retorna la membresía asociada si existe)
    public Membresia buscarMembresiaPorIdUsuario(String idUsuario) {
        Usuario u = buscarUsuarioPorId(idUsuario);
        if (u == null) return null;
        return u.getMembresia();
    }

    // cambiar estado de la membresía asociada a un usuario
    public boolean cambiarEstadoMembresiaPorUsuarioId(String idUsuario) {
        Membresia m = buscarMembresiaPorIdUsuario(idUsuario);
        if (m == null) return false;
        m.setEstado(!m.getEstado());
        // si se desactiva, opcionalmente ajustar fechaFin
        if (!m.getEstado()) m.setFechaFin(LocalDate.now().minusDays(1));
        return true;
    }


}

