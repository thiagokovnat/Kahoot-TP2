package edu.fiuba.algo3.modelo.TipoDeEstado;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;

public class Exclusivo implements TipoDeEstado{

    public void responder(Respuesta respuesta, TipoDePregunta pregunta){
        pregunta.puntuarRespuestaExclusiva(respuesta);
    }
}
