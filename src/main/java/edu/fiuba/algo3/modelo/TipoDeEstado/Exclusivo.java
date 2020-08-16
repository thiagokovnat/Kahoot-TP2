package edu.fiuba.algo3.modelo.TipoDeEstado;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

import static edu.fiuba.algo3.modelo.Constants.Constants.*;

public class Exclusivo implements TipoDeEstado{

    public void asignarPuntaje(List<Respuesta> respuestas){
        Respuesta respuestaJugadorUno = respuestas.get(0);
        Respuesta respuestaJugadorDos = respuestas.get(1);
        if( respuestaJugadorUno.esExclusivaCon(respuestaJugadorDos) ){
            respuestaJugadorUno.getJugador().modificarPuntos(EXCLUSIVIDAD *respuestaJugadorUno.getPuntaje());
        }else if( respuestaJugadorDos.esExclusivaCon(respuestaJugadorUno) ){
            respuestaJugadorDos.getJugador().modificarPuntos(EXCLUSIVIDAD *respuestaJugadorDos.getPuntaje());
        }
    }
}
