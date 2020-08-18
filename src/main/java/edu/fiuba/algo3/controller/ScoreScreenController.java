package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Comparator;
import java.util.List;


class comparadorJugadores implements Comparator<Jugador> {
    public int compare(Jugador uno, Jugador dos){
        return dos.getPuntos() - uno.getPuntos();
    }
}

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

        jugadores.sort(new comparadorJugadores());

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

        comenzarAnimacion();
    }

    public void comenzarAnimacion(){

        FadeTransition ftScore = new FadeTransition();
        ftScore.setNode(score1);
        ftScore.setFromValue(0.0);
        ftScore.setToValue(1.0);
        ftScore.setDuration(Duration.seconds(2));
        ftScore.play();

        FadeTransition ftPlayer = new FadeTransition();
        ftPlayer.setNode(player1);
        ftPlayer.setFromValue(0.0);
        ftPlayer.setToValue(1.0);
        ftPlayer.setDuration(Duration.seconds(2));
        ftPlayer.play();


        FadeTransition ftScoreDos = new FadeTransition();
        ftScoreDos.setNode(score2);
        ftScoreDos.setFromValue(0.0);
        ftScoreDos.setToValue(1.0);
        ftScoreDos.setDuration(Duration.seconds(1));
        ftScoreDos.play();

        FadeTransition ftPlayerDos = new FadeTransition();
        ftPlayerDos.setNode(player2);
        ftPlayerDos.setFromValue(0.0);
        ftPlayerDos.setToValue(1.0);
        ftPlayerDos.setDuration(Duration.seconds(1));
        ftPlayerDos.play();
    }

    public void exit(){
        Platform.exit();
        System.exit(0);
    }
}
