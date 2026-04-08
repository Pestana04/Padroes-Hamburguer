package FactoryMethod;

public class ServicoBalcao implements IServico {

    public String executar() {
        return "Pedido enviado ao balcão";
    }

    public String cancelar() {
        return "Pedido de balcão cancelado";
    }
}