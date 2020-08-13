package edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Exceptions.CantidadUsoMultiplicadorExcedidoException;
import edu.fiuba.algo3.modelo.Exceptions.PreguntaNoAdmiteMultiplicadorException;
import edu.fiuba.algo3.modelo.Multiplicador.Multiplicador;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX1;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;

import java.util.HashMap;
import java.util.List;


public class Jugador {
    private String nickname;
    private int puntuacion;
    private Multiplicador multiplicador;
    private HashMap<String, Integer> usosMultiplicadores = new HashMap<>();

    public Jugador(String nickname){
        this.nickname = nickname;
        this.puntuacion = 0;
        this.multiplicador = new MultiplicadorX1();
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

    public void usarMultiplicador(Multiplicador multiplicador){

        int usosDisponibles = usosMultiplicadores.get(multiplicador.getIdentificador());

        if(usosDisponibles > 0)
            usosMultiplicadores.put(multiplicador.getIdentificador(), usosDisponibles - 1);
    }

    public Boolean multiplicadorDisponible(Multiplicador multiplicador){

        if(!usosMultiplicadores.containsKey(multiplicador.getIdentificador())) {
            usosMultiplicadores.put(multiplicador.getIdentificador(), multiplicador.getCantidadUsosPermitidos());
            return true;
        }

        int usosDisponibles = usosMultiplicadores.get(multiplicador.getIdentificador());

        return usosDisponibles > 0;

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
}
