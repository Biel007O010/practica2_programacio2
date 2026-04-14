package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccesAsfaltTest {
    private AccesAsfalt accesAsfalt;

    @BeforeEach
    void setUp() {
        // Instanciamos anónimamente al ser abstracta
        accesAsfalt = new AccesAsfalt("Acceso Asfalto Test", true, 150.5f) {
            @Override
            public boolean isAccessibilitat() { return true; }
        };
    }

    @Test
    void comprovarConstructorYGetters() {
        assertEquals("Acceso Asfalto Test", accesAsfalt.getNom());
        assertEquals(150.5, accesAsfalt.getMetresQuadrats(), 0.01);
    }

    @Test
    void comprovarSetters() {
        accesAsfalt.setMetresQuadrats(200.0f);
        assertEquals(200.0, accesAsfalt.getMetresQuadrats(), 0.01);
    }
}