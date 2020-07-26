package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public interface TipoDePregunta {
    void puntuarRespuesta(Respuesta respuesta);

    void puntuarRespuestaExclusiva(Respuesta respuesta);
}