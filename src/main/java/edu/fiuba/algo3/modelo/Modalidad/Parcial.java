package edu.fiuba.algo3.modelo.Modalidad;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import java.util.HashMap;
import java.util.List;


public class Parcial implements Modalidad {


    // Hay que lograr erradicar este método de Parcial con otras interfaces.
    // O poner un excepción para evitar que se acceda a este método con una pregunta
    // de modalidad Parcial.
    public void puntuarVerdaderoFalso(Respuesta respuesta, List<Opcion> respuestasCorrectas){

    } //WIP

    public void puntuarMultipleChoice(Respuesta respuesta, List<Opcion> respuestasCorrectas) {

        int cantidadCorrectas = respuesta.cantidadCorrectas(respuestasCorrectas);
        int cantidadIncorrectas = respuesta.cantidadIncorrectas(respuestasCorrectas);

        if (cantidadIncorrectas == 0) {
            respuesta.jugador.modificarPuntos(cantidadCorrectas);
        }
    }

    public void puntuarOrderedChoice(Respuesta respuesta, List<Opcion> respuestasCorrectas){}

    public void puntuarGroupChoice( Respuesta respuesta, List<Opcion> respuestasCorrectas){}

    @Override
    public boolean admiteMultiplicador() {
        return false;
    }

}
