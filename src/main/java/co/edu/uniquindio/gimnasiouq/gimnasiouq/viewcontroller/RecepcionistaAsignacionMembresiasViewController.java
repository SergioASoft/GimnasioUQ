package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.RecepcionistaController;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Membresia;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.TipoMembresia;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class RecepcionistaAsignacionMembresiasViewController {

    private RecepcionistaController recepcionistaController;
    private ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    private Usuario usuarioSeleccionado;

    @FXML private TextField txtId;
    @FXML private ComboBox<String> cmbTipoMembresia;
    @FXML private ComboBox<TipoMembresia> cmbDuracion;

    @FXML private TableView<Usuario> tableMembresia;
    @FXML private TableColumn<Usuario, String> tcId;
    @FXML private TableColumn<Usuario, String> tcNombre;
    @FXML private TableColumn<Usuario, String> tcMembresia;
    @FXML private TableColumn<Usuario, String> tcDuracion;
    @FXML private TableColumn<Usuario, String> tcFechaInicio;
    @FXML private TableColumn<Usuario, String> tcFechaFinal;
    @FXML private TableColumn<Usuario, String> tcEstado;

    @FXML private Button btnBuscar;
    @FXML private Button btnAsignarMembresia;
    @FXML private Button btnCambiarEstado;

    @FXML
    void initialize() {
        recepcionistaController = new RecepcionistaController();

        // combos
        cmbTipoMembresia.getItems().addAll("Basica", "Premium", "Vip");
        cmbDuracion.setItems(FXCollections.observableArrayList(TipoMembresia.values()));
        cmbDuracion.setValue(TipoMembresia.MENSUAL);

        initDataBinding();
        cargarUsuarios();
        listenerSelection();
    }

    private void initDataBinding() {
        tcId.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getIdentificacion()));
        tcNombre.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNombre() + " " + c.getValue().getApellido()));

        tcMembresia.setCellValueFactory(c -> new SimpleStringProperty(
                c.getValue().getMembresia() != null ? c.getValue().getMembresia().getClass().getSimpleName() : "Sin membresía"
        ));

        tcDuracion.setCellValueFactory(c -> new SimpleStringProperty(
                c.getValue().getMembresia() != null ? c.getValue().getMembresia().getTipoMembresia().getDescripcion() : "-"
        ));

        tcFechaInicio.setCellValueFactory(c -> new SimpleStringProperty(
                c.getValue().getMembresia() != null && c.getValue().getMembresia().getFechaInicio() != null ?
                        c.getValue().getMembresia().getFechaInicio().toString() : "-"
        ));

        tcFechaFinal.setCellValueFactory(c -> new SimpleStringProperty(
                c.getValue().getMembresia() != null && c.getValue().getMembresia().getFechaFin() != null ?
                        c.getValue().getMembresia().getFechaFin().toString() : "-"
        ));

        tcEstado.setCellValueFactory(c -> new SimpleStringProperty(
                c.getValue().getMembresia() != null ? (c.getValue().getMembresia().getEstado() ? "Activa" : "Inactiva") : "-"
        ));
    }

    private void cargarUsuarios() {
        listaUsuarios.setAll(recepcionistaController.obtenerUsuarios());
        tableMembresia.setItems(listaUsuarios);
    }

    private void listenerSelection() {
        tableMembresia.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            usuarioSeleccionado = newV;
        });
    }

    @FXML
    void OnActionBuscar(ActionEvent event) {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            mostrarAlerta("Debe ingresar identificación a buscar");
            return;
        }

        usuarioSeleccionado = recepcionistaController.obtenerUsuarios().stream()
                .filter(u -> id.equals(u.getIdentificacion()))
                .findFirst()
                .orElse(null);

        if (usuarioSeleccionado == null) {
            mostrarAlerta("No existe usuario con ese ID");
            return;
        }
        tableMembresia.getSelectionModel().select(usuarioSeleccionado);
    }

    @FXML
    void OnActionAsignarMembresia(ActionEvent event) {
        if (usuarioSeleccionado == null) {
            mostrarAlerta("Seleccione un usuario");
            return;
        }

        String tipo = cmbTipoMembresia.getValue();
        TipoMembresia duracion = cmbDuracion.getValue();

        if (tipo == null || duracion == null) {
            mostrarAlerta("Seleccione tipo y duración");
            return;
        }

        Membresia creada = recepcionistaController.crearMembresiaParaUsuario(usuarioSeleccionado.getIdentificacion(), tipo, duracion);
        if (creada == null) {
            mostrarAlerta("No se pudo asignar la membresía");
            return;
        }

        cargarUsuarios();
        mostrarAlerta("Membresía asignada correctamente");
    }

    @FXML
    void OnActionCambiarEstado(ActionEvent event) {
        if (usuarioSeleccionado == null) {
            mostrarAlerta("Seleccione un usuario");
            return;
        }
        boolean ok = recepcionistaController.cambiarEstadoMembresiaPorUsuarioId(usuarioSeleccionado.getIdentificacion());
        if (!ok) mostrarAlerta("No se pudo cambiar estado (membresía inexistente)");
        else {
            cargarUsuarios();
            mostrarAlerta("Estado cambiado");
        }
    }

    private void mostrarAlerta(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
