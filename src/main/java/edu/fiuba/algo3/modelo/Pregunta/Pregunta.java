package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Exceptions.PreguntaNoAdmiteExclusividadException;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.TipoDeEstado.Clasico;
import edu.fiuba.algo3.modelo.TipoDeEstado.Exclusivo;
import edu.fiuba.algo3.modelo.TipoDeEstado.ExclusivoDoble;
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
        nuevaPregunta.tipoDePregunta = VerdaderoFalso.VerdaderoFalsoConPenalidad(respuestasCorrectas);

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

    public static Pregunta crearPreguntaOrderedChoice(String pregunta, List<Opcion> opcionesOrdenadas){

        Pregunta nuevaPregunta = new Pregunta(pregunta, opcionesOrdenadas);
        nuevaPregunta.tipoDePregunta = OrderedChoice.OrderedChoice(opcionesOrdenadas);

        return nuevaPregunta;
    }

    public static Pregunta crearPreguntaGroupChoice(String pregunta, List<Opcion> opcionesDisponibles ){
        Pregunta nuevaPregunta = new Pregunta( pregunta, opcionesDisponibles );
        nuevaPregunta.tipoDePregunta = GroupChoice.GroupChoice( opcionesDisponibles );
        return nuevaPregunta;
    }

    public void puntuarRespuestas(List<Respuesta> respuestasElegidas){

        for(Respuesta respuesta : respuestasElegidas){
            this.tipoDePregunta.puntuarRespuesta(respuesta);
        }

        this.estado.asignarPuntaje(respuestasElegidas);
    }

    public boolean admiteMultiplicador() {
        return tipoDePregunta.admiteMultiplicador();
    }

    public String getTexto(){

        return this.pregunta;
    }

    public void setExclusividad() throws PreguntaNoAdmiteExclusividadException {

        if(!admiteExclusividad())
            throw new PreguntaNoAdmiteExclusividadException();

        if(!this.estado.esExclusivo())
            this.estado = new Exclusivo();
        else
            this.estado = new ExclusivoDoble();
    }

    public boolean admiteExclusividad(){
        return this.tipoDePregunta.admiteExclusividad();
    }

    public List<Opcion> getOpciones() {

        return opcionesDisponibles;
    }

    public TipoDePregunta getTipo(){
        return this.tipoDePregunta;
    }
}