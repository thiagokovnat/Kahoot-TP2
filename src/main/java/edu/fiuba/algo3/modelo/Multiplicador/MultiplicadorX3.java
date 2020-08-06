package edu.fiuba.algo3.modelo.Multiplicador;

public class MultiplicadorX3 implements Multiplicador {

    public int aplicar(int puntos){
        return puntos*3;
    }

    public String getIdentificador(){
        return "MultiplicadorX3";
    }

    public int getCantidadUsosPermitidos(){
        return 2;
    }
}
