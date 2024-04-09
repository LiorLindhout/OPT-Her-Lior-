package Project;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public enum Dag {
    MAANDAG(new ArrayList<>()),
    DINSDAG(new ArrayList<>()),
    WOENSDAG(new ArrayList<>()),
    DONDERDAG(new ArrayList<>()),
    VRIJDAG(new ArrayList<>()),
    ZATERDAG(new ArrayList<>()),
    ZONDAG(new ArrayList<>());

    static Scanner scanner = new Scanner(System.in);

    private List<Eetmoment> eetmomenten;

    Dag(List<Eetmoment> eetmomenten) {
        this.eetmomenten = eetmomenten;
    }

    public List<Eetmoment> getEetmomenten() {
        return eetmomenten;
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

    public static void voegEetmomentToeAanDag(Dag dag) {
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

    static void bekijkGerechtenPerDag(Dag dag) {
        System.out.println("Gerechten voor " + dag.name() + ":");

        List<Eetmoment> eetmomenten = dag.getEetmomenten();

        if (eetmomenten.isEmpty()) {
            System.out.println("Geen eetmomenten toegevoegd voor " + dag.name());
            Main.menu();
        }

        for (Eetmoment eetmoment : eetmomenten) {
            System.out.println("Eetmoment: " + eetmoment.getClass().getSimpleName());

            List<Gerecht> gerechten = eetmoment.getGerechten();

            if (!gerechten.isEmpty()) {
                System.out.println("Gerechten:");
                for (Gerecht gerecht : gerechten) {
                    System.out.println("- " + gerecht.getNaam());
                }
            } else {
                System.out.println("Geen gerechten toegevoegd voor dit eetmoment.");
            }
        }
        Main.menu();
    }

    static void bekijkBoodschappenlijst(Dag dag) {
        System.out.println("Boodschappenlijst voor " + dag.name() + ":");

        List<Eetmoment> eetmomenten = dag.getEetmomenten();

        if (eetmomenten.isEmpty()) {
            System.out.println("Geen eetmomenten toegevoegd voor " + dag.name());
            Main.menu();
        }

        for (Eetmoment eetmoment : eetmomenten) {
            System.out.println("Eetmoment: " + eetmoment.getClass().getSimpleName());

            List<Gerecht> gerechten = eetmoment.getGerechten();

            if (!gerechten.isEmpty()) {
                System.out.println("Ingredienten:");
                for (Gerecht gerecht : gerechten) {
                    List<Ingredient> ingredienten = gerecht.getIngredienten();
                    for (Ingredient ingredient : ingredienten) {
                        System.out.println("- " + ingredient.getNaam() + " (" + ingredient.getHoeveelheid() + " "
                                + ingredient.getEenheid() + ")");

                        Main.menu();
                    }
                }
            } else {
                System.out.println("Geen gerechten toegevoegd voor dit eetmoment.");
            }
        }
    }
}