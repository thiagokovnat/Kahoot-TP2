package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Juego.CantidadMaximaDeJugadoresSuperadaException;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.Loader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXML;
import edu.fiuba.algo3.vista.Loader;

public class AgregarJugadorController {

    @FXML
    public TextField textField;

    @FXML
    public Button addPlayer;

    @FXML
    public Button confirmButton;

    @FXML
    public Button goBackButton;

    // Verificamos al principio de instanciar el controlador si se pueden añadir jugadores.
    public void initialize(){

        confirmButton.setDisable(true);
        addPlayer.setDisable(!App.getJuego().sePuedenCrearJugadores());
    }

    public void agregarJugador(ActionEvent event) {

        Juego juego = App.getJuego();

        if (!textField.getText().isEmpty()){
            try {
                juego.crearJugador(textField.getText());
                textField.clear();
            } catch (CantidadMaximaDeJugadoresSuperadaException e) {
                Loader.cargarEscena("errorPage");
            }
            confirmButton.setDisable(false);
        }

        if(!juego.sePuedenCrearJugadores()) {
            addPlayer.setDisable(true);
        }
    }

    public void continuar(){

        Loader.cargarEscena("agregarPregunta");
    }

    public void volver(ActionEvent event){

        App.getJuego().quitarJugadores();
        Loader.cargarEscena("mainPage");
    }
}
