package Hamburgueria;

import Hamburgueria.interfaces.InterpretadorExpressao;

public class CalculadoraExpressao {

    public static double calcular(String expressao) {
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas(expressao);
        return interpretador.interpretar();
    }
}