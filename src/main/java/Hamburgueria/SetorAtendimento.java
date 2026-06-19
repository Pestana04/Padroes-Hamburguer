package Hamburgueria;

import Hamburgueria.interfaces.MediadorHamburgueria;

public class SetorAtendimento extends SetorHamburgueria {

    public SetorAtendimento(MediadorHamburgueria mediador) {
        super(mediador);
    }

    public String getNomeSetor() {
        return "Atendimento";
    }

    public void solicitarPreparo(Pedido pedido) {
        enviarMensagem("Preparar pedido de " + pedido.getCliente().getNome());
    }
}