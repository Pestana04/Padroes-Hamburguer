package Hamburgueria;

import Hamburgueria.interfaces.TipoEntrega;

public class EntregaAplicativo implements TipoEntrega {

    public String entregar(Pedido pedido) {
        return "Aplicativo parceiro entregando pedido de " + pedido.getCliente().getNome();
    }

    public double calcularTaxa(Pedido pedido) {
        return 12.0;
    }
}