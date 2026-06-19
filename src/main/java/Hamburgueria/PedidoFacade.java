package Hamburgueria;

public class PedidoFacade {

    public Pedido criarPedidoBalcaoTradicional(String nomeCliente, String telefoneCliente) {
        Cliente cliente = new Cliente(nomeCliente, telefoneCliente);

        PedidoFactory pedidoFactory = new PedidoBalcaoFactory();
        Pedido pedido = pedidoFactory.criarPedido(cliente);

        ComboFactory comboFactory = new ComboFactory();
        pedido.adicionarItem(comboFactory.criarComboTradicional());

        baixarEstoqueComboTradicional();

        return pedido;
    }

    public Pedido criarPedidoDeliveryPremium(String nomeCliente, String telefoneCliente) {
        Cliente cliente = new Cliente(nomeCliente, telefoneCliente);

        PedidoFactory pedidoFactory = new PedidoDeliveryFactory();
        Pedido pedido = pedidoFactory.criarPedido(cliente);

        ComboFactory comboFactory = new ComboFactory();
        pedido.adicionarItem(comboFactory.criarComboPremium());

        baixarEstoqueComboPremium();

        return pedido;
    }

    private void baixarEstoqueComboTradicional() {
        Estoque.getInstancia().baixarProduto("Pao", 1);
        Estoque.getInstancia().baixarProduto("Carne", 1);
        Estoque.getInstancia().baixarProduto("Queijo", 1);
        Estoque.getInstancia().baixarProduto("Batata", 1);
        Estoque.getInstancia().baixarProduto("Refrigerante", 1);
    }

    private void baixarEstoqueComboPremium() {
        Estoque.getInstancia().baixarProduto("Pao", 1);
        Estoque.getInstancia().baixarProduto("Carne", 1);
        Estoque.getInstancia().baixarProduto("Bacon", 1);
        Estoque.getInstancia().baixarProduto("Batata", 1);
        Estoque.getInstancia().baixarProduto("Milkshake", 1);
    }
}