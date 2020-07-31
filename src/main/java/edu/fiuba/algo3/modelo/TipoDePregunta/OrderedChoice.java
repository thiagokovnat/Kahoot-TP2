package edu.fiuba.algo3.modelo.TipoDePregunta;


import edu.fiuba.algo3.modelo.Modalidad.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class OrderedChoice implements TipoDePregunta {

    private Modalidad modalidadDePregunta;
    private List<Opcion> respuestasCorrectas = new ArrayList<Opcion>();

    private OrderedChoice(List<Opcion> respuestasCorrectas){

        this.respuestasCorrectas.addAll(respuestasCorrectas);
    }

    public static OrderedChoice OrderedChoiceClasico(List<Opcion> respuestasCorrectas){

        OrderedChoice unaPregunta = new OrderedChoice(respuestasCorrectas);
        unaPregunta.modalidadDePregunta = new Clasica();

        return unaPregunta;
    }

    public void puntuarRespuesta(Respuesta respuesta){

        this.modalidadDePregunta.puntuarOrderedChoice(respuesta, respuestasCorrectas);

    }

    public void puntuarRespuestaExclusiva(Respuesta respuesta){}
}
