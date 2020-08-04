package edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX1;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.List;


public class Jugador {
    private String nickname;
    private int puntuacion;
    private Multiplicador multiplicador;

    public Jugador(String nickname){
        this.nickname = nickname;
        this.puntuacion = 0;
        this.multiplicador = new MultiplicadorX1();
    }

    public Respuesta responder(List<Opcion> opcionesElegidas){
        return new Respuesta(this, opcionesElegidas);
    }

    // Luke: "Sugiero separar en 2 métodos para aumentar/reducir la puntuación
    //        o sino usar constantes para pasar los puntajes '+1' o '-1'"
    public void modificarPuntos(int puntos){
        puntuacion += this.multiplicador.aplicar(puntos);
        this.multiplicador = new MultiplicadorX1();
    }

    public int getPuntos(){
        return this.puntuacion;
    }

    public void activarMultiplicador(Multiplicador multiplicador){
        this.multiplicador = multiplicador;
    }
}
