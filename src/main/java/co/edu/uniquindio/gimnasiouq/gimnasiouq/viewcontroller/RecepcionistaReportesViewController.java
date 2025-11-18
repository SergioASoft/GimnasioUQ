package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.RecepcionistaController;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Clase;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Membresia;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
public class RecepcionistaReportesViewController {
    private final RecepcionistaController controller = new RecepcionistaController();

    @FXML private ComboBox<String> cmbTipoReporte;
    @FXML private TextArea txtResultadoReporte;
    @FXML private Button btnGenerar;

    @FXML
    public void initialize() {
        cmbTipoReporte.getItems().addAll(
                "Usuarios activos",
                "Clases más reservadas",
                "Membresías próximas a vencer"
        );
        cmbTipoReporte.getSelectionModel().selectFirst();
    }

    @FXML
    public void OnActionGenerar(ActionEvent event) {
        String seleccion = cmbTipoReporte.getValue();
        StringBuilder resultado = new StringBuilder();

        if ("Usuarios activos".equals(seleccion)) {
            for (Usuario u : controller.getUsuariosActivos()) {
                resultado.append("Usuario: ").append(u.getNombre())
                        .append(" - Activo: ").append(u.isActivo() ? "Sí" : "No")
                        .append("\n");
            }
        } else if ("Clases más reservadas".equals(seleccion)) {
            for (Clase c : controller.getClasesMasReservadas()) {
                resultado.append("Clase: ").append(c.getNombre())
                        .append(" | Tipo: ").append(c.getTipoClase())
                        .append(" | Reservas: ").append(c.getContadorReservas())
                        .append("\n");
            }
        } else if ("Membresías próximas a vencer".equals(seleccion)) {
            for (Membresia m : controller.getMembresiasPorVencer(10)) {
                resultado.append("Usuario: ").append(m.getUsuarioName())
                        .append(" | Vence: ").append(m.getFechaFin())
                        .append("\n");
            }
        }

        txtResultadoReporte.setText(resultado.toString());
    }
}



