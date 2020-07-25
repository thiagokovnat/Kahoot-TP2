package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.HashMap;

public interface TipoDePregunta {
    void puntuarVerdaderoFalso(Respuesta respuesta, HashMap<String,Boolean> respuestasCorrectas);
    //void puntuarMultipleChoice();
    // Luego analizar caso del group choice.
}
