package co.edu.uniquindio.gimnasiouq.gimnasiouq.util;
import co.edu.uniquindio.gimnasiouq.gimnasiouq.model.*;

import java.time.LocalDate;

public class DataUtil {
    public static GimnasioUQ inicializarDatos() {

        GimnasioUQ gimnasio = new GimnasioUQ();

        gimnasio.setNombre("Gimnasio UQ");
        Estudiante estudiante1 = new Estudiante("Juan", "Perez", "123456789", 25, "3001234567", "juan@gmail.com");
        Estudiante estudiante2 = new Estudiante("Maria", "Gomez", "987654321", 22, "3007654321", "maria@gmail.com");
        Trabajador trabajador1 = new Trabajador("Carlos", "Lopez", "456789123", 30, "3004567890", "carlos@gmail.com");
        Trabajador trabajador2 = new Trabajador("Ana", "Martinez", "789123456", 28, "3009876543", "ana@gmail.com");
        Externo externo1 = new Externo("Luis", "Ramirez", "321654987", 35, "3003216549", "luis@gmail.com");
        Externo externo2 = new Externo("Sofia", "Torres", "654987321", 27, "3006549873", "sofia@gmail.com");
        //gimnasio.getListaEstudiantes().add(estudiante1);
        //gimnasio.getListaEstudiantes().add(estudiante2);
        //gimnasio.getListaTrabajadores().add(trabajador1);
        //gimnasio.getListaTrabajadores().add(trabajador2);
        //gimnasio.getListaExternos().add(externo1);
        //gimnasio.getListaExternos().add(externo2);
        gimnasio.getListaUsuarios().add(estudiante1);
        gimnasio.getListaUsuarios().add(estudiante2);
        gimnasio.getListaUsuarios().add(trabajador1);
        gimnasio.getListaUsuarios().add(trabajador2);
        gimnasio.getListaUsuarios().add(externo1);
        gimnasio.getListaUsuarios().add(externo2);

        MembresiaVip membresiaVip = new MembresiaVip(null,90000,null,null,false);
        MembresiaPremium membresiaPremium = new MembresiaPremium(null,60000,null,null,false);
        MembresiaBasica membresiaBasica = new MembresiaBasica(null,30000,null,null,false);
        gimnasio.getListaMembresias().add(membresiaVip);
        gimnasio.getListaMembresias().add(membresiaPremium);
        gimnasio.getListaMembresias().add(membresiaBasica);

        Clase yoga = new Clase(
                "Yoga mañanas",
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                20,
                TipoClase.YOGA,
                null // sin entrenador al inicio
        );

        Clase spinning = new Clase(
                "Spinning alto rendimiento",
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                15,
                TipoClase.SPINNING,
                null
        );

        Clase zumba = new Clase(
                "Zumba nocturna",
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                25,
                TipoClase.ZUMBA,
                null
        );
        gimnasio.getListaClases().add(yoga);
        gimnasio.getListaClases().add(spinning);
        gimnasio.getListaClases().add(zumba);


        return gimnasio;

    }
}
