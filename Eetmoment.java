package Project;

import java.util.ArrayList;

public abstract class Eetmoment {
    protected ArrayList<Gerecht> gerechten;
    protected String bereider;

    public Eetmoment() {
        this.gerechten = new ArrayList<>();
    }

    public void voegGerechtToe(String gerechtNaam) {

    }

    public void voegBereiderToe(String bereider) {
        this.bereider = bereider;
    }

}