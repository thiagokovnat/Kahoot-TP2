package edu.fiuba.algo3;

import edu.fiuba.algo3.controller.JuegoController;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.Loader;
import edu.fiuba.algo3.vista.StartButton;
import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
;import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage stage;


    @Override
    public void start(Stage stage) {

        App.stage = stage;
        JuegoController.iniciarJuego();

        stage.setTitle("Algohoot!");
        stage.setResizable(false);

        URL path = App.class.getResource("/images/icon.png");
        stage.getIcons().add(new Image(path.toExternalForm()));

        Loader.cargarEscena("mainPage");

    }

    public static void main(String[] args) {

        launch();
    }

    public static Stage getStage(){
        return stage;
    }


}