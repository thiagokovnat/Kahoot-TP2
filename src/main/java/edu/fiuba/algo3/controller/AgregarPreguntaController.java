package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Pair;

import java.util.List;

public class AgregarPreguntaController {

    @FXML
    public Button VFClasico;

    @FXML
    public Button VFPenalidad;

    @FXML
    public Button MCClasico;

    @FXML
    public Button MCParcial;

    @FXML
    public Button MCPenalidad;

    @FXML
    public Button OrderedChoice;

    @FXML
    public Button GroupChoice;

    public void onVFClasico(ActionEvent event){
        Loader.cargarEscena("VFClasico");
    }

    public void onVFPenalidad(){}

    public void onMCClasico(){}

    public void onMCPenalidad(){}

    public void onMCParcial(){}

    public void volver(ActionEvent event){

        App.getJuego().quitarJugadores();
        Loader.cargarEscena("mainPage");
    }
}
