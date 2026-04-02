package prog2.model;

import java.io.Serializable;

public class Bungalow extends Casa implements Serializable {

    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    public Bungalow(String nom_, String id_, float mida, int habitacions, int placesPersones,
                    int placesParquing_, boolean terrassa_, boolean tv_, boolean aireFred_, boolean operatiu_, String iluminacio_){

        super(nom_, id_, mida, habitacions, placesPersones, 7, 4, operatiu_, iluminacio_);
        this.placesParquing = placesParquing_;
        this.terrassa = terrassa_;
        this.tv = tv_;
        this.aireFred = aireFred_;
    }

    public boolean correcteFuncionament(){

        return aireFred;
    }
}