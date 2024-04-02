package Project;

import java.util.ArrayList;
import java.util.List;

public class Ontbijt extends Eetmoment {
    private ArrayList<Gerecht> gerechten;

    public Ontbijt() {
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

}