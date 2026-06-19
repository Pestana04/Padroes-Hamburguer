package Hamburgueria;

import Hamburgueria.interfaces.InterpretadorExpressao;

public class InterpretadorExpressoesAritmeticas implements InterpretadorExpressao {

    private String expressao;

    public InterpretadorExpressoesAritmeticas(String expressao) {
        this.expressao = expressao;
    }

    public double interpretar() {
        if (expressao == null || expressao.trim().equals("")) {
            throw new IllegalArgumentException("Expressão inválida");
        }

        String[] elementos = expressao.trim().split(" ");

        if (elementos.length < 3 || elementos.length % 2 == 0) {
            throw new IllegalArgumentException("Expressão inválida");
        }

        double resultado;

        try {
            resultado = Double.parseDouble(elementos[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Expressão com elemento inválido");
        }

        for (int i = 1; i < elementos.length; i += 2) {
            String operador = elementos[i];
            double valor;

            try {
                valor = Double.parseDouble(elementos[i + 1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Expressão com elemento inválido");
            }

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
                throw new IllegalArgumentException("Expressão com elemento inválido");
            }
        }

        return resultado;
    }
}