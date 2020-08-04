package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.Loader;
import edu.fiuba.algo3.vista.StartButton;
import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage stage;
    private static Juego juego = Juego.obtenerInstancia();

    @Override
    public void start(Stage stage) {

        App.stage = stage;

        stage.setTitle("Algohoot!");
        stage.getIcons().add(new Image("../../../../resources/images/icon.png"));
        Loader.cargarEscena("mainPage");

    }

    public static void main(String[] args) {

        launch();
    }

    public static Stage getStage(){
        return stage;
    }

    public static Juego getJuego(){
        return juego;
    }




}