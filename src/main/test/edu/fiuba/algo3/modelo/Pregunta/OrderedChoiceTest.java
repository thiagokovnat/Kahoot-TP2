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

public class OrderedChoiceTest {

    @Test
    public void unaPreguntaOrderedChoicePuedeCrearseIndicandoleRespuestasCorrectas(){

        String texto = "Ordenar los siguientes lenguajes por orden enseñado en Algoritmos 3";
        OpcionConGrupo OpcionUno = new OpcionConGrupo("Smalltalk");
        OpcionConGrupo OpcionDos = new OpcionConGrupo("Java");

        List<Opcion> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(OpcionUno);
        opcionesOrdenadas.add(OpcionDos);

        Pregunta pregunta = Pregunta.crearPreguntaOrderedChoice(texto, opcionesOrdenadas, opcionesOrdenadas);

        assertEquals(OpcionUno, pregunta.getOpcion(0));

    }

    @Test
    public void unaPreguntaOrderedChoiceClasicoAsignaPuntajeCorrectamente(){

        String texto = "Ordenar los siguientes lenguajes por orden enseñado en Algoritmos 3";
        OpcionConGrupo OpcionUno = new OpcionConGrupo("Smalltalk");
        OpcionConGrupo OpcionDos = new OpcionConGrupo("Java");

        List<Opcion> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(OpcionUno);
        opcionesOrdenadas.add(OpcionDos);

        Pregunta pregunta = Pregunta.crearPreguntaOrderedChoice(texto, opcionesOrdenadas, opcionesOrdenadas);

        Jugador JugadorUno = new Jugador("Jugador1");
        Jugador JugadorDos = new Jugador("Jugador2");

        List<Opcion> respuestasJugadorUno = new ArrayList<>(opcionesOrdenadas);

        List<Opcion> respuestasJugadorDos = new ArrayList<>();
        respuestasJugadorDos.add(OpcionDos);
        respuestasJugadorDos.add(OpcionUno);

        List<Respuesta> respuestasJugadores = new ArrayList<>();
        respuestasJugadores.add(JugadorUno.responder(respuestasJugadorUno));
        respuestasJugadores.add(JugadorDos.responder(respuestasJugadorDos));

        pregunta.puntuarRespuestas(respuestasJugadores);

        assertEquals(1, JugadorUno.getPuntos()); // Las ordeno bien
        assertEquals(0, JugadorDos.getPuntos()); // Las ordeno mal
    }

    @Test
    public void unaPreguntaOrderedChoiceNoAdmiteMultiplicador(){

        String texto = "Ordenar los siguientes lenguajes por orden enseñado en Algoritmos 3";
        OpcionConGrupo OpcionUno = new OpcionConGrupo("Smalltalk");
        OpcionConGrupo OpcionDos = new OpcionConGrupo("Java");

        List<Opcion> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(OpcionUno);
        opcionesOrdenadas.add(OpcionDos);

        Pregunta pregunta = Pregunta.crearPreguntaOrderedChoice(texto, opcionesOrdenadas, opcionesOrdenadas);

        Jugador jugador1 = new Jugador("Jugador_1");

        assertFalse(pregunta.admiteMultiplicador());
        assertThrows(PreguntaNoAdmiteMultiplicadorException.class,
                ()->{
                    jugador1.activarMultiplicador(new MultiplicadorX2(), pregunta);
                });
        assertThrows(PreguntaNoAdmiteMultiplicadorException.class,
                ()->{
                    jugador1.activarMultiplicador(new MultiplicadorX3(), pregunta);
                });
    }
}
