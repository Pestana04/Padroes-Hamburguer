package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;

public class Hamburguer implements ItemCardapio {

    private String nome;
    private double preco;

    public Hamburguer(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getDescricao() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}