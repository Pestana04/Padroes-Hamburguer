package Hamburgueria;

import Hamburgueria.interfaces.FormaPagamento;

public class PagamentoCartao implements FormaPagamento {

    public String pagar(double valor) {
        return "Pagamento via Cartão realizado no valor de R$ " + valor;
    }
}