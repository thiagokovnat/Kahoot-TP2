package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Exceptions.PreguntaNoAdmiteMultiplicadorException;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Opcion.OpcionSinGrupo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultipleChoiceTest {

    @Test
    public void unaPreguntaMCClasicoPuedeCrearseIndicandoLasRespuestasCorrectas() {

        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("Smalltalk");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("Java");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("Python");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("C#");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opcionesCorrectas.add(opcionUno);
        opcionesCorrectas.add(opcionDos);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoiceClasico(textoPregunta, opciones, opcionesCorrectas);

        assertEquals(opcionUno, nuevaPregunta.getOpcion(0));
        assertEquals(opcionDos, nuevaPregunta.getOpcion(1));
    }

    @Test
    public void unaPreguntaMCClasicoAsignaCorrectamenteElPuntaje(){
        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("C++");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("Assembly");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("C");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("Java");
        OpcionSinGrupo opcionCinco = new OpcionSinGrupo("Smalltalk");

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

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoiceClasico(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno));
        respuestas.add(jugador2.responder(respuestaJugadorDos));

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(1, jugador2.getPuntos()); // Respondió todas bien.
        assertEquals(0, jugador1.getPuntos()); // No respondió todas bien.
    }

    @Test
    public void unaPreguntaMCClasicoNoAdmiteMultiplicador() {

        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("Smalltalk");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("Java");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("Python");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("C#");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opcionesCorrectas.add(opcionUno);
        opcionesCorrectas.add(opcionDos);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoiceClasico(textoPregunta, opciones, opcionesCorrectas);

        Jugador jugador1 = new Jugador("Jugador_1");

        assertFalse(nuevaPregunta.admiteMultiplicador());
        assertThrows(PreguntaNoAdmiteMultiplicadorException.class,
                ()->{
                    jugador1.activarMultiplicador(new MultiplicadorX2(), nuevaPregunta);
                });
        assertThrows(PreguntaNoAdmiteMultiplicadorException.class,
                ()->{
                    jugador1.activarMultiplicador(new MultiplicadorX3(), nuevaPregunta);
                });
    }

    @Test
    public void unaPreguntaMCParcialPuedeCrearseIndicandoLasRespuestasCorrectas() {

        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("Python");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("C#");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("Smalltalk");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("Java");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opcionesCorrectas.add(opcionTres);
        opcionesCorrectas.add(opcionCuatro);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoiceParcial(textoPregunta, opciones, opcionesCorrectas);

        assertEquals(opcionTres, nuevaPregunta.getOpcion(2));
        assertEquals(opcionCuatro, nuevaPregunta.getOpcion(3));
    }

    @Test
    public void unaPreguntaMCParcialAsignaCorrectamenteElPuntaje(){
        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("C++");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("Assembly");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("C");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("Java");
        OpcionSinGrupo opcionCinco = new OpcionSinGrupo("Smalltalk");

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

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoiceParcial(textoPregunta, opciones, opcionesCorrectas);

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

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("C++");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("Assembly");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("C");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("Java");
        OpcionSinGrupo opcionCinco = new OpcionSinGrupo("Smalltalk");

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

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoiceParcial(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno));
        respuestas.add(jugador2.responder(respuestaJugadorDos));

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(0, jugador1.getPuntos()); // Respondió solo una mal.
        assertEquals(0, jugador2.getPuntos()); // Respondió todas las incorrectas.
    }

    @Test
    public void unaPreguntaMCParcialNoAdmiteMultiplicador() {

        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("Python");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("C#");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("Smalltalk");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("Java");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opcionesCorrectas.add(opcionTres);
        opcionesCorrectas.add(opcionCuatro);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoiceParcial(textoPregunta, opciones, opcionesCorrectas);

        Jugador jugador1 = new Jugador("Jugador_1");

        assertFalse(nuevaPregunta.admiteMultiplicador());
        assertThrows(PreguntaNoAdmiteMultiplicadorException.class,
                ()->{
                    jugador1.activarMultiplicador(new MultiplicadorX2(), nuevaPregunta);
                });
        assertThrows(PreguntaNoAdmiteMultiplicadorException.class,
                ()->{
                    jugador1.activarMultiplicador(new MultiplicadorX3(), nuevaPregunta);
                });
    }

    @Test
    public void unaPreguntaMCconPenalidadPuedeCrearseIndicandoLasRespuestasCorrectas() {

        String textoPregunta = "¿Que números son primos?";

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("10");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("5");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("7");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("20");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opcionesCorrectas.add(opcionDos);
        opcionesCorrectas.add(opcionTres);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

        assertEquals(opcionDos, nuevaPregunta.getOpcion(1));
        assertEquals(opcionTres, nuevaPregunta.getOpcion(2));
    }

    @Test
    public void unaPreguntaMCconPenalidadAsignaCorrectamenteElPuntajeAQuienesNoContestaronMal(){
        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("C++");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("C##++++xxv2.0420_Xx");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("C#");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("Java");
        OpcionSinGrupo opcionCinco = new OpcionSinGrupo("C");
        OpcionSinGrupo opcionSeis = new OpcionSinGrupo("Smalltalk");


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

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

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

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("C++");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("C##++++xxv2.0420_Xx");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("C#");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("Java");
        OpcionSinGrupo opcionCinco = new OpcionSinGrupo("C");
        OpcionSinGrupo opcionSeis = new OpcionSinGrupo("Smalltalk");

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

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

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

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("C++");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("C##++++xxv2.0420_Xx");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("C#");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("Java");
        OpcionSinGrupo opcionCinco = new OpcionSinGrupo("C");
        OpcionSinGrupo opcionSeis = new OpcionSinGrupo("Smalltalk");

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

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno));
        respuestas.add(jugador2.responder(respuestaJugadorDos));

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(-4, jugador1.getPuntos()); // Respondió todas mal.
        assertEquals(-2, jugador2.getPuntos()); // Respondió todas las opciones posibles.
    }

    @Test
    public void unaPreguntaMCconPenalidadAdmiteMultiplicador(){
        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("C++");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("C#");
        OpcionSinGrupo opcionTres = new OpcionSinGrupo("Java");
        OpcionSinGrupo opcionCuatro = new OpcionSinGrupo("Smalltalk");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opcionesCorrectas.add(opcionTres);
        opcionesCorrectas.add(opcionCuatro);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

        assertTrue(nuevaPregunta.admiteMultiplicador());
    }
}