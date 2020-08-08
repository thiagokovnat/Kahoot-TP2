package edu.fiuba.algo3.modelo.Opcion;

public class OpcionConGrupo implements Opcion{
    private String texto;
    private String grupo;

    public OpcionConGrupo(String texto ){
        this.texto = texto;
        this.grupo = null;
    }

    public void setGrupo( String grupo ){
        this.grupo = grupo;
    }

    public String getTexto(){
        return this.texto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass()))
            return false;

        if (this == obj)
            return true;

        OpcionConGrupo opc = (OpcionConGrupo) obj;

        return (this.texto.equals(opc.texto) && (this.grupo == null || this.grupo.equals(opc.grupo)));
    }

}
