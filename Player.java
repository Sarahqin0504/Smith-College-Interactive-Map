import java.util.*;

public class Player extends Thing implements Contract{

    private Place currentPlace; // The current room the player is in
    private List<String> inventory; // The player's inventory
    private boolean isResting = false;
    private String lastAction = "";
    Scanner scanner = new Scanner(System.in);

    public Player (String name, String description, Place startingPlace) {
        super(name, description);
        this.inventory = new ArrayList<>();
        // Set the default location to the first floor
        this.currentPlace = startingPlace;
    }

    Library library = new Library();
    BotanicGarden botanicGarden = new BotanicGarden();

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
                currentPlace = library.getFloors().get("First Floor");
                break;
            case "botanic garden":
                currentPlace = botanicGarden.getRooms().get("Outdoor Garden");
                break;
            default:
                System.out.println("Invalid building.");
                break;
        }
    }

    public void exit(String building) {
        switch (building.toLowerCase()) {
            case "First Floor":
                currentPlace = library;
                break;
            case "Outdoor Garden":
                currentPlace = botanicGarden;
                break;
            default:
                System.out.println("Invalid destination.");
                break;
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

    public void examine(String itemName) {
        // Check if the item exists in the current room's inventory
        for (Thing item : currentPlace.getList()) {
            if (item.getName().equals(itemName)) {
                // If the item exists, print its description
                System.out.println("You examined " + itemName + ": " + item.getDescription());
                return; // Exit the method after printing the description
            }
        }
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