package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VerdaderoFalsoClasicoTest {

    @Test
    public void unaPreguntaVFClasicoPuedeIndicandoLaRespuestaCorrecta(){

        String textoPregunta = "¿Se aprueba el TP2?";
        String opcionUno = "Verdadero", opcionDos = "Falso";

        List<String> opciones = new ArrayList<>();
        List<String> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(textoPregunta, opciones, opcionesCorrectas);

        assertEquals("Verdadero", nuevaPregunta.getRespuesta(0));

    }

    @Test
    public void unaPreguntaVFClasicoAsignaCorrectamenteElPunjateACadaJugadorQueRepondioBien(){
        String textoPregunta = "¿Se aprueba el TP2?";
        String opcionUno = "Verdadero", opcionDos = "Falso";

        List<String> opciones = new ArrayList<>();
        List<String> opcionesCorrectas = new ArrayList<>();

        Jugador jugador1 = new Jugador("Jugador_1");
        Jugador jugador2 = new Jugador("Jugador_2");

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(nuevaPregunta,0)); // Responde bien
        respuestas.add(jugador2.responder(nuevaPregunta,1)); // Responde mal

        nuevaPregunta.puntuarRespuesta(respuestas);

        assertEquals(1, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }
}