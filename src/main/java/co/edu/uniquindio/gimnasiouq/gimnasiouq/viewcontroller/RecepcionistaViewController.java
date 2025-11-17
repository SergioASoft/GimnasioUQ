package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class RecepcionistaViewController {

    @FXML
    private TabPane tabPanePrincipal;
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


}

