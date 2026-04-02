package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.*;

public class Camping implements InCamping, Serializable {
    //Atributs
    private String nom;
    private LlistaTasquesManteniment tasquesManteniment;
    private LlistaAllotjaments allotjaments;
    private LlistaAccessos accessos;

    public Camping(String _nom){
        this.nom = _nom;
        this.tasquesManteniment = new LlistaTasquesManteniment();
        this.allotjaments = new LlistaAllotjaments();
        this.accessos = new LlistaAccessos();
    }

    @Override
    public String getNomCamping() {
        return this.nom;
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return this.allotjaments.llistarAllotjaments(estat);
    }

    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        boolean estat;
        if (infoEstat.equals("Obert")){
            estat = true;
        }
        else if(infoEstat.equals("Tancat")){
            estat = false;
        }
        else {
            throw new ExcepcioCamping("L'estat: " + infoEstat + " no es valid");
        }
        return this.accessos.llistarAccessos(estat);
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return this.tasquesManteniment.llistarTasquesManteniment();
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {
        Allotjament a = this.allotjaments.getAllotjament(idAllotjament);
        this.tasquesManteniment.afegirTascaManteniment(num, tipus, a, data, dies);
    }

    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        TascaManteniment tasca = this.tasquesManteniment.getTascaManteniment(num);
        this.tasquesManteniment.completarTascaManteniment(tasca);
    }

    @Override
    public int calculaAccessosNoAccessibles() {
        return this.accessos.calculaAccessosNoAccessibles();
    }

    @Override
    public float calculaMetresTerra() {
        return this.accessos.calculaMetresTerra();
    }

    @Override
    public void save(String camiDesti) throws ExcepcioCamping {
        try{
            FileOutputStream fout = new FileOutputStream(camiDesti);
            ObjectOutputStream objecte = new ObjectOutputStream(fout);
            objecte.writeObject(this);
            objecte.close();
        }
        catch (Exception e){
            throw new ExcepcioCamping("Error al guardar: " + e.getMessage());
        }
    }

    static Camping load(String camiOrigen) throws ExcepcioCamping {
        Camping copiaDades;
        try{
            FileInputStream fis = new FileInputStream(camiOrigen);
            ObjectInputStream objecte = new ObjectInputStream(fis);

            copiaDades = (Camping) objecte.readObject();
            objecte.close();
        }
        catch (Exception e) {
            throw new UnsupportedOperationException("Error: " + e.getMessage());
        }
        return copiaDades;
    }

    @Override
    public void inicialitzaDadesCamping() {

        accessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfalt("A1", "No", true, asfalt);
        accessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfalt("A2", "Si", true, asfalt, pesMaxim);
        accessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", "No", true, longitud);
        accessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", "Si", true, longitud, amplada);
        accessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfalt("A5", "No", true, asfalt);
        accessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfalt("A6", "Si", true, asfalt, pesMaxim);
        accessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfalt("A7", "No", true, asfalt);
        accessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfalt("A8", "Si", true, asfalt, pesMaxim);
        accessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", "No", true, longitud);
        accessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", "Si", true, longitud, amplada);
        accessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", "No", true, longitud);
        accessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", "Si", true, longitud, amplada);
        accessos.afegirAcces(Acc12);


        /* Pistes */
        allotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        allotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        allotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, true, "100%");
        allotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi, true, "100%");
        allotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, mida, habitacions, placesPersones, material, casaMascota, true, "100%");
        allotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, mida, habitacions, placesPersones, terrassaBarbacoa, true, "100%");
        allotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);


    }
}
