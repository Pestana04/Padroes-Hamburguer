import interfaces.Bebida;
import interfaces.FabricaCombo;
import interfaces.HamburguerBase;

public class FabricaComboTradicional implements FabricaCombo {

    @Override
    public HamburguerBase criarHamburguer() {
        return new HamburguerTradicional();
    }

    @Override
    public Bebida criarBebida() {
        return new Refrigerante();
    }
}