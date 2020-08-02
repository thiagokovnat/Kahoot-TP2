package edu.fiuba.algo3.modelo.TipoDePregunta;


import edu.fiuba.algo3.modelo.Modalidad.*;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class OrderedChoice implements TipoDePregunta {

    private Modalidad modalidad;
    private List<Opcion> respuestasCorrectas = new ArrayList<Opcion>();

    private OrderedChoice(List<Opcion> respuestasCorrectas){

        this.respuestasCorrectas.addAll(respuestasCorrectas);
        this.modalidad = new Clasica();
    }

    public static OrderedChoice OrderedChoice(List<Opcion> respuestasCorrectas){

        OrderedChoice unaPregunta = new OrderedChoice(respuestasCorrectas);
        unaPregunta.modalidad = new Clasica();

        return unaPregunta;
    }

    public void puntuarRespuesta(Respuesta respuesta){

        this.modalidad.puntuarOrderedChoice(respuesta, respuestasCorrectas);
    }

    public void puntuarRespuestaExclusiva(Respuesta respuesta){}
}
