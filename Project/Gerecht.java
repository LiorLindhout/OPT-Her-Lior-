package Project;

import java.util.ArrayList;
import java.util.List;

public class Gerecht {
    private String naam;
    private List<Ingredient> ingredienten;

    public Gerecht(String naam) {
        this.naam = naam;
        this.ingredienten = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void voegIngredientToe(String naam, int hoeveelheid, String eenheid) {
        Ingredient nieuwIngredient = new Ingredient(naam, hoeveelheid, eenheid);
        ingredienten.add(nieuwIngredient);
    }

}