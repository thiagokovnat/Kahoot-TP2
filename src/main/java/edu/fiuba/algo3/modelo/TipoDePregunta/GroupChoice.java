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

    private void setGrupo( List<Opcion> opciones, String grupo ){
        for( Opcion opcion : opciones ){
            opcion.setGrupo(grupo);
        }
    }

    private GroupChoice(List<Opcion> grupoUno, List<Opcion> grupoDos){
        setGrupo(grupoUno, "1");
        setGrupo(grupoDos, "2");
        this.opcionesCorrectas.addAll( grupoUno );
        this.opcionesCorrectas.addAll( grupoDos );
    }

    public static GroupChoice GroupChoice(List<Opcion> grupoUno, List<Opcion> grupoDos){
        GroupChoice nuevaPregunta = new GroupChoice( grupoUno, grupoDos );
        nuevaPregunta.modalidad = new Clasica();
        return nuevaPregunta;
    }

    public void puntuarRespuesta(Respuesta respuesta){
        this.modalidad.puntuarGroupChoice(respuesta, opcionesCorrectas);
    }

    public void puntuarRespuestaExclusiva(Respuesta respuesta){}

}
