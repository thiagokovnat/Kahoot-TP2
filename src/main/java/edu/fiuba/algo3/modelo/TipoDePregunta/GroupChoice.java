package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Modalidad.Clasica;
import edu.fiuba.algo3.modelo.Modalidad.Modalidad;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class GroupChoice implements TipoDePregunta {

    private Modalidad modalidad;
    private List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();


    private GroupChoice(List<Opcion> opcionesCorrectas){

        this.opcionesCorrectas.addAll( opcionesCorrectas );
    }

    public static GroupChoice GroupChoice(List<Opcion> opcionesCorrectas){
        GroupChoice nuevaPregunta = new GroupChoice( opcionesCorrectas );
        nuevaPregunta.modalidad = new Clasica();
        return nuevaPregunta;
    }

    public void puntuarRespuesta(Respuesta respuesta){
        this.modalidad.puntuarGroupChoice(respuesta, opcionesCorrectas);
    }

    @Override
    public boolean admiteMultiplicador() {
        return modalidad.admiteMultiplicador();
    }

}
