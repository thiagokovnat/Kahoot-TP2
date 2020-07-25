package edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;

import java.util.ArrayList;
import java.util.List;


public class Respuesta{

    private List<Opcion> ArrayList;
    public Jugador jugador;
    public List<Opcion> opcionesElegida;

    public Respuesta( Jugador unJugador, List<Opcion> opcionElegida ){
        this.jugador = unJugador;
        this.opcionesElegida = new ArrayList<Opcion>();
        this.opcionesElegida.addAll( opcionElegida);
    }
}
