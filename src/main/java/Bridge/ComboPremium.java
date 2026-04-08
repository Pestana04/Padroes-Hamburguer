package Bridge;

public class ComboPremium extends Combo {

    public ComboPremium(float valorBase) {
        super(valorBase);
    }

    public float calcularValorFinal() {
        return this.valorBase * (1 + this.tamanho.percentualAdicional());
    }
}