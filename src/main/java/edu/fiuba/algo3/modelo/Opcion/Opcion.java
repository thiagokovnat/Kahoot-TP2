package edu.fiuba.algo3.modelo.Opcion;

public class Opcion {
    private String texto;
    private String grupo;

    public Opcion(String texto){

        this.texto = texto;
        this.grupo = null;
    }

    public boolean textoEsIgual(String texto){

        return (this.texto.equals(texto));
    }

    public boolean esIgualA(Opcion unaOpcion){

        return unaOpcion.textoEsIgual(this.texto);
    }

    public String getTexto(){

        return this.texto;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || (obj.getClass() != this.getClass()))
            return false;

        if(this == obj)
            return true;

        Opcion opc = (Opcion) obj;

        return (this.texto.equals(opc.texto) && (this.grupo == null || this.grupo.equals(opc.grupo)));
    }
}
