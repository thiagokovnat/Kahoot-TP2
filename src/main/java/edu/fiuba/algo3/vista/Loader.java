package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.App;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Loader {

    private static FXMLLoader loader;

    private Loader() {
    }

    private static void loadFXML(String fileName){
        URL path = App.class.getResource("/vista/" + fileName + ".fxml");
        loader = new FXMLLoader(path);
    }
    public static void cargarEscena(String escena){


        loadFXML(escena);

        Parent mainNode = null;

        try{
            mainNode = loader.load();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        Scene scene = new Scene(mainNode);
        Stage stage = App.getStage();
        stage.setScene(scene);
        stage.show();

    }

    public static void cargarEscenaConAnimacion(String escena, AnchorPane rootPane, AnchorPane parentContainer){

        Scene scene = rootPane.getScene();

        loadFXML(escena);
        Parent mainNode = null;

        try{
            mainNode = loader.load();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        mainNode.translateXProperty().set(scene.getWidth());

        rootPane.getChildren().add(mainNode);

        Timeline timeline = new Timeline();

        FadeTransition ft = new FadeTransition(Duration.seconds(1), parentContainer);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();

        KeyValue kv = new KeyValue(mainNode.translateXProperty(),0, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);

        timeline.setOnFinished(t -> {rootPane.getChildren().remove(parentContainer);});

        timeline.play();

    }


}