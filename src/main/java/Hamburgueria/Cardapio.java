package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cardapio implements Iterable<ItemCardapio> {

    private List<ItemCardapio> itens = new ArrayList<ItemCardapio>();

    public void adicionarItem(ItemCardapio item) {
        this.itens.add(item);
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public Iterator<ItemCardapio> iterator() {
        return itens.iterator();
    }

    public double getValorTotalCardapio() {
        double total = 0.0;

        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }

        return total;
    }

    public String getDescricaoCardapio() {
        String descricao = "Cardápio";

        for (ItemCardapio item : itens) {
            descricao += " | " + item.getDescricao();
        }

        return descricao;
    }
}