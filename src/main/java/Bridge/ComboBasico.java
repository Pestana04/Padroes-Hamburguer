package Bridge;

public class ComboBasico extends Combo {

    public ComboBasico(float valorBase) {
        super(valorBase);
    }

    public float calcularValorFinal() {
        return this.valorBase;
    }
}