package prog2.model;

import java.io.Serializable;

public class CarreteraAsfalt extends AccesAsfalt implements Serializable {
    //Atributs
    private float pesMax;
    //Constructor
    public CarreteraAsfalt(String _nom, boolean _accessabilitat, float _metresQuadrats, float _pesMax) {
        super(_nom, _accessabilitat, _metresQuadrats);
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
