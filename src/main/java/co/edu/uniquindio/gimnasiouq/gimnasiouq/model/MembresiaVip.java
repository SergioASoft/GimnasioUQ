package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

import java.time.LocalDate;

public class MembresiaVip extends Membresia{
    public MembresiaVip(TipoMembresia tipoMembresia, double costo, LocalDate fechaInicio, LocalDate fechaFin, boolean estado) {
        super(tipoMembresia, costo, fechaInicio, fechaFin, estado);
    }

    @Override
    public String mostrarAcceso() {
        return "Acceso a todas las clases, acceso a la zona de Spa y acceso a un entrenador personal";
    }
}
