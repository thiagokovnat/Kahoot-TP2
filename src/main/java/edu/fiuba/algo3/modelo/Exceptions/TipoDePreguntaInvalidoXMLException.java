package edu.fiuba.algo3.modelo.Exceptions;

public class TipoDePreguntaInvalidoXMLException extends Exception {
    public TipoDePreguntaInvalidoXMLException(String tipoPregunta) {
        super(tipoPregunta);
    }
}
