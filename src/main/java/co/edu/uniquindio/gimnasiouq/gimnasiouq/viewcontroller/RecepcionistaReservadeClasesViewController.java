package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.RecepcionistaController;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Clase;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.TipoClase;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class RecepcionistaReservadeClasesViewController implements Initializable {
    private final RecepcionistaController controller = new RecepcionistaController();
    @FXML private Button btnRegistrarAsistencia;
    @FXML private ComboBox<TipoClase> cmbClase;
    @FXML private Label txtReservaClases;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbClase.getItems().addAll(TipoClase.YOGA, TipoClase.ZUMBA, TipoClase.SPINNING);
        cmbClase.setValue(TipoClase.YOGA);

    }

    @FXML
    void OnActionRegistrarAsistencia(ActionEvent event) {
        Usuario usuarioSeleccionado = obtenerUsuarioSeleccionado();
        if (usuarioSeleccionado == null) {
            mostrarMensaje("Selecciona usuario valido.");
            return;
        }
        TipoClase tipoClaseSeleccionado = cmbClase.getValue();
        Clase claseSeleccionada = RecepcionistaController.buscarClasePorTipo(tipoClaseSeleccionado.name());
        if (claseSeleccionada == null) {
            mostrarMensaje("Clase no encontrada.");
            return;
        }
        boolean exito = RecepcionistaController.registrarAsistenciaAClase(usuarioSeleccionado, claseSeleccionada);
        mostrarMensaje(exito ? "¡La asistencia ha sido registrada!" : "No se pudo registrar la asistencia.");
    }

    private void mostrarMensaje(String mensaje) {
        txtReservaClases.setText(mensaje);
        // O bien en un Alert de JavaFX:
        // new Alert(Alert.AlertType.INFORMATION, mensaje).showAndWait();
    }

    private Usuario obtenerUsuarioSeleccionado() {
        return null;
    }

    public Button getBtnRegistrarAsistencia() {
        return btnRegistrarAsistencia;
    }

    public void setBtnRegistrarAsistencia(Button btnRegistrarAsistencia) {
        this.btnRegistrarAsistencia = btnRegistrarAsistencia;
    }
}




