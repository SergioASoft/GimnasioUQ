package co.edu.uniquindio.gimnasiouq.gimnasiouq;

import javafx.application.Application;
import javafx.scene.control.Alert;

public class Launcher {
    public static void main(String[] args) {
        Application.launch(GimnasioUq.class, args);
    }

    /**
     * Muestra una alerta con el mensaje especificado.
     *
     * @param title El título de la alerta.
     * @param message El contenido del mensaje.
     * @param type El tipo de alerta.
     */
    public static void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type); // Crear la alerta
        alert.setTitle(title); // Establecer el título de la alerta
        alert.setHeaderText(null); // No usar encabezado
        alert.setContentText(message); // Establecer el contenido del mensaje
        alert.showAndWait(); // Mostrar la alerta y esperar a que el usuario la cierre
    }
}
