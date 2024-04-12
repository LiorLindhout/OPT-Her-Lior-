package Project;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().menu();
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
        System.out.println("Welke dag wilt u reserveren.");
        System.out.println("U kunt Kiezen uit ma, di, wo, do, vr, za, zo, maak uw keuze.");
        String dagInvoer = scanner.nextLine();
        Dag gekozenDag = Dag.controle_dag(dagInvoer);

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
        System.out.println("Welke dag wilt u bekijken.");
        System.out.println("U kunt Kiezen uit ma, di, wo, do, vr, za,");
        System.out.println("zo, maak uw keuze.");
        String DagInvoer = scanner.nextLine();
        System.out.println("=========================================");
        Dag gekozenDag = Dag.controle_dag(DagInvoer);

        if (gekozenDag != null) {
            gekozenDag.bekijkGerechtenPerDag(gekozenDag);
        } else {
            System.out.println("Ongeldige dag. Probeer opnieuw.");
            dag_reserveren_menu();
        }
    }

    public void boodschappen_bekijken_menu() {
        System.out.println("=========================================");
        System.out.println("-----Boodschappen Lijst Bekijken Menu----");
        System.out.println("=========================================");
        System.out.println("Welke dag wilt u bekijken.");
        System.out.println("U kunt Kiezen uit ma, di, wo, do, vr, za,");
        System.out.println("zo, maak uw keuze.");
        String DagInvoer = scanner.nextLine();
        Dag gekozenDag = Dag.controle_dag(DagInvoer);

        if (gekozenDag != null) {
            gekozenDag.bekijkBoodschappenlijst(gekozenDag);
        } else {
            System.out.println("Ongeldige dag. Probeer opnieuw.");
            boodschappen_bekijken_menu();
        }
    }

}