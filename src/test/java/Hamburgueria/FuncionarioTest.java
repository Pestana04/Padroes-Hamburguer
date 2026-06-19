package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    Funcionario atendente;
    Funcionario cozinha;
    Funcionario gerente;

    @BeforeEach
    void setUp() {
        atendente = new Atendente();
        cozinha = new Cozinha();
        gerente = new Gerente();

        atendente.setSuperior(cozinha);
        cozinha.setSuperior(gerente);
    }

    @Test
    void deveRetornarAtendenteParaRegistrarPedido() {
        assertEquals("Atendente atendeu a solicitação: Registrar Pedido",
                atendente.atenderSolicitacao("Registrar Pedido"));
    }

    @Test
    void deveRetornarAtendenteParaReceberPagamento() {
        assertEquals("Atendente atendeu a solicitação: Receber Pagamento",
                atendente.atenderSolicitacao("Receber Pagamento"));
    }

    @Test
    void deveRetornarCozinhaParaPrepararPedido() {
        assertEquals("Cozinha atendeu a solicitação: Preparar Pedido",
                atendente.atenderSolicitacao("Preparar Pedido"));
    }

    @Test
    void deveRetornarCozinhaParaFinalizarPreparo() {
        assertEquals("Cozinha atendeu a solicitação: Finalizar Preparo",
                atendente.atenderSolicitacao("Finalizar Preparo"));
    }

    @Test
    void deveRetornarGerenteParaCancelarPedido() {
        assertEquals("Gerente atendeu a solicitação: Cancelar Pedido",
                atendente.atenderSolicitacao("Cancelar Pedido"));
    }

    @Test
    void deveRetornarGerenteParaResolverReclamacao() {
        assertEquals("Gerente atendeu a solicitação: Resolver Reclamação",
                atendente.atenderSolicitacao("Resolver Reclamação"));
    }

    @Test
    void deveRetornarSolicitacaoNaoAtendida() {
        assertEquals("Solicitação não atendida: Limpar Mesa",
                atendente.atenderSolicitacao("Limpar Mesa"));
    }
}