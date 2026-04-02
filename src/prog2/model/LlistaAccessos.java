package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos, Serializable {
    //Atributs
    private ArrayList<Acces> llistaAcc;

    //Constructor
    public LlistaAccessos(){
        this.llistaAcc = new ArrayList<>();
    }

    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        this.llistaAcc.add(acc);
    }

    @Override
    public void buidar() {
        this.llistaAcc.clear();

    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String accessos = "";
        int num = 1;
        Iterator<Acces> itr = this.llistaAcc.iterator();
        while(itr.hasNext()){
            Acces tmp = itr.next();
            if (tmp.getEstat() == estat){
                accessos += num + ". " + tmp.toString() + "\n";
                num++;
            }
        }
        if (accessos.equals("")){
            throw new ExcepcioCamping("No hi ha cap acces amb l'estat ordenat");
        }
        return accessos;
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        //Tanquem tots els accessos
        Iterator<Acces> itr = llistaAcc.iterator();
        while (itr.hasNext()){
            Acces tmp = itr.next();
            tmp.tancarAcces();
        }

        //Mirem quins allotjaments estan operatius
        Iterator<Acces> itr2 = llistaAcc.iterator();

        while (itr2.hasNext()){
            Acces accessos = itr2.next();
            LlistaAllotjaments llista = accessos.getAAllotjaments();
            if (llista.containsAllotjamentOperatiu()){
                accessos.obrirAcces();
            }
        }
    }

    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping{
        int noAccess = 0;
        for(Acces tmp: this.llistaAcc){
            if (tmp instanceof CamiTerra || tmp instanceof CamiAsfalt){
                noAccess++;
            }
        }
        return noAccess;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float metres = 0;
        for (Acces tmp: this.llistaAcc){
            if (tmp instanceof AccesTerra){
                AccesTerra a = (AccesTerra) tmp;
                metres += (float) a.getLongitud();
            }
        }
        return metres;
    }
}
