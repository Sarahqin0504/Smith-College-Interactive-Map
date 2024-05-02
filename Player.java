import java.util.*;

public class Player extends Thing implements Contract{

    private Place currentPlace; // The current room the player is in
    private List<String> inventory; // The player's inventory
    private boolean isResting = false;
    private String lastAction = "";
    Scanner scanner = new Scanner(System.in);
    GameSetup setup = new GameSetup();

    public Player (String name, String description, Place startingPlace, GameSetup setup) {
        super(name, description);
        this.inventory = new ArrayList<>();
        // Set the default location to the first floor
        this.currentPlace = startingPlace;
        this.setup = setup;
    }

    public Place getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace (Place currentPlace) {
        this.currentPlace = currentPlace;
    }

    public void move(String direction) {
        Place nextPlace = currentPlace.getExit(direction);
        if (nextPlace != null) {
            currentPlace = nextPlace;
            System.out.println("You move to: " + currentPlace.getDescription());
        } else {
            System.out.println("You can't go that way.");
        }
    }

    public void enter(String building) {
        switch (building.toLowerCase()) {
            case "library":
                currentPlace = setup.getLibrary().getFloors().get("First Floor");
                break;
            case "botanic garden":
                currentPlace = setup.getBotanicGarden().getRooms().get("Church Gallery");
                System.out.println("You are now in Lyman Plant House.");
                break;
            default:
                System.out.println("Invalid building.");
                break;
            case "bookstore":
                currentPlace = setup.getBookstore().getSections().get("Doorway");
                System.out.println("You are now in the Bookstore.");
                break;
        }
    }

    public void exit(String building) {
        switch (building) {
            case "First Floor":
                setCurrentPlace(this.setup.getLibrary());
                break;
            case "Church Gallery":
                setCurrentPlace(this.setup.getBotanicGarden());
                break;
            default:
                System.out.println("Invalid destination.");
                break;
        }
    }

    public void elevator(int floorNumber) {
        if (currentPlace == setup.getLibrary().getFloors().get("Ground Floor")||
            currentPlace == setup.getLibrary().getFloors().get("First Floor") || 
            currentPlace == setup.getLibrary().getFloors().get("Second Floor")||
            currentPlace == setup.getLibrary().getFloors().get("Third Floor") ||
            currentPlace == setup.getLibrary().getFloors().get("Fourth Floor")){
                // Use switch statement to handle different floor numbers
            switch (floorNumber) {
                case 0:
                    // I should use setCurrentPlace(), but I forgot about it
                    currentPlace = setup.getLibrary().getFloors().get("Ground Floor");
                    // System.out.println("You are now at the Ground Floor.");
                    break;
                case 1:
                    currentPlace = setup.getLibrary().getFloors().get("First Floor");
                    // System.out.println("You are now at the First Floor.");
                    break;
                case 2:
                    currentPlace = setup.getLibrary().getFloors().get("Second Floor");
                    // System.out.println("You are now at the Second Floor.");
                    break;
                case 3:
                    currentPlace = setup.getLibrary().getFloors().get("Third Floor");
                    // System.out.println("You are now at the Third Floor.");
                    break;
                case 4:
                    currentPlace = setup.getLibrary().getFloors().get("Fourth Floor");
                    // System.out.println("You are now at the Fourth Floor.");
                default:
                    // If the input doesn't match any floor number, inform the player
                    System.out.println("Invalid floor number.");
                    break;
            }
        }
    }

    public String getCurrentPlaceDescription() {
        return currentPlace.getDescription();
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

    public String buy(String item) {
        System.out.println("You bought " + item + ".");
        return item;
    }
    

    public void examine(String itemName) {
        // Get the list of items from the current place
        List<Thing> itemList = getCurrentPlaceItems();

        // Iterate over the list of items in the current place
        for (Thing item : itemList) {
            // Check if the item name matches the provided itemName
            if (item.getName().equalsIgnoreCase(itemName)) {
                // If a match is found, print its description
                System.out.println("You examined " + itemName + ": " + item.getDescription());
                return; // Exit the method after printing the description
            }
        }
        // If no matching item is found, print a message indicating that the item cannot be found
        System.out.println("The " + itemName + " cannot be found.");
    }

    public String lookAround(Place currentPlace) {
        // Get the list of items from the current place
        List<Thing> itemList = currentPlace.getList();
        
        // Initialize a StringBuilder to construct the description
        StringBuilder description = new StringBuilder();
        
        // Append the description of each item to the StringBuilder
        for (Thing item : itemList) {
            description.append("Item: ").append(item.getName()).append("\n");
        }
        
        // Return the concatenated description as a string
        return "\n" + currentPlace.getDescription() + "\n" + description.toString();
    }

    public void use(String item) {
        if(item.equalsIgnoreCase("map")) {
            System.out.println("You use the map to find your way.");
        } else {
        System.out.println("You used " + item + ".");
        }
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
