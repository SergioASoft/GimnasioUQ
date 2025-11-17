package co.edu.uniquindio.gimnasiouq.gimnasiouq.factory;


import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.GimnasioUQ;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.Usuario;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.util.DataUtil;

import java.util.ArrayList;

public class ModelFactory {
    private static ModelFactory instance;
    private GimnasioUQ gimnasioUQ;


    private ModelFactory() {
        gimnasioUQ = DataUtil.inicializarDatos();
        System.out.println("ModelFactory inicializada, gimnasioUQ: " + gimnasioUQ);
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }
    public GimnasioUQ getGimnasioUQ() {
        return gimnasioUQ;
    }

    public boolean autenticar(String usuario, String contrasenia, String rol) {
        // Antes de usar, verifica que gimnasioUQ no sea null (aunque no debería)
        if (gimnasioUQ == null) {
            throw new IllegalStateException("gimnasioUQ NO iniciado");
        }
        return gimnasioUQ.autenticar(usuario, contrasenia, rol);
    }

    public ArrayList<Usuario> obtenerUsuarios() {
        return gimnasioUQ.getListaUsuarios();
    }
}

