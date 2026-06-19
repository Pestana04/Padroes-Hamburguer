package Hamburgueria;

import Hamburgueria.interfaces.MediadorHamburgueria;

public class SetorGerencia extends SetorHamburgueria {

    public SetorGerencia(MediadorHamburgueria mediador) {
        super(mediador);
    }

    public String getNomeSetor() {
        return "Gerência";
    }

    public void autorizarCancelamento(Pedido pedido) {
        enviarMensagem("Cancelamento autorizado para pedido de " + pedido.getCliente().getNome());
    }
}