package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("=========================================");
        System.out.println("---------Welkom in Daily Serving---------");
        System.out.println("=========================================");
        System.out.println("Maak Uw keuze uit.");
        System.out.println("Eetmoment reserveren (typ: 1)");
        System.out.println("Eetmomenten bekijken (typ 2)");
        System.out.println("Boodschappen doen voor Eetmoment (typ 3)");
        System.out.println("Beheren (typ 4)");
        System.out.println("=========================================");
        String invoer1 = scanner.nextLine();
        controle_menu(invoer1);
    }

    public static void controle_menu(String invoer1) {
        switch (invoer1) {
            case "1":
                dag_reserveren_menu();
                break;
            case "2":
                dag_bekijken_menu();
                break;
            case "3":
                boodsschappen_bekijken_menu();
                break;
            case "4":
                beheer_menu();
                break;
            default:
                System.out.println("Ongeldige invoer. Probeer opnieuw.");
                menu();
                break;
        }
    }

    public static void dag_reserveren_menu() {
        System.out.println("=========================================");
        System.out.println("-----------Dag Reserveer Menu------------");
        System.out.println("=========================================");
        System.out.println("Welke dag wilt u reserveren.");
        System.out.println("U kunt Kiezen uit ma, di, wo, do, vr, za, zo, maak uw keuze.");
        String dagInvoer = scanner.nextLine();
        Dag gekozenDag = controle_dag(dagInvoer);

        if (gekozenDag != null) {
            voegEetmomentToeAanDag(gekozenDag);
        } else {
            System.out.println("Ongeldige dag. Probeer opnieuw.");
            dag_reserveren_menu();
        }
    }

    public static void dag_bekijken_menu() {
        System.out.println("=========================================");
        System.out.println("-------------Dag Bekijk Menu-------------");
        System.out.println("=========================================");
        System.out.println("Welke dag wilt u bekijken.");
        System.out.println("U kunt Kiezen uit ma, di, wo, do, vr, za,");
        System.out.println("zo, maak uw keuze.");
        String DagInvoer = scanner.nextLine();
        Dag gekozenDag = controle_dag(DagInvoer);

        if (gekozenDag != null) {
            bekijkGerechtenPerDag(gekozenDag);
        } else {
            System.out.println("Ongeldige dag. Probeer opnieuw.");
            dag_reserveren_menu();
        }
    }

    public static void boodsschappen_bekijken_menu() {
        System.out.println("=========================================");
        System.out.println("-----Boodschappen Lijst Bekijken Menu----");
        System.out.println("=========================================");
        String DagInvoer = scanner.nextLine();
        Dag gekozenDag = controle_dag(DagInvoer);

        if (gekozenDag != null) {
            bekijkBoodschappenlijst(gekozenDag);
        } else {
            System.out.println("Ongeldige dag. Probeer opnieuw.");
            boodsschappen_bekijken_menu();
        }
    }

    public static void beheer_menu() {
        System.out.println("=========================================");
        System.out.println("---------------Beheer Menu---------------");
        System.out.println("=========================================");
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
        System.out.println("Aan welk eetmoment wilt u een gerecht toevoegen?");
        System.out.println("Typ 'Ont' voor Ontbijt, typ 'Lun' voor Lunch, typ 'Avo' voor Avondeten:");
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

        voegGerechtToeAanEetmoment(eetmoment, dag);
    }

    public static void voegGerechtToeAanEetmoment(Eetmoment eetmoment, Dag dag) {
        if (eetmoment == null) {
            System.out.println("Ongeldige eetmoment.");
            return;
        }

        if (eetmoment instanceof Avondeten) {
            System.out.println("Voer de naam van het gerecht in:");
            String gerechtNaam = scanner.nextLine();
            System.out.println("Voer de ingrediënten in voor het gerecht: " + gerechtNaam);
            List<Ingredient> ingredienten = new ArrayList<>();
            boolean doorgaan = true;

            while (doorgaan) {
                System.out.println("Voer de naam van een ingrediënt in (of typ stop):");
                String ingredientNaam = scanner.nextLine();
                if (ingredientNaam.equalsIgnoreCase("stop")) {
                    doorgaan = false;
                } else {
                    System.out.println("Welke meetwaarde heeft dit Ingredient (Liter , Gram)");
                    String meetwaarde = scanner.nextLine();
                    System.out.println(
                            "Wat is de hoeveelheid die u nodig heeft van dit Ingredient. In de eerder aangegeven meetwaarde. ");
                    int hoeveelheid = scanner.nextInt();
                    scanner.nextLine();

                    Ingredient ingredient = new Ingredient(ingredientNaam, hoeveelheid, meetwaarde);
                    ingredienten.add(ingredient);
                }
            }
            System.out.println("Voer de naam van de Berijder in:");
            String Berijder = scanner.nextLine();

            Gerecht nieuwGerecht = new Gerecht(gerechtNaam);

            ((Avondeten) eetmoment).voegGerechtToe(nieuwGerecht);
            ((Avondeten) eetmoment).voegBereiderToe(Berijder);

            System.out.println(
                    "Gerecht " + gerechtNaam + " toegevoegd aan " + eetmoment.getClass().getSimpleName() + " op "
                            + dag.name() + " met Berijder " + Berijder + ".");
            menu();
        }

        else {
            System.out.println("Voer de naam van het gerecht in:");
            String gerechtNaam = scanner.nextLine();
            System.out.println("Voer de ingrediënten in voor het gerecht: " + gerechtNaam);
            List<Ingredient> ingredienten = new ArrayList<>();
            boolean doorgaan = true;

            while (doorgaan) {
                System.out.println("Voer de naam van een ingrediënt in (of typ stop):");
                String ingredientNaam = scanner.nextLine();
                if (ingredientNaam.equalsIgnoreCase("stop")) {
                    doorgaan = false;
                } else {
                    System.out.println("Welke meetwaarde heeft dit Ingredient (Liter , Gram)");
                    String meetwaarde = scanner.nextLine();
                    System.out.println(
                            "Wat is de hoeveelheid die u nodig heeft van dit Ingredient. In de eerder aangegeven meetwaarde. ");
                    int hoeveelheid = scanner.nextInt();
                    scanner.nextLine();

                    Ingredient ingredient = new Ingredient(ingredientNaam, hoeveelheid, meetwaarde);
                    ingredienten.add(ingredient);
                }
            }

            Gerecht nieuwGerecht = new Gerecht(gerechtNaam);

            if (eetmoment instanceof Lunch) {
                ((Lunch) eetmoment).voegGerechtToe(nieuwGerecht);
            } else if (eetmoment instanceof Ontbijt) {
                ((Ontbijt) eetmoment).voegGerechtToe(nieuwGerecht);
            } else {
                System.out.println("Ongeldige eetmoment.");
                return;
            }

            System.out.println(
                    "Gerecht " + gerechtNaam + " toegevoegd aan " + eetmoment.getClass().getSimpleName() + " op "
                            + dag.name() + ".");

            menu();
        }
    }

    private static void bekijkBoodschappenlijst(Dag dag) {

    }
}