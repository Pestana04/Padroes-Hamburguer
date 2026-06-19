package Hamburgueria;

import Hamburgueria.interfaces.TipoEntrega;

public class EntregaPadrao extends ServicoEntrega {

    public EntregaPadrao(TipoEntrega tipoEntrega) {
        super(tipoEntrega);
    }

    public String getDescricaoServico() {
        return "Entrega Padrão";
    }
}