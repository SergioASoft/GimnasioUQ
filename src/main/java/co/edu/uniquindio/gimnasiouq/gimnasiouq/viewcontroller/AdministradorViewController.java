package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class AdministradorViewController {


    @FXML
    private TabPane tabPanePrincipal;
    //Aquí vamos a controlar las subvistas
    @FXML
    private AdministradorGestionEntrenadoresViewController gestionEntrenadoresController;
    @FXML
    private AdministradorGeneradordeRegistroAvanzadoViewController generadorRegistroAvanzadoController ;


    @FXML
    public void initialize() {
        // Aquí podemos hacer las actualizaciones de las inicializaciones de la vista, por ejemplo:
        System.out.println("Vista de Recepcionista cargada correctamente");
    }


}