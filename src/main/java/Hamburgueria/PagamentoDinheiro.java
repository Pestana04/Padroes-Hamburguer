package Hamburgueria;

import Hamburgueria.interfaces.FormaPagamento;

public class PagamentoDinheiro implements FormaPagamento {

    public String pagar(double valor) {
        return "Pagamento em Dinheiro realizado no valor de R$ " + valor;
    }
}