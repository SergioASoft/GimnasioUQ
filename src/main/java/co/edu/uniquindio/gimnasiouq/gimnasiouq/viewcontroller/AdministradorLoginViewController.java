

package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.AdministradorController;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.AdministradorLoginController;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.factory.ModelFactory;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.GimnasioUQ;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdministradorLoginViewController {
    private AdministradorLoginController adminController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    private Label lblMensaje;

    @FXML
    private ComboBox<String> cmbRol;

    @FXML
    private Label lblBienvenida;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtUsuario;




    @FXML
    void initialize() {
        cmbRol.getItems().addAll("Administrador", "Recepcionista");
        cmbRol.setValue("Seleccionar");
        adminController = new AdministradorLoginController();

    }


    @FXML
    void OnActionOnLogin(ActionEvent event) throws IOException {

        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        String rol = cmbRol.getValue();

        boolean acceso = AdministradorLoginController.autenticar(usuario, contrasenia, rol);

        if(acceso){
            lblMensaje.setText("Acceso permitido");
            cambiarVentanaSegunRol(rol);
        }else{
            lblMensaje.setText("usuario o contraseña incorrecta");
        }
    }

    private void cambiarVentanaSegunRol(String rol) throws IOException {
        Stage stage = (Stage) txtUsuario.getScene().getWindow();
        Parent root = null;
        String ruta = null;

        if ("Administrador".equals(rol)) {
            ruta = "/co/edu/uniquindio/gimnasiouq/gimnasiouq/Administrador.fxml";
        } else if ("Recepcionista".equals(rol)) {
            ruta = "/co/edu/uniquindio/gimnasiouq/gimnasiouq/Recepcionista.fxml";
        } else {
            mostrarMensaje("Rol incorrecto", null, "Rol no reconocido", Alert.AlertType.WARNING);
            return;
        }

        System.out.println("Buscando FXML en: " + ruta + " => " + getClass().getResource(ruta));
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(ruta)));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();

    }

}









