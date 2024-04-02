package Project;

import java.util.ArrayList;
import java.util.List;

public class Avondeten extends Eetmoment {
    private ArrayList<Gerecht> gerechten;
    private String bereider;

    public Avondeten(String bereider) {
        this.bereider = bereider;
        this.gerechten = new ArrayList<>();
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
        return gerechten; // Implementatie specifiek voor Ontbijt
    }

    public Gerecht getLaatstToegevoegdGerecht() {
        if (gerechten.isEmpty()) {
            return null;
        }
        return gerechten.get(gerechten.size() - 1);
    }

}