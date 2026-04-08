package AbstractFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    void deveMontarHamburguerTradicional() {
        FabricaCombo fabrica = new FabricaComboTradicional();
        Cliente cliente = new Cliente(fabrica);
        assertEquals("Hambúrguer Tradicional", cliente.montarHamburguer());
    }

    @Test
    void deveServirRefrigeranteNoComboTradicional() {
        FabricaCombo fabrica = new FabricaComboTradicional();
        Cliente cliente = new Cliente(fabrica);
        assertEquals("Refrigerante", cliente.servirBebida());
    }

    @Test
    void deveMontarHamburguerPremium() {
        FabricaCombo fabrica = new FabricaComboPremium();
        Cliente cliente = new Cliente(fabrica);
        assertEquals("Hambúrguer Premium", cliente.montarHamburguer());
    }

    @Test
    void deveServirSucoNoComboPremium() {
        FabricaCombo fabrica = new FabricaComboPremium();
        Cliente cliente = new Cliente(fabrica);
        assertEquals("Suco", cliente.servirBebida());
    }
}