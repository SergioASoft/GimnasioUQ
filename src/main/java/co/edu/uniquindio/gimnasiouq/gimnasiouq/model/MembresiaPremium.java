package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

import java.time.LocalDate;

public class MembresiaPremium extends Membresia{
    public MembresiaPremium(TipoMembresia tipoMembresia, double costo, LocalDate fechaInicio, LocalDate fechaFin, boolean estado) {
        super(tipoMembresia, costo, fechaInicio, fechaFin, estado);
    }

    @Override
    public String mostrarAcceso() {
        return "Acceso a las máquinas en general y a las clases grupales";
    }
}
