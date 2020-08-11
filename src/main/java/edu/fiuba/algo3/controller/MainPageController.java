package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.vista.Loader;

public class MainPageController {

    public void comenzarJuego(){

        Loader.cargarEscena("addPlayer");
    }

    public void agregarPreguntas(){

        Loader.cargarEscena("agregarPregunta");
    }
}
