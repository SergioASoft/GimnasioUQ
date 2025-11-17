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

public class AdministradorGestionEntrenadoresViewController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Modificar;

    @FXML
    private Button btnAsignarClase;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private ComboBox<TipoClase> cmbClases;

    @FXML
    private Label txtApellido;

    @FXML
    private Label txtClases;

    @FXML
    private Label txtCorreo;

    @FXML
    private Label txtEdad;

    @FXML
    private Label txtId;

    @FXML
    private Label txtNombre;

    @FXML
    private Label txtTelefono;

    @FXML
    void OnActionAsignarClase(ActionEvent event) {

    }

    @FXML
    void OnActionEliminar(ActionEvent event) {

    }

    @FXML
    void OnActionModificar(ActionEvent event) {

    }

    @FXML
    void OnActionRegistrar(ActionEvent event) {

    }

    @FXML
    void initialize() {
    cmbClases.getItems().addAll(TipoClase.YOGA,TipoClase.SPINNING,TipoClase.ZUMBA);

    }

}

