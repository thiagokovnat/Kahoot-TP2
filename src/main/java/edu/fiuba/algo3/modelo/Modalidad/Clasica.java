package edu.fiuba.algo3.modelo.Modalidad;
import java.util.HashMap;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class Clasica implements Modalidad {

    // Dada una respuesta y hash de datos válido, puntúa al jugador asociado si su respuesta es correcta según el hash.
    public void puntuarVerdaderoFalso(Respuesta respuesta, HashMap <String,Boolean> respuestasCorrectas){

        // Se le podría delegar la tarea de asignar el puntaje a cada tipoDePregunta
        // pasándole la opción elegida y la lista de correctas.
        if(respuestasCorrectas.get(respuesta.opcionElegida) != null){
            respuesta.jugador.modificarPuntos(1);
        }

    }

}
