package Hamburgueria;

import Hamburgueria.interfaces.InterpretadorExpressao;

public class Adicao implements InterpretadorExpressao {

    private InterpretadorExpressao esquerda;
    private InterpretadorExpressao direita;

    public Adicao(InterpretadorExpressao esquerda, InterpretadorExpressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public double interpretar() {
        return esquerda.interpretar() + direita.interpretar();
    }
}