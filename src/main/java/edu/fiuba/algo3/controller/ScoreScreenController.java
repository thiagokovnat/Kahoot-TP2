package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class ScoreScreenController {

    @FXML
    Label player1;

    @FXML
    Label player2;

    @FXML
    Label score1;

    @FXML
    Label score2;

    private String ELIMINAR_TEXTO = "";

    public void initialize(){

        Juego juego = JuegoController.obtenerInstancia();
        List<Jugador> jugadores = juego.getJugadores();

        player1.setText(jugadores.get(0).getNombre());
        score1.setText(String.valueOf(jugadores.get(0).getPuntos()));

        // Evitamos acceder acá si no tenemos dos jugadores.
        if (jugadores.size() != 1) {
            player2.setText(jugadores.get(1).getNombre());
            score2.setText(String.valueOf(jugadores.get(1).getPuntos()));
        } else {
            player2.setText(ELIMINAR_TEXTO);
            score2.setText(ELIMINAR_TEXTO);
        }
    }

    public void exit(){
        Platform.exit();
        System.exit(0);
    }
}
