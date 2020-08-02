package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.fiuba.algo3.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class AddQuestionButton extends Button {

    private Stage stage;

    public AddQuestionButton(){
        super();
        this.stage = App.getStage();
        this.setText("Agregar Preguntas");


    }


}
