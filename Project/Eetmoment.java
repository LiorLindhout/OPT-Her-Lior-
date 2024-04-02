package Project;

import java.util.ArrayList;
import java.util.List;

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

    public List<Gerecht> getGerechten() {
        return gerechten;
    }

}