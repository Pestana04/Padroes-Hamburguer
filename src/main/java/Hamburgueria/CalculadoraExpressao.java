package Hamburgueria;

import Hamburgueria.interfaces.InterpretadorExpressao;

public class CalculadoraExpressao {

    public static double calcular(String expressao) {
        String[] elementos = expressao.split(" ");

        if (elementos.length == 0) {
            throw new IllegalArgumentException("Expressão inválida");
        }

        double resultado = Double.parseDouble(elementos[0]);

        for (int i = 1; i < elementos.length; i += 2) {
            String operador = elementos[i];
            double valor = Double.parseDouble(elementos[i + 1]);

            InterpretadorExpressao esquerda = new Numero(resultado);
            InterpretadorExpressao direita = new Numero(valor);

            if (operador.equals("+")) {
                resultado = new Adicao(esquerda, direita).interpretar();
            } else if (operador.equals("-")) {
                resultado = new Subtracao(esquerda, direita).interpretar();
            } else if (operador.equals("*")) {
                resultado = new Multiplicacao(esquerda, direita).interpretar();
            } else if (operador.equals("/")) {
                resultado = new Divisao(esquerda, direita).interpretar();
            } else {
                throw new IllegalArgumentException("Operador inválido");
            }
        }

        return resultado;
    }
}