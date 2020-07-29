package edu.fiuba.algo3.modelo.Opcion;

public class Opcion {
    private String texto;

    public Opcion(String texto){
        this.texto = texto;
    }

    public boolean textoEsIgual(String texto){
        return this.texto.equals(texto);
    }

    public boolean esIgualA(Opcion unaOpcion){
        return unaOpcion.textoEsIgual(this.texto);
    }

    public String getTexto(){
        return this.texto;
    }
}
