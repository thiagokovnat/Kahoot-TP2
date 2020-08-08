package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Juego.CantidadMaximaDeJugadoresSuperadaException;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSinGrupo;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
        Pregunta pregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico("Test", opciones, opciones);

        juego.agregarPregunta(pregunta);
        assertEquals(pregunta, juego.tomarPregunta());
    }
}
