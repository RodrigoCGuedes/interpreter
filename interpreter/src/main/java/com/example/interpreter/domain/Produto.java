package com.example.interpreter.domain;

import com.example.interpreter.pattern.InterpretadorExpressoesAritmeticas;

public class Produto {
    private double precoBase;
    private double imposto;

    public Produto(double precoBase, double imposto) {
        this.precoBase = precoBase;
        this.imposto = imposto;
    }

    public double calcularPrecoFinal(String formula) {
        String expressao = formula.replace("precoBase", Double.toString(this.precoBase));
        expressao = expressao.replace("imposto", Double.toString(this.imposto));

        InterpretadorExpressoesAritmeticas interpretador = new InterpretadorExpressoesAritmeticas(expressao);
        return interpretador.interpretar();
    }

    public double getPrecoBase() { return precoBase; }
    public void setPrecoBase(double precoBase) { this.precoBase = precoBase; }
    public double getImposto() { return imposto; }
    public void setImposto(double imposto) { this.imposto = imposto; }
}