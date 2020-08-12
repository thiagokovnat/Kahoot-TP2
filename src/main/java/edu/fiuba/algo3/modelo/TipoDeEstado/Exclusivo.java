package edu.fiuba.algo3.modelo.TipoDeEstado;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;

import java.util.List;

public class Exclusivo implements TipoDeEstado{

    public void asignarPuntaje(List<Respuesta> respuestas){
        Respuesta jugadorUno = respuestas.get(0);
        Respuesta jugadorDos = respuestas.get(1);
        if( jugadorUno.esExclusivaCon(jugadorDos) ){
            jugadorUno.getJugador().modificarPuntos(2*jugadorUno.getPuntaje());
        }else if( jugadorDos.esExclusivaCon(jugadorUno) ){
            jugadorDos.getJugador().modificarPuntos(2*jugadorDos.getPuntaje());
        }
    }
}
