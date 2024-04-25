import java.util.*;

public class Player extends Thing {

    private Room currentRoom; // The current room the player is in
    private List<String> inventory; // The player's inventory

    public Player (String name, String description, Room startingRoom) {
        super(name, description);
        this.currentRoom = startingRoom;
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
        System.out.println("You used " + item + ".");
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
}