import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {
    private Room groundFloor;
    private Room firstFloor;
    private Room secondFloor;
    private Room thirdFloor;
    private Room fourthFloor;
    private Room compassCafe;
    private Room terrace;
    private Room chapinLawn;
    private Room burtonLawn;
    private Room seelyeLawn;
    private Room alumniGym;

    private int elevatorFloor;

    // Constants for floor numbers
    public static final int GROUND_FLOOR = 0;
    public static final int FIRST_FLOOR = 1;
    public static final int SECOND_FLOOR = 2;
    public static final int THIRD_FLOOR = 3;
    public static final int FOURTH_FLOOR = 4;

    // Mapping of floor numbers to their names
    private Map<Integer, String> floorNames;


    public Library() {
        // Create rooms for each floor
        groundFloor = new Room("Ground Floor", "This is the Ground Floor. At the Front desk, you can borrow or return books. There is an exit to the south and west.");
        firstFloor = new Room("First Floor", "This is the First Floor. There is a Front desk and the Compass Cafe. Exit to the north and east.");
        compassCafe = new Room("Compass Cafe", "This is the Compass Cafe. You can purchase drinks here");
        secondFloor = new Room("Second Floor", "This is the Second Floor. Study Space to the north");
        thirdFloor = new Room("Third Floor", "This is the Third Floor. Study Space to the north");
        fourthFloor = new Room("Fourth Floor", "This is the Skyline reading room. Terrace to the west");
        terrace = new Room("Terrace", "This is the Terrace. Please enjoy the beautiful view");
        chapinLawn = new Room("Chapin Lawn", "This is Chapin Lawn, where students all love");
        burtonLawn = new Room("Burton Lawn", "This is Burton lawn, leading to the academic buildings");
        seelyeLawn = new Room("Seelye Lawn", "This is Seelye Lawn.");
        alumniGym = new Room("Alumni Gym", "This is the Alumni Gym, where you actually study");

        // Add things to ground floor inventory
        groundFloor.addItem(new Thing("Book", "Interactive Linear Algebra"));
        groundFloor.addItem(new Thing("Front Desk", "You can borrow and return books"));
        groundFloor.addItem(new Thing("Faculty One card", "You can access different exits"));
        firstFloor.addItem(new Thing("Front Desk", "You can ask questions here"));
        firstFloor.addItem(new Thing("Table", "A interesting looking table"));
        firstFloor.addItem(new Thing("One card", "Lost One card"));
        secondFloor.addItem(new Thing("Computer", "Hello world"));
        thirdFloor.addItem(new Thing("Desk", "Just a desk"));
        thirdFloor.addItem(new Thing("Chair", "You can rest here"));
        fourthFloor.addItem(new Thing("Lounge Chair", "You can rest here"));

        // Set initial elevator floor
        elevatorFloor = FIRST_FLOOR; // Elevator starts on the ground floor

        // Initialize floor names mapping
        floorNames = new HashMap<>();
        floorNames.put(GROUND_FLOOR, "Ground Floor");
        floorNames.put(FIRST_FLOOR, "First Floor");
        floorNames.put(SECOND_FLOOR, "Second Floor");
        floorNames.put(THIRD_FLOOR, "Third Floor");
        floorNames.put(FOURTH_FLOOR, "Fourth Floor");

        // Set exits for ground floor
        groundFloor.setExit("south", burtonLawn);
        groundFloor.setExit("west", alumniGym); 

        // Set exits for first floor
        firstFloor.setExit("north", compassCafe);
        firstFloor.setExit("east", seelyeLawn); 

        // Set exits for compass cafe
        compassCafe.setExit("south", firstFloor);
        compassCafe.setExit("west", burtonLawn);

        // Set exits for fourth floor
        fourthFloor.setExit("west", terrace); 

        // Set exits for terrace
        terrace.setExit("east", fourthFloor);
    }

    // Elevator 

    // Method to move the elevator to a specific floor
    public void goToFloor(int floor) {
        if (floor < GROUND_FLOOR || floor > FOURTH_FLOOR) {
            System.out.println("Invalid floor number.");
            return;
        }
        System.out.println("Elevator is moving to " + floorNames.get(floor));
        elevatorFloor = floor;
    }

    public Room getElevatorFloor() {
        // Logic to retrieve the Room object for the elevator floor based on the elevatorFloor integer
        Room elevatorRoom = null; // Initialize as null or assign appropriate Room object
        // Switch statement or conditional logic to set elevatorRoom based on elevatorFloor
        // For example:
        switch (elevatorFloor) {
            case 1:
                elevatorRoom = firstFloor;
                break;
            case 2:
                elevatorRoom = secondFloor;
                break;
            case 3:
                elevatorRoom = thirdFloor;
                break;
            case 4:
                elevatorRoom = fourthFloor;
                break;

        }
        return elevatorRoom;
    }

    // Method to take user input and go to the specified floor
    public void goToFloorFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the floor number (0 for Ground Floor, 1 for First Floor, etc): ");
        int floor = scanner.nextInt();
        goToFloor(floor);
        scanner.close();
    }

}
