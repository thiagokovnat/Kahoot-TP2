package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.vista.Loader;

public class MainPageController {

    public void comenzarJuego(){

        Loader.cargarEscena("VFJuego");
    }

    public void agregarJugador(){

        Loader.cargarEscena("addPlayer");
    }

    public void agregarPregunta(){

        Loader.cargarEscena("agregarPregunta");
    }
}
