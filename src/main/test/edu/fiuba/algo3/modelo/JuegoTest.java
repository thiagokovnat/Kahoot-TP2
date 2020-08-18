package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Exceptions.CantidadMaximaDeJugadoresSuperadaException;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSinGrupo;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class JuegoTest {

    @Test
    public void sePasaDeLosJugadoresMaximos(){

        Juego juego = Juego.obtenerInstancia();


        assertThrows(CantidadMaximaDeJugadoresSuperadaException.class, ()-> {
            juego.crearJugador("jugador_1");
            juego.crearJugador("Jugador_2");
            juego.crearJugador("jugador_3");});
    }

    @Test
    public void preguntaSeAgregaCorrectamente(){
        Juego juego = Juego.obtenerInstancia();

        OpcionSinGrupo opcion = new OpcionSinGrupo("unaOpcion");
        List<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta pregunta = fabrica.crearVerdaderoFalsoClasico("Test", opciones, opciones);

        juego.agregarPregunta(pregunta);
        assertEquals(pregunta, juego.tomarPregunta());
    }

    @Test
    public void juegoConRondasRestantesNoEstaTermiando(){

        Juego juego = Juego.obtenerInstancia();

        CreadorDePreguntas fabrica = new CreadorDePreguntas();

        OpcionSinGrupo opcion = new OpcionSinGrupo("Verdadero");
        try {
            juego.crearJugador("A");
        } catch (CantidadMaximaDeJugadoresSuperadaException e) {
            e.printStackTrace();
        }

        Pregunta pregunta1 = fabrica.crearVerdaderoFalsoClasico("", List.of(opcion), List.of(opcion));
        Pregunta pregunta2 = fabrica.crearVerdaderoFalsoClasico("", List.of(opcion), List.of(opcion));
        juego.comenzarJuego();

        assertFalse(juego.estaTerminado());

        }
    }

