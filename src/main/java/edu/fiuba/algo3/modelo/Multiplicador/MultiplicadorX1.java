package edu.fiuba.algo3.modelo.Multiplicador;

public class MultiplicadorX1 implements Multiplicador {

    public int aplicar(int puntos){
        return puntos;
    }

    @Override
    public boolean equals(Object obj){
        return this.getClass() == obj.getClass();
    }
}
