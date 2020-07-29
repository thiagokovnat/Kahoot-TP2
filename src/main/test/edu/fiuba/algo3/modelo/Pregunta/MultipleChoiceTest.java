package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleChoiceTest {

    @Test
    public void unaPreguntaMCClasicoPuedeCrearseIndicandoLasRespuestasCorrectas() {

        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        Opcion opcionUno = new Opcion("Smalltalk");
        Opcion opcionDos = new Opcion("Java");
        Opcion opcionTres = new Opcion("Python");
        Opcion opcionCuatro = new Opcion("C#");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opcionesCorrectas.add(opcionUno);
        opcionesCorrectas.add(opcionDos);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoiceClasico(textoPregunta, opciones, opcionesCorrectas);

        assertEquals(opcionUno, nuevaPregunta.getRespuesta(0));
        assertEquals(opcionDos, nuevaPregunta.getRespuesta(1));
    }

    @Test
    public void unaPreguntaMCClasicoAsignaCorrectamenteElPuntaje(){
        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        Opcion opcionUno = new Opcion("C++");
        Opcion opcionDos = new Opcion("Assembly");
        Opcion opcionTres = new Opcion("C");
        Opcion opcionCuatro = new Opcion("Java");
        Opcion opcionCinco = new Opcion("Smalltalk");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        Jugador jugador1 = new Jugador("Jugador_1");
        Jugador jugador2 = new Jugador("Jugador_2");

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opciones.add(opcionCinco);
        opcionesCorrectas.add(opcionCuatro);
        opcionesCorrectas.add(opcionCinco);

        List<Opcion> respuestaJugadorUno = new ArrayList<Opcion>();
        respuestaJugadorUno.add(opcionCuatro);
        List<Opcion> respuestaJugadorDos = new ArrayList<Opcion>();
        respuestaJugadorDos.add(opcionCuatro);
        respuestaJugadorDos.add(opcionCinco);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoiceClasico(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(nuevaPregunta,respuestaJugadorUno));
        respuestas.add(jugador2.responder(nuevaPregunta,respuestaJugadorDos));

        nuevaPregunta.puntuarRespuesta(respuestas);

        assertEquals(1, jugador2.getPuntos()); // Respondió todas bien.
        assertEquals(0, jugador1.getPuntos()); // No respondió todas bien.
    }
}