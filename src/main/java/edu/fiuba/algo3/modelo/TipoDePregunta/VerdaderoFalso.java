package edu.fiuba.algo3.modelo.TipoDePregunta;

import edu.fiuba.algo3.modelo.Modalidad.Clasica;
import edu.fiuba.algo3.modelo.Modalidad.Modalidad;
import edu.fiuba.algo3.modelo.Modalidad.Penalidad;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalso implements TipoDePregunta{

    private Modalidad modalidad;
    private List<Opcion> opcionesCorrectas = new ArrayList<Opcion>();

    // Recibe una lista de las respuestas correctas y crea la pregunta guardando dichas respuestas.
    private VerdaderoFalso(List<Opcion> opcionesCorrectas) {

        this.opcionesCorrectas.addAll(opcionesCorrectas);
    }

    // Devuelve una instancia de VF clásico dada una lista de respuestas correctas.
    public static VerdaderoFalso VerdaderoFalsoClasico(List<Opcion> opcionesCorrectas){

        VerdaderoFalso nuevaPregunta = new VerdaderoFalso(opcionesCorrectas);
        nuevaPregunta.modalidad = new Clasica();
        return nuevaPregunta;
    }

    // Devuelve una instancia de VF con penalidad dada una lista de respuestas correctas.
    public static VerdaderoFalso VerdaderoFalsoConPenalidad(List<Opcion> opcionesCorrectas){

        VerdaderoFalso nuevaPregunta = new VerdaderoFalso(opcionesCorrectas);
        nuevaPregunta.modalidad = new Penalidad();
        return nuevaPregunta;
    }

    // Puntúa la respuesta del jugador de forma correspondiente al tipo de pregunta del mismo.
    public void puntuarRespuesta(Respuesta respuesta) {
        this.modalidad.puntuarVerdaderoFalso(respuesta, opcionesCorrectas);
    }

    public void puntuarRespuestaExclusiva(Respuesta respuesta){}
}
