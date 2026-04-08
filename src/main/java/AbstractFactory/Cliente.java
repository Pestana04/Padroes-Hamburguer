package AbstractFactory;

public class Cliente {

    private HamburguerBase hamburguer;
    private Bebida bebida;

    public Cliente(FabricaCombo fabrica) {
        this.hamburguer = fabrica.criarHamburguer();
        this.bebida = fabrica.criarBebida();
    }

    public String montarHamburguer() {
        return this.hamburguer.montar();
    }

    public String servirBebida() {
        return this.bebida.servir();
    }
}