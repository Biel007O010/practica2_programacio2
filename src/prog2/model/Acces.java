package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Implementacio de la clase Accés.
 */
public abstract class Acces implements InAcces, Serializable {
    /**
     * Atributs
     */
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private LlistaAllotjaments llista;

    /**
     * Constructor de la classe Acces
     * @param _nom nom de l'accés
     * @param _estat estat operatiu de l'accès
     */
    public Acces(String _nom, boolean _estat){
        this.nom = _nom;
        this.accessibilitat = isAccessibilitat();
        this.estat = _estat;
        this.llista = new LlistaAllotjaments();
    }
    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        try {
            this.llista.afegirAllotjament(allotjament);
        } catch (ExcepcioCamping e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void tancarAcces() {
        this.estat = false;
    }
    @Override
    public void obrirAcces() {
        this.estat = true;
    }

    @Override
    public abstract boolean isAccessibilitat();

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public boolean getEstat() {
        return this.estat;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return this.llista;
    }

    /**
     * Metode per imprimir informació de l'accés
     * @return
     */
    @Override
    public String toString(){
        String e;
        String a;
        if (this.estat){
            e = "Obert";
        }
        else{
            e = "Tancat";
        }
        if (this.accessibilitat){
            a = "Accessible";
        }
        else{
            a = "No accessible";
        }

        return "Nom: " + this.nom + " Accessibilitat: " + a + " Estat: " + e;
    }
}
