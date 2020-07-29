package edu.fiuba.algo3.modelo.Modalidad;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.HashMap;
import java.util.List;


public class Penalidad implements Modalidad {
    public void puntuarVerdaderoFalso(Respuesta respuesta, List<Opcion> respuestasCorrectas){

        for(Opcion opcion : respuesta.opcionesElegidas){
            if (respuestasCorrectas.contains(opcion)){
                respuesta.jugador.modificarPuntos(1);
            } else {
                respuesta.jugador.modificarPuntos(-1);
            }
        }
    }
    public void puntuarMultipleChoice(Respuesta respuesta, List<Opcion> respuestasCorrectas){}
}