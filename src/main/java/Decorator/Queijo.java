package Decorator;

public class Queijo extends HamburguerDecorator {

    public Queijo(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public float getValor() {
        return hamburguer.getValor() + (hamburguer.getValor() * getPercentualValor());
    }

    @Override
    public String getDescricao() {
        return hamburguer.getDescricao() + ", queijo";
    }

    @Override
    public float getPercentualValor() {
        return 0.10f;
    }

    @Override
    public String getNomeDescricao() {
        return "Queijo";
    }
}