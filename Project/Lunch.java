package Project;

import java.util.ArrayList;

public class Lunch extends Eetmoment {
    private ArrayList<Gerecht> gerechten;

    @Override
    public void voegGerechtToe(String gerechtNaam) {
        Gerecht nieuwGerecht = new Gerecht(gerechtNaam);
        gerechten.add(nieuwGerecht);
    }

    @Override
    public void voegBereiderToe(String Bereider) {
    }
}