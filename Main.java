import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameSetup setup = new GameSetup(); // This should create and configure all places
        Player player = new Player("player", "player", setup.getStartingPlace(), setup);
        
        // Welcome message
        System.out.println("Welcome to Smith College!");
        System.out.println("You start in: " + player.getCurrentPlace().getName()); // Should output library's description

        // Game loop
        while (true) {
            System.out.print("Enter your action: ");
            String input = scanner.nextLine().trim().toLowerCase();

            // Process user input
            switch (input) {
                case "grab":
                    System.out.print("Enter item to grab: ");
                    String itemToGrab = scanner.nextLine().trim().toLowerCase();
                    player.grab(itemToGrab);
                    break;
                case "move":
                    System.out.print("Enter the direction: ");
                    String directionToMove = scanner.nextLine().trim().toLowerCase();
                    player.move(directionToMove);
                    break;
                case "drop":
                    System.out.print("Enter item to drop: ");
                    String itemToDrop = scanner.nextLine().trim().toLowerCase();
                    player.drop(itemToDrop);
                    break;
                case "examine":
                    System.out.print("Enter item to examine: ");
                    String itemToExamine = scanner.nextLine().trim().toLowerCase();
                    player.examine(itemToExamine);
                    break;
                case "look around":
                    Place lookPlace = player.getCurrentPlace();
                    System.out.println(player.lookAround(lookPlace));
                    break;
                case "use":
                    System.out.print("Enter item to use: ");
                    String itemToUse = scanner.nextLine().trim().toLowerCase();
                    player.use(itemToUse);
                    break;
                case "enter":
                    Place currentPlace = player.getCurrentPlace();
                    String building = currentPlace.getName();
                    player.enter(building);
                    System.out.println("Entering into " + player.getCurrentPlace().getName());
                    break;
                case "exit":
                    Place exitPlace = player.getCurrentPlace();
                    String exit = exitPlace.getName();
                    player.exit(exit);
                    System.out.println("Exiting into " + player.getCurrentPlace().getName());
                    break;
                case "elevator":
                    System.out.println("Enter floor number for the elevator:");
                    int floorNumber = scanner.nextInt();
                    player.elevator(floorNumber);
                    System.out.println("You are approaching " + player.getCurrentPlace().getName() + " and arrived");
                    break;
                case "quit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
                    break;
            }
            
        }

    }
}
