package FactoryMethod;

public class ServicoRetirada implements IServico {

    public String executar() {
        return "Retirada liberada";
    }

    public String cancelar() {
        return "Retirada cancelada";
    }
}