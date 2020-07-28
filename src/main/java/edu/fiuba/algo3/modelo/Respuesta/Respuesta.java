package edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;

import java.util.ArrayList;
import java.util.List;


public class Respuesta{

    public Jugador jugador;
    public List<Opcion> opcionesElegidas;

    public Respuesta(Jugador unJugador, List<Opcion> opcionElegida){

        this.jugador = unJugador;
        this.opcionesElegidas = new ArrayList<>();
        this.opcionesElegidas.addAll( opcionElegida);
    }
}
