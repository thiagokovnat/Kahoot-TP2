package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.PreguntaNoAdmiteMultiplicadorException;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerdaderoFalsoTest {

    @Test
    public void unaPreguntaVFClasicoPuedeCrearseIndicandoLaRespuestaCorrecta(){

        String textoPregunta = "¿Se aprueba el TP2?";
        OpcionConGrupo opcionUno = new OpcionConGrupo("Verdadero");
        OpcionConGrupo opcionDos = new OpcionConGrupo("Falso");

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

        OpcionConGrupo opcionUno = new OpcionConGrupo("Verdadero");
        OpcionConGrupo opcionDos = new OpcionConGrupo("Falso");

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

    @Test
    public void unaPreguntaVFClasicoNoAdmiteMultiplicador(){

        String textoPregunta = "¿Se aprueba el TP2?";
        OpcionConGrupo opcionUno = new OpcionConGrupo("Verdadero");
        OpcionConGrupo opcionDos = new OpcionConGrupo("Falso");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(textoPregunta, opciones, opcionesCorrectas);

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

    // Tests VF con Penalidad
    @Test
    public void unaPreguntaVFConPenalidadPuedeCrearseIndicandoLaRespuestaCorrecta(){

        String textoPregunta = "¿Se aprueba el TP2?";
        OpcionConGrupo opcionUno = new OpcionConGrupo("Verdadero");
        OpcionConGrupo opcionDos = new OpcionConGrupo("Falso");

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

        OpcionConGrupo opcionUno = new OpcionConGrupo("Verdadero");
        OpcionConGrupo opcionDos = new OpcionConGrupo("Falso");

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

    @Test
    public void unaPreguntaVFConPenalidadAdmiteMultiplicador(){

        String textoPregunta = "¿Se aprueba el TP2?";
        OpcionConGrupo opcionUno = new OpcionConGrupo("Verdadero");
        OpcionConGrupo opcionDos = new OpcionConGrupo("Falso");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoConPenalidad(textoPregunta, opciones, opcionesCorrectas);

        assertTrue(nuevaPregunta.admiteMultiplicador());
    }
}