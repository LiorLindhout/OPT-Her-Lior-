package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ontbijt extends Eetmoment {
    static Scanner scanner = new Scanner(System.in);
    Gerecht gerecht = new Gerecht(null);
    private static ArrayList<Gerecht> gerechten;

    public Ontbijt() {
        Ontbijt.gerechten = new ArrayList<>();
    }

    @Override
    public void voegGerechtToe(String gerechtNaam) {
        Gerecht nieuwGerecht = new Gerecht(gerechtNaam);
        gerechten.add(nieuwGerecht);
    }

    @Override
    public void voegBereiderToe(String Bereider) {
    }

    @Override
    public List<Gerecht> getGerechten() {
        return gerechten;
    }

    @Override
    public Gerecht getLaatstToegevoegdGerecht() {
        if (gerechten.isEmpty()) {
            return null;
        }
        return gerechten.get(gerechten.size() - 1);
    }

    @Override
    public void voegGerechtToeAanEetmoment(Eetmoment eetmoment, Dag dag) {
        System.out.println("=========================================");
        System.out.println("Voer de naam van het gerecht in:");
        String gerechtNaam = scanner.nextLine();

        voegGerechtToe(gerechtNaam);

        gerecht.IngredientenToevoegen(eetmoment);
    }

}