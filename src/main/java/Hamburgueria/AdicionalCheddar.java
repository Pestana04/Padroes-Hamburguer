package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;

public class AdicionalCheddar extends ItemPedido {

    public AdicionalCheddar(ItemCardapio item) {
        super(item);
    }

    public String getDescricao() {
        return getItem().getDescricao() + " + Cheddar";
    }

    public double getPreco() {
        return getItem().getPreco() + 4.0;
    }
}