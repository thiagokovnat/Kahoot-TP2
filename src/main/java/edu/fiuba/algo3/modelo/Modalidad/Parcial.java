package edu.fiuba.algo3.modelo.Modalidad;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;


public class Parcial implements ModalidadMultipleChoice {

    @Override
    public void puntuarMultipleChoice(Respuesta respuesta, List<Opcion> respuestasCorrectas) {

        int cantidadCorrectas = respuesta.cantidadCorrectas(respuestasCorrectas);
        int cantidadIncorrectas = respuesta.cantidadIncorrectas(respuestasCorrectas);

        if (cantidadIncorrectas == 0) {
            respuesta.setPuntuacion(cantidadCorrectas);
        }
    }

    @Override
    public boolean admiteMultiplicador() {
        return false;
    }
}
