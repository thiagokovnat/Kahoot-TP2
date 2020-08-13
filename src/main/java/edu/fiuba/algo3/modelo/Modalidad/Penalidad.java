package edu.fiuba.algo3.modelo.Modalidad;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;


public class Penalidad implements ModalidadVerdaderoFalso, ModalidadMultipleChoice {

    @Override
    public void puntuarVerdaderoFalso(Respuesta respuesta, List<Opcion> respuestasCorrectas){

        int cantidadCorrectas = respuesta.cantidadCorrectas(respuestasCorrectas);
        int cantidadIncorrectas = respuesta.cantidadIncorrectas(respuestasCorrectas);

        respuesta.setPuntuacion(cantidadCorrectas-cantidadIncorrectas);
    }

    @Override
    public void puntuarMultipleChoice(Respuesta respuesta, List<Opcion> respuestasCorrectas){

        int cantidadCorrectas = respuesta.cantidadCorrectas(respuestasCorrectas);
        int cantidadIncorrectas = respuesta.cantidadIncorrectas(respuestasCorrectas);

        respuesta.setPuntuacion(cantidadCorrectas-cantidadIncorrectas);
    }

    @Override
    public boolean admiteMultiplicador() {
        return true;
    }

    @Override
    public boolean admiteExclusividad(){
        return false;
    }
}