package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.TipoDeEstado.Clasico;
import edu.fiuba.algo3.modelo.TipoDeEstado.Exclusivo;
import edu.fiuba.algo3.modelo.TipoDeEstado.TipoDeEstado;
import edu.fiuba.algo3.modelo.TipoDePregunta.*;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;


public class Pregunta {

    private String pregunta;
    private List<Opcion> opcionesDisponibles;
    private TipoDePregunta tipoDePregunta;
    private TipoDeEstado estado;


    private Pregunta(String pregunta, List<Opcion> opcionesDisponibles){

        this.pregunta = pregunta;
        this.opcionesDisponibles = new ArrayList<Opcion>(opcionesDisponibles);
        this.estado = new Clasico();
    }

    public Opcion getOpcion(int index){

        try{
            return opcionesDisponibles.get(index);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }
    }



    // Método de clase, instancia una Pregunta con su tipo seteado en Verdadero/Falso Clásico.
    public static Pregunta crearPreguntaVerdaderoFalsoClasico(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles);
        nuevaPregunta.tipoDePregunta = VerdaderoFalso.VerdaderoFalsoClasico(respuestasCorrectas);

        return nuevaPregunta;
    }

    // Método de clase, instancia una Pregunta con su tipo seteado en Verdadero/Falso con Penalidad.
    public static Pregunta crearPreguntaVerdaderoFalsoConPenalidad(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles);
        nuevaPregunta.tipoDePregunta = VerdaderoFalso.VerdaderoFalsoPenalidad(respuestasCorrectas);

        return nuevaPregunta;
    }

    public static Pregunta crearPreguntaMultipleChoiceClasico(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas) {

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles);
        nuevaPregunta.tipoDePregunta = MultipleChoice.MultipleChoiceClasico(respuestasCorrectas);

        return nuevaPregunta;
    }

    public static Pregunta crearPreguntaMultipleChoiceParcial(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas) {

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles);
        nuevaPregunta.tipoDePregunta = MultipleChoice.MultipleChoiceParcial(respuestasCorrectas);

        return nuevaPregunta;
    }

    public static Pregunta crearPreguntaMultipleChoicePenalidad(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas) {

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles);
        nuevaPregunta.tipoDePregunta = MultipleChoice.MultipleChoicePenalidad(respuestasCorrectas);

        return nuevaPregunta;
    }

    public static Pregunta crearPreguntaOrderedChoice(String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> respuestasCorrectas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesDisponibles);
        nuevaPregunta.tipoDePregunta = OrderedChoice.OrderedChoice(respuestasCorrectas);

        return nuevaPregunta;
    }

    public static Pregunta crearPreguntaGroupChoice( String pregunta, List<Opcion> opcionesDisponibles, List<Opcion> correctasGrupoUno, List<Opcion> correctasGrupoDos ){
        Pregunta nuevaPregunta = new Pregunta( pregunta, opcionesDisponibles );
        nuevaPregunta.tipoDePregunta = GroupChoice.GroupChoice( correctasGrupoUno, correctasGrupoDos );
        return nuevaPregunta;
    }

    public void puntuarRespuestas(List<Respuesta> respuestasElegidas){

        for(Respuesta respuesta : respuestasElegidas){
            this.estado.responder(respuesta, this.tipoDePregunta);
        }
    }

    public void setExclusividad(){

        this.estado = new Exclusivo();
    }
}