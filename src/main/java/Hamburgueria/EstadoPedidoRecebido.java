package Hamburgueria;

import Hamburgueria.interfaces.EstadoPedido;

public class EstadoPedidoRecebido implements EstadoPedido {

    private static EstadoPedidoRecebido instance = new EstadoPedidoRecebido();

    private EstadoPedidoRecebido() {}

    public static EstadoPedidoRecebido getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Recebido";
    }

    public boolean preparar(Pedido pedido) {
        pedido.setEstado(EstadoPedidoEmPreparo.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(EstadoPedidoCancelado.getInstance());
        return true;
    }
}