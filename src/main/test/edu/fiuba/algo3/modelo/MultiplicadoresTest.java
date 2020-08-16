package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Exceptions.CantidadUsoMultiplicadorExcedidoException;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionConGrupo;


import edu.fiuba.algo3.modelo.Opcion.OpcionSinGrupo;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
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

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("Verdadero");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("Falso");

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);
        List<Opcion> respuestaJugadorUno = new ArrayList<Opcion>();
        respuestaJugadorUno.add(opcionUno);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearVerdaderoFalsoPenalidad(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorUno));

        try{
            jugador1.activarMultiplicador(new MultiplicadorX2(), nuevaPregunta);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(2, jugador1.getPuntos());
    }

    @Test
    public void activarMultiplicadorX3ModificaCorrectamenteElPuntaje(){
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

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearMultipleChoicePenalidad(textoPregunta, opciones, opcionesCorrectas);

        List<Respuesta> respuestas = new ArrayList<>();
        respuestas.add(jugador1.responder(respuestaJugadorDos));

        try{
            jugador1.activarMultiplicador(new MultiplicadorX3(), nuevaPregunta);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(6, jugador1.getPuntos());
    }

    @Test
    public void unJugadorNoPuedeActivarTresVecesUnMultiplicadorX2(){
        String textoPregunta = "¿Se aprueba el TP2?";

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        Jugador jugador1 = new Jugador("Jugador_1");

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("Verdadero");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("Falso");

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearVerdaderoFalsoPenalidad(textoPregunta, opciones, opcionesCorrectas);

        assertThrows(CantidadUsoMultiplicadorExcedidoException.class,
                ()->{
                    jugador1.activarMultiplicador(new MultiplicadorX2(), nuevaPregunta);
                    jugador1.activarMultiplicador(new MultiplicadorX2(), nuevaPregunta);
                    jugador1.activarMultiplicador(new MultiplicadorX2(), nuevaPregunta);
                });
    }
}
