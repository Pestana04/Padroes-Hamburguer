package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CentralHamburgueriaTest {

    CentralHamburgueria central;
    SetorAtendimento atendimento;
    SetorCozinha cozinha;
    SetorGerencia gerencia;
    Pedido pedido;

    @BeforeEach
    void setUp() {
        central = new CentralHamburgueria();

        atendimento = new SetorAtendimento(central);
        cozinha = new SetorCozinha(central);
        gerencia = new SetorGerencia(central);

        central.setAtendimento(atendimento);
        central.setCozinha(cozinha);
        central.setGerencia(gerencia);

        pedido = new Pedido(new Cliente("Gustavo", "99999-9999"), "Balcão");
    }

    @Test
    void deveEnviarMensagemDoAtendimentoParaCozinha() {
        atendimento.solicitarPreparo(pedido);

        assertEquals("Cozinha recebeu: Atendimento: Preparar pedido de Gustavo",
                cozinha.getUltimaMensagem());
    }

    @Test
    void deveEnviarMensagemDoAtendimentoParaGerencia() {
        atendimento.solicitarPreparo(pedido);

        assertEquals("Gerência recebeu: Atendimento: Preparar pedido de Gustavo",
                gerencia.getUltimaMensagem());
    }

    @Test
    void deveEnviarMensagemDaCozinhaParaAtendimento() {
        cozinha.avisarPedidoPronto(pedido);

        assertEquals("Atendimento recebeu: Cozinha: Pedido pronto para Gustavo",
                atendimento.getUltimaMensagem());
    }

    @Test
    void deveEnviarMensagemDaCozinhaParaGerencia() {
        cozinha.avisarPedidoPronto(pedido);

        assertEquals("Gerência recebeu: Cozinha: Pedido pronto para Gustavo",
                gerencia.getUltimaMensagem());
    }

    @Test
    void deveEnviarMensagemDaGerenciaParaAtendimento() {
        gerencia.autorizarCancelamento(pedido);

        assertEquals("Atendimento recebeu: Gerência: Cancelamento autorizado para pedido de Gustavo",
                atendimento.getUltimaMensagem());
    }

    @Test
    void deveEnviarMensagemDaGerenciaParaCozinha() {
        gerencia.autorizarCancelamento(pedido);

        assertEquals("Cozinha recebeu: Gerência: Cancelamento autorizado para pedido de Gustavo",
                cozinha.getUltimaMensagem());
    }
}