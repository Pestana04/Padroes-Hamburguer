package Decorator;

public class Bacon extends HamburguerDecorator {

    public Bacon(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public float getValor() {
        return hamburguer.getValor() + (hamburguer.getValor() * getPercentualValor());
    }

    @Override
    public String getDescricao() {
        return hamburguer.getDescricao() + ", bacon";
    }

    @Override
    public float getPercentualValor() {
        return 0.20f;
    }

    @Override
    public String getNomeDescricao() {
        return "Bacon";
    }
}