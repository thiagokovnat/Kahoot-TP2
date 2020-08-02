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
    public void unaPreguntaVFClasicoPuedeCrearseIndicandoLaRespuestaCorrecta(){

        String textoPregunta = "¿Se aprueba el TP2?";
        Opcion opcionUno = new Opcion("Verdadero");
        Opcion opcionDos = new Opcion("Falso");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(textoPregunta, opciones, opcionesCorrectas);

        assertEquals(opcionUno, nuevaPregunta.getOpcion(0));

    }

    @Test
    public void unaPreguntaVFClasicoAsignaCorrectamenteElPuntaje(){
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
        respuestas.add(jugador1.responder(respuestaJugadorUno)); // Responde bien
        respuestas.add(jugador2.responder(respuestaJugadorDos)); // Responde mal

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }

    // Tests VF con Penalidad
    @Test
    public void unaPreguntaVFConPenalidadPuedeCrearseIndicandoLaRespuestaCorrecta(){

        String textoPregunta = "¿Se aprueba el TP2?";
        Opcion opcionUno = new Opcion("Verdadero");
        Opcion opcionDos = new Opcion("Falso");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoConPenalidad(textoPregunta, opciones, opcionesCorrectas);

        assertEquals(opcionUno, nuevaPregunta.getOpcion(0));

    }

    @Test
    public void unaPreguntaVFConPenalidadAsignaCorrectamenteElPuntaje(){
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

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoConPenalidad(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno)); // Responde bien
        respuestas.add(jugador2.responder(respuestaJugadorDos)); // Responde mal

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntos());
        assertEquals(-1, jugador2.getPuntos());
    }
}