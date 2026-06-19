package Hamburgueria;

import Hamburgueria.interfaces.TipoEntrega;

public class RetiradaBalcao implements TipoEntrega {

    public String entregar(Pedido pedido) {
        return "Pedido de " + pedido.getCliente().getNome() + " retirado no balcão";
    }

    public double calcularTaxa(Pedido pedido) {
        return 0.0;
    }
}