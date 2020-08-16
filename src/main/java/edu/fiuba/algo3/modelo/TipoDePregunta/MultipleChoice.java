package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Modalidad.Clasica;
import edu.fiuba.algo3.modelo.Modalidad.ModalidadMultipleChoice;
import edu.fiuba.algo3.modelo.Modalidad.Parcial;
import edu.fiuba.algo3.modelo.Modalidad.Penalidad;
import edu.fiuba.algo3.modelo.Opcion.Opcion;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoice implements TipoDePregunta {

    private ModalidadMultipleChoice modalidad;
    private List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();

    // Recibe una lista de las respuestas correctas y crea la pregunta guardando dichas respuestas.
    private MultipleChoice(List<Opcion> opcionesCorrectas) {
        this.opcionesCorrectas.addAll(opcionesCorrectas);
    }

    // Devuelve una instancia de MC clásico dada una lista de respuestas correctas.
    public static MultipleChoice MultipleChoiceClasico(List<Opcion> opcionesCorrectas){

        MultipleChoice nuevaPregunta = new MultipleChoice(opcionesCorrectas);
        nuevaPregunta.modalidad = new Clasica();
        return nuevaPregunta;
    }

    public static MultipleChoice MultipleChoiceParcial(List<Opcion> opcionesCorrectas) {

        MultipleChoice nuevaPregunta = new MultipleChoice(opcionesCorrectas);
        nuevaPregunta.modalidad = new Parcial();
        return nuevaPregunta;
    }

    public static MultipleChoice MultipleChoicePenalidad(List<Opcion> opcionesCorrectas) {

        MultipleChoice nuevaPregunta = new MultipleChoice(opcionesCorrectas);
        nuevaPregunta.modalidad = new Penalidad();
        return nuevaPregunta;
    }

    // Puntúa la respuesta del jugador de forma correspondiente al tipo de pregunta del mismo.
    @Override
    public void puntuarRespuesta(Respuesta respuesta){
        this.modalidad.puntuarMultipleChoice(respuesta, opcionesCorrectas);
    }

    @Override
    public boolean admiteMultiplicador() {
        return modalidad.admiteMultiplicador();
    }

    @Override
    public boolean admiteExclusividad(){
        return this.modalidad.admiteExclusividad();
    }
}
