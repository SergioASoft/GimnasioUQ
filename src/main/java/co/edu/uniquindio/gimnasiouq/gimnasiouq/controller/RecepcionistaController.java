package co.edu.uniquindio.gimnasiouq.gimnasiouq.controller;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.factory.*;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Usuario;

import java.util.ArrayList;

public class RecepcionistaController {
    ModelFactory modelFactory;
    public RecepcionistaController() {
        modelFactory = ModelFactory.getInstance();
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }
}
