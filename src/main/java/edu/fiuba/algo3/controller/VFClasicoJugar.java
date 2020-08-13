package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class VFClasicoJugar {

    @FXML
    TextField textField;

    public void initialize() {

        Juego juego = JuegoController.obtenerInstancia();

        Pregunta pregunta = juego.tomarPregunta();
        textField.setText(pregunta.getTexto()); 
        textField.setEditable(false);

    }

    public void volverMenuPrincipal(ActionEvent event){

        Juego juego = JuegoController.obtenerInstancia();

        juego.quitarJugadores();
        Loader.cargarEscena("mainPage");
    }

    public void seleccionarVerdadero(){}

    public void seleccionarFalso(){}
}
