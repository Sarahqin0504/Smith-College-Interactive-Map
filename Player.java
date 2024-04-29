import java.util.*;

public class Player extends Thing implements Contract{

    private Room currentRoom; // The current room the player is in
    private List<String> inventory; // The player's inventory
    private boolean isResting = false;
    private String lastAction = "";
    private int flowerSize = 1;
    private String season = "";

    public Player (String name, String description) {
        super(name, description);
        this.inventory = new ArrayList<>();
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
    * check the inventory
    * @param item
    * @return T/F the inventory contains the item
    */
    public boolean checkInventory(String item){
        return this.inventory.contains(item);
    }

    public void grab(String item) {
        this.inventory.add(item);
        System.out.println("You grabbed " + item + ".");
    }

    public String drop(String item) {
        System.out.println("You dropped " + item + ".");
        return item;
    }

    public void examine(String itemName) {
        switch (itemName.toLowerCase()) {
            case "butterfly":
                System.out.println("You see a butterfly. Its wings feature bright blue with black markings.");
                break;
            case "flower":
                if (season.equalsIgnoreCase("spring")) {
                    System.out.println("You examine a sakura. It seems to be a cherry-blossom season.");
                } 
                else if (season.equalsIgnoreCase("summer")) {
                    System.out.println("You're looking at a pink lotus. It lies on the lily pads.");
                }
                break;
            case "pond":
                System.out.println("The pond is peaceful, with lily pads scattered across the surface. There is a sculpture of swan standing in the middle of the pond.");
                break;
            case "tree":
                if (season.equalsIgnoreCase("autumn")) {
                    System.out.println("The maple tree features the autumn vibe. There are red, orange, and yellow leaves all over the ground.");
                } else if (season.equalsIgnoreCase("winter")) {
                    System.out.println("The bare branches of the oak tree are covered with a light dusting of snow, stark against the winter sky.");
                }
                break;
            case "bird":
                System.out.println("Birds are singing delightly.");
                break;
            default:
                System.out.println("The"+ itemName + "can not be found in the botanic garden.");
                break;
        }
        // Check if the item exists in the current room's inventory
        for (Thing item : currentRoom.getList()) {
            if (item.getName().equals(itemName)) {
                // If the item exists, print its description
                System.out.println("You examined " + itemName + ": " + item.getDescription());
                return; // Exit the method after printing the description
            }
        }
        // If the loop completes without finding the item, inform the player
        System.out.println("There is no " + itemName + " to examine in this room.");
    }

    public void use(String item) {
        if(item.equalsIgnoreCase("map")) {
            System.out.println("You use the map to find your way to the botanic garden.");
        } else {
        System.out.println("You used " + item + ".");
        }
    }

    public boolean walk(String direction) {
        Room nextRoom = null;
        switch (direction.toLowerCase()) {
            case "north":
                nextRoom = currentRoom.getExit("north");
                break;
            case "south":
                nextRoom = currentRoom.getExit("south");
                break;
            case "east":
                nextRoom = currentRoom.getExit("east");
                break;
            case "west":
                nextRoom = currentRoom.getExit("west");
                break;
            default:
                System.out.println("Invalid direction. Please enter north, south, east, or west.");
                return false;
        }
        if (nextRoom != null) {
            // If there is an exit in the specified direction, move to the next room
            currentRoom = nextRoom;
            return true;
        } else {
            // If there is no exit in the specified direction, inform the player
            System.out.println("There is no exit in that direction.");
            return false;
        }
    }

    /**
     * Changes the season in the garden.
     * Simulates the effect of seasons changing on the garden's flora and fauna.
     */
    public void changeSeason() {
        String[] seasons = {"spring", "summer", "autumn", "winter"};
        Random rand = new Random();
        this.season = seasons[rand.nextInt(seasons.length)];
        System.out.println("The season has changed to " + this.season + ".");
        switch (this.season) {
            case "spring":
                System.out.println("Flowers start blooming beautifully.");
                break;
            case "summer":
                System.out.println("The garden is having a hot party now!");
                break;
            case "autumn":
                System.out.println("The garden starts to calm down.");
                break;
            case "winter":
                System.out.println("The garden rests under a blanket of snow.");
                break;
        }
        lastAction = "changeSeason";
    }

    /**
     * The method is for visitors to observes insects flying around in the garden.
     * @param x The x-coordinate of the flight path.
     * @param y The y-coordinate of the flight path.
     * @return true if the observation was successful, false otherwise (e.g., no insects in sight).
     */
    @Override
    public boolean fly(int x, int y) {
        System.out.println("You watch a insect fluttering at coordinates (" + x + ", " + y + ").");
        lastAction = "fly";
        return true; 
    }

    /**
     * The method is to represent the shrinking of a flower or plant in the garden.
     * @return The new size of the flower after shrinking.
     */
    @Override
    public Number shrink() {
        flowerSize = Math.max(0, flowerSize - 1); 
        System.out.println("A flower in the garden has shrunk.");
        lastAction = "shrink";
        return flowerSize;
    }

    /**
     * The method is to represent the growth of a flower or plant in the garden.
     * @return The new size of the flower after growing.
     */
    @Override
    public Number grow() {
        flowerSize = Math.min(2, flowerSize + 1); // Ensure flowerSize doesn't exceed 2
        System.out.println("A flower in the garden has grown.");
        lastAction = "grow";
        return flowerSize;
    }

    /**
     * The method is to allow the visitor (or their pet) to take a rest in the garden.
     */
    @Override
    public void rest() {
        isResting = true;
        System.out.println("You take a moment to rest and enjoy the peaceful environment.");
        lastAction = "rest";
    }

    /**
     * The method is to undo the last action performed by the visitor.
     */
    @Override
    public void undo() {
        switch (lastAction) {
            case "rest":
                isResting = false;
                System.out.println("You're now continuing your wonderful journey of exploring the botanic garden!");
                break;
            default:
                System.out.println("There's nothing to undo.");
                break;
        }
    }

}