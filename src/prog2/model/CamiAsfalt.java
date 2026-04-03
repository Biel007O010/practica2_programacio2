package prog2.model;

import java.io.Serializable;

public class CamiAsfalt extends AccesAsfalt implements Serializable {
    //Constructor
    public CamiAsfalt(String _nom, boolean _accessabilitat, float metresQuadrats) {
        super(_nom, _accessabilitat, metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
