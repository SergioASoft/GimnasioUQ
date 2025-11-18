package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.AdministradorController;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdministradorGeneradordeRegistroAvanzadoViewController {

    private final AdministradorController controller = new AdministradorController();


    @FXML private ComboBox<String> cmbReportes;
    @FXML private TableView tablaReportes;

    @FXML private TableColumn<ReservaClase, String> colNumReserva;
    @FXML private TableColumn<ReservaClase, String> colUsuario;
    @FXML private TableColumn<ReservaClase, String> colClase;
    @FXML private TableColumn<Membresia, String> colFecha;
    @FXML private TableColumn<Membresia, Double> colValor;
    @FXML private TableColumn<Clase, String> colNombreClase;
    @FXML private TableColumn<Clase, String> colTipoClase;
    @FXML private TableColumn<Clase, Integer> colReservas;

    @FXML
    public void initialize() {
        cmbReportes.getItems().addAll(
                "Estadística de Asistencia",
                "Ingresos por Membresías",
                "Clases más populares"
        );
        cmbReportes.getSelectionModel().selectFirst();
        cmbReportes.setOnAction(event -> actualizarTablaReporte());
        configurarColumnas();
        actualizarTablaReporte();
    }

    private void configurarColumnas() {
        if (colNumReserva != null)
            colNumReserva.setCellValueFactory(new PropertyValueFactory<>("numReserva"));
        if (colUsuario != null)
            colUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        if (colClase != null)
            colClase.setCellValueFactory(new PropertyValueFactory<>("clase"));
        if (colFecha != null)
            colFecha.setCellValueFactory(cellData ->
                    new SimpleStringProperty(cellData.getValue().getFechaInicio().toString())
            );
        if (colValor != null)
            colValor.setCellValueFactory(new PropertyValueFactory<>("costo"));
        if (colNombreClase != null)
            colNombreClase.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        if (colTipoClase != null)
            colTipoClase.setCellValueFactory(new PropertyValueFactory<>("tipoClase"));
        if (colReservas != null)
            colReservas.setCellValueFactory(new PropertyValueFactory<>("contadorReservas"));
    }

    private void mostrarColumnas(boolean asistencia, boolean membresias, boolean populares) {
        if (colNumReserva != null) colNumReserva.setVisible(asistencia);
        if (colUsuario != null) colUsuario.setVisible(asistencia);
        if (colClase != null) colClase.setVisible(asistencia);
        if (colFecha != null) colFecha.setVisible(membresias);
        if (colValor != null) colValor.setVisible(membresias);
        if (colNombreClase != null) colNombreClase.setVisible(populares);
        if (colTipoClase != null) colTipoClase.setVisible(populares);
        if (colReservas != null) colReservas.setVisible(populares);
    }

    private void actualizarTablaReporte() {
        String seleccion = cmbReportes.getValue();

        if ("Estadística de Asistencia".equals(seleccion)) {
            mostrarColumnas(true, false, false);
            tablaReportes.setItems(FXCollections.observableArrayList(controller.getReporteAsistencias()));

        } else if ("Ingresos por Membresías".equals(seleccion)) {
            mostrarColumnas(false, true, false);
            tablaReportes.setItems(FXCollections.observableArrayList(controller.getReporteIngresosMembresias()));

        } else if ("Clases más populares".equals(seleccion)) {
            mostrarColumnas(false, false, true);
            tablaReportes.setItems(FXCollections.observableArrayList(controller.getClasesMasPopulares()));
        }
    }

    @FXML
    public void OnActionActualizar(ActionEvent actionEvent) {
        actualizarTablaReporte();
    }
}



