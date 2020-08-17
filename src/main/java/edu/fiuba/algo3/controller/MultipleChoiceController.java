package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Constants.Constants;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSinGrupo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceController extends GeneralPreguntaController{

    @FXML
    Button opcionUno;

    @FXML
    Button opcionDos;

    @FXML
    Button opcionTres;

    @FXML
    Button opcionCuatro;

    @FXML
    Button opcionCinco;

    private List<Button> listaBotones = new ArrayList<>();

    private int cantidadOpciones = 0;

    protected void setUp(){
        iniciarBotones();
    }

    private void iniciarBotones(){

        listaBotones.add(opcionUno);
        listaBotones.add(opcionDos);
        listaBotones.add(opcionTres);
        listaBotones.add(opcionCuatro);
        listaBotones.add(opcionCinco);

        List<Opcion> opcionesPregunta = rondaActual.getOpciones();


        for(Opcion opcion : opcionesPregunta){
            listaBotones.get(cantidadOpciones).setText(opcion.getTexto());
            listaBotones.get(cantidadOpciones).setWrapText(true);
            cantidadOpciones++;
        }

        for (int j = cantidadOpciones; j < Constants.CANTIDAD_MAXIMA_OPCIONES; j++) {
                listaBotones.get(j).setVisible(false);
        }
    }

    public void onOpcionUno(){

        OpcionSinGrupo opcion = new OpcionSinGrupo(opcionUno.getText());
        opcionesSeleccionadas.add(opcion);
        opcionUno.setDisable(true);
    }

    public void onOpcionDos(){

        OpcionSinGrupo opcion = new OpcionSinGrupo(opcionDos.getText());
        opcionesSeleccionadas.add(opcion);
        opcionDos.setDisable(true);
    }

    public void onOpcionTres(){

        OpcionSinGrupo opcion = new OpcionSinGrupo(opcionTres.getText());
        opcionesSeleccionadas.add(opcion);
        opcionTres.setDisable(true);
    }

    public void onOpcionCuatro(){

        OpcionSinGrupo opcion = new OpcionSinGrupo(opcionCuatro.getText());
        opcionesSeleccionadas.add(opcion);
        opcionCuatro.setDisable(true);
    }

    public void onOpcionCinco(){

        OpcionSinGrupo opcion = new OpcionSinGrupo(opcionCinco.getText());
        opcionesSeleccionadas.add(opcion);
        opcionCinco.setDisable(true);
    }

}
