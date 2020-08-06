package edu.fiuba.algo3.modelo.TipoDeEstado;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;

import java.util.List;

public interface TipoDeEstado {
    void puntuarRespuesta(Respuesta respuesta, TipoDePregunta pregunta);
}
