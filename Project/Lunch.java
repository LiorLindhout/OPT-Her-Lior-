package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lunch extends Eetmoment {
    static Scanner scanner = new Scanner(System.in);
    private ArrayList<Gerecht> gerechten;

    public Lunch() {
        this.gerechten = new ArrayList<>();
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

        Gerecht.IngredientenToevoegen(eetmoment);
    }

}