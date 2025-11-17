package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AdministradorGeneradordeRegistroAvanzadoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private ComboBox<String> cmbReportes;

    @FXML
    private Label txtGeneradorReportesAvanzados;

    @FXML
    private Label txtReporte;

    @FXML
    void OnActionActualizar(ActionEvent event) {

    }


    @FXML
    void initialize() {
        cmbReportes.getItems().addAll("Estadisticas de asistencia", "Ingresos por membresia", "Clases populares");

    }

}


