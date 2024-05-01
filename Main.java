import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameSetup setup = new GameSetup(); // This should create and configure all places
        Player player = new Player("player", "player", setup.getStartingPlace());
        
        // Welcome message
        System.out.println("Welcome to Smith College!");
        System.out.println("You start in: " + player.getCurrentPlaceDescription()); // Should output library's description

        // Movement commands to test
        player.move("south"); // Moves to the bookstore
        System.out.println("Now in: " + player.getCurrentPlaceDescription());
        player.move("north"); // Moves back to the library
        System.out.println("Now in: " + player.getCurrentPlaceDescription());
        
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
                case "use":
                    System.out.print("Enter item to use: ");
                    String itemToUse = scanner.nextLine().trim().toLowerCase();
                    player.use(itemToUse);
                    break;
                case "walk":
                    System.out.print("Enter direction to walk (north/south/east/west) (elevator available in Library): ");
                    String direction = scanner.nextLine().trim().toLowerCase();
                    player.walk(direction);
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
