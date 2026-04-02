package prog2.model;

import java.io.Serializable;

public abstract class AccesTerra extends Acces implements Serializable {
    //Atributs
    private float longitud;
    //Constructor
    public AccesTerra(String _nom, String _accesibilitat, boolean _estat, float _longitud){
        super(_nom, _accesibilitat, _estat);
        this.longitud = _longitud;
    }
    //Getter
    public double getLongitud() {
        return this.longitud;
    }
    //Setter
    public void setLongitud(float _longitud){
        this.longitud = _longitud;
    }

    @Override
    public String toString(){
        return super.toString() + " Longitud: " + this.longitud + "m";
    }
}
