package prog2.model;

import java.io.Serializable;

/**
 * Implementacio de la subclasse CammiAsfalt
 */
public class CamiAsfalt extends AccesAsfalt implements Serializable {
    /**
     * Constructor de la clase
     * @param _nom nom
     * @param _accessabilitat estat de la accesabilitat
     * @param metresQuadrats metres
     */
    public CamiAsfalt(String _nom, boolean _accessabilitat, float metresQuadrats) {
        super(_nom, _accessabilitat, metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
