package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.vista.ConstantesVista;
import edu.fiuba.algo3.vista.Loader;
import javafx.fxml.FXML;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

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
