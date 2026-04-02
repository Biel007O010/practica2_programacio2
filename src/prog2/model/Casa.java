package prog2.model;

import java.io.Serializable;

public abstract class Casa extends Allotjament implements Serializable {

    private float mida;
    private int numHabitacions;
    private int Capacitat;

    public Casa(String nom, String id_, float mida,
                int numHabitacions, int Capacitat, long estadaMinimaALTA_, long estadaMinimaBAIXA_, boolean operatiu_, String iluminacio_){

        super(nom, id_, estadaMinimaALTA_, estadaMinimaBAIXA_, operatiu_, iluminacio_);
        this.mida = mida;
        this.numHabitacions = numHabitacions;
        this.Capacitat = Capacitat;
    }
};
