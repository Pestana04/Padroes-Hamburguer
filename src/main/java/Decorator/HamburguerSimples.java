package Decorator;

public class HamburguerSimples implements Hamburguer {

    private float valor;

    public HamburguerSimples(float valor) {
        this.valor = valor;
    }

    @Override
    public float getValor() {
        return valor;
    }

    @Override
    public String getDescricao() {
        return "Hamburguer simples";
    }
}