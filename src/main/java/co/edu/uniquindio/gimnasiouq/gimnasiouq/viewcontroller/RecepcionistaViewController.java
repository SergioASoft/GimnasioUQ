package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RecepcionistaViewController {

    @FXML
    private TabPane tabPanePrincipal;
    @FXML
    private Button btnCerrarSesion;
    //Aquí vamos a controlar las subvistas
    @FXML
    private RecepcionistaRegistroUsuariosViewController registroUsuariosController;
    @FXML
    private RecepcionistaAsignacionMembresiasViewController asignacionMembresiasController;
    @FXML
    private RecepcionistaReportesViewController reportesController;
    @FXML
    private RecepcionistaReservadeClasesViewController reservadeClasesController;


    @FXML
    public void initialize() {
        // Aquí podemos hacer las actualizaciones de las inicializaciones de la vista, por ejemplo:
        System.out.println("Vista de Recepcionista cargada correctamente");
    }

    @FXML
    public void OnActionCerrarSesion(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/gimnasiouq/gimnasiouq/AdministradorLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al cargar la vista de login: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

