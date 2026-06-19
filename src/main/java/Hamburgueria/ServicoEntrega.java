package Hamburgueria;

import Hamburgueria.interfaces.TipoEntrega;

public abstract class ServicoEntrega {

    private TipoEntrega tipoEntrega;

    public ServicoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public double calcularTaxa(Pedido pedido) {
        return tipoEntrega.calcularTaxa(pedido);
    }

    public double calcularTotal(Pedido pedido) {
        return pedido.getValorTotal() + calcularTaxa(pedido);
    }

    public String realizarEntrega(Pedido pedido) {
        return getDescricaoServico() + " | "
                + tipoEntrega.entregar(pedido)
                + " | Total com entrega: R$ " + calcularTotal(pedido);
    }

    public abstract String getDescricaoServico();
}