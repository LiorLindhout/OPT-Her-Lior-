package Project;

import java.util.List;
import java.util.ArrayList;

public enum Dag {
    MAANDAG(new ArrayList<>()),
    DINSDAG(new ArrayList<>()),
    WOENSDAG(new ArrayList<>()),
    DONDERDAG(new ArrayList<>()),
    VRIJDAG(new ArrayList<>()),
    ZATERDAG(new ArrayList<>()),
    ZONDAG(new ArrayList<>());

    private List<Eetmoment> eetmomenten;

    Dag(List<Eetmoment> eetmomenten) {
        this.eetmomenten = eetmomenten;
    }

    public List<Eetmoment> getEetmomenten() {
        return eetmomenten;
    }

    public void voegEetmomentToe(Eetmoment eetmoment) {
        eetmomenten.add(eetmoment);
    }
}