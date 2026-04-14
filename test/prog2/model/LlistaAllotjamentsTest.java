package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;
import static org.junit.jupiter.api.Assertions.*;

public class LlistaAllotjamentsTest {

    private LlistaAllotjaments llista;
    private Bungalow bungalow;
    private Glamping glamping;
    private MobilHome mobilhome;

    @BeforeEach
    void setUp() {
        llista = new LlistaAllotjaments();
        bungalow = new Bungalow("B1", "ID-B1", 30.0f, 2, 4, 1, true, true, true, true, "100%");
        glamping = new Glamping("G1", "ID-G1", 20.0f, 1, 2, "Fusta", true, true, "100%");
        mobilhome = new MobilHome("M1", "ID-M1", 40.0f, 3, 6, true, false, "0%");
    }

    @Test
    void comprovarAfegirIContains() throws ExcepcioCamping {
        llista.afegirAllotjament(bungalow);
        llista.afegirAllotjament(glamping);
        assertTrue(llista.contains(bungalow));
        assertTrue(llista.contains(glamping));
        assertFalse(llista.contains(mobilhome));
    }

    @Test
    void comprovarGetAllotjament() throws ExcepcioCamping {
        llista.afegirAllotjament(bungalow);
        Allotjament trobat = llista.getAllotjament("ID-B1");
        assertEquals(bungalow, trobat);
        assertThrows(ExcepcioCamping.class, () -> llista.getAllotjament("ID-FALS"));
    }

    @Test
    void comprovarContainsOperatiu() throws ExcepcioCamping {
        llista.afegirAllotjament(mobilhome);
        assertFalse(llista.containsAllotjamentOperatiu());
        llista.afegirAllotjament(bungalow);
        assertTrue(llista.containsAllotjamentOperatiu());
    }

    @Test
    void comprovarLlistarFiltre() throws ExcepcioCamping {
        llista.afegirAllotjament(bungalow);
        llista.afegirAllotjament(mobilhome);
        String operatius = llista.llistarAllotjaments("Operatiu");
        String noOperatius = llista.llistarAllotjaments("No operatiu");
        assertTrue(operatius.contains("ID-B1"));
        assertTrue(noOperatius.contains("ID-M1"));
    }
}