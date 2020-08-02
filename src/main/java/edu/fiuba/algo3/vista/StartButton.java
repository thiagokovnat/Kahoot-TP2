package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class StartButton extends Button{

    private Stage stage;

    public StartButton(){

        super();
        this.stage = App.getStage();
        this.setText("Comenzar!");


    }


}
