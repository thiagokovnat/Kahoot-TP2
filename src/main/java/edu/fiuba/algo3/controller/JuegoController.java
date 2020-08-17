package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Exceptions.ArchivoInvalidoException;
import edu.fiuba.algo3.modelo.ImportadorPregunta.ImportadorPreguntaXML;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Ronda.Ronda;
import edu.fiuba.algo3.vista.ConstantesVista;
import edu.fiuba.algo3.vista.Loader;

import java.io.IOException;
import java.util.List;

public class JuegoController {

    private static Juego juego;

    public static void iniciarJuego(){

        JuegoController.juego = Juego.obtenerInstancia();
        List<Pregunta> preguntas = null;
        try {
            preguntas = ImportadorPreguntaXML.importarPreguntas(ConstantesVista.ARCHIVOPREGUNTAS);
        } catch (ArchivoInvalidoException | IOException e) {
            Loader.cargarEscena(ConstantesVista.ERROR);
        }

        for(Pregunta pregunta : preguntas)
            juego.agregarPregunta(pregunta);
    }

    public static Juego obtenerInstancia(){
        return juego;
    }

    public static void comenzarJuego(){
        juego.comenzarJuego();
    }

    public static Ronda getProximaRonda(){
        return juego.getProximaRonda();
    }

    public static boolean estaTerminado(){
        return juego.estaTerminado();
    }

    public static Ronda getRondaActual(){
        return juego.getRondaActual();
    }

    public static List<Jugador> getJugadores(){
        return juego.getJugadores();
    }


}
