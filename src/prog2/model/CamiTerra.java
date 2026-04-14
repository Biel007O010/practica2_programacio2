package prog2.model;

import java.io.Serializable;

/**
 * Implementació de la subclasse AccesTerra
 */
public class CamiTerra extends AccesTerra implements Serializable {
    /**
     * Constructor de la clase
     * @param _nom nom
     * @param _accesibilitat estat de l'accesibilitat
     * @param _longitud longitud
     */
    public CamiTerra(String _nom, boolean _accesibilitat, float _longitud) {
        super(_nom, _accesibilitat, _longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
