package Hamburgueria.interfaces;

import Hamburgueria.Pedido;

public interface TipoEntrega {

    String entregar(Pedido pedido);

    double calcularTaxa(Pedido pedido);
}