package edu.fiuba.algo3.modelo.Multiplicador;

public class MultiplicadorX3 implements Multiplicador {

    public int aplicar(int puntos){
        return puntos*3;
    }

    @Override
    public boolean equals(Object obj){
        return this.getClass() == obj.getClass();
    }
}
