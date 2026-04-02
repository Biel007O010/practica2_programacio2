package prog2.model;

import java.io.Serializable;

public class BungalowPremium extends Bungalow implements Serializable {

    private boolean serveisExtra;
    private String codiWifi;

    BungalowPremium(String nom_, String id_, float mida, int habitacions, int placesPersones,
                    int placesParquing_, boolean terrassa_, boolean tv_, boolean aireFred_,
                    boolean serveisExtra_, String codiWifi_, boolean operatiu_, String iluminacio_){

        super(nom_, id_, mida, habitacions, placesPersones, placesParquing_, terrassa_, tv_, aireFred_, operatiu_, iluminacio_);
        this.serveisExtra = serveisExtra_;
        this.codiWifi = codiWifi_;
    }
    public boolean correcteFuncionament(){
        return super.correcteFuncionament() && (codiWifi.length() > 8 && codiWifi.length() < 16);
    }
}