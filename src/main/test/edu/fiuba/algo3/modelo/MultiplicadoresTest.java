package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.CantidadUsoMultiplicadorExcedidoException;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicadoresTest {

    @Test
    public void activarMultiplicadorX2ModificaCorrectamenteElPuntaje(){
        String textoPregunta = "¿Se aprueba el TP2?";

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        Jugador jugador1 = new Jugador("Jugador_1");

        Opcion opcionUno = new Opcion("Verdadero");
        Opcion opcionDos = new Opcion("Falso");

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);
        List<Opcion> respuestaJugadorUno = new ArrayList<Opcion>();
        respuestaJugadorUno.add(opcionUno);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoConPenalidad(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno));

        try{
            jugador1.activarMultiplicador(new MultiplicadorX2());
        }
        catch(CantidadUsoMultiplicadorExcedidoException e){
            e.printStackTrace();
        }

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(2, jugador1.getPuntos());
    }

    @Test
    public void unaPreguntaMCconPenalidadAsignaCorrectamenteElPuntaje(){
        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        Opcion opcionUno = new Opcion("C++");
        Opcion opcionDos = new Opcion("C##++++xxv2.0420_Xx");
        Opcion opcionTres = new Opcion("C#");
        Opcion opcionCuatro = new Opcion("Java");
        Opcion opcionCinco = new Opcion("C");
        Opcion opcionSeis = new Opcion("Smalltalk");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        Jugador jugador1 = new Jugador("Jugador_1");

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opciones.add(opcionCinco);
        opciones.add(opcionSeis);
        opcionesCorrectas.add(opcionCuatro);
        opcionesCorrectas.add(opcionSeis);

        List<Opcion> respuestaJugadorDos = new ArrayList<Opcion>();
        respuestaJugadorDos.add(opcionCuatro);
        respuestaJugadorDos.add(opcionSeis);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorDos));

        try{
            jugador1.activarMultiplicador(new MultiplicadorX3());
        }
        catch(CantidadUsoMultiplicadorExcedidoException e){
            e.printStackTrace();
        }

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(6, jugador1.getPuntos());
    }

    @Test
    public void unJugadorNoPuedeActivarTresVecesUnMultiplicadorX2(){

        Boolean lanzada = false;

        Jugador jugador1 = new Jugador("J1");

        try{
            jugador1.activarMultiplicador(new MultiplicadorX2());
        }
        catch(CantidadUsoMultiplicadorExcedidoException e){
            e.printStackTrace();
        }

        try{
            jugador1.activarMultiplicador(new MultiplicadorX2());
        }
        catch(CantidadUsoMultiplicadorExcedidoException e){
            e.printStackTrace();
        }

        try{
            jugador1.activarMultiplicador(new MultiplicadorX2());
        }
        catch(CantidadUsoMultiplicadorExcedidoException e){
            lanzada = true;
        }

        assertTrue(lanzada);
    }
}
