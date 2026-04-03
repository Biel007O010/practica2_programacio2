package prog2.vista;

import prog2.model.Camping;
import prog2.model.InCamping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaCamping{

    private enum OpcionsMenu{
        LLISTAR_TOT_ALLOTJAMENTS,
        LLISTAR_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS,
        LLISTAR_TASQUES,
        AFEGIR_TASCA,
        COMPLETAR_TASCA,
        CALCUL_ACCESSIBILITAT,
        CALCUL_METRES_TERRA,
        GUARDAR,
        CARREGAR,
        SORTIR
    }

    private static final String[]descripcions ={
            "Llistar la informació de tots els allotjaments",
            "Llistar la informació dels allotjaments operatius",
            "Llistar la informació dels allotjaments no operatius",
            "Llistar la informació dels accessos oberts",
            "Llistar la informació dels accessos tancats",
            "Llistar la informació dels les tasques de manteniment actives",
            "Afegir una nova tasca de manteniment",
            "Completar una tasca de manteniment",
            "Calcular i mostrar els accessos no accessibles amb vehicle",
            "Calcular i mostrar els metres totals de camins de terra",
            "Guardar Càmping",
            "Recuperar Càmping",
            "Sortir de l'aplicació"
    };

    private Camping camping;

    public VistaCamping(String _nom) throws ExcepcioCamping{
        this.camping = new Camping(_nom);
        this.camping.inicialitzaDadesCamping();
    }

    public void gestioCamping() throws ExcepcioCamping{
        Scanner sc = new Scanner(System.in);
        Menu<OpcionsMenu> menuCamping = new Menu<>("Menú de gestió", OpcionsMenu.values());
        menuCamping.setDescripcions(descripcions);

        OpcionsMenu opcio;
        do{
            menuCamping.mostrarMenu();
            opcio = menuCamping.getOpcio(sc);

            try{
                switch (opcio){
                    case LLISTAR_TOT_ALLOTJAMENTS:
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                        System.out.println(camping.llistarAllotjaments("No operatiu"));
                        break;
                    case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                        break;
                    case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                        System.out.println(camping.llistarAllotjaments("No operatiu"));
                        break;
                    case LLISTAR_ACCESSOS_OBERTS:
                        System.out.println(camping.llistarAccessos("Oberts"));
                        break;
                    case LLISTAR_ACCESSOS_TANCATS:
                        System.out.println(camping.llistarAccessos("Tancats"));
                        break;
                    case LLISTAR_TASQUES:
                        System.out.println(camping.llistarTasquesManteniment());
                        break;
                    case AFEGIR_TASCA:
                        System.out.println("Afegir tasca:");
                        int numId, dies;
                        String tipus, idALL, data;
                        try {
                            System.out.println("Id del allotjament que vols afegir la tasca: ");
                            idALL = sc.nextLine();
                            System.out.println("Num identificador de la tasca: ");
                            numId = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Tipus de tasca: ");
                            tipus = sc.nextLine();
                            System.out.println("Data: ");
                            data = sc.nextLine();
                            System.out.println("Durada de la tasca: ");
                            dies = sc.nextInt();
                            sc.nextLine();

                            camping.afegirTascaManteniment(numId, tipus, idALL, data, dies);
                        }catch (InputMismatchException e){
                            System.err.println("ERROR: format incorrecte, torneu a intentar...");
                            sc.nextLine();
                        }
                        break;
                    case COMPLETAR_TASCA:
                        System.out.println("Digeu el num de la tasca que vols completar:");
                        try {
                            int numTasca = sc.nextInt();
                            sc.nextLine();
                            camping.completarTascaManteniment(numTasca);
                        }catch (InputMismatchException e){
                            System.err.println("ERROR: format incorrecte, heu de introduir un num.");
                            sc.nextLine();
                        }
                        break;
                    case CALCUL_ACCESSIBILITAT:
                        System.out.println("Hi han " + camping.calculaAccessosNoAccessibles() + " accessos no accessibles amb vehicle.");
                        break;
                    case CALCUL_METRES_TERRA:
                        System.out.println("Hi han " + camping.calculaMetresTerra() + " metres de terra.");
                        break;
                    case GUARDAR:
                        System.out.println("Poseu la direcció del fitxer que vols guardar: ");
                        String desti = sc.nextLine();
                        camping.save(desti);
                        break;
                    case CARREGAR:
                        System.out.println("Poseu la direcció del fitxer que vols carregar: ");
                        String origen = sc.next();
                        this.camping = Camping.load(origen);
                        break;
                    case SORTIR:
                        System.out.println("Tancant el programa...");
                        break;
                }
            }catch (ExcepcioCamping e){
                System.out.println(e.getMessage());
            }
        }while (opcio != OpcionsMenu.SORTIR);
    }
}
