package Hamburgueria;

import Hamburgueria.interfaces.EstadoPedido;
import Hamburgueria.interfaces.ItemCardapio;

import java.util.ArrayList;
import java.util.List;

public class PedidoMemento {

    private List<ItemCardapio> itens;
    private EstadoPedido estado;
    private String pagamento;

    public PedidoMemento(List<ItemCardapio> itens, EstadoPedido estado, String pagamento) {
        this.itens = new ArrayList<ItemCardapio>(itens);
        this.estado = estado;
        this.pagamento = pagamento;
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public String getPagamento() {
        return pagamento;
    }
}