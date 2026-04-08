package Bridge;

public abstract class Combo {

    protected Tamanho tamanho;
    protected float valorBase;

    public Combo(float valorBase) {
        this.valorBase = valorBase;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public void setValorBase(float valorBase) {
        this.valorBase = valorBase;
    }

    public abstract float calcularValorFinal();
}