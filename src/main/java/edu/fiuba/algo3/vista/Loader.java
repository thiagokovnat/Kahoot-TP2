package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.stage.Stage;

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


}