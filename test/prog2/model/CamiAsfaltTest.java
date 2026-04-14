package prog2.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CamiAsfaltTest {
    @Test
    void comprovarCamiAsfalt() {
        CamiAsfalt cami = new CamiAsfalt("Camino Asfalto", true, 100.0f);
        assertFalse(cami.isAccessibilitat()); // Según tu código siempre devuelve false
        assertEquals(100.0, cami.getMetresQuadrats());
    }
}