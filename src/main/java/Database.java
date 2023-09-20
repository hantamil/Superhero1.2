import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import static java.util.List.of;

public class Database {
    private int count = 0;

    public ArrayList<Superhero> superheroList = new ArrayList<>();

    public Database() {
        this.superheroList = new ArrayList<>();

        superheroList.add(new Superhero("Superman", "Clark", " Kent", "Flight", "Human"));
        superheroList.add(new Superhero("Batman", "Bruce", " Wayne", "Strong", "Human"));
        superheroList.add(new Superhero("Spiderman", "Peter", " Parker", "Web", "Human"));
    }

    public void addSuperhero(String superheroName, String firstName, String lastName, String abilities, String creature) {
        Superhero superhero = new Superhero(superheroName, firstName, lastName, abilities, creature);
        superheroList.add(superhero);
    }

    public ArrayList<Superhero> getSuperheroList() {
        return superheroList;
    }

    public ArrayList<Superhero> findSuperhero(String superheroName) {
        ArrayList<Superhero> searchSHN = new ArrayList<>();

        for (Superhero superhero : superheroList) {
            if (superhero.getSuperheroName().toLowerCase().contains(superheroName.toLowerCase())) {
                    searchSHN.add(superhero);
            }
        }
        return searchSHN;
    }

    public ArrayList<String> findSuperheroesNames(String superheroName) {
        ArrayList<Superhero> superheroes = findSuperhero(superheroName);
        ArrayList<String> superheroNames = new ArrayList<String>();
        for (Superhero superhero : superheroes) {
            superheroNames.add(superhero.getSuperheroName());
        }
        return superheroNames;
    }

    public void editSuperhero(String superheroName, String newSuperheroName, String newFirstName, String newLastName, String newAbilities, String newType) {
        boolean found = false;
        for (Superhero superhero : superheroList) {
            if (superhero != null && superhero.getSuperheroName().equalsIgnoreCase(superheroName)) {
                superhero.setSuperheroName(newSuperheroName);
                superhero.setFirstName(newFirstName);
                superhero.setLastName(newLastName);
                superhero.setAbilities(newAbilities);
                superhero.setType(newType);
                System.out.println("Superhero information updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Superhero not found");
        }

    }
}