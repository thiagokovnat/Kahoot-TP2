package edu.fiuba.algo3.modelo.TipoDeEstado;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;

import java.util.List;

public class Clasico implements TipoDeEstado{

    public void asignarPuntaje(List<Respuesta> respuestas){

        for(Respuesta respuesta : respuestas){
            respuesta.getJugador().modificarPuntos(respuesta.getPuntaje());
        }

    }
}
