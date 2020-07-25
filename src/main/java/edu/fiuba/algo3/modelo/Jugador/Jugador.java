package edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.List;


public class Jugador {
    private String nickname;
    private int puntuacion;
    /* private Bonificacion bonificacion;
    falta implementar la clase Bonificacion pero lo dejo para no olvidarlo a futuro */

    public Jugador(String nickname){

        this.nickname = nickname;
        this.puntuacion = 0;
    }

    public Respuesta responder(Pregunta unaPregunta, List<Opcion> opcion){
        return new Respuesta(this, opcion);
    }

    public void modificarPuntos(int puntos){

        puntuacion += puntos;
    }

    // tal vez, en un futuro sea mas optimo cambiar el tipo de dato a List<String>, por ahora solo es un string
    // para pasar las primeras pruebas.
    private Opcion elegirOpcion(Pregunta unaPregunta, int opcion){

        return unaPregunta.getRespuesta(opcion);
    }

    public int getPuntos(){
        return this.puntuacion;
    }
}