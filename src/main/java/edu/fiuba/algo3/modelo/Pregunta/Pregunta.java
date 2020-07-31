package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.TipoDeEstado.Clasico;
import edu.fiuba.algo3.modelo.TipoDeEstado.Exclusivo;
import edu.fiuba.algo3.modelo.TipoDeEstado.TipoDeEstado;
import edu.fiuba.algo3.modelo.TipoDePregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.TipoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.TipoDePregunta.VerdaderoFalso;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;


public class Pregunta {

    private String pregunta;
    private List<Opcion> opcionesDisponibles;
    private List<Opcion> respuestasCorrectas;
    private TipoDePregunta tipoDePregunta;
    private TipoDeEstado estado;


    private Pregunta(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){

        this.pregunta = pregunta;
        this.opcionesDisponibles = new ArrayList<Opcion>(opcionesDisponibles);
        this.respuestasCorrectas = new ArrayList<Opcion>();
        this.respuestasCorrectas.addAll(respuestasCorrectas);
        this.estado = new Clasico();
    }

    public Opcion getRespuesta(int index){

        try{
            return opcionesDisponibles.get(index);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }
    }

    // Método de clase, instancia una Pregunta con su tipo seteado en Verdadero/Falso Clásico.
    public static Pregunta crearPreguntaVerdaderoFalsoClasico(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles, respuestasCorrectas);
        nuevaPregunta.tipoDePregunta = VerdaderoFalso.VerdaderoFalsoClasico(nuevaPregunta.respuestasCorrectas);

        return nuevaPregunta;
    }

    // Método de clase, instancia una Pregunta con su tipo seteado en Verdadero/Falso con Penalidad.
    public static Pregunta crearPreguntaVerdaderoFalsoConPenalidad(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles, respuestasCorrectas);
        nuevaPregunta.tipoDePregunta = VerdaderoFalso.VerdaderoFalsoPenalidad(nuevaPregunta.respuestasCorrectas);

        return nuevaPregunta;
    }

    public static Pregunta crearPreguntaMultipleChoiceClasico(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas) {

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles, respuestasCorrectas);
        nuevaPregunta.tipoDePregunta = MultipleChoice.MultipleChoiceClasico(nuevaPregunta.respuestasCorrectas);

        return nuevaPregunta;
    }

    public static Pregunta crearPreguntaMultipleChoiceParcial(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas) {

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles, respuestasCorrectas);
        nuevaPregunta.tipoDePregunta = MultipleChoice.MultipleChoiceParcial(nuevaPregunta.respuestasCorrectas);

        return nuevaPregunta;
    }

    public static Pregunta crearPreguntaMultipleChoicePenalidad(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas) {

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles, respuestasCorrectas);
        nuevaPregunta.tipoDePregunta = MultipleChoice.MultipleChoicePenalidad(nuevaPregunta.respuestasCorrectas);

        return nuevaPregunta;
    }

    public static Pregunta crearPreguntaOrderedChoiceClasico(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles, respuestasCorrectas);
        nuevaPregunta.tipoDePregunta = OrderedChoice.OrderedChoiceClasico(nuevaPregunta.respuestasCorrectas);

        return nuevaPregunta;
    }

    public void puntuarRespuesta(List<Respuesta> respuestasElegidas){

        for(Respuesta respuesta : respuestasElegidas){
            this.estado.responder(respuesta, this.tipoDePregunta);
        }
    }

    public void setExclusividad(){

        this.estado = new Exclusivo();
    }
}