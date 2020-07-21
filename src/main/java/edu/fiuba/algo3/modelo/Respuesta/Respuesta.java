package edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Jugador.Jugador;


public class Respuesta{

    private Jugador jugador;
    private String opcionElegida;

    public Respuesta( Jugador unJugador, String opcionElegida ){
        this.jugador = unJugador;
        this.opcionElegida = opcionElegida;
    }
}