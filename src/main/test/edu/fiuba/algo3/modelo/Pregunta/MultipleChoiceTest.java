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

        assertEquals(opcionUno, nuevaPregunta.getOpcion(0));
        assertEquals(opcionDos, nuevaPregunta.getOpcion(1));
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
        respuestas.add(jugador1.responder(respuestaJugadorUno));
        respuestas.add(jugador2.responder(respuestaJugadorDos));

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(1, jugador2.getPuntos()); // Respondió todas bien.
        assertEquals(0, jugador1.getPuntos()); // No respondió todas bien.
    }

    @Test
    public void unaPreguntaMCParcialPuedeCrearseIndicandoLasRespuestasCorrectas() {

        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        Opcion opcionUno = new Opcion("Python");
        Opcion opcionDos = new Opcion("C#");
        Opcion opcionTres = new Opcion("Smalltalk");
        Opcion opcionCuatro = new Opcion("Java");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opcionesCorrectas.add(opcionTres);
        opcionesCorrectas.add(opcionCuatro);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoiceParcial(textoPregunta, opciones, opcionesCorrectas);

        assertEquals(opcionTres, nuevaPregunta.getOpcion(2));
        assertEquals(opcionCuatro, nuevaPregunta.getOpcion(3));
    }

    @Test
    public void unaPreguntaMCParcialAsignaCorrectamenteElPuntaje(){
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

        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoiceParcial(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno));
        respuestas.add(jugador2.responder(respuestaJugadorDos));

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntos()); // Respondió una bien.
        assertEquals(2, jugador2.getPuntos()); // Respondió todas (dos) bien.
    }

    @Test
    public void unaPreguntaMCParcialAsignaCorrectamenteElPuntajeAJugadoresQueRespondieronMal(){
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
        respuestaJugadorUno.add(opcionUno);
        List<Opcion> respuestaJugadorDos = new ArrayList<Opcion>();
        respuestaJugadorUno.add(opcionUno);
        respuestaJugadorUno.add(opcionDos);
        respuestaJugadorUno.add(opcionTres);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoiceParcial(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno));
        respuestas.add(jugador2.responder(respuestaJugadorDos));

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntos()); // Respondió solo una mal.
        assertEquals(0, jugador2.getPuntos()); // Respondió todas las incorrectas.
    }

    @Test
    public void unaPreguntaMCconPenalidadPuedeCrearseIndicandoLasRespuestasCorrectas() {

        String textoPregunta = "¿Que números son primos?";

        Opcion opcionUno = new Opcion("10");
        Opcion opcionDos = new Opcion("5");
        Opcion opcionTres = new Opcion("7");
        Opcion opcionCuatro = new Opcion("20");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opcionesCorrectas.add(opcionDos);
        opcionesCorrectas.add(opcionTres);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

        assertEquals(opcionDos, nuevaPregunta.getOpcion(1));
        assertEquals(opcionTres, nuevaPregunta.getOpcion(2));
    }

    @Test
    public void unaPreguntaMCconPenalidadAsignaCorrectamenteElPuntajeAQuienesNoContestaronMal(){
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
        Jugador jugador2 = new Jugador("Jugador_2");

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opciones.add(opcionCinco);
        opciones.add(opcionSeis);
        opcionesCorrectas.add(opcionCuatro);
        opcionesCorrectas.add(opcionSeis);

        List<Opcion> respuestaJugadorUno = new ArrayList<Opcion>();
        respuestaJugadorUno.add(opcionCuatro);

        List<Opcion> respuestaJugadorDos = new ArrayList<Opcion>();
        respuestaJugadorDos.add(opcionCuatro);
        respuestaJugadorDos.add(opcionSeis);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno));
        respuestas.add(jugador2.responder(respuestaJugadorDos));
        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(1, jugador1.getPuntos()); // Respondió una bien.
        assertEquals(2, jugador2.getPuntos()); // Respondió todas (dos) bien.
    }

    @Test
    public void unaPreguntaMCconPenalidadAsignaCorrectamenteElPuntajeCuandoEsteResultaSerNulo(){
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
        Jugador jugador2 = new Jugador("Jugador_2");

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opciones.add(opcionCinco);
        opciones.add(opcionSeis);
        opcionesCorrectas.add(opcionCuatro);
        opcionesCorrectas.add(opcionSeis);

        List<Opcion> respuestaJugadorUno = new ArrayList<Opcion>();
        respuestaJugadorUno.add(opcionTres);
        respuestaJugadorUno.add(opcionCuatro);

        List<Opcion> respuestaJugadorDos = new ArrayList<Opcion>(); //Verificamos que funciona con un jugador sin respuestas.

        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno));
        respuestas.add(jugador2.responder(respuestaJugadorDos));
        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntos()); // Respondió una mal y una bien.
        assertEquals(0, jugador2.getPuntos()); // No respondió.
    }

    @Test
    public void unaPreguntaMCconPenalidadAsignaCorrectamenteElPuntajeCuandoResultaNegativo(){
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
        Jugador jugador2 = new Jugador("Jugador_2");

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opciones.add(opcionCinco);
        opciones.add(opcionSeis);
        opcionesCorrectas.add(opcionCuatro);
        opcionesCorrectas.add(opcionSeis);

        List<Opcion> respuestaJugadorUno = new ArrayList<Opcion>();
        respuestaJugadorUno.add(opcionUno);
        respuestaJugadorUno.add(opcionDos);
        respuestaJugadorUno.add(opcionTres);
        respuestaJugadorUno.add(opcionCinco);

        List<Opcion> respuestaJugadorDos = new ArrayList<Opcion>();
        respuestaJugadorDos.add(opcionUno);
        respuestaJugadorDos.add(opcionDos);
        respuestaJugadorDos.add(opcionTres);
        respuestaJugadorDos.add(opcionCinco);
        respuestaJugadorDos.add(opcionCuatro);
        respuestaJugadorDos.add(opcionSeis);


        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno));
        respuestas.add(jugador2.responder(respuestaJugadorDos));

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(-4, jugador1.getPuntos()); // Respondió todas mal.
        assertEquals(-2, jugador2.getPuntos()); // Respondió todas las opciones posibles.
    }
}