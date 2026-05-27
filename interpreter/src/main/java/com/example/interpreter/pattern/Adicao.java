package com.example.interpreter.pattern;

public class Adicao implements InterpretadorExpressao {
    private final InterpretadorExpressao esquerda;
    private final InterpretadorExpressao direita;

    public Adicao(InterpretadorExpressao esquerda, InterpretadorExpressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public double interpretar() {
        return this.esquerda.interpretar() + this.direita.interpretar();
    }
}