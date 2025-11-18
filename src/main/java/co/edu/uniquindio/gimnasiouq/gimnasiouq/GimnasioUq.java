package co.edu.uniquindio.gimnasiouq.gimnasiouq;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class GimnasioUq extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GimnasioUq.class.getResource("AdministradorGeneradordeRegistroAvanzado.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("GimnasioUq");
        stage.setScene(scene);
        stage.show();
    }
}