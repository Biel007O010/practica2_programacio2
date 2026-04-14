package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;
import static org.junit.jupiter.api.Assertions.*;

public class LlistaTasquesMantenimentTest {

    private LlistaTasquesManteniment llista;
    private Parcela parcela;
    private Bungalow bungalow;

    @BeforeEach
    void setUp() {
        llista = new LlistaTasquesManteniment();
        parcela = new Parcela("P1", "ID-P1", true, "100%", 60.0f, true);
        bungalow = new Bungalow("B1", "ID-B1", 35.0f, 2, 4, 1, true, true, true, true, "100%");
    }

    @Test
    void comprovarAfegirTasca() throws ExcepcioCamping {
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "14/04/2026", 2);
        assertFalse(parcela.isOperatiu());
        assertEquals("50%", parcela.getIluminacio());
    }

    @Test
    void comprovarErrorAllotjamentOcupat() throws ExcepcioCamping {
        llista.afegirTascaManteniment(1, "Neteja", bungalow, "14/04/2026", 1);
        assertThrows(ExcepcioCamping.class, () ->
                llista.afegirTascaManteniment(2, "Desinfeccio", bungalow, "15/04/2026", 1));
    }

    @Test
    void comprovarCompletarTasca() throws ExcepcioCamping {
        llista.afegirTascaManteniment(5, "Desinfeccio", parcela, "14/04/2026", 3);
        assertEquals("0%", parcela.getIluminacio());

        TascaManteniment t = llista.getTascaManteniment(5);
        llista.completarTascaManteniment(t);

        assertTrue(parcela.isOperatiu());
        assertEquals("100%", parcela.getIluminacio());
        assertThrows(ExcepcioCamping.class, () -> llista.getTascaManteniment(5));
    }

    @Test
    void comprovarGetTascaExcepcio() {
        assertThrows(ExcepcioCamping.class, () -> llista.getTascaManteniment(999));
    }
}