package Bridge;

public class ComboFamilia extends Combo {

    private int quantidadePessoas;

    public ComboFamilia(float valorBase) {
        super(valorBase);
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public float calcularValorFinal() {
        return this.valorBase * this.quantidadePessoas * (1 + this.tamanho.percentualAdicional());
    }
}