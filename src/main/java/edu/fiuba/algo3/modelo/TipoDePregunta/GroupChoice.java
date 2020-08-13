package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Modalidad.Clasica;
import edu.fiuba.algo3.modelo.Modalidad.ModalidadGroupChoice;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class GroupChoice implements TipoDePregunta {

    private ModalidadGroupChoice modalidad;
    private List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();


    private GroupChoice(List<Opcion> opcionesCorrectas){

        this.opcionesCorrectas.addAll( opcionesCorrectas );
    }

    public static GroupChoice GroupChoice(List<Opcion> opcionesCorrectas){
        GroupChoice nuevaPregunta = new GroupChoice( opcionesCorrectas );
        nuevaPregunta.modalidad = new Clasica();
        return nuevaPregunta;
    }

    @Override
    public void puntuarRespuesta(Respuesta respuesta){
        this.modalidad.puntuarGroupChoice(respuesta, opcionesCorrectas);
    }

    @Override
    public boolean admiteMultiplicador() {
        return modalidad.admiteMultiplicador();
    }

    @Override
    public boolean admiteExclusividad(){
        return this.modalidad.admiteExclusividad();
    }
}
