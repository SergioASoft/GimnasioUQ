package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.AdministradorController;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Clase;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Entrenador;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.TipoClase;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdministradorGestionEntrenadoresViewController {

    AdministradorController administradorController;

    // Listas observables para cargar tablas
    ObservableList<Entrenador> listaEntrenadores = FXCollections.observableArrayList();
    ObservableList<Clase> listaClases = FXCollections.observableArrayList();

    // Variables para almacenar selección
    Entrenador entrenadorSeleccionado;
    Clase claseSeleccionada;

    @FXML private Button btnAsignarClase;
    @FXML private Button btnEliminar;
    @FXML private Button btnModificar;
    @FXML private Button btnRegistrar;

    @FXML private TableView<Clase> tableClases;
    @FXML private TableView<Entrenador> tableEntrenadores;

    @FXML private TableColumn<Entrenador, String> tcId;
    @FXML private TableColumn<Entrenador, String> tcNombreEntrenador;
    @FXML private TableColumn<Entrenador, String> tcTelefono;

    @FXML private TableColumn<Clase, String> tcNombreClase;
    @FXML private TableColumn<Clase, TipoClase> tcTipo;

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;

    @FXML
    private Label lblClaseAsignada;

    @FXML
    void initialize() {
        administradorController = new AdministradorController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerEntrenadores();
        obtenerClases();

        tableEntrenadores.setItems(listaEntrenadores);
        tableClases.setItems(listaClases);

        listenerSelectionEntrenadores();
        listenerSelectionClases();
    }

    private void initDataBinding() {
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcNombreEntrenador.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));

        tcNombreClase.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcTipo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipoClase()));
    }

    private void obtenerEntrenadores() {
        listaEntrenadores.clear();
        listaEntrenadores.addAll(administradorController.obtenerEntrenadores());
    }

    private void obtenerClases() {
        listaClases.clear();
        listaClases.addAll(administradorController.obtenerClases());
    }

    private void listenerSelectionEntrenadores() {
        tableEntrenadores.getSelectionModel().selectedItemProperty().addListener((obs, old, selected) -> {
            entrenadorSeleccionado = selected;
            mostrarInfoEntrenador(entrenadorSeleccionado);
        });
    }

    private void listenerSelectionClases() {
        tableClases.getSelectionModel().selectedItemProperty().addListener((obs, old, selected) -> {
            claseSeleccionada = selected;
            mostrarClaseAsignada(claseSeleccionada);
        });
    }

    private void mostrarClaseAsignada(Clase clase) {
        if (clase == null) {
            lblClaseAsignada.setText("Seleccione una clase");
            return;
        }

        String nombreClase = clase.getNombre();

        // Puede no tener entrenador asignado
        String nombreEntrenador;

        if (clase.getEntrenador() != null) {
            nombreEntrenador = clase.getEntrenador().getNombre();
        } else {
            nombreEntrenador = "Ninguno";
        }

        lblClaseAsignada.setText(nombreClase + " - " + nombreEntrenador);
    }



    private void mostrarInfoEntrenador(Entrenador e) {
        if (e != null) {
            txtId.setText(e.getIdentificacion());
            txtNombre.setText(e.getNombre());
            txtTelefono.setText(e.getTelefono());
        } else {
            txtId.setText("");
            txtNombre.setText("");
            txtTelefono.setText("");
        }
    }

    @FXML
    void OnActionRegistrar(ActionEvent event) {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();

        if (id.isEmpty() || nombre.isEmpty() || telefono.isEmpty()) {
            mostrarMensaje("Error", "Campos vacíos", "Por favor llene todos los campos", Alert.AlertType.ERROR);
            return;
        }

        boolean exito = administradorController.registrarEntrenador(id, nombre, telefono);

        if (exito) {
            mostrarMensaje("Éxito", null, "Entrenador registrado", Alert.AlertType.INFORMATION);
            obtenerEntrenadores();
            tableEntrenadores.refresh();
        } else {
            mostrarMensaje("Error", null, "No se pudo registrar (ID repetido)", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void OnActionModificar(ActionEvent event) {
        if (entrenadorSeleccionado == null) {
            mostrarMensaje("Error", null, "Seleccione un entrenador", Alert.AlertType.ERROR);
            return;
        }

        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();

        boolean exito = administradorController.modificarEntrenador(entrenadorSeleccionado, id, nombre, telefono);

        if (exito) {
            mostrarMensaje("Éxito", null, "Entrenador modificado", Alert.AlertType.INFORMATION);
            obtenerEntrenadores();
            tableEntrenadores.refresh();
        } else {
            mostrarMensaje("Error", null, "No se pudo modificar", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void OnActionEliminar(ActionEvent event) {
        if (entrenadorSeleccionado == null) {
            mostrarMensaje("Error", null, "Seleccione un entrenador", Alert.AlertType.ERROR);
            return;
        }

        boolean exito = administradorController.eliminarEntrenador(entrenadorSeleccionado.getIdentificacion());

        if (exito) {
            mostrarMensaje("Éxito", null, "Entrenador eliminado", Alert.AlertType.INFORMATION);
            obtenerEntrenadores();
        } else {
            mostrarMensaje("Error", null, "No se pudo eliminar", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void OnActionAsignarClase(ActionEvent event) {

        if (entrenadorSeleccionado == null) {
            mostrarMensaje("Error", null, "Seleccione un entrenador", Alert.AlertType.ERROR);
            return;
        }

        if (claseSeleccionada == null) {
            mostrarMensaje("Error", null, "Seleccione una clase", Alert.AlertType.ERROR);
            return;
        }

        boolean exito = administradorController.asignarClaseAEntrenador(entrenadorSeleccionado, claseSeleccionada);

        if (exito) {
            mostrarMensaje("Éxito", null, "Clase asignada al entrenador", Alert.AlertType.INFORMATION);
            tableClases.refresh();
        } else {
            mostrarMensaje("Error", null, "La clase ya tiene entrenador asignado", Alert.AlertType.ERROR);
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(header);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}
