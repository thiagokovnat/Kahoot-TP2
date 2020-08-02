package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AddPlayerButton extends Button {

    private Stage stage;

    public AddPlayerButton(){

        super();
        this.stage = App.getStage();
        this.setText("Agregar jugador");


    }


}
