package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.HashMap;
import java.util.List;

public class Juego {

    private final int CANTIDAD_MAXIMA_JUGADORES = 2;
    private final static Juego instanciaJuego = new Juego();
    private final HashMap<String, Jugador> jugadores;

    private Juego() {
        this.jugadores = new HashMap<String, Jugador>();
    }

    public Juego obtenerInstancia() {
        return instanciaJuego;
    }

    public void crearJugador(String nickname) throws CantidadMaximaDeJugadoresSuperadaException {
        if (this.jugadores.size() >= this.CANTIDAD_MAXIMA_JUGADORES) {
            throw new CantidadMaximaDeJugadoresSuperadaException();
        }
        Jugador jugador = new Jugador(nickname);
        this.jugadores.put(nickname, jugador);
    }

    public Respuesta responder(String nickname, List<Opcion> opcionesElegidas) {
        Jugador jugador = this.jugadores.get(nickname);
        return jugador.responder(opcionesElegidas);
    }
}
