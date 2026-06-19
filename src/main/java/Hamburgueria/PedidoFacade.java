package Hamburgueria;

public class PedidoFacade {

    public Pedido criarPedidoSimples(String nomeCliente, String telefoneCliente) {
        Cliente cliente = new Cliente(nomeCliente, telefoneCliente);
        Pedido pedido = new Pedido(cliente);

        Hamburguer hamburguer = new Hamburguer("X-Burguer", 20.0);
        pedido.adicionarItem(hamburguer);

        Estoque.getInstancia().baixarProduto("Pao", 1);
        Estoque.getInstancia().baixarProduto("Carne", 1);
        Estoque.getInstancia().baixarProduto("Queijo", 1);

        return pedido;
    }

    public Pedido criarPedidoCombo(String nomeCliente, String telefoneCliente) {
        Cliente cliente = new Cliente(nomeCliente, telefoneCliente);
        Pedido pedido = new Pedido(cliente);

        Combo combo = new Combo("Combo Tradicional");
        combo.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        combo.adicionarItem(new Hamburguer("Batata", 10.0));
        combo.adicionarItem(new Hamburguer("Refrigerante", 8.0));

        pedido.adicionarItem(combo);

        Estoque.getInstancia().baixarProduto("Pao", 1);
        Estoque.getInstancia().baixarProduto("Carne", 1);
        Estoque.getInstancia().baixarProduto("Batata", 1);
        Estoque.getInstancia().baixarProduto("Refrigerante", 1);

        return pedido;
    }
}