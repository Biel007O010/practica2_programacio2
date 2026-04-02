package prog2.model;

import java.io.Serializable;

public abstract class AccesAsfalt extends Acces implements Serializable {
    //Atributs
    private float metresQuadrats;
    //Constructor
    public AccesAsfalt(String _nom, String _accessabilitat, boolean _estat, float metresQuadrats) {
        super(_nom, _accessabilitat, _estat);
        this.metresQuadrats = metresQuadrats;
    }
    //Getter
    public double getMetresQuadrats() {
        return this.metresQuadrats;
    }
    //Setter
    public void setMetresQuadrats(float _metresQuadrats){
        this.metresQuadrats = _metresQuadrats;
    }

    @Override
    public String toString(){
        return super.toString() + " Metres quadrats: " + this.metresQuadrats + "m2";
    }
}
