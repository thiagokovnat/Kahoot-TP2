package edu.fiuba.algo3.modelo.Opcion;

public class OpcionSinGrupo implements Opcion {

    private String texto;

    public OpcionSinGrupo(String texto){
        this.texto = texto;
    }

    public String getTexto(){
        return texto;
    }

    @Override
    public boolean equals(Object obj){

        if (obj == null || (obj.getClass() != this.getClass()))
            return false;

        if (this == obj)
            return true;

        OpcionSinGrupo opc = (OpcionSinGrupo) obj;
        return this.texto.equals(opc.texto);
    }
}
