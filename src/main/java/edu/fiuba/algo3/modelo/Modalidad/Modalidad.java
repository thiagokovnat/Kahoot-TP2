package edu.fiuba.algo3.modelo.Modalidad;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.HashMap;
import java.util.List;

public interface Modalidad{
    void puntuarVerdaderoFalso(Respuesta respuesta, List<Opcion> respuestasCorrectas);
    //void puntuarMultipleChoice();
    // Luego analizar caso del group choice.
}
