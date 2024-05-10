import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        String ans;
        String size;
        int cream;
        int sugar;
        GameSetup setup = new GameSetup(); // This should create and configure all places
        Player player = new Player("player", "player", setup.getStartingPlace(), setup);
        Bookstore bookstore = new Bookstore();

        // Welcome message
        System.out.println("Welcome to Smith College!");
        System.out.println("Founded in 1871, Smith College opened in 1875 with 14 students. Today, Smith is among the largest women’s colleges in the United States, with students from 46 states and 78 countries. An independent, nondenominational college, Smith remains strongly committed to the education of women at the undergraduate level");
        System.out.println("You first stop is: " + player.getCurrentPlace().getName()); // Should output library's description

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
                case "inventory":
                    System.out.print(player.getInventory() + "\n");
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
                    System.out.println("Exiting " + player.getCurrentPlace().getName());
                    break;
                case "elevator":
                    System.out.println("Enter floor number for the elevator:");
                    int floorNumber = scanner.nextInt();
                    player.elevator(floorNumber);
                    System.out.println("You are approaching " + player.getCurrentPlace().getName() + " and arrived");
                    break;
                case "buy":
                    System.out.println("What would you like to buy?: ");
                    ans = scanner.nextLine();
                    System.out.println("How many would you like to buy?: ");
                    num = scanner.nextInt();
                    bookstore.buyItem(ans, num);
                    break;
                case "buy coffee":
                    System.out.println("Welcome to Compass Cafe!");
                    System.out.println("What size do you like? (small, medium, large)");
                    size = scanner.nextLine();
                    System.out.println("How much cream would you like? (enter numbers)");
                    cream = scanner.nextInt();
                    System.out.println("How much sugar would you like? (enter numbers)");
                    sugar = scanner.nextInt();
                    player.buyCoffee(size, cream, sugar);
                    break;
                case "return":
                    System.out.println("What would you like to return?: ");
                    ans = scanner.nextLine();
                    System.out.println("How many would you like to return?: ");
                    num = scanner.nextInt();
                    bookstore.returnItem(ans, num);
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
