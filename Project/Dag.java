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
        dag.voegEetmomentToe(eetmoment);

        eetmoment.voegGerechtToeAanEetmoment(eetmoment, dag);
    }

    void bekijkGerechtenPerDag(Dag dag) {
        Dag huidigeDag = main.getDag(dag);
        System.out.println("Gerechten voor " + huidigeDag.name() + ":");
        if (eetmomenten.isEmpty()) {
            System.out.println("Geen eetmomenten toegevoegd voor " + huidigeDag.name());
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
        Dag huidigeDag = main.getDag(dag);
        System.out.println("Boodschappenlijst voor " + huidigeDag.name() + ":");
        if (eetmomenten.isEmpty()) {
            System.out.println("Geen eetmomenten toegevoegd voor " + huidigeDag.name());
        } else {
            for (Eetmoment eetmoment : eetmomenten) {
                System.out.println("Eetmoment: " + eetmoment.getClass().getSimpleName());
                eetmoment.toonIngredient();
            }
        }
        main.menu();
    }
}