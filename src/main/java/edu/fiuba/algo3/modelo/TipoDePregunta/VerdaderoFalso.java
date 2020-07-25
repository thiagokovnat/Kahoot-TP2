package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Modalidad.Clasica;
import edu.fiuba.algo3.modelo.Modalidad.Modalidad;
import edu.fiuba.algo3.modelo.Modalidad.Penalidad;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import java.util.HashMap;
import java.util.List;

public class VerdaderoFalso implements TipoDePregunta{

    private Modalidad modalidadDePregunta;
    private HashMap<String, Boolean> respuestasCorrectas;

    // Recibe una lista de las respuestas correctas y crea la pregunta guardando dichas respuestas.
    public VerdaderoFalso(List<String> listaDeRespuestasCorrectas) {

        this.respuestasCorrectas = new HashMap<String, Boolean>();

        for (String respuesta : listaDeRespuestasCorrectas) {
            this.respuestasCorrectas.put(respuesta, true);
        }

    }

    // Devuelve una instancia de VF clásico dada una lista de respuestas correctas.
    public static VerdaderoFalso VerdaderoFalsoClasico(List<String> listaDeRespuestasCorrectas){
        VerdaderoFalso nuevaPregunta = new VerdaderoFalso(listaDeRespuestasCorrectas);
        nuevaPregunta.modalidadDePregunta = new Clasica();
        return (nuevaPregunta);
    }


    // Devuelve una instancia de VF con penalidad dada una lista de respuestas correctas.
    public static VerdaderoFalso VerdaderoFalsoPenalidad(List<String> listaDeRespuestasCorrectas){
        VerdaderoFalso nuevaPregunta = new VerdaderoFalso(listaDeRespuestasCorrectas);
        nuevaPregunta.modalidadDePregunta = new Penalidad();
        return (nuevaPregunta);
    }

    //Puntúa la respuesta del jugador de forma correspondiente al tipo de pregunta del mismo.
    public void puntuarRespuesta(Respuesta respuesta) {

        this.modalidadDePregunta.puntuarVerdaderoFalso(respuesta,respuestasCorrectas);

    }

}
