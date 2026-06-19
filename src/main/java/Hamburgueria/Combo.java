package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemCardapio {

    private String nome;
    private List<ItemCardapio> itens = new ArrayList<ItemCardapio>();

    public Combo(String nome) {
        this.nome = nome;
    }

    public void adicionarItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public String getDescricao() {
        String descricao = "Combo: " + nome;

        for (ItemCardapio item : itens) {
            descricao += " + " + item.getDescricao();
        }

        return descricao;
    }

    public double getPreco() {
        double total = 0.0;

        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }

        return total;
    }
}