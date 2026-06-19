package Hamburgueria;

import Hamburgueria.interfaces.EstadoPedido;

public class EstadoPedidoFinalizado implements EstadoPedido {

    private static EstadoPedidoFinalizado instance = new EstadoPedidoFinalizado();

    private EstadoPedidoFinalizado() {}

    public static EstadoPedidoFinalizado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Finalizado";
    }
}