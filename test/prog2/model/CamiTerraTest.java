package prog2.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CamiTerraTest {
    @Test
    void comprovarCamiTerra() {
        CamiTerra cami = new CamiTerra("Camino Tierra", false, 500.0f);
        assertFalse(cami.isAccessibilitat()); // Según tu código siempre devuelve false
        assertEquals(500.0, cami.getLongitud());
    }
}