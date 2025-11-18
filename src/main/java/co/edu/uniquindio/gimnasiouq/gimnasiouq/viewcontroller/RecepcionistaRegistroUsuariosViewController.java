package co.edu.uniquindio.gimnasiouq.gimnasiouq.viewcontroller;

import co.edu.uniquindio.gimnasiouq.gimnasiouq.controller.RecepcionistaController;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RecepcionistaRegistroUsuariosViewController {
    RecepcionistaController recepcionistaController;
    ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    Usuario usuarioSeleccionado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private Button btnEliminar;

    @FXML
    private ComboBox<String> cmbTipoUsuario;

    @FXML
    private TableView<Usuario> tableUsuarios;

    @FXML
    private TableColumn<Usuario, String> tcApellido;

    @FXML
    private TableColumn<Usuario, String> tcCorreo;

    @FXML
    private TableColumn<Usuario, String> tcEdad;

    @FXML
    private TableColumn<Usuario, String> tcId;

    @FXML
    private TableColumn<Usuario, String> tcNombre;

    @FXML
    private TableColumn<Usuario, String> tcTelefono;

    @FXML
    private TableColumn<Usuario, String> tcTipo;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    void OnActionActualizar(ActionEvent event) {

    }

    @FXML
    void OnActionAgregarUsuario(ActionEvent event) {
        agregarUsuario();
    }

    private void agregarUsuario() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtId.getText();
        String edadText = txtEdad.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();
        String tipoUsuario = cmbTipoUsuario.getValue();

        if (nombre.isEmpty() || apellido.isEmpty() || identificacion.isEmpty() || edadText.isEmpty() || telefono.isEmpty() || correo.isEmpty() || tipoUsuario.equals("Seleccionar")) {
            mostrarMensaje("Error", "Campos incompletos", "Por favor, complete todos los campos.", Alert.AlertType.ERROR);
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadText);
        } catch (NumberFormatException e) {
            mostrarMensaje("Error", "Edad inválida", "Por favor, ingrese un número válido para la edad.", Alert.AlertType.ERROR);
            return;
        }

        boolean exito = recepcionistaController.agregarUsuario(nombre, apellido, identificacion, edad, telefono, correo, tipoUsuario);
        if (exito) {
            mostrarMensaje("Éxito", "Usuario agregado", "El usuario ha sido agregado exitosamente.", Alert.AlertType.INFORMATION);
            listaUsuarios.clear();
            obtenerUsuarios();
            tableUsuarios.setItems(listaUsuarios);
        } else {
            mostrarMensaje("Error", "Fallo al agregar usuario", "No se pudo agregar el usuario. Verifique los datos e intente nuevamente.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void OnActionEliminar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        cmbTipoUsuario.getItems().addAll("Estudiante", "Trabajador","Externo");
        cmbTipoUsuario.setValue("Seleccionar");
        recepcionistaController = new RecepcionistaController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerUsuarios();
        tableUsuarios.getItems().clear();
        tableUsuarios.setItems(listaUsuarios);
        listenerSelection();
    }

    private void obtenerUsuarios() {
        listaUsuarios.addAll(recepcionistaController.obtenerUsuarios());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tcTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClass().getSimpleName()));
    }

    private void listenerSelection() {
        tableUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacion(usuarioSeleccionado);
        });
    }

    private void mostrarInformacion(Usuario usuarioSeleccionado) {
        if (usuarioSeleccionado != null) {
            txtNombre.setText(usuarioSeleccionado.getNombre());
            txtApellido.setText(usuarioSeleccionado.getApellido());
            txtId.setText(usuarioSeleccionado.getIdentificacion());
            txtEdad.setText(String.valueOf(usuarioSeleccionado.getEdad()));
            txtTelefono.setText(usuarioSeleccionado.getTelefono());
            txtCorreo.setText(usuarioSeleccionado.getCorreo());
        } else {
            txtNombre.setText("");
            txtApellido.setText("");
            txtId.setText("");
            txtEdad.setText("");
            txtTelefono.setText("");
            txtCorreo.setText("");
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
}
