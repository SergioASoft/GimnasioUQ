package co.edu.uniquindio.gimnasiouq.gimnasiouq.model;

public enum TipoMembresia {
    MENSUAL(1, "Mensual"),
    TRIMESTRAL(3, "Trimestral"),
    ANUAL(12, "Anual");

    private final int meses;
    private final String descripcion;

    TipoMembresia(int meses, String descripcion) {
        this.meses = meses;
        this.descripcion = descripcion;
    }

    public int getMeses() {
        return meses;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
