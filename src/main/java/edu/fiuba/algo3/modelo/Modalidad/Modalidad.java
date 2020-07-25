package edu.fiuba.algo3.modelo.Modalidad;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.HashMap;

public interface Modalidad{
    void puntuarVerdaderoFalso(Respuesta respuesta, HashMap<String,Boolean> respuestasCorrectas);
    //void puntuarMultipleChoice();
    // Luego analizar caso del group choice.
}
