package prog2.model;

import java.time.LocalDate;

public class TascaManteniment implements InTascaManteniment{

    public static enum TipusTascaManteniment{
        Reparacio, Neteja, RevisioTecnica, Desinfeccio,
    }
    //Atributs:
    private int numId;
    private Allotjament allotjament;
    private int DuradaDies;
    private String data;
    private TipusTascaManteniment tipus;

    //Constructor:
    public TascaManteniment(int numId_, TipusTascaManteniment tipus_, Allotjament allotjament_, String data_, int duradaDies_){
        this.numId = numId_;
        this.tipus = tipus_;
        this.allotjament = allotjament_;
        this.data = data_;
        this.DuradaDies = duradaDies_;
        allotjament.tancarAllotjament(this);
    }

    public int getNum(){
        return numId;
    }

    public TascaManteniment.TipusTascaManteniment getTipus(){
        return tipus;
    }

    public Allotjament getAllotjament(){
        return allotjament;
    }

    public String getData(){
        return data;
    }

    public int getDies(){
        return DuradaDies;
    }

    public void setNum(int num_){
        numId = num_;
    }

    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_){
        tipus = tipus_;
    }

    public void setAllotjament(Allotjament allotjament_){
        allotjament = allotjament_;
    }

    public void setData(String data_){
        data = data_;
    }

    public void setDies(int dies_){
        DuradaDies = dies_;
    }

    public String getIluminacioAllotjament(){
        return allotjament.getIluminacio();
    }

    public String toString(){
        return "\n La tasca amb numId: " + numId + " del allotjament amd Id: " + allotjament.getId() + " està en manteniment de " + tipus + " durante " + DuradaDies;
    }
}
