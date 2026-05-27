package com.example.interpreter.pattern;

public class Divisao implements InterpretadorExpressao {
    private final InterpretadorExpressao esquerda;
    private final InterpretadorExpressao direita;

    public Divisao(InterpretadorExpressao esquerda, InterpretadorExpressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public double interpretar() {
        return this.esquerda.interpretar() / this.direita.interpretar();
    }
}