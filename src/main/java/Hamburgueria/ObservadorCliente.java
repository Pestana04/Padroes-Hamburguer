package Hamburgueria;

import Hamburgueria.interfaces.ObservadorPedido;

public class ObservadorCliente implements ObservadorPedido {

    private String ultimaNotificacao;

    public void atualizar(String mensagem) {
        this.ultimaNotificacao = "Cliente avisado: " + mensagem;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }
}