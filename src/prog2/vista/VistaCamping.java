package prog2.vista;

import prog2.model.Camping;

import java.util.Scanner;

public class VistaCamping{

    static private enum OpcionsCamping {ALLOTJAMENTS, MANTENIMENT, ACCESSOS, SORTIR}

    static private enum OpcioALL {OPERATIUS, NO_OPERATIUS, MENU_ANTERIOR}

    static private enum OpcioMANT {LLISTATASQUES, AFEGIRTASQUESMANT, COMPLETARTASQUES, MENU_ANTERIOR}

    static private enum OpcioACC {LLISTAACCESSOS, CALCULARDISPONIBILITAT, TERRATOTAL, MENU_ANTERIOR}


    static private String[] MenuCampingDesc={
            "Allotjaments.",
            "Manteniment.",
            "Accesos.",
            "Sortit."
    };

    static private String[] OpcioALLDesc={
            "Llistar allotjaments operatius.",
            "Llistar allotjaments no operatius.",
            "Menu anterior."
    };

    static private String[] OpcioMANTDesc={
            "Listar tasques de manteniment.",
            "Afegir tasques de manteniment.",
            "Completar tasques de manteniment.",
            "Menu anterior."
    };

    static private String[] OpcioACCDesc={
            "Llistar accesos.",
            "Calcular accesos no accessibles.",
            "Calcular metres de terra total.",
            "Menu anterior"
    };

    private Camping camping;

    public VistaCamping(String _nom) throws ExcepcioCamping {

        this.camping = new Camping(_nom);
        this.camping.inicialitzaDadesCamping();
    }

    public void gestioCamping() throws ExcepcioCamping {

        Scanner sc = new Scanner(System.in);

        Menu<OpcionsCamping> menuCamping = new Menu<>("Menu Principal",OpcionsCamping.values());

        menuCamping.setDescripcions(MenuCampingDesc);

        OpcionsCamping opcio = null;

        do{
            menuCamping.mostrarMenu();

            opcio=menuCamping.getOpcio(sc);

            switch (opcio){
                case ALLOTJAMENTS:
                    System.out.println("Gestió de allotjaments:");
                    gestioALL(sc);
                    break;

                case MANTENIMENT:
                    System.out.println("Gestió de tasques de manteniment:");
                    gestioMANT(sc);
                    break;

                case ACCESSOS:
                    System.out.println("Gestió d'accessos:");
                    gestioACC(sc);
                    break;

                case SORTIR:
                    System.out.println("Tancant el programa...");
                    break;
            }

        } while(opcio!=OpcionsCamping.SORTIR);
    }

    private void gestioALL(Scanner sc){

        Menu<OpcioALL> menuALL=new Menu<OpcioALL>("Gestió de allotjaments", OpcioALL.values());

        menuALL.setDescripcions(OpcioALLDesc);

        OpcioALL opcio = null;
        do {
            menuALL.mostrarMenu();
            opcio=menuALL.getOpcio(sc);

            switch(opcio) {
                case OPERATIUS:
                    System.out.println("Allotjaments operatius:");

                    try {
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                    }catch (ExcepcioCamping e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case NO_OPERATIUS:
                    System.out.println("Allotjaments no operatius:");
                    try {
                        System.out.println(camping.llistarAllotjaments("No operatiu"));
                    }catch (ExcepcioCamping e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case MENU_ANTERIOR:
                    System.out.println("Menu anterior");
                    break;
            }

        } while(opcio!= OpcioALL.MENU_ANTERIOR);
    }

    private void gestioMANT(Scanner sc){

        Menu<OpcioMANT> menuMant=new Menu<OpcioMANT>("Gestió del manteniment:", OpcioMANT.values());

        menuMant.setDescripcions(OpcioMANTDesc);

        OpcioMANT opcio = null;
        do {
            menuMant.mostrarMenu();
            Scanner input = new Scanner(System.in);
            opcio=menuMant.getOpcio(sc);

            switch(opcio) {
                case LLISTATASQUES:
                    System.out.println("Llista de tasques de manteninement:");
                    try {
                        System.out.println(camping.llistarTasquesManteniment());
                    }catch (ExcepcioCamping e){
                        System.out.println(e.getMessage());

                }
                    break;
                case AFEGIRTASQUESMANT:
                    System.out.println("Afegir tasca:");

                    int numId, dies;
                    String tipus, idALL, data;

                    try {
                        System.out.println("Id del allotjament que vols afegir la tasca: ");
                        idALL = input.nextLine();
                        System.out.println("Num identificador de la tasca: ");
                        numId = input.nextInt();
                        System.out.println("Tipus de tasca: ");
                        tipus = input.nextLine();
                        System.out.println("Data: ");
                        data = input.nextLine();
                        System.out.println("Durada de la tasca: ");
                        dies = input.nextInt();

                        camping.afegirTascaManteniment(numId, tipus, idALL, data, dies);
                    }catch (ExcepcioCamping e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case COMPLETARTASQUES:
                    System.out.println("Digeu el num de la tasca que vols completar:");

                    try {
                        int num = input.nextInt();
                        camping.completarTascaManteniment(num);
                    }catch (ExcepcioCamping e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case MENU_ANTERIOR:
                    System.out.println("Tornant...");
                    break;
            }

        } while(opcio!= OpcioMANT.MENU_ANTERIOR);
    }

    private void gestioACC(Scanner sc){

        Menu<OpcioACC> menu=new Menu<OpcioACC>("Gestió dels accesos", OpcioACC.values());

        menu.setDescripcions(OpcioACCDesc);

        OpcioACC opcio = null;
        do {
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);

            switch(opcio) {
                case LLISTAACCESSOS:
                    System.out.println("Quins accesos vols llistar? (Oberts/Tancats)");
                    String tipus = sc.nextLine();

                    try {
                        System.out.println(camping.llistarAccessos(tipus));
                    } catch (ExcepcioCamping e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case CALCULARDISPONIBILITAT:
                    System.out.println("Calculant...");
                    try {
                        System.out.println("Hi han " + camping.calculaAccessosNoAccessibles() + " accessos no disponibles.");
                    }catch (ExcepcioCamping e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case TERRATOTAL:
                    System.out.println("Calculant...");
                    try {
                        System.out.println("Hi han " +  camping.calculaMetresTerra() + " metres de terra.");
                    }catch (ExcepcioCamping e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case MENU_ANTERIOR:
                    System.out.println("Tornant...");
                    break;
            }

        } while(opcio!= OpcioACC.MENU_ANTERIOR);
    }

}
