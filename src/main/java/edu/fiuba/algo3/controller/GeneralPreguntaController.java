package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Exceptions.CantidadUsoMultiplicadorExcedidoException;
import edu.fiuba.algo3.modelo.Exceptions.PreguntaNoAdmiteMultiplicadorException;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Ronda.Ronda;
import edu.fiuba.algo3.vista.Loader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public abstract class GeneralPreguntaController {

    @FXML
    Button confirmarRespuesta;

    @FXML
    Text textoPregunta;

    @FXML
    Button multiplicadorDoble;

    @FXML
    Button multiplicadorTriple;

    @FXML
    Button activarExclusividad;

    @FXML
    TextField nombreJugadorActual;

    protected static Ronda rondaActual = JuegoController.getProximaRonda();

    protected List<Opcion> opcionesSeleccionadas;

    public void initialize(){

        opcionesSeleccionadas = new ArrayList<>();
        multiplicadorDoble.setDisable(!rondaActual.getJugadorActual().multiplicadorDisponible(new MultiplicadorX2()));
        multiplicadorTriple.setDisable(!rondaActual.getJugadorActual().multiplicadorDisponible(new MultiplicadorX3()));
        activarExclusividad.setDisable(!rondaActual.admiteExclusividad());
        textoPregunta.setText(rondaActual.getTextoPregunta());
    }

    public void onConfirmarRespuesta(){

        rondaActual.responder(opcionesSeleccionadas);

        if(rondaActual.hayProximoTurno()) {
            Loader.cargarEscena("VFJuego");
        }
        else if(!JuegoController.estaTerminado()){
            rondaActual = JuegoController.getProximaRonda();
            Loader.cargarEscena("VFJuego");
        }
        else{
            Loader.cargarEscena("mainPage");
        }

    }

    public void onMultiplicadorDoble(){

        try{
            rondaActual.activarMultiplicador(new MultiplicadorX2());
        }
        catch(CantidadUsoMultiplicadorExcedidoException | PreguntaNoAdmiteMultiplicadorException e){
            Loader.cargarEscena("errorPage.fxml");
        }
    }

    public void onMultiplicadorTriple(){

        try{
            rondaActual.activarMultiplicador(new MultiplicadorX3());
        }
        catch(CantidadUsoMultiplicadorExcedidoException | PreguntaNoAdmiteMultiplicadorException e){
            Loader.cargarEscena("errorPage.fxml");
        }
    }

    public void onExclusividad(){
        this.rondaActual.setExclusividad();
    }
}
