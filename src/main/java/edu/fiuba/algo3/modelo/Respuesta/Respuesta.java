package edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;

import java.util.ArrayList;
import java.util.List;


public class Respuesta{

    public Jugador jugador;
    private List<Opcion> opcionesElegidas = new ArrayList<Opcion>();
    private int puntuacion;

    public Respuesta(Jugador unJugador, List<Opcion> opcionesElegidas){

        this.jugador = unJugador;
        this.opcionesElegidas.addAll(opcionesElegidas);
        this.puntuacion = 0;
    }

    public int cantidadCorrectas(List<Opcion> opcionesCorrectas){

        int cantCorrectas = 0;
        for(Opcion opcion: opcionesElegidas){
            if(opcionesCorrectas.contains(opcion)) cantCorrectas++;
        }
        return cantCorrectas;

    }

    public Jugador getJugador(){
        return this.jugador;
    }

    public int getPuntaje(){
        return this.puntuacion;
    }

    public int cantidadIncorrectas(List<Opcion> opcionesCorrectas){

        int cantIncorrectas = 0;
        for(Opcion opcion: opcionesElegidas){
            if(!opcionesCorrectas.contains(opcion)) cantIncorrectas++;
        }
        return cantIncorrectas;
    }

    public boolean opcionesEnOrden(List<Opcion> opcionesOrdenadas){

        return opcionesOrdenadas.equals(opcionesElegidas);
    }

    public boolean contieneLasOpciones(List<Opcion> opcionesCorrectas){
        return opcionesElegidas.containsAll(opcionesCorrectas);
    }

    public void setPuntuacion(int nuevoPuntaje){
        this.puntuacion = nuevoPuntaje;
    }

}
