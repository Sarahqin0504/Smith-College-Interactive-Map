import java.util.*;

/* Represents a Player in the game. */
public class Player extends Thing implements Cheatsheet{

    private Place currentPlace; // The current room the player is in
    private List<String> inventory; // The player's inventory
    private boolean isResting = false;
    private String lastAction = "";
    Scanner scanner = new Scanner(System.in);
    GameSetup setup = new GameSetup();

     /**
     * Constructor for Player class.
     * @param name The name of the player.
     * @param description The description of the player.
     * @param startingPlace The starting place of the player.
     * @param setup The game setup object.
     */
    public Player (String name, String description, Place startingPlace, GameSetup setup) {
        super(name, description);
        this.inventory = new ArrayList<>();
        // Set the default location to the first floor
        this.currentPlace = startingPlace;
        this.setup = setup;
    }

    /**
     * Getter for the current place.
     * @return The current place of the player.
     */
    public Place getCurrentPlace() {
        return currentPlace;
    }

    /**
     * Setter for the current place.
     * @param currentPlace The current place to set.
     */
    public void setCurrentPlace (Place currentPlace) {
        this.currentPlace = currentPlace;
    }

    /**
     * get the list of items from the current place.
     * @return List of items in the current place.
     */
    // Method to get the list of items from the current place
    public List<Thing> getCurrentPlaceItems() {
        return currentPlace.getList();
    }

    /**
     * Retrieves the description of the current place.
     * @return Description of the current place.
     */
    public String getCurrentPlaceDescription() {
        return currentPlace.getDescription();
    }

    /**
     * Moves the player in the specified direction.
     * @param direction The direction in which to move.
     */
    @Override
    public void move(String direction) {
        // Check if the player has a one card
        boolean hasOneCard = checkInventory("one card");

        // Check if the direction is valid and the player has a one card
        if (hasOneCard && direction.equalsIgnoreCase("west") && currentPlace == setup.getLibrary().getFloors().get("Fourth Floor")) {
            Place nextPlace = currentPlace.getExit(direction);
            if (nextPlace != null) {
                currentPlace = nextPlace;
                System.out.println("You move to: " + currentPlace.getName());
            } else {
                System.out.println("You can't go that way.");
            }
        } else if (!hasOneCard && direction.equalsIgnoreCase("west") && currentPlace == setup.getLibrary().getFloors().get("Fourth Floor")) {
            System.out.println("You need a one card to access the terrace from this floor.");
        } else {
            // Handle other directions as before
            Place nextPlace = currentPlace.getExit(direction);
            if (nextPlace != null) {
                currentPlace = nextPlace;
                System.out.println("You move to: " + currentPlace.getName());
            } else {
                System.out.println("You can't go that way.");
            }
        }
    }

    /**
     * Enters the specified building.
     * @param building The building to enter.
     */
    @Override
    public void enter(String building) {
        switch (building.toLowerCase()) {
            case "library":
                currentPlace = setup.getLibrary().getFloors().get("First Floor");
                break;
            case "botanic garden":
                currentPlace = setup.getBotanicGarden().getRooms().get("Church Gallery");
                System.out.println("You are now in Lyman Plant House.");
                break;
            case "bookstore":
                currentPlace = setup.getBookstore().getSections().get("Doorway");
                System.out.println("You are now in the Bookstore.");
                break;
            default:
                System.out.println("Invalid building.");
                break;
        }
    }

    /**
     * Exits the specified building.
     * @param building The building to exit.
     */
    @Override
    public void exit(String building) {
        switch (building) {
            case "First Floor":
                setCurrentPlace(this.setup.getLibrary());
                break;
            case "Church Gallery":
                setCurrentPlace(this.setup.getBotanicGarden());
                break;
            case"Doorway":
                setCurrentPlace(this.setup.getBookstore());
                break;
            default:
                System.out.println("Invalid destination.");
                break;
        }
    }

