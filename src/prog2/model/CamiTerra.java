package prog2.model;

public class CamiTerra extends AccesTerra{
    //Constructor
    public CamiTerra(String _nom, String _accesibilitat, boolean _estat, float _longitud) {
        super(_nom, "No", _estat, _longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
