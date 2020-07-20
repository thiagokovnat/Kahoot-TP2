package edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;


public class Jugador {
    private String nickname;
    private int puntuacion;
    /*private Bonificacion bonificacion;
    falta implementar la clase Bonificacion pero lo dejo para no olvidarlo a futuro */

    public Respuesta responder(Pregunta unaPregunta, int opcion){

        String opcionesElegidas = elegirOpciones(unaPregunta, opcion);

        return new Respuesta(this, opcionesElegidas);
    }

    public void modificarPuntos(int puntos){

        puntuacion += puntos;
    }

    // tal vez, en un futuro sea mas optimo cambiar el tipo de dato a List<String>, por ahora solo es un string
    // para pasar las primeras pruebas.
    private String elegirOpciones(Pregunta unaPregunta, int opcion){
        
        return unaPregunta.getRespuesta(opcion);
    }
}