package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;

public class AdicionalBacon extends ItemPedido {

    public AdicionalBacon(ItemCardapio item) {
        super(item);
    }

    public String getDescricao() {
        return getItem().getDescricao() + " + Bacon";
    }

    public double getPreco() {
        return getItem().getPreco() + 5.0;
    }
}