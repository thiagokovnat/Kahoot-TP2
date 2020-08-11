package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Modalidad.Clasica;
import edu.fiuba.algo3.modelo.Modalidad.ModalidadOrderedChoice;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class OrderedChoice implements TipoDePregunta {

    private ModalidadOrderedChoice modalidad;
    private List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();

    private OrderedChoice(List<Opcion> opcionesCorrectas){

        this.opcionesCorrectas.addAll(opcionesCorrectas);
        this.modalidad = new Clasica();
    }

    public static OrderedChoice OrderedChoice(List<Opcion> opcionesCorrectas){

        OrderedChoice unaPregunta = new OrderedChoice(opcionesCorrectas);
        unaPregunta.modalidad = new Clasica();

        return unaPregunta;
    }

    @Override
    public void puntuarRespuesta(Respuesta respuesta){

        this.modalidad.puntuarOrderedChoice(respuesta, opcionesCorrectas);
    }

    @Override
    public boolean admiteMultiplicador() {
        return modalidad.admiteMultiplicador();
    }
}
