package prog2.model;

public class CamiAsfalt extends AccesAsfalt{
    //Constructor
    public CamiAsfalt(String _nom, String _accessabilitat, boolean _estat, float metresQuadrats) {
        super(_nom, "No", _estat, metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
