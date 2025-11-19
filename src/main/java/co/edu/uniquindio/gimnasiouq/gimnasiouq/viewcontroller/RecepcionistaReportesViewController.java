package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.RecepcionistaController;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Clase;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Membresia;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Usuario;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class RecepcionistaReportesViewController implements Initializable {
    private final RecepcionistaController controller = new RecepcionistaController();

    @FXML
    private TableView<String> tablaReportes;
    @FXML
    private ComboBox<String> cmbTipoReporte;

    @FXML
    private TableColumn<String, String> colDetalle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cmbTipoReporte.getItems().addAll(
                "Usuarios activos",
                "Clases más reservadas",
                "Membresías próximas a vencer"
        );
        cmbTipoReporte.getSelectionModel().selectFirst();

        colDetalle.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
    }

    @FXML
    public void OnActionGenerar(ActionEvent event) {

        String seleccion = cmbTipoReporte.getValue();
        ObservableList<String> items = FXCollections.observableArrayList();

        if ("Usuarios activos".equals(seleccion)) {
            for (Usuario u : controller.getUsuariosActivos()) {
                String detalle = " " + u.getNombre() + " | ID: " + u.getIdentificacion() + " | Estado: Activo";
                items.add(detalle);
            }
        }

        else if ("Clases más reservadas".equals(seleccion)) {
            for (Clase c : controller.getClasesMasReservadas()) {
                String detalle = " " + c.getNombre() + " | Tipo: " + c.getTipoClase() + " | Reservas: " + c.getContadorReservas();
                items.add(detalle);
            }
        }

        else if ("Membresías próximas a vencer".equals(seleccion)) {
            for (Membresia m : controller.getMembresiasPorVencer(10)) {
                String usuarioNombre = m.getUsuario() != null ? m.getUsuario().getNombre() : "Desconocido";
                String tipo = m.getTipoMembresia() != null ? m.getTipoMembresia().toString() : "N/A";
                String fecha = m.getFechaFin() != null ? m.getFechaFin().toString() : "N/A";

                String detalle = " " + usuarioNombre + " | Tipo: " + tipo + " | Vence: " + fecha;
                items.add(detalle);
            }
        }

        tablaReportes.setItems(items);

        if (items.isEmpty()) {
            items.add("✓ No hay datos para mostrar en este reporte.");
        }
    }

}




