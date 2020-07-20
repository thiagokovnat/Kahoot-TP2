package edu.fiuba.algo3.modelo.Pregunta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class VerdaderoFalsoClasicoTest {

    @Test
    public void unaPreguntaVFClasicoPuedeIndicandoLaRespuestaCorrecta(){

        String textoPregunta = "¿Se aprueba el TP2?";
        String opcionUno = "Verdadero", opcionDos = "Falso";

        List<String> opciones = new ArrayList<>();
        List<String> opcionesCorrectas = new ArrayList<>();

        opciones.add(opcionUno);
        opciones.add(opcionDos);
        opcionesCorrectas.add(opcionUno);

        Pregunta nuevaPregunta = Pregunta.crearPreguntaVerdaderoFalsoClasico(textoPregunta, opciones, opcionesCorrectas);

        // Falta terminar y falta el assert.
    }
}