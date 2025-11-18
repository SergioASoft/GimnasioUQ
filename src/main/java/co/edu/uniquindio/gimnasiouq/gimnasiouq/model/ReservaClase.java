package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

public class ReservaClase {
    private String numReserva;
    private String usuario;
    private String clase;

    // Constructor
    public ReservaClase(String numReserva, String usuario, String clase) {
        this.numReserva = numReserva;
        this.usuario = usuario;
        this.clase = clase;
    }

    // Getters y setters
    public String getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(String numReserva) {
        this.numReserva = numReserva;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

}