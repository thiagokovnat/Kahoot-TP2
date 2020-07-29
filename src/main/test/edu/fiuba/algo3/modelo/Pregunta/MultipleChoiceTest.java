package edu.fiuba.algo3.modelo.Pregunta;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleChoiceTest {

    @Test
    public void unaPreguntaMCClasicoPuedeCrearseIndicandoLasRespuestasCorrectas() {

        String textoPregunta = "¿Que lenguajes se ven en Algo III?";

        Opcion opcionUno = new Opcion("Smalltalk");
        Opcion opcionDos = new Opcion("Java");
        Opcion opcionTres = new Opcion("Python");
        Opcion opcionCuatro = new Opcion("C#");

        List<Opcion> opciones = new ArrayList<>();
        List<Opcion> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opciones.add(opcionTres);
        opciones.add(opcionCuatro);
        opcionesCorrectas.add(opcionUno);
        opcionesCorrectas.add(opcionDos);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaMultipleChoiceClasico(textoPregunta, opciones, opcionesCorrectas);

        assertEquals(opcionUno, nuevaPregunta.getRespuesta(0));
        assertEquals(opcionDos, nuevaPregunta.getRespuesta(1));
    }
}