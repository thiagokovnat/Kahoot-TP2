package edu.fiuba.algo3.modelo.Pregunta;
import java.util.ArrayList;
import java.util.List;

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

    public String getRespuesta(int opcion){

        try{
            return opciones.get(opcion);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }

    }

    // Cambia el tipo de la pregunta a Verdadero/Falso Clasico.
    public void crearVerdaderoFalsoClasico(){

        this.tipoDePregunta = new VerdaderoFalsoClasico(this.respuestasCorrectas);

    }

    // Metodo de clase, instancia una Pregunta con su tipo seteado en Verdadero/Falso Clasico.
    public static Pregunta crearPreguntaVerdaderoFalsoClasico(String pregunta, List<String> opciones, List<String> respuestasCorrectas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opciones, respuestasCorrectas);
        nuevaPregunta.crearVerdaderoFalsoClasico();

        return nuevaPregunta;

    }
}
