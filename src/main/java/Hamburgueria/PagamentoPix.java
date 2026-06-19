package Hamburgueria;

import Hamburgueria.interfaces.FormaPagamento;

public class PagamentoPix implements FormaPagamento {

    public String pagar(double valor) {
        return "Pagamento via Pix realizado no valor de R$ " + valor;
    }
}