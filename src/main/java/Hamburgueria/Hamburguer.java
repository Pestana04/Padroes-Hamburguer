package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;
import Hamburgueria.interfaces.VisitorCardapio;

import java.util.ArrayList;
import java.util.List;

public class Hamburguer implements ItemCardapio, Cloneable {

    private String nome;
    private double preco;
    private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

    public Hamburguer(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Hamburguer(String nome, double preco, List<Ingrediente> ingredientes) {
        this.nome = nome;
        this.preco = preco;
        this.ingredientes = new ArrayList<Ingrediente>(ingredientes);
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public String getDescricao() {
        String descricao = nome;

        if (!ingredientes.isEmpty()) {
            descricao += " com ";

            for (int i = 0; i < ingredientes.size(); i++) {
                descricao += ingredientes.get(i).getDescricao();

                if (i < ingredientes.size() - 1) {
                    descricao += ", ";
                }
            }
        }

        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public String aceitar(VisitorCardapio visitor) {
        return visitor.exibirHamburguer(this);
    }

    public Hamburguer clone() {
        try {
            Hamburguer hamburguerClone = (Hamburguer) super.clone();
            hamburguerClone.ingredientes = new ArrayList<Ingrediente>(this.ingredientes);
            return hamburguerClone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}