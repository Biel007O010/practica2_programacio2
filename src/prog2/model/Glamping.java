package prog2.model;

public class Glamping extends Casa{

    private String material;
    private boolean casaMascotes;

    public Glamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota, boolean operatiu_, String iluminacio_){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 3, 3, operatiu_, iluminacio_);
        this.material = material;
        this.casaMascotes = casaMascota;
    }

    public boolean correcteFuncionament() {
        return this.casaMascotes;
    }
}
