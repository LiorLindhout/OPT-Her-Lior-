package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerecht {
    static Scanner scanner = new Scanner(System.in);
    private String naam;
    private List<Ingredient> ingredienten;

    public Gerecht(String naam) {
        this.naam = naam;
        this.ingredienten = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void voegIngredientToe(String naam, int hoeveelheid, String eenheid) {
        Ingredient nieuwIngredient = new Ingredient(naam, hoeveelheid, eenheid);
        ingredienten.add(nieuwIngredient);
    }

    public static void IngredientenToevoegen(Eetmoment eetmoment) {
        System.out.println("Voer de ingrediënten in voor Uw gerecht");
        boolean doorgaan = true;

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

                Gerecht gerecht = null;
                if (eetmoment instanceof Avondeten) {
                    gerecht = ((Avondeten) eetmoment).getLaatstToegevoegdGerecht();
                } else if (eetmoment instanceof Ontbijt) {
                    gerecht = ((Ontbijt) eetmoment).getLaatstToegevoegdGerecht();
                } else if (eetmoment instanceof Lunch) {
                    gerecht = ((Lunch) eetmoment).getLaatstToegevoegdGerecht();
                }

                if (gerecht != null) {
                    gerecht.voegIngredientToe(ingredientNaam, hoeveelheid, meetwaarde);
                } else {
                }
            }
        }
        Main.menu();
    }

}