package edu.fiuba.algo3.modelo.Ronda;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.OpcionSinGrupo;
import edu.fiuba.algo3.modelo.Pregunta.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RondaTest {

    @Test
    public void finalizarRondaPuntuaALosJugadores(){

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("Verdadero");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("Falso");

        CreadorDePreguntas fabrica = new CreadorDePreguntas();

        Pregunta pregunta =  fabrica.crearVerdaderoFalsoClasico("", List.of(opcionUno, opcionDos), List.of(opcionUno));

        Jugador player1 = new Jugador("Player");
        Ronda ronda = new Ronda(pregunta, List.of(player1));


        ronda.responder(List.of(opcionUno));
        ronda.finalizar();

        assertEquals(1, player1.getPuntos());
    }

    @Test
    public void pasarDeTurnoCambiaJugadorActual(){

        OpcionSinGrupo opcionUno = new OpcionSinGrupo("Verdadero");
        OpcionSinGrupo opcionDos = new OpcionSinGrupo("Falso");

        CreadorDePreguntas fabrica = new CreadorDePreguntas();

        Pregunta pregunta =  fabrica.crearVerdaderoFalsoClasico("", List.of(opcionUno, opcionDos), List.of(opcionUno));

        Jugador player1 = new Jugador("Player");
        Jugador player2 = new Jugador("Player2");
        Ronda ronda = new Ronda(pregunta, List.of(player1, player2));
        ronda.hayProximoTurno();

        assertEquals(player2, ronda.getJugadorActual());

    }
}
