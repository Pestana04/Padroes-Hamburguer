package Hamburgueria;

import Hamburgueria.interfaces.FormaPagamento;

public class PagamentoOnlineAdapter implements FormaPagamento {

    private SistemaPagamentoOnline sistemaPagamentoOnline;

    public PagamentoOnlineAdapter(SistemaPagamentoOnline sistemaPagamentoOnline) {
        this.sistemaPagamentoOnline = sistemaPagamentoOnline;
    }

    public String pagar(double valor) {
        return sistemaPagamentoOnline.autorizarPagamento(valor);
    }
}