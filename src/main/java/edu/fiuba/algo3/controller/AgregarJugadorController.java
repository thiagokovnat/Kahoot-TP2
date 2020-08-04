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

public class AgregarJugadorController {

    @FXML
    public TextField textField;

    @FXML
    public Button confirmButton;

    @FXML
    public Button goBackButton;


    public void agregarJugador(ActionEvent event) {

        Juego juego = App.getJuego();

        if(!textField.getText().isEmpty()) {
            try {
                juego.crearJugador(textField.getText());
                Loader.cargarEscena("mainPage");
            } catch (CantidadMaximaDeJugadoresSuperadaException e) {
                Loader.cargarEscena("errorPage");
            }
        }
    }

    public void volverMenuPrincipal(ActionEvent event){
        Loader.cargarEscena("mainPage");
    }
}
