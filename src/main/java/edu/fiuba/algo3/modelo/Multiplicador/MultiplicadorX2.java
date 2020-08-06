package edu.fiuba.algo3.modelo.Multiplicador;

public class MultiplicadorX2 implements Multiplicador {

    public int aplicar(int puntos){
        return puntos*2;
    }

    public String getIdentificador(){
        return "MultiplicadorX2";
    }

    public int getCantidadUsosPermitidos(){
        return 2;
    }
}
