package edu.fiuba.algo3.modelo.Modalidad;
import java.util.List;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class Clasica implements Modalidad {

    // Dada una respuesta y lista de datos válidos, puntúa al jugador asociado si su respuesta es correcta.
    public void puntuarVerdaderoFalso(Respuesta respuesta, List<Opcion> respuestasCorrectas){

        if(respuestasCorrectas.containsAll(respuesta.opcionesElegidas)){
            respuesta.jugador.modificarPuntos(1);
        }
    }

    // Dada una respuesta y lista de datos válidos, puntúa al jugador asociado si su respuesta es correcta.
    public void puntuarMultipleChoice(Respuesta respuesta, List<Opcion> respuestasCorrectas){
        System.out.println("No entró");
        if((respuestasCorrectas.size() == respuesta.opcionesElegidas.size()) &&
                (respuestasCorrectas.containsAll(respuesta.opcionesElegidas))){
            System.out.println("Entró");
            respuesta.jugador.modificarPuntos(1);
        }

    }
}