package FactoryMethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicoBalcaoTest {

    @Test
    void deveExecutarBalcao() {
        IServico servico = ServicoFactory.obterServico("Balcao");
        assertEquals("Pedido enviado ao balcão", servico.executar());
    }

    @Test
    void deveCancelarBalcao() {
        IServico servico = ServicoFactory.obterServico("Balcao");
        assertEquals("Pedido de balcão cancelado", servico.cancelar());
    }
}