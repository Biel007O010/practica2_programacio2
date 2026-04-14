package prog2.model;

import java.io.Serializable;

/**
 * Implementacio de la subclase AccessAsfalt
 */
public abstract class AccesAsfalt extends Acces implements Serializable {
    /**
     * Atributs
     */
    private float metresQuadrats;

    /**
     * Constructor
     * @param _nom nom de l'acces
     * @param _accessabilitat estat de la accesibilitat de l'acces
     * @param metresQuadrats metres quadratas de l'acces
     */
    public AccesAsfalt(String _nom, boolean _accessabilitat, float metresQuadrats) {
        super(_nom, _accessabilitat);
        this.metresQuadrats = metresQuadrats;
    }

    /**
     * Getter de l'atribut metresQuadrats
     * @return
     */
    public double getMetresQuadrats() {
        return this.metresQuadrats;
    }

    /**
     * Setter de l'atribut metresQUadrats
     * @param _metresQuadrats
     */
    public void setMetresQuadrats(float _metresQuadrats){
        this.metresQuadrats = _metresQuadrats;
    }

    /**
     * Metode toString ampliat per la clase
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + " Metres quadrats: " + this.metresQuadrats + "m2";
    }
}
