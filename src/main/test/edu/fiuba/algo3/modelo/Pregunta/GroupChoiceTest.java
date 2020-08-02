package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupChoiceTest {

    @Test
    public void unaPreguntaGroupChoicePuedeCrearseIndicandoLasRespuestasCorrectas(){

        String texto = "Poner en el grupo 1 los lenguajes de tipado estático, y en el grupo 2 los de tipado dinámico:";

        Opcion opcionUno = new Opcion( "Java" );
        Opcion opcionDos = new Opcion( "C" );
        Opcion opcionTres = new Opcion( "Smalltalk" );
        Opcion opcionCuatro = new Opcion( "Python" );

        List<Opcion> opcionesDisponibles = new ArrayList<>();

        opcionesDisponibles.add(opcionUno);
        opcionesDisponibles.add(opcionDos);
        opcionesDisponibles.add(opcionTres);
        opcionesDisponibles.add(opcionCuatro);

        List<Opcion> correctasGrupoUno = new ArrayList<>();
        List<Opcion> correctasGrupoDos = new ArrayList<>();

        correctasGrupoUno.add(opcionUno);
        correctasGrupoUno.add(opcionDos);

        correctasGrupoDos.add(opcionTres);
        correctasGrupoDos.add(opcionCuatro);

        Pregunta pregunta = Pregunta.crearPreguntaGroupChoice(texto, opcionesDisponibles, correctasGrupoUno, correctasGrupoDos );

        opcionUno.setGrupo("1");
        opcionDos.setGrupo("1");
        opcionTres.setGrupo("2");
        opcionCuatro.setGrupo("2");

        assertEquals( opcionUno, pregunta.getOpcion(0) );
        assertEquals( opcionDos, pregunta.getOpcion(1) );
        assertEquals( opcionTres, pregunta.getOpcion(2) );
        assertEquals( opcionCuatro, pregunta.getOpcion(3) );
    }

    @Test
    public void unaPreguntaGroupChoiceAsignaCorrectamenteElPuntaje(){
        String texto = "Poner en el grupo 1 los lenguajes de tipado estático, y en el grupo 2 los de tipado dinámico:";

        Opcion opcionUno = new Opcion( "Java" );
        Opcion opcionDos = new Opcion( "C" );
        Opcion opcionTres = new Opcion( "Smalltalk" );
        Opcion opcionCuatro = new Opcion( "Python" );

        List<Opcion> opcionesDisponibles = new ArrayList<>();

        opcionesDisponibles.add(opcionUno);
        opcionesDisponibles.add(opcionDos);
        opcionesDisponibles.add(opcionTres);
        opcionesDisponibles.add(opcionCuatro);

        List<Opcion> correctasGrupoUno = new ArrayList<>();
        List<Opcion> correctasGrupoDos = new ArrayList<>();

        correctasGrupoUno.add(opcionUno);
        correctasGrupoUno.add(opcionDos);

        correctasGrupoDos.add(opcionTres);
        correctasGrupoDos.add(opcionCuatro);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaGroupChoice(texto, opcionesDisponibles, correctasGrupoUno, correctasGrupoDos );

        Jugador jugadorUno = new Jugador("Jugador_1");
        Jugador jugadorDos = new Jugador("Jugador_2");

        opcionUno.setGrupo("1");
        opcionDos.setGrupo("1");
        opcionTres.setGrupo("2");
        opcionCuatro.setGrupo("2");

        List<Respuesta> respuestas = new ArrayList<>();
        // Todas las opciones de jugador 1 estan bien
        List<Opcion> respuestaJugadorUno = new ArrayList<>();
        respuestaJugadorUno.add( opcionUno );
        respuestaJugadorUno.add( opcionDos );
        respuestaJugadorUno.add( opcionTres );
        respuestaJugadorUno.add( opcionCuatro );

        // Cambio de grupo para el jugador 2
        opcionUno.setGrupo("1");
        opcionDos.setGrupo("2");
        opcionTres.setGrupo("1");
        opcionCuatro.setGrupo("2");

        List<Opcion> respuestaJugadorDos = new ArrayList<>();
        respuestaJugadorDos.add( opcionUno );
        respuestaJugadorDos.add( opcionDos );
        respuestaJugadorDos.add( opcionTres );
        respuestaJugadorDos.add( opcionCuatro );

        respuestas.add( jugadorUno.responder(respuestaJugadorUno) );
        respuestas.add( jugadorDos.responder(respuestaJugadorDos) );

        nuevaPregunta.puntuarRespuestas(respuestas);

        assertEquals(2, jugadorUno.getPuntos()); // respondio todo bien
        assertEquals(0, jugadorDos.getPuntos()); // respondio todo mal
    }
}
