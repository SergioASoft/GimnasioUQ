package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.TipoMembresia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.*;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.RecepcionistaController;
public class RecepcionistaAsignacionMembresiasViewController {
    RecepcionistaController recepcionistaController;
    @FXML
    private Label Lupa;

    @FXML
    private Button btnAsignarMembresia;

    @FXML
    private Button btnBuscar;

    @FXML
    private ComboBox<?> cmbDuracion;

    @FXML
    private ComboBox<?> cmbTipoMembresia;

    @FXML
    private TableView<?> tableMembresia;

    @FXML
    private TableColumn<?, ?> tcDuracion;

    @FXML
    private TableColumn<?, ?> tcEstado;

    @FXML
    private TableColumn<?, ?> tcFechaFinal;

    @FXML
    private TableColumn<?, ?> tcFechaInicio;

    @FXML
    private TableColumn<?, ?> tcId;

    @FXML
    private TableColumn<?, ?> tcMembresia;

    @FXML
    private TableColumn<?, ?> tcNombre;

    @FXML
    private Label txtAsignacionMembresia;

    @FXML
    private Label txtDuracion;

    @FXML
    private TextField txtId;

    @FXML
    private Label txtIdM;

    @FXML
    private Label txtTipoMembresia;

    @FXML
    void OnActionAsignarMembresia(ActionEvent event) {

    }

    @FXML
    void OnActionBuscar(ActionEvent event) {
       // buscarUsuario();
    }

   // private void buscarUsuario() {
    //    String identificacion = txtId.getText();
      //  Usuario usuario = recepcionistaController.buscarUsuarioPorIdentificacion(identificacion);
       // if (usuario != null) {
       //     lblUsuarioEncontrado.setText(usuario.getNombre());
     //   } else {
       //     lblUsuarioEncontrado.setText("Usuario no encontrado");
      //  }
    //}

    @FXML
    void initialize() {
     //   cmbTipoMembresia.getItems().addAll("Basica", "Premium", "VIP");
      //  cmbTipoMembresia.setValue("Seleccionar");
       // cmbDuracion.getItems().addAll(TipoMembresia.MENSUAL, TipoMembresia.TRIMESTRAL, TipoMembresia.ANUAL);
       // cmbDuracion.setValue(TipoMembresia.MENSUAL);
       //RecepcionistaController recepcionistaController = new RecepcionistaController();

    }

   // String identificacionUsuario = txtId.getText();


}
