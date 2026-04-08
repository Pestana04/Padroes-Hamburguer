package Singleton;

import Decorator.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaHamburguerTest {

    @Test
    void deveSerSingleton() {
        SistemaHamburguer s1 = SistemaHamburguer.getInstance();
        SistemaHamburguer s2 = SistemaHamburguer.getInstance();

        assertEquals(s1, s2);
    }

    @Test
    void deveArmazenarPedido() {
        Hamburguer h = new HamburguerSimples(10f);
        h = new Bacon(h);

        SistemaHamburguer.getInstance().setPedidoAtual(h);

        assertEquals(12f,
                SistemaHamburguer.getInstance().getPedidoAtual().getValor(),
                0.01f);
    }
}