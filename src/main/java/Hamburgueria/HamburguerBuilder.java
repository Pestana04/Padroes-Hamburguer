package Hamburgueria;

public class HamburguerBuilder {

    private String nome;
    private double preco;

    public HamburguerBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public HamburguerBuilder setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public Hamburguer build() {
        return new Hamburguer(nome, preco);
    }
}