package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.RecepcionistaController;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Clase;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Membresia;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class RecepcionistaReportesViewController {
    private final RecepcionistaController controller = new RecepcionistaController();

    @FXML private ComboBox<String> cmbTipoReporte;
    @FXML private TableView<ReporteItem> tablaReportes;
    @FXML private TableColumn<ReporteItem, String> colDetalle;
    @FXML private Button btnGenerar;

    @FXML
    public void initialize() {
        cmbTipoReporte.getItems().addAll(
                "Usuarios activos",
                "Clases más reservadas",
                "Membresías próximas a vencer"
        );
        cmbTipoReporte.getSelectionModel().selectFirst();
        
        if (colDetalle != null) {
            colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));
        }
    }

    @FXML
    public void OnActionGenerar(ActionEvent event) {
        String seleccion = cmbTipoReporte.getValue();
        ObservableList<ReporteItem> items = FXCollections.observableArrayList();

        if ("Usuarios activos".equals(seleccion)) {
            for (Usuario u : controller.getUsuariosActivos()) {
                items.add(new ReporteItem("Usuario: " + u.getNombre() + " | Activo: " + (u.isActivo() ? "Sí" : "No")));
            }
        } else if ("Clases más reservadas".equals(seleccion)) {
            for (Clase c : controller.getClasesMasReservadas()) {
                items.add(new ReporteItem("Clase: " + c.getNombre() + " | Tipo: " + c.getTipoClase() + " | Reservas: " + c.getContadorReservas()));
            }
        } else if ("Membresías próximas a vencer".equals(seleccion)) {
            for (Membresia m : controller.getMembresiasPorVencer(10)) {
                items.add(new ReporteItem("Usuario: " + m.getUsuarioName() + " | Vence: " + m.getFechaFin()));
            }
        }

        tablaReportes.setItems(items);
    }
    
    // Clase interna para los items de la tabla
    public static class ReporteItem {
        private final String detalle;
        
        public ReporteItem(String detalle) {
            this.detalle = detalle;
        }
        
        public String getDetalle() {
            return detalle;
        }
    }
}




