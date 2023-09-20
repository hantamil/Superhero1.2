import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class UserInterface {
    public static final String BLUE_BOLD = "\033[1;34m";

    public void startProgram() {
        Database superheroDatabase = new Database();
        Scanner searchSuperhero = new Scanner(System.in);

        System.out.println("Welcome to the SUPERHERO UNIVERSE!");
        Scanner scanner = new Scanner(System.in);
        boolean runProgram = true;


        int menuNumber;

        while (runProgram) {
            System.out.println("\nChoose your next step and enter a number:");
            System.out.println("1. Create");
            System.out.println("2. See complete list of superhero");
            System.out.println("3. Search for superhero(es)");
            System.out.println("4. Edit superhero");
            System.out.println("9. Close");

            if (!scanner.hasNextInt()) {
                String text = scanner.next();
                System.out.printf(text + " is not an eligible number. Try again. ");

            }

            menuNumber = scanner.nextInt();
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
                String findSuperhero = null;
                System.out.println("Enter the superhero name");
                findSuperhero = searchSuperhero.next();

                if (!findSuperhero.contains(findSuperhero)) {
                    System.out.println("This superhero does not exist in our library of superheroes.");
                } else {
                    System.out.println(superheroDatabase.findSuperhero(findSuperhero));
                }


            } else if (menuNumber == 4) {

                //TODO fix
                String findSuperhero = null;

                Scanner searchEdit = new Scanner(System.in);
                System.out.println("Enter the name of the superhero you would like to edit:");
                String searchSHName = searchEdit.nextLine();
                ArrayList<Superhero> searchSHN = superheroDatabase.findSuperhero(searchSHName);

                if (!searchSHN.isEmpty()) {
                    System.out.println("Superheroes have been found.");

                    for (int superhero = 0; superhero < searchSHN.size(); superhero++){
                        System.out.println(superhero + 1 + ".\n" + searchSHN.get(superhero));
                        System.out.println();
                    }

                    System.out.println("Type in number of the superhero you would like to edit:");
                    int superheroNumber = menuNumber;
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
                    System.out.println("No results matches your search: " + findSuperhero);
                }


            }else if (menuNumber == 9) {
                System.out.println("We hope to see you again soon");
                runProgram = false;
            }
        }
    }
    }

