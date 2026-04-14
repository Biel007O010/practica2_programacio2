package prog2.model;

import java.io.Serializable;

/**
 * Implementació de la subclasse BungalowPremium
 */
public class BungalowPremium extends Bungalow implements Serializable {

    /**
     * Atributs
     */
    private boolean serveisExtra;
    private String codiWifi;

    /**
     * COntructor de la classe
     * @param nom_ nom
     * @param id_ id
     * @param mida mida
     * @param habitacions nombre d'habitacions
     * @param placesPersones nombre de plaçes
     * @param placesParquing_ nombre de plaçes de parquing
     * @param terrassa_ terrassa
     * @param tv_ tv
     * @param aireFred_ AireFred
     * @param serveisExtra_ serveis estras
     * @param codiWifi_ codi wifi
     * @param operatiu_ operatiu
     * @param iluminacio_ iluminació
     */
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