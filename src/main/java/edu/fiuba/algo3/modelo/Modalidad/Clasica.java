package edu.fiuba.algo3.modelo.Modalidad;
import java.util.List;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

public class Clasica implements ModalidadVerdaderoFalso, ModalidadMultipleChoice, ModalidadOrderedChoice, ModalidadGroupChoice {

    // Dada una respuesta y lista de datos válidos, puntúa al jugador asociado si su respuesta es correcta.
    @Override
    public void puntuarVerdaderoFalso(Respuesta respuesta, List<Opcion> opcionesCorrectas){

        int cantidadCorrectas = respuesta.cantidadCorrectas(opcionesCorrectas);
        int cantidadIncorrectas = respuesta.cantidadIncorrectas(opcionesCorrectas);

        if(opcionesCorrectas.size() == cantidadCorrectas && cantidadIncorrectas == 0){
            respuesta.setPuntuacion(1);
        }
    }

    // Dada una respuesta y lista de datos válidos, puntúa al jugador asociado si su respuesta es correcta.
    @Override
    public void puntuarMultipleChoice(Respuesta respuesta, List<Opcion> opcionesCorrectas){

        int cantidadCorrectas = respuesta.cantidadCorrectas(opcionesCorrectas);
        int cantidadIncorrectas = respuesta.cantidadIncorrectas(opcionesCorrectas);

        if(opcionesCorrectas.size() == cantidadCorrectas && cantidadIncorrectas == 0){
            respuesta.setPuntuacion(1);
        }
    }

    @Override
    public void puntuarOrderedChoice(Respuesta respuesta, List<Opcion> opcionesCorrectas){

        if(respuesta.opcionesEnOrden(opcionesCorrectas))
            respuesta.setPuntuacion(1);
    }

    @Override
    public void puntuarGroupChoice( Respuesta respuesta, List<Opcion> opcionesCorrectas){

        if( respuesta.contieneLasOpciones(opcionesCorrectas) ){
            respuesta.setPuntuacion(1);
        }
    }

    @Override
    public boolean admiteMultiplicador() {
        return false;
    }

    @Override
    public boolean admiteExclusividad(){
        return true;
    }
}