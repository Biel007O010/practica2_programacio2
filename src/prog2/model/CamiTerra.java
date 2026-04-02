package prog2.model;

import java.io.Serializable;

public class CamiTerra extends AccesTerra implements Serializable {
    //Constructor
    public CamiTerra(String _nom, String _accesibilitat, boolean _estat, float _longitud) {
        super(_nom, _accesibilitat, _estat, _longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
