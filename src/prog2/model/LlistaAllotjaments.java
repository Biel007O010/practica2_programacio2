package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {
    //Atributs
    private ArrayList<Allotjament> llistaAll;

    //Cosntructor
    public LlistaAllotjaments(){
        this.llistaAll = new ArrayList<>();
    }
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        this.llistaAll.add(allotjament);
    }

    @Override
    public void buidar() {
        this.llistaAll.clear();
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        String allotjaments = "";
        int num = 1;
        Iterator<Allotjament> itr = this.llistaAll.iterator();
        while(itr.hasNext()){
            Allotjament tmp = itr.next();
            if (estat.equals("Operatiu") && tmp.isOperatiu()){
                allotjaments += num + ". " + tmp.toString() + "\n";
                num++;
            }
            else if (estat.equals("No operatiu") && !tmp.isOperatiu()) {
                allotjaments += num + ". " + tmp.toString() + "\n";
                num++;
            }
        }
        if (allotjaments.equals("")){
            throw new ExcepcioCamping("No hi ha cap allotjament amb l'estat ordenat");
        }
        return allotjaments;
    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        Iterator<Allotjament> itr = llistaAll.iterator();
        boolean operatiu = false;
        while(itr.hasNext()&&!operatiu){
            if (itr.next().isOperatiu()){
                operatiu = true;
            }
        }
        return operatiu;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        return this.llistaAll.contains(allotjament);
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        Iterator<Allotjament> itr = llistaAll.iterator();
        while (itr.hasNext()){
            Allotjament allotjament = itr.next();
            if (allotjament.getId().equals(id)){
                return allotjament;
            }
        }
        throw new ExcepcioCamping("L'allotjament solicitat no existeix a la llista");
    }
}
