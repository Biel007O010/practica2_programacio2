package prog2.model;

import java.util.ArrayList;
import prog2.vista.ExcepcioCamping;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment {

    private ArrayList<TascaManteniment> llistaTasques;

    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {

        if (!allotjament.isOperatiu()) {
            throw new ExcepcioCamping("Aquest allotjament ja està en manteniment");
        } else {
            TascaManteniment NovaTasca = new TascaManteniment(num, TascaManteniment.TipusTascaManteniment.valueOf(tipus), allotjament, data, dies);
            llistaTasques.add(NovaTasca);
            System.out.println("La tasque s'ha afegit correctament");
        }
    }

    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        if (llistaTasques.isEmpty()) {
            throw new ExcepcioCamping("No hi ha tasques per completar");
        } else {
            boolean trobat = false;
            for (int i = llistaTasques.size() - 1; i >= 0; i--) {
                if (llistaTasques.get(i).getNum() == tasca.getNum()) {
                    trobat = true;
                    llistaTasques.get(i).getAllotjament().obrirAllotjament();
                    llistaTasques.remove(i);
                    System.out.println("La tasca s'ha completat correctament");
                }
            }
            if (!trobat) {
                throw new ExcepcioCamping("No s'ha encontrat aquesta tasca.");
            }
        }
    }

    public String llistarTasquesManteniment() throws ExcepcioCamping {

        if (llistaTasques.isEmpty()) {
            throw new ExcepcioCamping("No hi ha tasques pendets");
        } else {
            String sortida = "";
            for (TascaManteniment e : llistaTasques) {
                sortida = sortida + e.toString();
            }
            return sortida;
        }
    }

    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {

        for (TascaManteniment e : llistaTasques) {
            if (e.getNum() == num) {
                return e;
            }
        }
        throw new ExcepcioCamping("No s'ha trobat una tasca amb numId: " + num);
    }
}
