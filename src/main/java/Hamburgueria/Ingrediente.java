package Hamburgueria;

public class Ingrediente {

    private String nome;
    private String tipo;

    public Ingrediente(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return nome + " (" + tipo + ")";
    }
}