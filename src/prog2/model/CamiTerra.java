package prog2.model;

import java.io.Serializable;

public class CamiTerra extends AccesTerra implements Serializable {
    //Constructor
    public CamiTerra(String _nom, boolean _accesibilitat, float _longitud) {
        super(_nom, _accesibilitat, _longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
