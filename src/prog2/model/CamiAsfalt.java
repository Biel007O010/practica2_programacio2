package prog2.model;

import java.io.Serializable;

public class CamiAsfalt extends AccesAsfalt implements Serializable {
    //Constructor
    public CamiAsfalt(String _nom, String _accessabilitat, boolean _estat, float metresQuadrats) {
        super(_nom, _accessabilitat, _estat, metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
