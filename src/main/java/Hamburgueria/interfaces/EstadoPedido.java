package Hamburgueria.interfaces;

import Hamburgueria.Pedido;

public interface EstadoPedido {

    String getEstado();

    default boolean preparar(Pedido pedido) {
        return false;
    }

    default boolean deixarPronto(Pedido pedido) {
        return false;
    }

    default boolean finalizar(Pedido pedido) {
        return false;
    }

    default boolean cancelar(Pedido pedido) {
        return false;
    }
}