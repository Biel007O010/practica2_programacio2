package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccesTerraTest {
    private AccesTerra accesTerra;

    @BeforeEach
    void setUp() {
        accesTerra = new AccesTerra("Acceso Tierra Test", false, 50.0f) {
            @Override
            public boolean isAccessibilitat() { return false; }
        };
    }

    @Test
    void comprovarConstructorYGetters() {
        assertEquals("Acceso Tierra Test", accesTerra.getNom());
        assertEquals(50.0, accesTerra.getLongitud(), 0.01);
    }

    @Test
    void comprovarSetters() {
        accesTerra.setLongitud(75.5f);
        assertEquals(75.5, accesTerra.getLongitud(), 0.01);
    }
}
