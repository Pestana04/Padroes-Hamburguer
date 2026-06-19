package Hamburgueria;

public class PedidoBalcaoFactory extends PedidoFactory {

    public Pedido criarPedido(Cliente cliente) {
        return new Pedido(cliente, "Balcão");
    }
}