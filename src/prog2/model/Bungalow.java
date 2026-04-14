package prog2.model;

import java.io.Serializable;

/**
 * Implementació de la subclasse bungalow
 */
public class Bungalow extends Casa implements Serializable {
    /**
     * Atributs
     */
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    /**
     * Constructor
     * @param nom_ nom del bungalow
     * @param id_ id del bungalow
     * @param mida mida en metres
     * @param habitacions nombre d'habitacions
     * @param placesPersones nombre de plaçes
     * @param placesParquing_ nombre de plaçes de parquin
     * @param terrassa_ tarrasa
     * @param tv_ tv
     * @param aireFred_ AireFred
     * @param operatiu_ operatiu
     * @param iluminacio_ iluminació
     */
    public Bungalow(String nom_, String id_, float mida, int habitacions, int placesPersones,
                    int placesParquing_, boolean terrassa_, boolean tv_, boolean aireFred_, boolean operatiu_, String iluminacio_){

        super(nom_, id_, mida, habitacions, placesPersones, 7, 4, operatiu_, iluminacio_);
        this.placesParquing = placesParquing_;
        this.terrassa = terrassa_;
        this.tv = tv_;
        this.aireFred = aireFred_;
    }

    /**
     * Metodo boolean que retorna l'estat del bungalow.
     * @return
     */
    public boolean correcteFuncionament(){

        return aireFred;
    }
}