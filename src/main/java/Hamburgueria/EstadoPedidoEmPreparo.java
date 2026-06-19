package Hamburgueria;

import Hamburgueria.interfaces.EstadoPedido;

public class EstadoPedidoEmPreparo implements EstadoPedido {

    private static EstadoPedidoEmPreparo instance = new EstadoPedidoEmPreparo();

    private EstadoPedidoEmPreparo() {}

    public static EstadoPedidoEmPreparo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Em Preparo";
    }

    public boolean deixarPronto(Pedido pedido) {
        pedido.setEstado(EstadoPedidoPronto.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(EstadoPedidoCancelado.getInstance());
        return true;
    }
}