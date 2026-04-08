package Decorator;

public abstract class HamburguerDecorator implements Hamburguer {

    protected Hamburguer hamburguer;

    public HamburguerDecorator(Hamburguer hamburguer) {
        this.hamburguer = hamburguer;
    }

    @Override
    public float getValor() {
        return hamburguer.getValor();
    }

    @Override
    public String getDescricao() {
        return hamburguer.getDescricao();
    }

    public abstract float getPercentualValor();
    public abstract String getNomeDescricao();
}