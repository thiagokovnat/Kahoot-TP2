package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Modalidad.Clasica;
import edu.fiuba.algo3.modelo.Modalidad.Modalidad;
import edu.fiuba.algo3.modelo.Modalidad.Penalidad;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalso implements TipoDePregunta{

    private Modalidad modalidadDePregunta;
    private List<Opcion> respuestasCorrectas;

    // Recibe una lista de las respuestas correctas y crea la pregunta guardando dichas respuestas.
    public VerdaderoFalso(List<Opcion> respuestasCorrectas) {

        this.respuestasCorrectas = new ArrayList<Opcion>();
        this.respuestasCorrectas.addAll(respuestasCorrectas);

    }

    // Devuelve una instancia de VF clásico dada una lista de respuestas correctas.
    public static VerdaderoFalso VerdaderoFalsoClasico(List<Opcion> respuestasCorrectas){
        VerdaderoFalso nuevaPregunta = new VerdaderoFalso(respuestasCorrectas);
        nuevaPregunta.modalidadDePregunta = new Clasica();
        return (nuevaPregunta);
    }


    // Devuelve una instancia de VF con penalidad dada una lista de respuestas correctas.
    public static VerdaderoFalso VerdaderoFalsoPenalidad(List<Opcion> respuestasCorrectas){
        VerdaderoFalso nuevaPregunta = new VerdaderoFalso(respuestasCorrectas);
        nuevaPregunta.modalidadDePregunta = new Penalidad();
        return (nuevaPregunta);
    }

    //Puntúa la respuesta del jugador de forma correspondiente al tipo de pregunta del mismo.
    public void puntuarRespuesta(Respuesta respuesta) {

        this.modalidadDePregunta.puntuarVerdaderoFalso(respuesta,respuestasCorrectas);

    }

    public void puntuarRespuestaExclusiva(Respuesta respuesta){

    }

}
