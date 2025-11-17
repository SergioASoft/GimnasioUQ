package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.TipoClase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class RecepcionistaReservadeClasesViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarAsistencia;

    @FXML
    private ComboBox<TipoClase> cmbClase;

    @FXML
    private Label txtReservaClases;

    @FXML
    private Label txtReservaClases1;

    @FXML
    private Label txtReservaClases11;

    @FXML
    void OnActionRegistrarAsistencia(ActionEvent event) {

    }

    @FXML
    void initialize() {
    cmbClase.getItems().addAll(TipoClase.YOGA, TipoClase.ZUMBA, TipoClase.SPINNING);
    cmbClase.setValue(TipoClase.YOGA);

    }

}

