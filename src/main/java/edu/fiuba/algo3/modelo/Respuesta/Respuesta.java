package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Jugador;


public class Respuesta{

    public Jugador jugador;
    public String opcionElegida;

    public Respuesta( Jugador unJugador, String opcionElegida ){

        this.jugador = unJugador;
        this.opcionElegida = opcionElegida;
    }
}