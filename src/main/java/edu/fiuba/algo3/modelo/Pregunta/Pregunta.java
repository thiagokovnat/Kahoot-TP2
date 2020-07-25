package edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso.VerdaderoFalsoClasico;

public class Pregunta {

    private String pregunta;
    private List<String> opciones;
    private List<String> respuestasCorrectas;
    private TipoDePregunta tipoDePregunta;

    public Pregunta(String pregunta, List<String> opciones, List<String> respuestasCorrectas){

        this.pregunta = pregunta;
        this.opciones = new ArrayList<String>(opciones);
        this.respuestasCorrectas = new ArrayList<String>(respuestasCorrectas);

    }

    public String getRespuesta(int index){

        try{
            return opciones.get(index);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }

    }

    // Cambia el tipo de la pregunta a Verdadero/Falso Clásico.
    public void crearVerdaderoFalsoClasico(){

        this.tipoDePregunta = VerdaderoFalsoClasico(this.respuestasCorrectas);

    }

    // Cambia el tipo de la pregunta a Verdadero/Falso con Penalidad.
    public void crearVerdaderoFalsoPenalidad(){

        this.tipoDePregunta = VerdaderoFalsoClasico(this.respuestasCorrectas);

    }

    // Método de clase, instancia una Pregunta con su tipo seteado en Verdadero/Falso Clásico.
    public static Pregunta crearPreguntaVerdaderoFalsoClasico(String pregunta, List<String> opciones, List<String> respuestasCorrectas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opciones, respuestasCorrectas);
        nuevaPregunta.crearVerdaderoFalsoClasico();

        return nuevaPregunta;

    }

    public void puntuarRespuesta(List<Respuesta> respuestas){

        for(Respuesta respuesta : respuestas){
            this.tipoDePregunta.puntuarRespuesta(respuesta);
        }

    }
}