package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;
import Hamburgueria.interfaces.VisitorCardapio;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemCardapio, Cloneable {

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

    public String getNome() {
        return nome;
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public String aceitar(VisitorCardapio visitor) {
        return visitor.exibirCombo(this);
    }

    public Combo clone() {
        try {
            Combo comboClone = (Combo) super.clone();
            comboClone.itens = new ArrayList<ItemCardapio>();

            for (ItemCardapio item : this.itens) {
                if (item instanceof Hamburguer) {
                    comboClone.adicionarItem(((Hamburguer) item).clone());
                } else if (item instanceof Combo) {
                    comboClone.adicionarItem(((Combo) item).clone());
                } else {
                    comboClone.adicionarItem(item);
                }
            }

            return comboClone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}