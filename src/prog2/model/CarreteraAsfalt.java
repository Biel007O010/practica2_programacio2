package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt{
    //Atributs
    private float pesMax;
    //Constructor
    public CarreteraAsfalt(String _nom, String _accessabilitat, boolean _estat, float _metresQuadrats, float _pesMax) {
        super(_nom, "Si", _estat, _metresQuadrats);
        this.pesMax = _pesMax;
    }
    //Getter
    public float getPesMax(){
        return this.pesMax;
    }
    //Setter
    public void setPesMax(float _pesMax){
        this.pesMax = _pesMax;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString(){
        return super.toString() + " Pes màxim: " + this.pesMax + "Kg";
    }
}
