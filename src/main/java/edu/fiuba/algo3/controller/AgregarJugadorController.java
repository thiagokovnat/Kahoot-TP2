package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Exceptions.CantidadMaximaDeJugadoresSuperadaException;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.Loader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

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
        addPlayer.setDisable(!JuegoController.obtenerInstancia().sePuedenCrearJugadores());
    }

    public void agregarJugador(ActionEvent event) {

        Juego juego = JuegoController.obtenerInstancia();

        if (!textField.getText().isEmpty()){
            try {
                juego.crearJugador(textField.getText());
                textField.clear();
            } catch (CantidadMaximaDeJugadoresSuperadaException e) {
                Loader.cargarEscena("errorPage");
            }
            confirmButton.setDisable(juego.noHayPreguntasCargadas());
        }

        if(!juego.sePuedenCrearJugadores()) {
            addPlayer.setDisable(true);
        }
    }

    public void continuar(){
        JuegoController.comenzarJuego();
        Loader.cargarEscena("VFJuego");
    }

    public void volver(ActionEvent event){

        Juego juego = JuegoController.obtenerInstancia();

        juego.quitarJugadores();
        Loader.cargarEscena("mainPage");
    }
}
