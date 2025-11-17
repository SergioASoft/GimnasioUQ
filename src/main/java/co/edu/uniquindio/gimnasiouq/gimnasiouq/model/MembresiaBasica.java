package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

public class MembresiaBasica extends Membresia{
    public MembresiaBasica(TipoMembresia tipoMembresia, double costo, java.time.LocalDate fechaInicio, java.time.LocalDate fechaFin, boolean estado) {
        super(tipoMembresia, costo, fechaInicio, fechaFin, estado);
    }
    @Override
    public String mostrarAcceso() {
        return "Acceso general a las máquinas";
    }
}
