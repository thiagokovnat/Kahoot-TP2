package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {

    @Test
    public void unaPreguntaOrderedChoicePuedeCrearseIndicandoleRespuestasCorrectas(){

        String texto = "Ordenar los siguientes lenguajes por orden enseñado en Algoritmos 3";
        Opcion OpcionUno = new Opcion("Smalltalk");
        Opcion OpcionDos = new Opcion("Java");

        List<Opcion> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(OpcionUno);
        opcionesOrdenadas.add(OpcionDos);

        Pregunta pregunta = Pregunta.crearPreguntaOrderedChoiceClasico(texto, opcionesOrdenadas, opcionesOrdenadas);

        assertEquals(OpcionUno, pregunta.getRespuesta(0));

    }

    @Test
    public void unaPreguntaOrderedChoiceClasicoAsignaPuntajeCorrectamente(){

        String texto = "Ordenar los siguientes lenguajes por orden enseñado en Algoritmos 3";
        Opcion OpcionUno = new Opcion("Smalltalk");
        Opcion OpcionDos = new Opcion("Java");

        List<Opcion> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(OpcionUno);
        opcionesOrdenadas.add(OpcionDos);

        Pregunta pregunta = Pregunta.crearPreguntaOrderedChoiceClasico(texto, opcionesOrdenadas, opcionesOrdenadas);

        Jugador playerOne = new Jugador("Jugador1");
        Jugador playerTwo = new Jugador("Jugador2");

        List<Opcion> respuestasPlayerOne = new ArrayList<>(opcionesOrdenadas);

        List<Opcion> respuestasPlayerTwo = new ArrayList<>();
        respuestasPlayerTwo.add(OpcionDos);
        respuestasPlayerTwo.add(OpcionUno);

        List<Respuesta> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(playerOne.responder(respuestasPlayerOne));
        respuestasJugadores.add(playerTwo.responder(respuestasPlayerTwo));

        pregunta.puntuarRespuesta(respuestasJugadores);

        assertEquals(1, playerOne.getPuntos()); // Las ordeno bien
        assertEquals(0, playerTwo.getPuntos()); // Las ordeno mal
    }
}
