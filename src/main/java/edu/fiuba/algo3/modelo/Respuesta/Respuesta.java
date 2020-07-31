package edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;

import java.util.ArrayList;
import java.util.List;


public class Respuesta{

    public Jugador jugador;
    private List<Opcion> opcionesElegidas = new ArrayList<Opcion>();

    public Respuesta(Jugador unJugador, List<Opcion> opcionesElegidas){

        this.jugador = unJugador;
        this.opcionesElegidas.addAll(opcionesElegidas);
    }

    public int cantidadCorrectas(List<Opcion> respuestasCorrectas){

        int cantCorrectas = 0;
        for(Opcion opcion: opcionesElegidas){
            if(respuestasCorrectas.contains(opcion)) cantCorrectas++;
        }
        return cantCorrectas;
    }

    public int cantidadIncorrectas(List<Opcion> respuestasCorrectas){

        int cantIncorrectas = 0;
        for(Opcion opcion: opcionesElegidas){
            if(!respuestasCorrectas.contains(opcion)) cantIncorrectas++;
        }
        return cantIncorrectas;
    }

    public boolean opcionesEnOrden(List<Opcion> opcionesOrdenadas){

        return opcionesOrdenadas.equals(opcionesElegidas);
    }
}
