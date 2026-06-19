package Hamburgueria;

import Hamburgueria.interfaces.EstadoPedido;

public class EstadoPedidoPronto implements EstadoPedido {

    private static EstadoPedidoPronto instance = new EstadoPedidoPronto();

    private EstadoPedidoPronto() {}

    public static EstadoPedidoPronto getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pronto";
    }

    public boolean finalizar(Pedido pedido) {
        pedido.setEstado(EstadoPedidoFinalizado.getInstance());
        return true;
    }
}