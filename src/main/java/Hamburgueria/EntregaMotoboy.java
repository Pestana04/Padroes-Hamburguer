package Hamburgueria;

import Hamburgueria.interfaces.TipoEntrega;

public class EntregaMotoboy implements TipoEntrega {

    public String entregar(Pedido pedido) {
        return "Motoboy entregando pedido de " + pedido.getCliente().getNome();
    }

    public double calcularTaxa(Pedido pedido) {
        return 8.0;
    }
}