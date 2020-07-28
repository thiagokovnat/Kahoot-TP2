package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.TipoDeEstado.Clasico;
import edu.fiuba.algo3.modelo.TipoDeEstado.Exclusivo;
import edu.fiuba.algo3.modelo.TipoDeEstado.TipoDeEstado;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;



public class Pregunta {

    private String pregunta;
    private List<Opcion> opciones;
    private List<Opcion> respuestasCorrectas;
    private TipoDePregunta tipoDePregunta;
    private TipoDeEstado estado;

    public Pregunta(String pregunta, List<Opcion> opciones, List<Opcion> respuestasCorrectas){

        this.pregunta = pregunta;
        this.opciones = new ArrayList<Opcion>(opciones);
        this.respuestasCorrectas = new ArrayList<Opcion>();
        this.respuestasCorrectas.addAll(respuestasCorrectas);
        this.estado = new Clasico();
    }

    public Opcion getRespuesta(int index){

        try{
            return opciones.get(index);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }
    }

    // Método de clase, instancia una Pregunta con su tipo seteado en Verdadero/Falso Clásico.
    public static Pregunta crearPreguntaVerdaderoFalsoClasico(String pregunta, List<Opcion> opciones, List<Opcion> respuestasCorrectas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opciones, respuestasCorrectas);
        nuevaPregunta.tipoDePregunta = VerdaderoFalso.VerdaderoFalsoClasico(nuevaPregunta.respuestasCorrectas);

        return nuevaPregunta;
    }

    // Método de clase, instancia una Pregunta con su tipo seteado en Verdadero/Falso con Penalidad.
    public static Pregunta crearPreguntaVerdaderoFalsoConPenalidad(String pregunta, List<Opcion> opciones, List<Opcion> respuestasCorrectas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opciones, respuestasCorrectas);
        nuevaPregunta.tipoDePregunta = VerdaderoFalso.VerdaderoFalsoPenalidad(nuevaPregunta.respuestasCorrectas);

        return nuevaPregunta;
    }

    public void puntuarRespuesta(List<Respuesta> respuestas){

        for(Respuesta respuesta : respuestas){
            this.estado.responder(respuesta, this.tipoDePregunta);
        }

    }

    public void setExclusividad() {
        this.estado = new Exclusivo();
    }
}