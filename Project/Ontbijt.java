package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ontbijt extends Eetmoment {
    static Scanner scanner = new Scanner(System.in);
    Gerecht gerecht = new Gerecht(null);
    private ArrayList<Gerecht> gerechten;

    public Ontbijt() {
        gerechten = new ArrayList<>();
    }

    @Override
    public void voegBereiderToe(String Bereider) {
    }

    @Override
    public List<Gerecht> getGerechten() {
        return gerechten;
    }

    // we hebben een gerecht hier boven aan gemaakt en je maakt een nieuw gerecht
    // aan in de methode voegGerechtToe dus dat moet anders
    @Override
    public void voegGerechtToeAanEetmoment(Eetmoment eetmoment) {
        System.out.println("=========================================");
        System.out.println("Voer de naam van het gerecht in:");
        String gerechtNaam = scanner.nextLine();

        Gerecht gerecht = new Gerecht(gerechtNaam);
        voegGerechtToe(gerecht);

        gerecht.IngredientenToevoegen(eetmoment);
    }

    @Override
    public void voegGerechtToe(Gerecht gerecht) {
        super.voegGerechtToe(gerecht);
    }
}