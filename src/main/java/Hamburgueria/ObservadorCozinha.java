package Hamburgueria;

import Hamburgueria.interfaces.ObservadorPedido;

public class ObservadorCozinha implements ObservadorPedido {

    private String ultimaNotificacao;

    public void atualizar(String mensagem) {
        this.ultimaNotificacao = "Cozinha avisada: " + mensagem;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}