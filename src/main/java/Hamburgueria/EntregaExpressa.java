package Hamburgueria;

import Hamburgueria.interfaces.TipoEntrega;

public class EntregaExpressa extends ServicoEntrega {

    public EntregaExpressa(TipoEntrega tipoEntrega) {
        super(tipoEntrega);
    }

    public String getDescricaoServico() {
        return "Entrega Expressa";
    }

    public double calcularTaxa(Pedido pedido) {
        return super.calcularTaxa(pedido) + 7.0;
    }
}