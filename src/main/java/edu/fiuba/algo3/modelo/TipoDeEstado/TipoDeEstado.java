package edu.fiuba.algo3.modelo.TipoDeEstado;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;

import java.util.List;

public interface TipoDeEstado {
    void asignarPuntaje(List<Respuesta> respuestas);
     boolean esExclusivo();
}
