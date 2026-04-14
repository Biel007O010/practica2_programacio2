package prog2.model;

import java.io.Serializable;

/**
 * Implementació de la subclase AccesTerra
 */
public abstract class AccesTerra extends Acces implements Serializable {
    /**
     * Atributs
     */
    private float longitud;

    /**
     * Constructor de la clase
     * @param _nom nom de l'accés
     * @param _accesibilitat estat de l'accés
     * @param _longitud longitud de l'accés
     */
    public AccesTerra(String _nom, boolean _accesibilitat, float _longitud){
        super(_nom, _accesibilitat);
        this.longitud = _longitud;
    }

    /**
     * Getter de l'atribut Longitud
     * @return
     */
    public double getLongitud() {
        return this.longitud;
    }

    /**
     * Setter de l'atribut Longitud
     * @param _longitud
     */
    public void setLongitud(float _longitud){
        this.longitud = _longitud;
    }

    /**
     * String per imprimir l'atribut de l'aceés
     * @return
     */
    @Override
    public String toString(){
        return super.toString() + " Longitud: " + this.longitud + "m";
    }
}
