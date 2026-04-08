package FactoryMethod;

public class ServicoEntrega implements IServico {

    public String executar() {
        return "Entrega iniciada";
    }

    public String cancelar() {
        return "Entrega cancelada";
    }
}