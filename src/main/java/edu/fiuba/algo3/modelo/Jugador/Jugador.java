package edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;

import java.util.List;


public class Jugador {
    private String nickname;
    private int puntuacion;
    /* private Multiplicador multiplicador;
    falta implementar la clase Multiplicador pero lo dejo para no olvidarlo a futuro */

    public Jugador(String nickname){
        this.nickname = nickname;
        this.puntuacion = 0;
    }

    public Respuesta responder(List<Opcion> opcionesElegidas){
        return new Respuesta(this, opcionesElegidas);
    }

    // Luke: "Sugiero separar en 2 métodos para aumentar/reducir la puntuación
    //        o sino usar constantes para pasar los puntajes '+1' o '-1'"
    public void modificarPuntos(int puntos){
        puntuacion += puntos;
    }

    public int getPuntos(){
        return this.puntuacion;
    }
}