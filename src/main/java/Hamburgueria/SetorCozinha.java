package Hamburgueria;

import Hamburgueria.interfaces.MediadorHamburgueria;

public class SetorCozinha extends SetorHamburgueria {

    public SetorCozinha(MediadorHamburgueria mediador) {
        super(mediador);
    }

    public String getNomeSetor() {
        return "Cozinha";
    }

    public void avisarPedidoPronto(Pedido pedido) {
        enviarMensagem("Pedido pronto para " + pedido.getCliente().getNome());
    }
}