package edu.fiuba.algo3.modelo.Multiplicador;

public class MultiplicadorX2 implements Multiplicador {

    public int aplicar(int puntos){
        return puntos*2;
    }

    @Override
    public boolean equals(Object obj){
        return this.getClass() == obj.getClass();
    }
}
