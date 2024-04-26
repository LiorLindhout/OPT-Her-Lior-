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
        super();
    }

    public String getbereider() {
        return bereider;
    }

    public void setbereider(String bereider) {
        this.bereider = bereider;
    }

    @Override
    public void voegGerechtToe(Gerecht gerecht) {
        super.voegGerechtToe(gerecht);
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
    public void voegGerechtToeAanEetmoment(Eetmoment eetmoment) {
        System.out.println("=========================================");
        System.out.println("Voer de naam van het gerecht in:");
        String gerechtNaam = scanner.nextLine();
        System.out.println("=========================================");
        System.out.println("Voer de naam van de Bereider in:");
        String bereider = scanner.nextLine();

        Gerecht gerecht = new Gerecht(gerechtNaam);
        voegGerechtToe(gerecht);
        voegBereiderToe(bereider);

        gerecht.IngredientenToevoegen(eetmoment);
    }

}