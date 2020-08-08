package edu.fiuba.algo3.modelo.Modalidad;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;


public class Penalidad implements Modalidad {

    public void puntuarVerdaderoFalso(Respuesta respuesta, List<Opcion> respuestasCorrectas){

        int cantidadCorrectas = respuesta.cantidadCorrectas(respuestasCorrectas);
        int cantidadIncorrectas = respuesta.cantidadIncorrectas(respuestasCorrectas);

        respuesta.jugador.modificarPuntos(cantidadCorrectas-cantidadIncorrectas);
    }

    public void puntuarMultipleChoice(Respuesta respuesta, List<Opcion> respuestasCorrectas){


        int cantidadCorrectas = respuesta.cantidadCorrectas(respuestasCorrectas);
        int cantidadIncorrectas = respuesta.cantidadIncorrectas(respuestasCorrectas);

        respuesta.jugador.modificarPuntos(cantidadCorrectas-cantidadIncorrectas);
    }

    public void puntuarOrderedChoice(Respuesta respuesta, List<Opcion> respuestasCorrectas){}

    public void puntuarGroupChoice( Respuesta respuesta, List<Opcion> respuestasCorrectas ){}

    @Override
    public boolean admiteMultiplicador() {
        return true;
    }
}