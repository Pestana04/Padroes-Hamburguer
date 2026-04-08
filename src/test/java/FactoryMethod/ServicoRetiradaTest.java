package FactoryMethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicoRetiradaTest {

    @Test
    void deveExecutarRetirada() {
        IServico servico = ServicoFactory.obterServico("Retirada");
        assertEquals("Retirada liberada", servico.executar());
    }

    @Test
    void deveCancelarRetirada() {
        IServico servico = ServicoFactory.obterServico("Retirada");
        assertEquals("Retirada cancelada", servico.cancelar());
    }
}