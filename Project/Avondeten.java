package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Avondeten extends Eetmoment {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Gerecht> gerechten;
    Gerecht gerecht = new Gerecht(getbereider());
    private String bereider;

    public Avondeten(String bereider) {
        this.bereider = bereider;
        Avondeten.gerechten = new ArrayList<>();
    }

    public String getbereider() {
        return bereider;
    }

    public void setbereider(String bereider) {
        this.bereider = bereider;
    }

    @Override
    public void voegGerechtToe(String gerechtNaam) {
        Gerecht nieuwGerecht = new Gerecht(gerechtNaam);
        gerechten.add(nieuwGerecht);
    }

    @Override
    public void voegBereiderToe(String Bereider) {
        setbereider(bereider);
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
        System.out.println("=========================================");
        System.out.println("Voer de naam van de Bereider in:");
        String bereider = scanner.nextLine();

        voegGerechtToe(gerechtNaam);
        voegBereiderToe(bereider);

        gerecht.IngredientenToevoegen(eetmoment);
    }

}