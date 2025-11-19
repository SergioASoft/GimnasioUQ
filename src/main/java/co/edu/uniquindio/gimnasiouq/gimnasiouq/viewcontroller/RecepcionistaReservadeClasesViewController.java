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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RecepcionistaReservadeClasesViewController implements Initializable {
    private final RecepcionistaController controller = new RecepcionistaController();
    @FXML private Button btnReservarClase;
    @FXML private ComboBox<TipoClase> cmbClase;
    @FXML private Label txtReservaClases;
    @FXML private TextField txtIdUsuario;
    @FXML private TextArea txtAreaMensajes;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbClase.getItems().addAll(TipoClase.YOGA, TipoClase.ZUMBA, TipoClase.SPINNING);
        cmbClase.setValue(TipoClase.YOGA);
    }

    @FXML
    void OnActionReservarClase(ActionEvent event) {
        String idUsuario = txtIdUsuario.getText().trim();

        if (idUsuario.isEmpty()) {
            mostrarMensaje("Por favor ingresa una ID de usuario válida.");
            return;
        }

        Usuario usuarioSeleccionado = obtenerUsuarioSeleccionado(idUsuario);
        if (usuarioSeleccionado == null) {
            mostrarMensaje("Usuario no encontrado con ID: " + idUsuario);
            return;
        }

        TipoClase tipoClaseSeleccionado = cmbClase.getValue();
        if (tipoClaseSeleccionado == null) {
            mostrarMensaje("Por favor selecciona una clase.");
            return;
        }

        Clase claseSeleccionada = RecepcionistaController.buscarClasePorTipo(tipoClaseSeleccionado.name());
        if (claseSeleccionada == null) {
            mostrarMensaje("Clase no encontrada para tipo: " + tipoClaseSeleccionado.name());
            return;
        }

        boolean exito = RecepcionistaController.registrarAsistenciaAClase(usuarioSeleccionado, claseSeleccionada);

        if (exito) {
            mostrarMensaje("✓ ¡La reserva ha sido registrada exitosamente para " + usuarioSeleccionado.getNombre() + "!");
            mostrarAlerta("Éxito", "Reserva registrada", "La reserva ha registrado correctamente.");
            txtIdUsuario.clear();
        } else {
            mostrarMensaje("✗ No se pudo reservar clase.");
            mostrarAlerta("Error", "Error al reservar", "No se pudo reservar la clase.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        if (txtAreaMensajes != null) {
            String textoActual = txtAreaMensajes.getText();
            if (textoActual.isEmpty()) {
                txtAreaMensajes.setText(mensaje);
            } else {
                txtAreaMensajes.setText(textoActual + "\n" + mensaje);
            }
        }
    }

    private void mostrarAlerta(String titulo, String header, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private Usuario obtenerUsuarioSeleccionado(String id) {
        return controller.buscarUsuarioPorId(id);
    }

    public Button getBtnReservarClase() {
        return btnReservarClase;
    }

    public void setBtnReservarClase(Button btnReservarClase) {
        this.btnReservarClase = btnReservarClase;
    }
}



