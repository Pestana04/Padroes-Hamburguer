package Hamburgueria;

public class PedidoDeliveryFactory extends PedidoFactory {

    public Pedido criarPedido(Cliente cliente) {
        return new Pedido(cliente, "Delivery");
    }
}