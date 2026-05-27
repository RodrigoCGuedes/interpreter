package com.example.interpreter;

import com.example.interpreter.domain.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InterpreterApplicationTests {

	@Test
	void deveCalcularPrecoFinalComAdicao() {
		Produto produto = new Produto(100.0, 15.5);
		String formula = "precoBase + imposto";

		double resultado = produto.calcularPrecoFinal(formula);

		assertEquals(115.5, resultado);
	}

	@Test
	void deveCalcularPrecoFinalComExpressaoComplexa() {
		Produto produto = new Produto(200.0, 2.0);
		String formula = "precoBase * imposto - 50.0";

		double resultado = produto.calcularPrecoFinal(formula);

		assertEquals(350.0, resultado);
	}

	@Test
	void deveLancarExcecaoParaExpressaoIncompleta() {
		Produto produto = new Produto(100.0, 10.0);
		String formula = "precoBase +";

		assertThrows(IllegalArgumentException.class, () -> produto.calcularPrecoFinal(formula));
	}
}