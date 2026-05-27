package com.example.interpreter.pattern;

public class Multiplicacao implements InterpretadorExpressao {
    private final InterpretadorExpressao esquerda;
    private final InterpretadorExpressao direita;

    public Multiplicacao(InterpretadorExpressao esquerda, InterpretadorExpressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public double interpretar() {
        return this.esquerda.interpretar() * this.direita.interpretar();
    }
}