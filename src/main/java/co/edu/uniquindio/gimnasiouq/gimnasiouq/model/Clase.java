package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

import java.time.LocalDate;

public class Clase {
    private String nombre;
    private LocalDate horarioInicio;
    private LocalDate horarioFin;
    private int cupoMaximo;
    private TipoClase tipoClase;
    private Entrenador entrenador;
    private int contadorReservas = 0; // <-- El contador

    public Clase(String nombre, LocalDate horarioInicio, LocalDate horarioFin, int cupoMaximo, TipoClase tipoClase, Entrenador entrenador) {
        this.nombre = nombre;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.cupoMaximo = cupoMaximo;
        this.tipoClase = tipoClase;
        this.entrenador = entrenador;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalDate horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalDate getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(LocalDate horarioFin) {
        this.horarioFin = horarioFin;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public TipoClase getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
    }
    public void incrementarReserva() {
        contadorReservas++;
    }

    public int getContadorReservas() {
        return contadorReservas;
    }
}


