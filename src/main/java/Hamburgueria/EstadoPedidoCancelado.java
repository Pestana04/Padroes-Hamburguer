package Hamburgueria;

import Hamburgueria.interfaces.EstadoPedido;

public class EstadoPedidoCancelado implements EstadoPedido {

    private static EstadoPedidoCancelado instance = new EstadoPedidoCancelado();

    private EstadoPedidoCancelado() {}

    public static EstadoPedidoCancelado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Cancelado";
    }
}