package Project;

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

        voegGerechtToeAanEetmoment(eetmoment, dag);
    }

    public static void voegGerechtToeAanEetmoment(Eetmoment eetmoment, Dag dag) {
        if (eetmoment == null) {
            System.out.println("Ongeldige eetmoment.");
            return;
        }

        if (eetmoment instanceof Avondeten) {
            System.out.println("=========================================");
            System.out.println("Voer de naam van het gerecht in:");
            String gerechtNaam = scanner.nextLine();
            System.out.println("=========================================");
            System.out.println("Voer de ingrediënten in voor het gerecht: " + gerechtNaam);
            boolean doorgaan = true;

            System.out.println("=========================================");
            System.out.println("Voer de naam van de Berijder in:");
            String Berijder = scanner.nextLine();

            ((Avondeten) eetmoment).voegGerechtToe(gerechtNaam);
            ((Avondeten) eetmoment).voegBereiderToe(Berijder);

            while (doorgaan) {
                System.out.println("=========================================");
                System.out.println("Voer de naam van een ingrediënt in ");
                System.out.println("of typ stop");
                String ingredientNaam = scanner.nextLine();
                if (ingredientNaam.equalsIgnoreCase("stop")) {
                    doorgaan = false;
                } else {
                    System.out.println("=========================================");
                    System.out.println("Welke meetwaarde heeft dit Ingredient");
                    System.out.println("(Liter , Gram)");
                    String meetwaarde = scanner.nextLine();
                    System.out.println("=========================================");
                    System.out.println("Wat is de hoeveelheid die u nodig heeft ");
                    System.out.println("van dit Ingredient. In de eerder ");
                    System.out.println("aangegeven meetwaarde. ");
                    int hoeveelheid = scanner.nextInt();
                    scanner.nextLine();

                    Gerecht gerecht = ((Avondeten) eetmoment).getLaatstToegevoegdGerecht();
                    gerecht.voegIngredientToe(ingredientNaam, hoeveelheid, meetwaarde);
                }
            }

            System.out.println(
                    "Gerecht " + gerechtNaam + " toegevoegd aan " + eetmoment.getClass().getSimpleName() + " op "
                            + dag.name() + " met Berijder " + Berijder + ".");
            menu();
        }

        else {
            System.out.println("=========================================");
            System.out.println("Voer de naam van het gerecht in:");
            String gerechtNaam = scanner.nextLine();
            System.out.println("=========================================");
            System.out.println("Voer de ingrediënten in voor het");
            System.out.println("gerecht:" + gerechtNaam);
            boolean doorgaan = true;

            if (eetmoment instanceof Lunch) {
                ((Lunch) eetmoment).voegGerechtToe(gerechtNaam);
            } else if (eetmoment instanceof Ontbijt) {
                ((Ontbijt) eetmoment).voegGerechtToe(gerechtNaam);
            } else {
                System.out.println("Ongeldige eetmoment.");
                return;
            }

            while (doorgaan) {
                System.out.println("=========================================");
                System.out.println("Voer de naam van een ingrediënt in ");
                System.out.println("of typ stop");
                String ingredientNaam = scanner.nextLine();
                if (ingredientNaam.equalsIgnoreCase("stop")) {
                    doorgaan = false;
                } else {
                    System.out.println("=========================================");
                    System.out.println("Welke meetwaarde heeft dit Ingredient");
                    System.out.println("(Liter , Gram)");
                    String meetwaarde = scanner.nextLine();
                    System.out.println("=========================================");
                    System.out.println("Wat is de hoeveelheid die u nodig heeft ");
                    System.out.println("van dit Ingredient. In de eerder ");
                    System.out.println("aangegeven meetwaarde. ");
                    int hoeveelheid = scanner.nextInt();
                    scanner.nextLine();

                    if (eetmoment instanceof Ontbijt) {
                        Gerecht gerecht = ((Ontbijt) eetmoment).getLaatstToegevoegdGerecht();
                        gerecht.voegIngredientToe(ingredientNaam, hoeveelheid, meetwaarde);
                    } else if (eetmoment instanceof Lunch) {
                        Gerecht gerecht = ((Lunch) eetmoment).getLaatstToegevoegdGerecht();
                        gerecht.voegIngredientToe(ingredientNaam, hoeveelheid, meetwaarde);
                    }
                }
            }

            System.out.println(
                    "Gerecht " + gerechtNaam + " toegevoegd aan " + eetmoment.getClass().getSimpleName() + " op "
                            + dag.name() + ".");

            menu();
        }
    }

    private static void bekijkGerechtenPerDag(Dag dag) {
        System.out.println("Gerechten voor " + dag.name() + ":");

        List<Eetmoment> eetmomenten = dag.getEetmomenten();

        if (eetmomenten.isEmpty()) {
            System.out.println("Geen eetmomenten toegevoegd voor " + dag.name());
            return;
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
        menu();
    }

    private static void bekijkBoodschappenlijst(Dag dag) {

    }
}