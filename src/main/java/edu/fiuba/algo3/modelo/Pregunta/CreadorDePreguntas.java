package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Opcion.Opcion;

import java.util.List;

public class CreadorDePreguntas<Modalidad> {


    public Pregunta crearMultipleChoiceClasico(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){
        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoiceClasico(pregunta, opcionesDisponibles, respuestasCorrectas);
        return nuevaPregunta;
    }


    public Pregunta crearMultipleChoiceParcial(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){
        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoiceParcial(pregunta, opcionesDisponibles, respuestasCorrectas);
        return nuevaPregunta;
    }


    public Pregunta crearMultipleChoicePenalidad(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){
        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoicePenalidad(pregunta, opcionesDisponibles, respuestasCorrectas);
        return nuevaPregunta;
    }


    public Pregunta crearOrderedChoice(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){
        Pregunta nuevaPregunta = Pregunta.crearPreguntaOrderedChoice(pregunta, opcionesDisponibles, respuestasCorrectas);
        return nuevaPregunta;
    }


    public Pregunta crearGroupChoice(String pregunta, List<Opcion> opcionesDisponibles){
        Pregunta nuevaPregunta = Pregunta.crearPreguntaGroupChoice(pregunta, opcionesDisponibles);
        return nuevaPregunta;
    }


    public Pregunta crearVerdaderoFalsoClasico(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){
        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(pregunta, opcionesDisponibles, respuestasCorrectas);
        return nuevaPregunta;
    }


    public Pregunta crearVerdaderoFalsoPenalidad(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){
        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoConPenalidad(pregunta, opcionesDisponibles, respuestasCorrectas);
        return nuevaPregunta;
    }
}
