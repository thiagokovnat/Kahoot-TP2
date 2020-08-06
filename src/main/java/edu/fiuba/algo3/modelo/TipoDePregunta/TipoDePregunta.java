package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public interface TipoDePregunta {

    void puntuarRespuesta(Respuesta respuesta);

    // Luke: "Según entiendo, una pregunta con Penalidad puede acceder a este método
    //        porque TipoDePregunta no discrimina Modalidad, pero una pregunta con Penalidad
    //        no tiene posibilidad de Exclusividad"
    void puntuarRespuestaExclusiva(Respuesta respuesta);

    boolean admiteMultiplicador();
}