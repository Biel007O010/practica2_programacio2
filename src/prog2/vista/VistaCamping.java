package prog2.vista;

import prog2.model.Camping;
import prog2.model.InCamping;

import java.util.Scanner;

public class VistaCamping{

    private enum OpcionsMenu{
        MOSTRAR_NOM,
        LLISTAR_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS,
        LLISTAR_TASQUES,
        AFEGIR_TASCA,
        COMPLETAR_TASCA,
        CALCUL_METRES_TERRA,
        CALCUL_ACCESSIBILITAT,
        GUARDAR,
        CARREGAR,
        SORTIR
    }

    private static final String[]descripcions ={
            "Mostrar el nom del càmping",
            "Llistar allotjaments operatius",
            "Llistar allotjaments no operatius",
            "Llistar accessos oberts",
            "Llistar accessos tancats",
            "Llistar totes les tasques de manteniment",
            "Afegir una nova tasca de manteniment",
            "Completar una tasca de manteniment",
            "Calcular metres totals de camins de terra",
            "Calcular accessos no accessibles",
            "Guardar dade",
            "Carregar dades",
            "Sortir"
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
                    case MOSTRAR_NOM:
                        System.out.println("Nom del càmping: " + camping.getNomCamping());
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
                        Scanner input = new Scanner(System.in);
                        int numId, dies;
                        String tipus, idALL, data;

                        System.out.println("Id del allotjament que vols afegir la tasca: ");
                        idALL = input.nextLine();
                        System.out.println("Num identificador de la tasca: ");
                        numId = input.nextInt();
                        input.nextLine();
                        System.out.println("Tipus de tasca: ");
                        tipus = input.nextLine();
                        System.out.println("Data: ");
                        data = input.nextLine();
                        System.out.println("Durada de la tasca: ");
                        dies = input.nextInt();

                        camping.afegirTascaManteniment(numId, tipus, idALL, data, dies);
                        break;
                    case COMPLETAR_TASCA:
                        System.out.println("Digeu el num de la tasca que vols completar:");
                        int n = sc.nextInt(); sc.nextLine();
                        camping.completarTascaManteniment(n);
                        break;
                    case CALCUL_METRES_TERRA:
                        System.out.println("Hi han " + camping.calculaMetresTerra() + " metres de terra.");
                        break;
                    case CALCUL_ACCESSIBILITAT:
                        System.out.println("Hi han " + camping.calculaAccessosNoAccessibles() + " accessos no disponibles.");
                        break;
                    case GUARDAR:
                        System.out.println("Poseu la direcció del fitxer que vols guardar: ");
                        camping.save(sc.nextLine());
                        break;
                    case CARREGAR:
                        System.out.println("Poseu la direcció del fitxer que vols carregar: ");
                        this.camping = InCamping.load(sc.nextLine());
                        break;
                    case SORTIR:
                        System.out.println("Tancant el programa...");
                        break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (opcio != OpcionsMenu.SORTIR);
    }
}
