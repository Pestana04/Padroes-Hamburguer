package Hamburgueria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioCardapioVisitorTest {

    RelatorioCardapioVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new RelatorioCardapioVisitor();
        IngredienteFactory.limparIngredientes();
    }

    @Test
    void deveExibirHamburguer() {
        Hamburguer hamburguer = new PreparoHamburguerTradicional().preparar();

        assertEquals("Hambúrguer: X-Burguer Tradicional | Ingredientes: 4 | Preço: R$ 20.0",
                visitor.exibirItem(hamburguer));
    }

    @Test
    void deveExibirCombo() {
        Combo combo = new Combo("Combo Tradicional");
        combo.adicionarItem(new Hamburguer("X-Burguer", 20.0));
        combo.adicionarItem(new Hamburguer("Batata", 10.0));

        assertEquals("Combo: Combo Tradicional | Itens: 2 | Preço total: R$ 30.0",
                visitor.exibirItem(combo));
    }

    @Test
    void deveExibirIngrediente() {
        Ingrediente ingrediente = new Ingrediente("Pão", "Massa");

        assertEquals("Ingrediente: Pão | Tipo: Massa",
                ingrediente.aceitar(visitor));
    }

    @Test
    void deveExibirHamburguerDiretoPeloAceitar() {
        Hamburguer hamburguer = new Hamburguer("X-Bacon", 28.0);
        hamburguer.adicionarIngrediente(new Ingrediente("Bacon", "Proteína"));

        assertEquals("Hambúrguer: X-Bacon | Ingredientes: 1 | Preço: R$ 28.0",
                hamburguer.aceitar(visitor));
    }

    @Test
    void deveExibirComboDiretoPeloAceitar() {
        Combo combo = new Combo("Combo Simples");
        combo.adicionarItem(new Hamburguer("X-Burguer", 20.0));

        assertEquals("Combo: Combo Simples | Itens: 1 | Preço total: R$ 20.0",
                combo.aceitar(visitor));
    }
}