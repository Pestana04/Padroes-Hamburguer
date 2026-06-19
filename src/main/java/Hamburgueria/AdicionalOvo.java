package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;

public class AdicionalOvo extends ItemPedido {

    public AdicionalOvo(ItemCardapio item) {
        super(item);
    }

    public String getDescricao() {
        return getItem().getDescricao() + " + Ovo";
    }

    public double getPreco() {
        return getItem().getPreco() + 3.0;
    }
}