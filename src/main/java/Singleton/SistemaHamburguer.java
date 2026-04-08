package Singleton;

import Decorator.Hamburguer;

public class SistemaHamburguer {

    private static SistemaHamburguer instance = new SistemaHamburguer();

    private SistemaHamburguer() {}

    public static SistemaHamburguer getInstance() {
        return instance;
    }

    private String nomeLanchonete;
    private Hamburguer pedidoAtual;

    public String getNomeLanchonete() {
        return nomeLanchonete;
    }

    public void setNomeLanchonete(String nomeLanchonete) {
        this.nomeLanchonete = nomeLanchonete;
    }

    public Hamburguer getPedidoAtual() {
        return pedidoAtual;
    }

    public void setPedidoAtual(Hamburguer pedidoAtual) {
        this.pedidoAtual = pedidoAtual;
    }
}