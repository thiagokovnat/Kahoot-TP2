package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import java.util.HashMap;
import java.util.List;

public class VerdaderoFalsoClasico implements VerdaderoFalso {

    private HashMap<String, Boolean> respuestasCorrectas;

    // Recibe una lista de las respuestas correctas y crea la pregunta guardando dichas respuestas.
    public VerdaderoFalsoClasico(List<String> respuestasCorrectas) {

        this.respuestasCorrectas = new HashMap<String, Boolean>();

        for (String respuesta : respuestasCorrectas) {
            this.respuestasCorrectas.put(respuesta, true);
        }

    }


    /*
    Dejo esta alternativa para el constructor con una sola respuesta correcta (Luke).
    public VerdaderoFalsoClasico(String respuestaCorrecta){
        this.respuestasCorrectas = new HashMap<String, Boolean>();
        this.respuestasCorrectas.put(respuestaCorrecta, true);
    }
    */


    // Recibe una Respuesta y comprueba si esta guardada en el HashMap para saber si la respuesta es correcta.
    public void puntuarRespuesta(Respuesta respuesta) {

        if(respuestasCorrectas.get(respuesta.opcionElegida) != null){
            respuesta.jugador.modificarPuntos(1);
        }

    }
}