    /**
     * Moves the player to the specified floor with the elevator.
     * @param floorNumber The floor number to move to.
     */
    @Override
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
                    break;
                default:
                    // If the input doesn't match any floor number, inform the player
                    System.out.println("Invalid floor number.");
                    break;
            }
        }
    }

    /**
    * check the inventory
    * @param item
    * @return T/F the inventory contains the item
    */
    public boolean checkInventory(String item){
        return this.inventory.contains(item);
    }

    /**
     * Retrieves the inventory of the player.
     * @return The inventory of the player.
     */
    public List<String> getInventory() {
        return this.inventory;
    }

    /**
     * Adds the specified item to the player's inventory.
     * @param item The item to add to the inventory.
     */
    @Override
    public void grab(String item) {
        this.inventory.add(item);
        System.out.println("You grabbed " + item + ".");
    }

    /**
     * Removes the specified item from the player's inventory.
     * @param item The item to remove from the inventory.
     * @return The item that was removed.
     */
    @Override
    public String drop(String item) {
        System.out.println("You dropped " + item + ".");
        return item;
    }

    /**
     * Buys the specified item.
     * @param item The item to buy.
     * @return The item that was bought.
     */
    @Override
    public String buy(String item) {
        System.out.println("You bought " + item + ".");
        return item;
    }
    
    /**
     * Buys a coffee with the specified size, sugar, and cream.
     * @param size The size of the coffee.
     * @param sugar The amount of sugar.
     * @param cream The amount of cream.
     */
    public void buyCoffee(String size, int sugar, int cream) {
        CompassCafe compassCafe = (CompassCafe) setup.getLibrary().getFloors().get("Compass Cafe");
        switch (size) {
            case "small":
                compassCafe.sellCoffee(2, sugar, cream, 1);
                break;
            case "medium":
                compassCafe.sellCoffee(4, sugar, cream, 1);
                break;
            case "large":
                compassCafe.sellCoffee(6, sugar, cream, 1);
                break;
            default:
                System.out.println("Too much coffee is bad");
                break;
        }
        this.inventory.add("Coffee");
    }

    /**
     * Examines the specified item.
     * @param itemName The name of the item to examine.
     */
    @Override
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

    /**
     * Provides a description of the current place including its items.
     * @param currentPlace The current place to describe.
     * @return Description of the current place including its items.
     */
    @Override
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

    /**
     * Uses the specified item
     * @param item The item to use.
     */
    @Override
    public void use(String item) {
        switch (item) {
            case "map":
                System.out.println("You use the map to find your way.");
                break;
            case "computer":
                System.out.println("What would you like to search?");
                String itemToSearch = scanner.nextLine().trim().toLowerCase();
                useComputer(itemToSearch);
                break;
            case "large":

                break;
            default:
                System.out.println("You used " + item + ".");
                break;
        }
    }

    /**
     * Uses the computer to search for the specified item.
     * @param item The item to search for.
     */
    public void useComputer(String item) {
        // list library
        List<Thing> itemList = setup.getLibrary().getFloors().get("First Floor").getList();
        itemList.addAll(setup.getLibrary().getFloors().get("Second Floor").getList());
        itemList.addAll(setup.getLibrary().getFloors().get("Third Floor").getList());
        itemList.addAll(setup.getLibrary().getFloors().get("Fourth Floor").getList());
        itemList.addAll(setup.getLibrary().getFloors().get("Terrace").getList());
        itemList.addAll(setup.getLibrary().getFloors().get("Compass Cafe").getList());
        itemList.addAll(setup.getLibrary().getFloors().get("Chapin Lawn").getList());
        itemList.addAll(setup.getLibrary().getFloors().get("Burton Lawn").getList());
        itemList.addAll(setup.getLibrary().getFloors().get("Seelye Lawn").getList());
        itemList.addAll(setup.getLibrary().getFloors().get("Alumni Gym").getList());
        // list botanic garden
        itemList.addAll(setup.getBotanicGarden().getList());
        // list bookstore
        itemList.addAll(setup.getBookstore().getList());
        // get description 
        try{ 
            for (Thing itemSearch : itemList) {
                    if (itemSearch.getName().equalsIgnoreCase(item)) {
                        // If a match is found, print its description
                        System.out.println(item + ": " + itemSearch.getDescription());
                        return; // Exit the method after printing the description
                        }
                    }
        }catch (RuntimeException e) {
            System.out.println( item + "not found.");
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
