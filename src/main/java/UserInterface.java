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


        int menuNumber = 0;
        while (runProgram) {
            System.out.println("\nChoose your next step and enter a number:");
            System.out.println("1 Create");
            System.out.println("2 See complete list of superhero");
            System.out.println("3 Search for superhero(es)");
            System.out.println("4 Edit superhero");
            System.out.println("9 Close");

            if (!scanner.hasNextInt()) {
                String text = scanner.next();
                System.out.printf(text + " is not an eligible number. Try again. ");
            }

            menuNumber = scanner.nextInt();

            String findSuperhero = null;
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
                findSuperhero = searchSuperhero.next();

                if (!findSuperhero.contains(findSuperhero)) {
                    System.out.println("This superhero does not exist in our library of superheroes.");
                } else {
                    System.out.println(superheroDatabase.findSuperhero(findSuperhero));
                }


            } else if (menuNumber == 4) {
                Scanner editInput = new Scanner(System.in);
                System.out.println("If you have nothing to edit in the following simply press Enter");

                System.out.println("Enter the superhero name to edit: ");
                String editName = editInput.next();
                // scanner input skal søge i databasen

                boolean found =

                for (Database superheroList : Superhero){
                    if(Database.getSuperheroList())
                }

                System.out.println("Enter new superhero name:");
                String newSuperheroName = editInput.nextLine();
                if (!newSuperheroName.isEmpty()){
                    editInput.setSuperheroName(newSuperheroName);
                }


                System.out.println("Enter new legal first name:");
                String newFirstName = editInput.next();

                System.out.println("Enter new legal last name:");
                String newLastName = editInput.next();

                System.out.println("Enter new abilities: ");
                String newAbilities = editInput.next();

                System.out.println("Enter new creature: ");
                String newType = editInput.next();


                superheroDatabase.editSuperhero(editName, newSuperheroName, newFirstName, newLastName, newAbilities, newType);
            }
        }

        /*else (menuNumber == 9) {
            System.out.println("We hope to see you again soon");
            runProgram = false;
        }*/
    }
}

