package Hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class HamburguerBuilder {

    private String nome;
    private double preco;
    private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

    public HamburguerBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public HamburguerBuilder setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public HamburguerBuilder adicionarIngrediente(String nome, String tipo) {
        Ingrediente ingrediente = IngredienteFactory.getIngrediente(nome, tipo);
        this.ingredientes.add(ingrediente);
        return this;
    }

    public Hamburguer build() {
        if (nome == null || nome.trim().equals("")) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (preco <= 0.0) {
            throw new IllegalArgumentException("Preço inválido");
        }

        return new Hamburguer(nome, preco, ingredientes);
    }
}