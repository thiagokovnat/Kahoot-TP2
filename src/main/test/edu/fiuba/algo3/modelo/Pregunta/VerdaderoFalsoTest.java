package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VerdaderoFalsoTest {

    @Test
    public void unaPreguntaVFClasicoPuedeIndicandoLaRespuestaCorrecta(){

        String textoPregunta = "¿Se aprueba el TP2?";
        Opcion opcionUno = new Opcion("Verdadero");
        Opcion opcionDos = new Opcion("Falso");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(textoPregunta, opciones, opcionesCorrectas);

        assertEquals(opcionUno, nuevaPregunta.getRespuesta(0));

    }

    @Test
    public void unaPreguntaVFClasicoAsignaCorrectamenteElPunjateACadaJugadorQueRepondioBien(){
        String textoPregunta = "¿Se aprueba el TP2?";

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        Jugador jugador1 = new Jugador("Jugador_1");
        Jugador jugador2 = new Jugador("Jugador_2");

        Opcion opcionUno = new Opcion("Verdadero");
        Opcion opcionDos = new Opcion("Falso");

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);
        List<Opcion> respuestaJugadorUno = new ArrayList<Opcion>();
        respuestaJugadorUno.add(opcionUno);
        List<Opcion> respuestaJugadorDos = new ArrayList<Opcion>();
        respuestaJugadorDos.add(opcionDos);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(nuevaPregunta,respuestaJugadorUno)); // Responde bien
        respuestas.add(jugador2.responder(nuevaPregunta,respuestaJugadorDos)); // Responde mal

        nuevaPregunta.puntuarRespuesta(respuestas);

        assertEquals(1, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }
}