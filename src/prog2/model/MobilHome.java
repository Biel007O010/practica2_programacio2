package prog2.model;

import java.io.Serializable;

public class MobilHome extends Casa implements Serializable {

    private boolean terrassaBBQ;

    public MobilHome(String nom_, String idAllotjament_, float mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa, boolean operatiu_, String iluminacio_){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 5, 3, operatiu_, iluminacio_);
        this.terrassaBBQ = terrassaBarbacoa;
    }

    public boolean correcteFuncionament() {
        return this.terrassaBBQ;
    }
}
