package edu.fiuba.algo3.modelo.Ronda;

import edu.fiuba.algo3.modelo.Exceptions.CantidadMaximaDeJugadoresSuperadaException;
import edu.fiuba.algo3.modelo.Exceptions.CantidadUsoMultiplicadorExcedidoException;
import edu.fiuba.algo3.modelo.Exceptions.PreguntaNoAdmiteMultiplicadorException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ronda {
    public Pregunta pregunta;
    public List<Jugador> jugadores = new ArrayList<>();
    public ListIterator<Jugador> iterador;
    public List<Respuesta> respuestas = new ArrayList<>();
    public Jugador jugadorActual;

    public Ronda( Pregunta pregunta, List<Jugador> jugadores ){

        this.pregunta = pregunta;
        this.jugadores.addAll(jugadores);
        this.iterador = this.jugadores.listIterator();
        this.jugadorActual = iterador.next();
    }

    public void finalizar(){

        this.pregunta.puntuarRespuestas(respuestas);
    }

    public void responder(List<Opcion> opcionesElegidas ){

        Respuesta respuesta = jugadorActual.responder(opcionesElegidas);
        respuestas.add(respuesta);
    }

    public boolean sePuedeActivarMultiplicador( Multiplicador multiplicador ){
        return (getJugadorActual().multiplicadorDisponible(multiplicador) && this.pregunta.admiteMultiplicador());
    }

    public void activarMultiplicador(Multiplicador multiplicador) throws CantidadUsoMultiplicadorExcedidoException, PreguntaNoAdmiteMultiplicadorException {

        jugadorActual.activarMultiplicador(multiplicador, this.pregunta);
    }

    // Devuelve true si sigue habiendo jugadores para que respondan, caso contrario false.
    public boolean hayProximoTurno(){

        if( this.iterador.hasNext() ) {
            this.jugadorActual = this.iterador.next();
            return true;
        }
        else{
            finalizar();
            return false;
        }
    }

    public Jugador getJugadorActual(){
        return jugadorActual;
    }

    public boolean admiteExclusividad(){
        return (this.pregunta.admiteExclusividad() && (this.jugadores.size() == 2));
    }

    public void setExclusividad(){
        this.pregunta.setExclusividad();
    }

    public String getTextoPregunta(){
        return this.pregunta.getTexto();
    }

}
