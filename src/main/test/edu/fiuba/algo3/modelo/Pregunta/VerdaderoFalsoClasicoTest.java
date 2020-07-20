package edu.fiuba.algo3.modelo.Pregunta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class VerdaderoFalsoClasicoTest {

    @Test
    public void unaPreguntaVFClasicoPuedeIndicandoLaRespuestaCorrecta(){

        String textoPregunta = "¿Se aprueba el TP2?";
        String opcionUno = "Verdadero", opcionDos = "Falso";

        List<String> opciones = new ArrayList<String>, opcionesCorrectas = new ArrayList<String>;

        opciones.add(opcionUno, opcionDos);
        opcionesCorrectas.add(opcionUno);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(textoPregunta, opciones, opcionUno);

        // Falta terminar y falta el assert.
    }
}