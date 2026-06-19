package Hamburgueria;

import Hamburgueria.interfaces.ItemCardapio;

public abstract class ItemPedido implements ItemCardapio {

    private ItemCardapio item;

    public ItemPedido(ItemCardapio item) {
        this.item = item;
    }

    public ItemCardapio getItem() {
        return item;
    }
}