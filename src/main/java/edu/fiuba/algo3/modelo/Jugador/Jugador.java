package edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Constants.Constants;
import edu.fiuba.algo3.modelo.Exceptions.CantidadUsoMultiplicadorExcedidoException;
import edu.fiuba.algo3.modelo.Exceptions.PreguntaNoAdmiteMultiplicadorException;
import edu.fiuba.algo3.modelo.Multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX1;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;


public class Jugador {
    private String nickname;
    private int puntuacion;
    private Multiplicador multiplicador;
    private List<Multiplicador> multiplicadoresRestantes = new ArrayList<>();

    public Jugador(String nickname){
        this.nickname = nickname;
        this.puntuacion = 0;
        this.multiplicador = new MultiplicadorX1();
        this.agregarMultiplicadores();
    }

    public Respuesta responder(List<Opcion> opcionesElegidas){
        return new Respuesta(this, opcionesElegidas);
    }

    public void modificarPuntos(int puntos){
        puntuacion += this.multiplicador.aplicar(puntos);
        this.multiplicador = new MultiplicadorX1();
    }

    public int getPuntos(){
        return this.puntuacion;
    }

    private void usarMultiplicador(Multiplicador multiplicador){

       if(multiplicadoresRestantes.contains(multiplicador)){
           Multiplicador multiplicadorBuscado = multiplicadoresRestantes.get(multiplicadoresRestantes.indexOf(multiplicador));
           multiplicadoresRestantes.remove(multiplicador);
           this.multiplicador = multiplicadorBuscado;
       }
    }

    public Boolean multiplicadorDisponible(Multiplicador multiplicador){

        return multiplicadoresRestantes.contains(multiplicador);
    }

    public void activarMultiplicador(Multiplicador multiplicador, Pregunta pregunta) throws CantidadUsoMultiplicadorExcedidoException, PreguntaNoAdmiteMultiplicadorException {

        if(!pregunta.admiteMultiplicador()) {
            throw new PreguntaNoAdmiteMultiplicadorException();
        }
        if(!multiplicadorDisponible(multiplicador)) {
            throw new CantidadUsoMultiplicadorExcedidoException();
        }
        usarMultiplicador(multiplicador);
        this.multiplicador = multiplicador;
    }

    public String getNombre(){
        return this.nickname;
    }

    private void agregarMultiplicadores(){

        for (int i = 0; i < Constants.CANTIDAD_MULTIPLICADOR_DOBLE; i++) {
            multiplicadoresRestantes.add(new MultiplicadorX2());
        }

        for (int i = 0; i < Constants.CANTIDAD_MULTIPLICADOR_TRIPLE; i++) {
            multiplicadoresRestantes.add(new MultiplicadorX3());
        }
    }
}
