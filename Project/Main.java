package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static List<Dag> dagen = new ArrayList<>();

    public static void main(String[] args) {

        voegDagToe(Dag.MAANDAG);
        voegDagToe(Dag.DINSDAG);
        voegDagToe(Dag.WOENSDAG);
        voegDagToe(Dag.DONDERDAG);
        voegDagToe(Dag.VRIJDAG);
        voegDagToe(Dag.ZATERDAG);
        voegDagToe(Dag.ZONDAG);

        new Main().menu();
    }

    // dit is er voor om specefieke dag uit de lijst te halen.
    public Dag getDag(Dag dag) {
        for (Dag d : dagen) {
            if (d == dag) {
                return d;
            }
        }
        return null;
    }

    // dit is om de hele lijst met dagen op te halen.
    public static List<Dag> getDagen() {
        return dagen;
    }

    public Dag controle_dag(String invoer) {
        switch (invoer.toLowerCase()) {
            case "ma":
                return getDag(Dag.MAANDAG);
            case "di":
                return getDag(Dag.DINSDAG);
            case "wo":
                return getDag(Dag.WOENSDAG);
            case "do":
                return getDag(Dag.DONDERDAG);
            case "vr":
                return getDag(Dag.VRIJDAG);
            case "za":
                return getDag(Dag.ZATERDAG);
            case "zo":
                return getDag(Dag.ZONDAG);
            default:
                return null;
        }
    }

    public void menu() {
        System.out.println("=========================================");
        System.out.println("---------Welkom in Daily Serving---------");
        System.out.println("=========================================");
        System.out.println("Maak Uw keuze uit.");
        System.out.println("Eetmoment reserveren (typ: 1)");
        System.out.println("Eetmomenten bekijken (typ 2)");
        System.out.println("Boodschappen doen voor Eetmoment (typ 3)");
        System.out.println("=========================================");
        String invoer1 = scanner.nextLine();
        controle_menu(invoer1);
    }

    public void controle_menu(String invoer1) {
        switch (invoer1) {
            case "1":
                dag_reserveren_menu();
                break;
            case "2":
                dag_bekijken_menu();
                break;
            case "3":
                boodschappen_bekijken_menu();
                break;
            default:
                System.out.println("Ongeldige invoer. Probeer opnieuw.");
                menu();
                break;
        }
    }

    public void dag_reserveren_menu() {
        System.out.println("=========================================");
        System.out.println("-----------Dag Reserveer Menu------------");
        System.out.println("=========================================");
        System.out.println("Welke dag wilt u bekijken?");
        System.out.println("Ma, Di, Wo, Do, Vr, Za, Zo");
        String dagInvoer = scanner.nextLine();
        Dag gekozenDag = controle_dag(dagInvoer);

        if (gekozenDag != null) {
            gekozenDag.voegEetmomentToeAanDag(gekozenDag);
        } else {
            System.out.println("Ongeldige dag. Probeer opnieuw.");
            dag_reserveren_menu();
        }
    }

    public void dag_bekijken_menu() {
        System.out.println("=========================================");
        System.out.println("-------------Dag Bekijk Menu-------------");
        System.out.println("=========================================");
        System.out.println("Welke dag wilt u bekijken?");
        System.out.println("Ma, Di, Wo, Do, Vr, Za, Zo");
        String DagInvoer = scanner.nextLine();
        System.out.println("=========================================");
        Dag gekozenDag = controle_dag(DagInvoer);

        if (gekozenDag != null) {
            gekozenDag.bekijkGerechtenPerDag(gekozenDag);
        } else {
            System.out.println("Ongeldige dag. Probeer opnieuw.");
            dag_bekijken_menu();
        }
    }

    public void boodschappen_bekijken_menu() {
        System.out.println("=========================================");
        System.out.println("-----Boodschappen Lijst Bekijken Menu----");
        System.out.println("=========================================");
        System.out.println("Welke dag wilt u bekijken?");
        System.out.println("Ma, Di, Wo, Do, Vr, Za, Zo");
        String DagInvoer = scanner.nextLine();
        Dag gekozenDag = controle_dag(DagInvoer);

        if (gekozenDag != null) {
            gekozenDag.bekijkBoodschappenlijst(gekozenDag);
        } else {
            System.out.println("Ongeldige dag. Probeer opnieuw.");
            boodschappen_bekijken_menu();
        }
    }

    public static void voegDagToe(Dag dag) {
        if (!dagen.contains(dag)) {
            dagen.add(dag);
        } else {
            System.out.println("Deze dag is al toegevoegd.");
        }
    }

}