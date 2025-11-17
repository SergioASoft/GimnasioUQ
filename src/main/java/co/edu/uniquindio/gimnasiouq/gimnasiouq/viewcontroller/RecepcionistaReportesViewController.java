package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class RecepcionistaReportesViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGenerar;

    @FXML
    private ComboBox<String> cmbTipoReporte;

    @FXML
    private Label txtTipoReporte;

    @FXML
    void initialize() {
        cmbTipoReporte.getItems().addAll("Usuarios activos","Clases más reservadas", "Vencimiento de Membresia");
        cmbTipoReporte.setValue("Seleccionar");

    }

}

