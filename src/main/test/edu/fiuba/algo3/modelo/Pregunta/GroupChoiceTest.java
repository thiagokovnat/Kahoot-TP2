package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Exceptions.PreguntaNoAdmiteMultiplicadorException;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Multiplicador.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupChoiceTest {

    @Test
    public void unaPreguntaGroupChoicePuedeCrearseIndicandoLasRespuestasCorrectas(){

        String texto = "Poner en el grupo 1 los lenguajes de tipado estático, y en el grupo 2 los de tipado dinámico:";

        OpcionConGrupo opcionUno = new OpcionConGrupo( "Java");
        OpcionConGrupo opcionDos = new OpcionConGrupo( "C");
        OpcionConGrupo opcionTres = new OpcionConGrupo( "Smalltalk");
        OpcionConGrupo opcionCuatro = new OpcionConGrupo( "Python");


        opcionUno.setGrupo("1");
        opcionDos.setGrupo("1");
        opcionTres.setGrupo("2");
        opcionCuatro.setGrupo("2");

        List<Opcion> opcionesDisponibles = new ArrayList<Opcion>();

        opcionesDisponibles.add(opcionUno);
        opcionesDisponibles.add(opcionDos);
        opcionesDisponibles.add(opcionTres);
        opcionesDisponibles.add(opcionCuatro);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta pregunta = fabrica.crearGroupChoice(texto, opcionesDisponibles);

        assertEquals( opcionUno, pregunta.getOpcion(0) );
        assertEquals( opcionDos, pregunta.getOpcion(1) );
        assertEquals( opcionTres, pregunta.getOpcion(2) );
        assertEquals( opcionCuatro, pregunta.getOpcion(3) );
    }

    @Test
    public void unaPreguntaGroupChoiceAsignaCorrectamenteElPuntaje(){
        String texto = "Poner en el grupo 1 los lenguajes de tipado estático, y en el grupo 2 los de tipado dinámico:";

        OpcionConGrupo opcionUnoBien = new OpcionConGrupo( "Java" );
        OpcionConGrupo opcionDosBien = new OpcionConGrupo( "C" );
        OpcionConGrupo opcionTresBien = new OpcionConGrupo( "Smalltalk" );
        OpcionConGrupo opcionCuatroBien = new OpcionConGrupo( "Python" );

        OpcionConGrupo opcionUnoMal = new OpcionConGrupo( "Java" );
        OpcionConGrupo opcionDosMal = new OpcionConGrupo( "C" );
        OpcionConGrupo opcionTresMal = new OpcionConGrupo( "Smalltalk" );
        OpcionConGrupo opcionCuatroMal = new OpcionConGrupo( "Python" );

        opcionUnoBien.setGrupo("1");
        opcionDosBien.setGrupo("1");
        opcionTresBien.setGrupo("2");
        opcionCuatroBien.setGrupo("2");

        opcionUnoMal.setGrupo("2");
        opcionDosMal.setGrupo("2");
        opcionTresMal.setGrupo("1");
        opcionCuatroMal.setGrupo("1");

        List<Opcion> opcionesDisponibles = new ArrayList<Opcion>();

        opcionesDisponibles.add(opcionUnoBien);
        opcionesDisponibles.add(opcionDosBien);
        opcionesDisponibles.add(opcionTresBien);
        opcionesDisponibles.add(opcionCuatroBien);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta nuevaPregunta = fabrica.crearGroupChoice(texto, opcionesDisponibles);

        Jugador jugadorUno = new Jugador("Jugador_1");
        Jugador jugadorDos = new Jugador("Jugador_2");

        List<Respuesta> respuestas = new ArrayList<>();

        // Todas las opciones de jugador 1 estan bien
        List<Opcion> respuestaJugadorUno = new ArrayList<Opcion>();
        respuestaJugadorUno.add( opcionUnoBien );
        respuestaJugadorUno.add( opcionDosBien );
        respuestaJugadorUno.add( opcionTresBien );
        respuestaJugadorUno.add( opcionCuatroBien );

        // Cambio de grupo para el jugador 2

        List<Opcion> respuestaJugadorDos = new ArrayList<Opcion>();
        respuestaJugadorDos.add( opcionUnoMal );
        respuestaJugadorDos.add( opcionDosMal );
        respuestaJugadorDos.add( opcionTresMal );
        respuestaJugadorDos.add( opcionCuatroMal );

        respuestas.add( jugadorUno.responder(respuestaJugadorUno) );
        respuestas.add( jugadorDos.responder(respuestaJugadorDos) );

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(1, jugadorUno.getPuntos()); // respondio bien
        assertEquals(0, jugadorDos.getPuntos()); // respondio mal
    }

    @Test
    public void unaPreguntaGroupChoiceNoAdmiteMultiplicadores(){

        String texto = "Poner en el grupo 1 los lenguajes de tipado estático, y en el grupo 2 los de tipado dinámico:";

        OpcionConGrupo opcionUno = new OpcionConGrupo( "Java" );
        OpcionConGrupo opcionDos = new OpcionConGrupo( "C" );
        OpcionConGrupo opcionTres = new OpcionConGrupo( "Smalltalk" );
        OpcionConGrupo opcionCuatro = new OpcionConGrupo( "Python" );

        List<Opcion> opcionesDisponibles = new ArrayList<Opcion>();

        opcionesDisponibles.add(opcionUno);
        opcionesDisponibles.add(opcionDos);
        opcionesDisponibles.add(opcionTres);
        opcionesDisponibles.add(opcionCuatro);

        List<Opcion> correctasGrupoUno = new ArrayList<Opcion>();
        List<Opcion> correctasGrupoDos = new ArrayList<Opcion>();

        correctasGrupoUno.add(opcionUno);
        correctasGrupoUno.add(opcionDos);

        correctasGrupoDos.add(opcionTres);
        correctasGrupoDos.add(opcionCuatro);

        CreadorDePreguntas fabrica = new CreadorDePreguntas();
        Pregunta pregunta = fabrica.crearGroupChoice(texto, opcionesDisponibles);

        opcionUno.setGrupo("1");
        opcionDos.setGrupo("1");
        opcionTres.setGrupo("2");
        opcionCuatro.setGrupo("2");

        Jugador jugador1 = new Jugador("Jugador_1");

        assertFalse(pregunta.admiteMultiplicador());
        assertThrows(PreguntaNoAdmiteMultiplicadorException.class,
                ()->{
                    jugador1.activarMultiplicador(new MultiplicadorX2(), pregunta);
                });
        assertThrows(PreguntaNoAdmiteMultiplicadorException.class,
                ()->{
                    jugador1.activarMultiplicador(new MultiplicadorX3(), pregunta);
                });
    }
}
