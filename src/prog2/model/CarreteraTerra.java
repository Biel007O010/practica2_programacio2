package prog2.model;

public class CarreteraTerra extends AccesTerra{
    //Atributs
    private float amplada;
    //Constructor
    public CarreteraTerra(String _nom, String _accesibilitat, boolean _estat, float _longitud, float _amplada) {
        super(_nom, "Si", _estat, _longitud);
        this.amplada = _amplada;
    }

    //Getter
    public float getAmplada(){
        return this.amplada;
    }
    //Setter
    public void setAmplada(float _amplada){
        this.amplada = _amplada;
    }

    @Override
    public boolean isAccessibilitat() {
        return true;
    }

    @Override
    public String toString(){
        return super.toString() + " Amplada: " + this.amplada + "m";
    }
}
