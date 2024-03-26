package Project;

import java.util.ArrayList;

public class Avondeten extends Eetmoment {
    private ArrayList<Gerecht> gerechten;
    private String bereider;

    public Avondeten(String bereider) {
        this.bereider = bereider;
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

}