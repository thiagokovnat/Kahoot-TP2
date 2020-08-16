package edu.fiuba.algo3.modelo.ImportadorPreguntaXML;

import edu.fiuba.algo3.modelo.ImportadorPregunta.ImportadorPreguntaXML;
import edu.fiuba.algo3.modelo.Pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ImportadorPreguntaXMLTest {
    String PATH_ARCHIVO_PREGUNTAS_TEST = "archivoPreguntasTest.xml";

    @Test
    public void PreguntasDeArchivoSeCarganCorrectamente() {
        boolean excepcionLanzada = false;
        List<Pregunta> preguntas = new ArrayList<>();
        try {
            preguntas = ImportadorPreguntaXML.importarPreguntas(PATH_ARCHIVO_PREGUNTAS_TEST);
        } catch (Exception ex) {
            excepcionLanzada = true;
        }
        assertFalse(excepcionLanzada);
        assertEquals(preguntas.size(), 4);
        assertEquals(preguntas.get(0).getTexto(), "¿Se aprueba el TP2?");
        assertEquals(preguntas.get(1).getTexto(), "¿Que lenguajes se aprenden en Algo III?");
        assertEquals(preguntas.get(2).getTexto(), "Poner en el grupo 1 los lenguajes de tipado estático, y en el grupo 2 los de tipado dinámico:");
        assertEquals(preguntas.get(3).getTexto(), "Ordenar los siguientes lenguajes por orden enseñado en Algoritmos 3");
        assertEquals(preguntas.get(0).getOpciones().size(), 2);
        assertEquals(preguntas.get(1).getOpciones().size(), 4);
        assertEquals(preguntas.get(2).getOpciones().size(), 4);
        assertEquals(preguntas.get(3).getOpciones().size(), 2);
        // Matias: "Podríamos agregar pruebas que chequeen los textos de las opciones, pero tendría que hacer un get(indice)
        // de la lista de opciones y eso creo que rompe encapsulamiento (ya que se asume que las Opciones están ordenadas)"
    }
}
