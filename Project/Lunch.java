package Project;

import java.util.ArrayList;
import java.util.List;

public class Lunch extends Eetmoment {
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
        return gerechten; // Implementatie specifiek voor Ontbijt
    }

    public Gerecht getLaatstToegevoegdGerecht() {
        if (gerechten.isEmpty()) {
            return null;
        }
        return gerechten.get(gerechten.size() - 1);
    }

}