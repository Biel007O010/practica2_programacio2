package prog2.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarreteraTerraTest {
    @Test
    void comprovarCarreteraTerra() {
        CarreteraTerra carretera = new CarreteraTerra("Pista Forestal", true, 1000.0f, 4.5f);
        assertTrue(carretera.isAccessibilitat()); // Siempre true
        assertEquals(4.5, carretera.getAmplada());

        carretera.setAmplada(5.0f);
        assertEquals(5.0, carretera.getAmplada());
        assertTrue(carretera.toString().contains("Amplada"));
    }
}