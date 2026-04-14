package prog2.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarreteraAsfaltTest {
    @Test
    void comprovarCarreteraAsfalt() {
        CarreteraAsfalt carretera = new CarreteraAsfalt("C-32", true, 2000.0f, 3500.0f);
        assertTrue(carretera.isAccessibilitat()); // Siempre true
        assertEquals(3500.0, carretera.getPesMax());

        carretera.setPesMax(4000.0f);
        assertEquals(4000.0, carretera.getPesMax());
        assertTrue(carretera.toString().contains("Pes màxim"));
    }
}