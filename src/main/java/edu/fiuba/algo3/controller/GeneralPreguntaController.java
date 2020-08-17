package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Exceptions.CantidadUsoMultiplicadorExcedidoException;
import edu.fiuba.algo3.modelo.Exceptions.PreguntaNoAdmiteMultiplicadorException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Ronda.Ronda;
import edu.fiuba.algo3.modelo.TipoDePregunta.MultipleChoice;
import edu.fiuba.algo3.vista.ConstantesVista;
import edu.fiuba.algo3.vista.Loader;
import edu.fiuba.algo3.vista.LoaderPregunta;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public abstract class GeneralPreguntaController {

    @FXML
    Button confirmarRespuesta;

    @FXML
    Label textoPregunta;

    @FXML
    Button multiplicadorDoble;

    @FXML
    Button multiplicadorTriple;

    @FXML
    Button activarExclusividad;

    @FXML
    TextField nombreJugadorActual;

    @FXML
    Label counter;

    @FXML
    Label nombreJugador;

    protected static Ronda rondaActual;

    protected List<Opcion> opcionesSeleccionadas;

    protected Timeline timeline;

    protected Timeline counterTimeLine;

    protected Integer segundosCounter = 30;

    public void initialize(){

        comenzarAnimaciones();

        rondaActual = JuegoController.getRondaActual();

        boolean sePuedeUsarElMultiplicadorX2 = !rondaActual.sePuedeActivarMultiplicador(new MultiplicadorX2());

        boolean sePuedeUsarElMultiplicadorX3 = !rondaActual.sePuedeActivarMultiplicador(new MultiplicadorX3());

        boolean sePuedeUsarLaExclusividad = !rondaActual.admiteExclusividad();

        String playerName = rondaActual.getJugadorActual().getNombre();
        nombreJugador.setText("Turno: " + playerName);

        counter.setText(segundosCounter.toString());

        timeline = new Timeline(new KeyFrame(Duration.millis(30000), ae -> onConfirmarRespuesta()));
        timeline.play();

        counterTimeLine = new Timeline(new KeyFrame(Duration.millis(1000), ae -> modificarContador()));
        counterTimeLine.setCycleCount(Animation.INDEFINITE);
        counterTimeLine.play();

        opcionesSeleccionadas = new ArrayList<>();
        multiplicadorDoble.setDisable(sePuedeUsarElMultiplicadorX2);
        multiplicadorTriple.setDisable(sePuedeUsarElMultiplicadorX3);
        activarExclusividad.setDisable(sePuedeUsarLaExclusividad);
        textoPregunta.setText(rondaActual.getTextoPregunta());
        textoPregunta.setWrapText(true);

        this.setUp();

    }

    private void comenzarAnimaciones(){

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1));
        fadeIn.setNode(nombreJugador);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.setCycleCount(2);
        fadeIn.setAutoReverse(false);
        fadeIn.play();
    }

    protected abstract void setUp();

    public void onConfirmarRespuesta(){

        timeline.stop();

        rondaActual.responder(opcionesSeleccionadas);

        if(rondaActual.hayProximoTurno()) {
            LoaderPregunta.cargarProximoTurno();
        }
        else if(!JuegoController.estaTerminado()){
            LoaderPregunta.cargarProximaPregunta();
        }
        else{

            Loader.cargarEscena(ConstantesVista.LEADERBOARD);
        }

    }

    public void onMultiplicadorDoble(){

        try{
            rondaActual.activarMultiplicador(new MultiplicadorX2());
        }
        catch(CantidadUsoMultiplicadorExcedidoException | PreguntaNoAdmiteMultiplicadorException e){
            Loader.cargarEscena(ConstantesVista.ERROR);
        }

        multiplicadorDoble.setDisable(true);
    }

    public void onMultiplicadorTriple(){

        try{
            rondaActual.activarMultiplicador(new MultiplicadorX3());
        }
        catch(CantidadUsoMultiplicadorExcedidoException | PreguntaNoAdmiteMultiplicadorException e){
            Loader.cargarEscena(ConstantesVista.ERROR);
        }

        multiplicadorTriple.setDisable(true);
    }

    public void onExclusividad(){
        this.rondaActual.setExclusividad();
        activarExclusividad.setDisable(true);
    }

    public void modificarContador(){

        segundosCounter--;

        counter.setText(segundosCounter.toString());

        if(segundosCounter <= 10){
            FadeTransition ft = new FadeTransition(Duration.seconds(1));
            ft.setNode(counter);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.play();
            counter.setTextFill(Color.GOLD);
        }
    }

}
