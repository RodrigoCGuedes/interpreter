package com.example.interpreter.pattern;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class InterpretadorExpressoesAritmeticas implements InterpretadorExpressao {

    private final InterpretadorExpressao interpretadorInicial;

    public InterpretadorExpressoesAritmeticas(String contexto) {
        Stack<InterpretadorExpressao> pilhaInterpretadores = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();

            if (elemento.matches("\\d+(\\.\\d*)?")) {
                pilhaInterpretadores.push(new Numero(Double.parseDouble(elemento)));
            } else if (elemento.equals("+")) {
                validarProximoElemento(iterator);
                InterpretadorExpressao esquerda = pilhaInterpretadores.pop();
                InterpretadorExpressao direita = new Numero(Double.parseDouble(iterator.next()));
                pilhaInterpretadores.push(new Numero(new Adicao(esquerda, direita).interpretar()));
            } else if (elemento.equals("-")) {
                validarProximoElemento(iterator);
                InterpretadorExpressao esquerda = pilhaInterpretadores.pop();
                InterpretadorExpressao direita = new Numero(Double.parseDouble(iterator.next()));
                pilhaInterpretadores.push(new Numero(new Subtracao(esquerda, direita).interpretar()));
            } else if (elemento.equals("*")) {
                validarProximoElemento(iterator);
                InterpretadorExpressao esquerda = pilhaInterpretadores.pop();
                InterpretadorExpressao direita = new Numero(Double.parseDouble(iterator.next()));
                pilhaInterpretadores.push(new Numero(new Multiplicacao(esquerda, direita).interpretar()));
            } else if (elemento.equals("/")) {
                validarProximoElemento(iterator);
                InterpretadorExpressao esquerda = pilhaInterpretadores.pop();
                InterpretadorExpressao direita = new Numero(Double.parseDouble(iterator.next()));
                pilhaInterpretadores.push(new Numero(new Divisao(esquerda, direita).interpretar()));
            } else {
                throw new IllegalArgumentException("Expressão com elemento inválido: " + elemento);
            }
        }
        this.interpretadorInicial = pilhaInterpretadores.pop();
    }

    private void validarProximoElemento(Iterator<String> iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Expressão inválida: operando faltando após operador.");
        }
    }

    @Override
    public double interpretar() {
        return this.interpretadorInicial.interpretar();
    }
}