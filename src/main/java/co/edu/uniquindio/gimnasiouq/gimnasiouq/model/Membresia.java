package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

import java.time.LocalDate;

public abstract class Membresia implements IMembresia {

    private TipoMembresia tipoMembresia;
    private double costo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean estado;
    private Usuario usuario;

    public Membresia() {}

    public Membresia(TipoMembresia tipoMembresia, double costo, LocalDate fechaInicio, LocalDate fechaFin, boolean estado) {
        this.tipoMembresia = tipoMembresia;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(TipoMembresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsuarioName() {
        return usuario != null ? usuario.getNombre() : "Desconocido";
    }

    /**
     * Activa la membresía calculando fechaInicio = hoy
     * y fechaFin = hoy + meses del tipo seleccionado
     */
    public void activarSegunTipo() {
        if (tipoMembresia == null)
            throw new IllegalStateException("El tipo de membresía no está definido");

        LocalDate inicio = LocalDate.now();
        setFechaInicio(inicio);
        setFechaFin(inicio.plusMonths(tipoMembresia.getMeses()));
        setEstado(true);
    }
}