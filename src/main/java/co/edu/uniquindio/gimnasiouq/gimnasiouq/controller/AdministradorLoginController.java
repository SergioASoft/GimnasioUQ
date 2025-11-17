package co.edu.uniquindio.gimnasiouq.gimnasiouq.controller;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.factory.ModelFactory;

public class AdministradorLoginController  {

    static ModelFactory modelFactory;

    public AdministradorLoginController(){
        modelFactory=ModelFactory.getInstance();
   }


    public static boolean autenticar(String usuario, String contrasenia, String rol) {
        return modelFactory.autenticar(usuario, contrasenia, rol);
    }
}

