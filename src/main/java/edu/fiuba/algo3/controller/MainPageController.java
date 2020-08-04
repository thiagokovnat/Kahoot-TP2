package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.vista.Loader;

public class MainPageController {

    public void comenzarJuego(){

        System.out.println("Comienza el juego");
    }

    public void agregarJugador(){

        Loader.cargarEscena("addPlayer");
    }

    public void agregarPregunta(){

        Loader.cargarEscena("agregarPregunta");
    }
}
