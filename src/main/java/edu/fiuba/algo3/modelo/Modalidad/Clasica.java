package edu.fiuba.algo3.modelo.Modalidad;
import java.util.List;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class Clasica implements Modalidad {

    // Dada una respuesta y lista de datos válidos, puntúa al jugador asociado si su respuesta es correcta.
    public void puntuarVerdaderoFalso(Respuesta respuesta, List<Opcion> respuestasCorrectas){

        int cantidadCorrectas = respuesta.cantidadCorrectas(respuestasCorrectas);
        int cantidadIncorrectas = respuesta.cantidadIncorrectas(respuestasCorrectas);

        if(respuestasCorrectas.size() == cantidadCorrectas && cantidadIncorrectas == 0){
            respuesta.jugador.modificarPuntos(1);
        }
    }

    // Dada una respuesta y lista de datos válidos, puntúa al jugador asociado si su respuesta es correcta.
    public void puntuarMultipleChoice(Respuesta respuesta, List<Opcion> respuestasCorrectas){

        int cantidadCorrectas = respuesta.cantidadCorrectas(respuestasCorrectas);
        int cantidadIncorrectas = respuesta.cantidadIncorrectas(respuestasCorrectas);

        if(respuestasCorrectas.size() == cantidadCorrectas && cantidadIncorrectas == 0){
            respuesta.jugador.modificarPuntos(1);
        }
    }

    public void puntuarOrderedChoice(Respuesta respuesta, List<Opcion> respuestasCorrectas){

        if(respuesta.opcionesEnOrden(respuestasCorrectas))
            respuesta.jugador.modificarPuntos(1);
    }
}