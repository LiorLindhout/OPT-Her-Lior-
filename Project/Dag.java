package Project;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public enum Dag {
    MAANDAG,
    DINSDAG,
    WOENSDAG,
    DONDERDAG,
    VRIJDAG,
    ZATERDAG,
    ZONDAG;

    static Scanner scanner = new Scanner(System.in);

    private List<Eetmoment> eetmomenten;

    Main main = new Main();

    Dag() {
        this.eetmomenten = new ArrayList<>();
    }

    public void voegEetmomentToe(Eetmoment eetmoment) {
        eetmomenten.add(eetmoment);
    }

    public static Dag controle_dag(String invoer) {
        switch (invoer.toLowerCase()) {
            case "ma":
                return Dag.MAANDAG;
            case "di":
                return Dag.DINSDAG;
            case "wo":
                return Dag.WOENSDAG;
            case "do":
                return Dag.DONDERDAG;
            case "vr":
                return Dag.VRIJDAG;
            case "za":
                return Dag.ZATERDAG;
            case "zo":
                return Dag.ZONDAG;
            default:
                return null;
        }
    }

    public void voegEetmomentToeAanDag(Dag dag) {
        System.out.println("=========================================");
        System.out.println("Aan welk eetmoment wilt u een gerecht ");
        System.out.println("toevoegen ?");
        System.out.println("Typ 'Ont' voor Ontbijt, typ 'Lun' voor ");
        System.out.println("Lunch, typ 'Avo' voor Avondeten:");
        String eetmomentNaam = scanner.nextLine().toLowerCase();

        Eetmoment eetmoment = null;

        switch (eetmomentNaam) {
            case "ont":
                eetmoment = new Ontbijt();
                break;
            case "lun":
                eetmoment = new Lunch();
                break;
            case "avo":
                eetmoment = new Avondeten(null);
                break;
            default:
                System.out.println("Ongeldige invoer voor eetmoment. Probeer opnieuw.");
                voegEetmomentToeAanDag(dag);
                return;
        }

        eetmoment.voegGerechtToeAanEetmoment(eetmoment, dag);
    }

    void bekijkGerechtenPerDag(Dag dag) {
        System.out.println("Gerechten voor " + dag.name() + ":");
        if (eetmomenten.isEmpty()) {
            System.out.println("Geen eetmomenten toegevoegd voor " + dag.name());
            System.out.println("=========================================");
            main.menu();
        } else {
            for (Eetmoment eetmoment : eetmomenten) {
                System.out.println("Eetmoment: " + eetmoment.getClass().getSimpleName());
                eetmoment.toon();
            }
        }
        System.out.println("=========================================");
        main.menu();
    }

    void bekijkBoodschappenlijst(Dag dag) {
        System.out.println("Boodschappenlijst voor " + dag.name() + ":");
        if (eetmomenten.isEmpty()) {
            System.out.println("Geen eetmomenten toegevoegd voor " + dag.name());
            main.menu();
        } else {
            for (Eetmoment eetmoment : eetmomenten) {
                System.out.println("Eetmoment: " + eetmoment.getClass().getSimpleName());
                eetmoment.toonIngredient();
            }
        }
    }
}