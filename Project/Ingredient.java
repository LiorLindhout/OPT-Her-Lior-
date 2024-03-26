package Project;

public class Ingredient {
    private String naam;
    private int hoeveelheid;
    private String eenheid;

    public Ingredient(String naam, int hoeveelheid, String eenheid) {
        this.naam = naam;
        this.hoeveelheid = hoeveelheid;
        this.eenheid = eenheid;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    public String getEenheid() {
        return eenheid;
    }

    public void setEenheid(String eenheid) {
        this.eenheid = eenheid;
    }

}