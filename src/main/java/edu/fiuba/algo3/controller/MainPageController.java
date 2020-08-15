package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.vista.ConstantesVista;
import edu.fiuba.algo3.vista.Loader;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainPageController {

    @FXML
    AnchorPane  rootPane;

    @FXML
    AnchorPane parentContainer;

    public void comenzarJuego(){

        Loader.cargarEscenaConAnimacion(ConstantesVista.AGREGARJUGADOR, rootPane, parentContainer);
    }

    public void agregarPreguntas(){

        Loader.cargarEscena("agregarPregunta");
    }
}
