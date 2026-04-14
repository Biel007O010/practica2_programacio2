package prog2.model;

import java.io.Serializable;public abstract class Allotjament implements InAllotjament, Serializable{
    /**
     * Atributs
     */
    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private boolean operatiu;
    private String iluminacio;

    /**
     * Constructor de la clase.
     * @param nom nom de l'allotjament
     * @param id id de l'allotjament
     * @param estadaMinimaALTA_ estada mínima alta
     * @param estadaMinimaBAIXA_ estada minima baixa
     * @param operatiu_ estat de l'allotjament
     * @param iluminacio_ porcentatge de l'allotjament
     */
    public Allotjament(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_, boolean operatiu_, String iluminacio_){
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaALTA_;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
        this.operatiu = operatiu_;
        this.iluminacio = iluminacio_;
    }

    public String getNom(){return nom;};

    public void setNom(String nom){this.nom = nom;};

    public String getId(){return id;};

    public void setId(String id){this.id = id;};

    public long getEstadaMinima(InAllotjament.Temp temp){
        if (temp.equals(Temp.ALTA)){
            return estadaMinimaALTA;
        }else{
            return estadaMinimaBAIXA;
        }
    };

    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        estadaMinimaALTA = estadaMinimaALTA_;
        estadaMinimaBAIXA = estadaMinimaBAIXA_;
    };

    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id + ", estada mínima en temp ALTA: " + estadaMinimaALTA + ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA + ".";
    }

    public void tancarAllotjament(TascaManteniment tasca){
        switch (tasca.getTipus()){
            case Reparacio, RevisioTecnica:
                this.iluminacio = "50%";
                break;

            case Neteja:
                this.iluminacio = "100%";
                break;

            case Desinfeccio:
                this.iluminacio = "0%";
                break;
        }
        this.operatiu = false;
    }

    public void obrirAllotjament(){
        this.operatiu = true;
        this.iluminacio = "100%";
    }

    /**
     * Metode que retorna l'estat de l'allotjament
     * @return boolean
     */

    public boolean isOperatiu(){
        return operatiu;
    }

    /**
     * Metode que retorna el porcentatge de iluminació de l'allotjament
     * @return String
     */
    public String getIluminacio(){
        return iluminacio;
    }
}
