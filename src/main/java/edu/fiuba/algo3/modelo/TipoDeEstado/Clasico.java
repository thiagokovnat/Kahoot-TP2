package edu.fiuba.algo3.modelo.TipoDeEstado;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;

public class Clasico implements TipoDeEstado{

    public void puntuarRespuesta(Respuesta respuesta, TipoDePregunta pregunta){
        pregunta.puntuarRespuesta(respuesta);
    }
}
