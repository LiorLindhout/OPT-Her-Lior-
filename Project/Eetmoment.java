package Project;

import java.util.ArrayList;
import java.util.List;

public abstract class Eetmoment {
    protected ArrayList<Gerecht> gerechten;
    protected String bereider;

    public Eetmoment() {
        gerechten = new ArrayList<>();
    }

    public void toon() {
        if (gerechten != null && !gerechten.isEmpty()) {
            System.out.println("Gerechten:");
            for (Gerecht gerecht : gerechten) {
                if (gerecht != null) {
                    System.out.println("- " + gerecht.getNaam());
                }
            }
        } else {
            System.out.println("Geen gerechten toegevoegd voor dit eetmoment.");
        }
    }

    public void toonIngredient() {
        if (gerechten != null && !gerechten.isEmpty()) {
            System.out.println("Gerechten:");
            for (Gerecht gerecht : gerechten) {
                System.out.println("- " + gerecht.getNaam());
                if (gerecht != null) {
                    gerecht.toon();
                }
            }
        } else {
            System.out.println("Geen gerechten toegevoegd voor dit eetmoment.");
        }
    }

    public void voegGerechtToe(Gerecht gerecht) {
        gerechten.add(gerecht);
    }

    public abstract void voegGerechtToeAanEetmoment(Eetmoment eetmoment);

    public void voegBereiderToe(String bereider) {
        this.bereider = bereider;
    }

    public List<Gerecht> getGerechten() {
        return gerechten;
    }

    public Gerecht getLaatstToegevoegdGerecht() {
        if (gerechten.isEmpty()) {
            return null;
        }
        return gerechten.get(gerechten.size() - 1);
    }

}