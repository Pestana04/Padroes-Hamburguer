package Decorator;

public class Ovo extends HamburguerDecorator {

    public Ovo(Hamburguer hamburguer) {
        super(hamburguer);
    }

    @Override
    public float getValor() {
        return hamburguer.getValor() + (hamburguer.getValor() * getPercentualValor());
    }

    @Override
    public String getDescricao() {
        return hamburguer.getDescricao() + ", ovo";
    }

    @Override
    public float getPercentualValor() {
        return 0.08f;
    }

    @Override
    public String getNomeDescricao() {
        return "Ovo";
    }
}