package Hamburgueria;

import Hamburgueria.interfaces.MediadorHamburgueria;

public abstract class SetorHamburgueria {

    private MediadorHamburgueria mediador;
    private String ultimaMensagem;

    public SetorHamburgueria(MediadorHamburgueria mediador) {
        this.mediador = mediador;
    }

    public void enviarMensagem(String mensagem) {
        mediador.enviarMensagem(mensagem, this);
    }

    public void receberMensagem(String mensagem) {
        this.ultimaMensagem = getNomeSetor() + " recebeu: " + mensagem;
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }

    public abstract String getNomeSetor();
}