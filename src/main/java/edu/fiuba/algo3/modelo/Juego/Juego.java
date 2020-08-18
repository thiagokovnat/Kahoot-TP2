package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Exceptions.CantidadMaximaDeJugadoresSuperadaException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Ronda.Ronda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static edu.fiuba.algo3.modelo.Constants.Constants.CANTIDAD_MAXIMA_JUGADORES;

public class Juego {

    private final static Juego instanciaJuego = new Juego();
    private HashMap<String, Jugador> jugadores;
    private List<Pregunta> preguntas = new ArrayList<>();
    private List<Ronda> rondasDisponibles = new ArrayList<>();
    private int indiceRondaActual = 0;
    private int cantidadRondas;

    private Juego() {

        this.jugadores = new HashMap<String, Jugador>();
    }

    public List<Jugador> getJugadores(){

        return (new ArrayList<Jugador>(this.jugadores.values()));
    }

    public static Juego obtenerInstancia() {

        return instanciaJuego;
    }

    //TEST ONLY
    public Pregunta tomarPregunta(){

        return this.preguntas.get(0);
    }

    public void crearJugador(String nickname) throws CantidadMaximaDeJugadoresSuperadaException {

        if (this.jugadores.size() >= CANTIDAD_MAXIMA_JUGADORES) {
            throw new CantidadMaximaDeJugadoresSuperadaException();
        }

        Jugador jugador = new Jugador(nickname);
        this.jugadores.put(nickname, jugador);
    }

    public void agregarPregunta(Pregunta pregunta){
        this.preguntas.add(pregunta);
    }

    public boolean sePuedenCrearJugadores() {

        return (jugadores.size() < CANTIDAD_MAXIMA_JUGADORES);
    }

    public boolean noHayPreguntasCargadas(){

        return (preguntas.size() == 0);
    }

    public void quitarJugadores() {

        this.jugadores = new HashMap<String, Jugador>();
    }

    public Ronda getProximaRonda() {

       if(indiceRondaActual < cantidadRondas){
           Ronda ronda = rondasDisponibles.get(indiceRondaActual);
           indiceRondaActual++;
           return ronda;
       }

       return null;
    }

    public Ronda getRondaActual(){
        if(indiceRondaActual <= cantidadRondas){
            Ronda ronda = rondasDisponibles.get(indiceRondaActual - 1);
            return ronda;
        }

        return null;
    }

    public void comenzarJuego(){

        for(Pregunta pregunta : this.preguntas){
            List<Jugador> jugadores = new ArrayList<Jugador>(this.jugadores.values());
            rondasDisponibles.add(new Ronda(pregunta, jugadores));
        }

        cantidadRondas = rondasDisponibles.size();
    }

    public boolean estaTerminado(){
        return cantidadRondas <= indiceRondaActual;
    }

    public boolean sePuedeIniciarJuego(){
        return this.jugadores.size() > 0 && !this.noHayPreguntasCargadas();
    }

}
