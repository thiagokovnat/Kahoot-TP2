package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSinGrupo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalsoController extends GeneralPreguntaController{

    @FXML
    Button opcionVerdadero;

    @FXML
    Button opcionFalso;


    protected void setUp(){

        opcion1.setText(opcionVerdadero.getText());
        opcion2.setText(opcionFalso.getText());
    }


    public void onOpcionVerdadera(){

        this.opcionesSeleccionadas.add(new OpcionSinGrupo(opcionVerdadero.getText()));
        opcionVerdadero.setDisable(true);
        opcionFalso.setDisable(true);
    }

    public void onOpcionFalso(){
        this.opcionesSeleccionadas.add(new OpcionSinGrupo(opcionFalso.getText()));
        opcionVerdadero.setDisable(true);
        opcionFalso.setDisable(true);
    }
}
