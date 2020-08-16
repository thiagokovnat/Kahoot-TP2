package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionSinGrupo;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.vista.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.util.ArrayList;
import java.util.List;

public class FormularioPreguntaController {

    @FXML
    TextField campoPregunta;

    @FXML
    Button toggleOpcionUno;

    @FXML
    Button toggleOpcionDos;

    @FXML
    Button terminar;

    private List<Opcion> opcionesDisponibles = new ArrayList<>();
    private List<Opcion> opcionesCorrectas = new ArrayList<>();

    public void initialize(){

        OpcionSinGrupo verdadero = new OpcionSinGrupo("Verdadero");
        OpcionSinGrupo falso = new OpcionSinGrupo("Falso");

        terminar.setDisable(true);
        
        opcionesDisponibles.add(verdadero);
        opcionesDisponibles.add(falso);
    }
    public void onOpcionUnoCorrecta(ActionEvent event){

        if (!campoPregunta.getText().isEmpty()) {
            OpcionSinGrupo opcionVerdadera = new OpcionSinGrupo("Verdadero");
            opcionesCorrectas.add(opcionVerdadera);
            toggleOpcionUno.setVisible(false);
            toggleOpcionDos.setVisible(false);
            terminar.setDisable(false);
        }
    }

    public void onOpcionDosCorrecta(ActionEvent event){

        if (!campoPregunta.getText().isEmpty()) {
            OpcionSinGrupo opcionFalsa = new OpcionSinGrupo("Falso");
            opcionesCorrectas.add(opcionFalsa);
            toggleOpcionUno.setVisible(false);
            toggleOpcionDos.setVisible(false);
            terminar.setDisable(false);
        }
    }

    public void onEnter(ActionEvent event){

        String texto = null;

        if(!campoPregunta.getText().isEmpty() && !opcionesCorrectas.isEmpty())
            texto = campoPregunta.getText();
        else{
            Loader.cargarEscena("errorPage");
            return;
        }

        Pregunta pregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(texto, opcionesDisponibles, opcionesCorrectas);

        Juego juego = JuegoController.obtenerInstancia();
        juego.agregarPregunta(pregunta);

        Loader.cargarEscena("mainPage");

    }
}
