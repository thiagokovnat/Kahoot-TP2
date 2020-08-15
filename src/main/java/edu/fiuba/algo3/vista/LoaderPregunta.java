package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controller.JuegoController;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Ronda.Ronda;

public class LoaderPregunta {

    public static void cargarProximoTurno(){

        Ronda ronda = JuegoController.getRondaActual();

        cargarEscena(ronda.getPregunta());
    }

    public static void cargarProximaPregunta(){

        Ronda ronda = JuegoController.getProximaRonda();

        cargarEscena(ronda.getPregunta());

    }

    private static void cargarEscena(Pregunta pregunta){

       String className = pregunta.getTipo().getClass().getSimpleName();
       Loader.cargarEscena(getFileName(className));

    }

    private static String getFileName(String className){

        switch(className){
            case "VerdaderoFalso":
                return ConstantesVista.VERDADEROFALSO;

            case "MultipleChoice":
                return ConstantesVista.MULTIPLECHOICE;

            case "OrderedChoice":
                return ConstantesVista.ORDEREDCHOICE;

            case "GroupChoice":
                return ConstantesVista.GROUPCHOICE;

        }

        return "";
    }
}
