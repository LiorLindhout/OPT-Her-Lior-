package Project;

import java.util.ArrayList;
import java.util.List;

public abstract class Eetmoment {
    protected ArrayList<Gerecht> gerechten;
    protected String bereider;

    public void toon() {
        if (!gerechten.isEmpty()) {
            System.out.println("Gerechten:");
            for (Gerecht gerecht : gerechten) {
                System.out.println("- " + gerecht.getNaam());
            }
        } else {
            System.out.println("Geen gerechten toegevoegd voor dit eetmoment.");
        }
    }

    public void toonIngredient() {
        if (!gerechten.isEmpty()) {
            System.out.println("Gerechten:");
            for (Gerecht gerecht : gerechten) {
                System.out.println("- " + gerecht.getNaam());
                gerecht.toon();
            }
        } else {
            System.out.println("Geen gerechten toegevoegd voor dit eetmoment.");
        }
    }

    public void voegGerechtToe(String gerechtNaam) {
    }

    public void voegGerechtToeAanEetmoment(Eetmoment eetmoment, Dag dag) {
    }

    public void voegBereiderToe(String bereider) {
        this.bereider = bereider;
    }

    public List<Gerecht> getGerechten() {
        return gerechten;
    }

    public abstract Gerecht getLaatstToegevoegdGerecht();

}