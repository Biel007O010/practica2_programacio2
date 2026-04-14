package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;
import static org.junit.jupiter.api.Assertions.*;

public class LlistaAccessosTest {

    private LlistaAccessos llista;
    private CamiAsfalt camiA;
    private CarreteraTerra carreteraT;

    @BeforeEach
    void setUp() {
        llista = new LlistaAccessos();
        camiA = new CamiAsfalt("Cami Nord", true, 100.0f);
        carreteraT = new CarreteraTerra("Carretera Sud", true, 500.0f, 4.0f);
    }

    @Test
    void comprovarAfegirIBuidar() throws ExcepcioCamping {
        llista.afegirAcces(camiA);
        assertNotNull(llista.llistarAccessos(true));
        llista.buidar();
        assertThrows(ExcepcioCamping.class, () -> llista.llistarAccessos(true));
    }

    @Test
    void comprovarCalculaMetresTerra() throws ExcepcioCamping {
        llista.afegirAcces(carreteraT);
        llista.afegirAcces(camiA);
        assertEquals(500.0f, llista.calculaMetresTerra(), 0.01);
    }

    @Test
    void comprovarCalculaNoAccessibles() throws ExcepcioCamping {
        llista.afegirAcces(camiA);
        llista.afegirAcces(carreteraT);
        assertEquals(1, llista.calculaAccessosNoAccessibles());
    }
}