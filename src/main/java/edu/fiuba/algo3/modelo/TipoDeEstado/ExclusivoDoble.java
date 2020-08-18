package edu.fiuba.algo3.modelo.TipoDeEstado;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;

import static edu.fiuba.algo3.modelo.Constants.Constants.EXCLUSIVIDAD;

public class ExclusivoDoble implements TipoDeEstado{

    public void asignarPuntaje(List<Respuesta> respuestas){
        Respuesta respuestaJugadorUno = respuestas.get(0);
        Respuesta respuestaJugadorDos = respuestas.get(1);
        if( respuestaJugadorUno.esExclusivaCon(respuestaJugadorDos) ){
            respuestaJugadorUno.getJugador().modificarPuntos(4 *respuestaJugadorUno.getPuntaje());
        }else if( respuestaJugadorDos.esExclusivaCon(respuestaJugadorUno) ){
            respuestaJugadorDos.getJugador().modificarPuntos(4 *respuestaJugadorDos.getPuntaje());
        }
    }

    public boolean esExclusivo(){
        return true;
    }
}
