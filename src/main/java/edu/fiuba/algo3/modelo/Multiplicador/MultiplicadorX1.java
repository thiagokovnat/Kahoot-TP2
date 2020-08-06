package edu.fiuba.algo3.modelo.Multiplicador;

public class MultiplicadorX1 implements Multiplicador {

    public int aplicar(int puntos){
        return puntos;
    }

    public String getIdentificador(){
       return "MultiplicadorX1";
    }

    public int getCantidadUsosPermitidos(){
        return 2;
    }
}
