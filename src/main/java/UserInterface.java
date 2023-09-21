import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class UserInterface {
    public static final String BLUE_BOLD = "\033[1;34m";

    private int scanIntWithRetry() {
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Not a number! Try again");
        }
        return scanner.nextInt();
    }





    public void startProgram() {
        Database superheroDatabase = new Database();
        Scanner searchSuperhero = new Scanner(System.in);

        System.out.println("Welcome to the SUPERHERO UNIVERSE!");
        boolean runProgram = true;


        int menuNumber;

        while (runProgram) {
            System.out.println("\nChoose your next step and enter a number:");
            System.out.println("1. Create");
            System.out.println("2. See complete list of superhero");
            System.out.println("3. Search for superhero(es)");
            System.out.println("4. Edit superhero");
            System.out.println("9. Close");

            menuNumber = scanIntWithRetry();

            if (menuNumber == 1) {
                Scanner superheroInput = new Scanner(System.in);

                System.out.println("Enter the superhero name: ");
                String superheroName = superheroInput.next();
                System.out.println("Enter the superhero's legal name (first and last): ");
                String firstName = superheroInput.next();
                String lastName = superheroInput.next();
                System.out.println("Enter superpower: ");
                String abilities = superheroInput.next();
                System.out.println("Enter which kind of creature the superhero is: ");
                String type = superheroInput.next();
                System.out.println("The superhero you have added: " +
                        superheroName + " " +
                        firstName + lastName + " " +
                        abilities + " " + type);
                superheroInput.nextLine();

                superheroDatabase.addSuperhero(superheroName, firstName, lastName, abilities, type);

            } else if (menuNumber == 2) {

                ArrayList<Superhero> superheroList = superheroDatabase.getSuperheroList();
                if (superheroList.isEmpty()) {
                    System.out.println("No superhero found");
                } else {
                    System.out.println("Complete list of superheroes:");
                    for (Superhero superhero1 : superheroList) {
                        if (superhero1 != null)
                            System.out.println(BLUE_BOLD + " Superhero: " + superhero1.getSuperheroName() +
                                    "\u001B[0m" + "\n" +
                                    " Name: " + superhero1.getFirstName() + " " + superhero1.getLastName() + "\n" +
                                    " Abilities: " + superhero1.getAbilities() + "\n" +
                                    " Creature: " + superhero1.getType());
                    }
                }
            } else if (menuNumber == 3) {
                System.out.println("Enter the superhero name");
                final String superheroName = searchSuperhero.next();

                    if (superheroDatabase.findSuperhero(superheroName).isEmpty()) {
                        System.out.println("This superhero does not exist in our library of superheroes.");
                    } else {
                        System.out.println(superheroDatabase.findSuperheroesNames(superheroName));
                    }

            } else if (menuNumber == 4) {
                Scanner searchEdit = new Scanner(System.in);
                System.out.println("Enter the name of the superhero you would like to edit:");
                final String searchSHName = searchEdit.nextLine();
                ArrayList<Superhero> searchSHN = superheroDatabase.findSuperhero(searchSHName);

                if (!searchSHN.isEmpty()) {
                    System.out.println("Superheroes have been found.");

                    for (int index = 0; index < searchSHN.size(); index++){
                        System.out.println((index + 1) + ". " + searchSHN.get(index).getSuperheroName());
                        System.out.println();
                    }

                    System.out.println("Type in number of the superhero you would like to edit:");
                    int superheroNumber = scanIntWithRetry();
                    Superhero editSuperhero = searchSHN.get(superheroNumber - 1);

                    System.out.println("Edit the data and press ENTER. If the data does not require changes, then press ENTER.");

                    System.out.println("Superhero Name: " + editSuperhero.getSuperheroName());
                    String newSuperheroName = searchSuperhero.nextLine();
                    if (!newSuperheroName.isEmpty())
                        editSuperhero.setSuperheroName(newSuperheroName);

                    System.out.println("First name: " + editSuperhero.getFirstName());
                    String newFirstName = searchSuperhero.nextLine();
                    if (!newFirstName.isEmpty())
                        editSuperhero.setFirstName(newFirstName);

                    System.out.println("Last name: " + editSuperhero.getLastName());
                    String newLastName = searchSuperhero.nextLine();
                    if (!newLastName.isEmpty())
                        editSuperhero.setLastName(newLastName);

                    System.out.println("Abilities: " + editSuperhero.getAbilities());
                    String newAbilities = searchSuperhero.nextLine();
                    if (!newAbilities.isEmpty())
                        editSuperhero.setAbilities(newAbilities);

                    System.out.println("Type: " + editSuperhero.getType());
                    String newType = searchSuperhero.nextLine();
                    if (!newType.isEmpty())
                        editSuperhero.setType(newType);
                } else {
                    System.out.println("No results match your search: " + searchSHName);
                }

            } else if (menuNumber == 9) {
                System.out.println("We hope to see you again soon");
                runProgram = false;
            }
        }
    }
}

