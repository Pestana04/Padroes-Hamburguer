package AbstractFactory;

public class FabricaComboPremium implements FabricaCombo {

    @Override
    public HamburguerBase criarHamburguer() {
        return new HamburguerPremium();
    }

    @Override
    public Bebida criarBebida() {
        return new Suco();
    }
}