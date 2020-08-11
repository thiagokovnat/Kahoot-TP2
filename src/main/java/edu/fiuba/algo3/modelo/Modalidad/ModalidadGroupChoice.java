package edu.fiuba.algo3.modelo.Modalidad;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

public interface ModalidadGroupChoice {
    void puntuarGroupChoice(Respuesta respuesta, List<Opcion> opcionesCorrectas);
    boolean admiteMultiplicador();
}
