package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSinGrupo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class VerdaderoFalsoController extends GeneralPreguntaController{

    @FXML
    Button opcionVerdadero;

    @FXML
    Button opcionFalso;


    public void onOpcionVerdadera(){

        this.opcionesSeleccionadas.add(new OpcionSinGrupo(opcionVerdadero.getText()));
    }

    public void onOpcionFalso(){
        this.opcionesSeleccionadas.add(new OpcionSinGrupo(opcionFalso.getText()));
    }
}
