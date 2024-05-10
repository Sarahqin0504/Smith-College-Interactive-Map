import java.util.*;

/* Represents a location on Smith Campus */
public class Place extends Thing{

    private Map<String, Place> exits;
    private List<Thing> list;

    /**
     * constructor of Place
     * @param name The name of the place
     * @param description The description of the place
     */
    public Place(String name, String description) {
        super (name, description);
        this.exits = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /**
     * Sets an exit from this place to another place in the specified direction
     * @param direction The direction of the exit (e.g., "north", "south")
     * @param room The place to which the exit leads
     */
     public void setExit(String direction, Place room) {
        exits.put(direction.toLowerCase(), room);
    }

    /**
     * Retrieves the place to which the exit leads in the specified direction
     * @param direction The direction of the exit
     * @return The place to which the exit leads
     */
    public Place getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    /**
     * Retrieves the list of items present in this place
     * @return The list of items
     */
    public List<Thing> getList() {
        return list;
    }

    /**
     * Adds an item to this place
     * @param item The item to add
     */
    public void addItem(Thing item) {
        list.add(item);
    }

    /**
     * Removes an item from this place
     * @param item The item to remove
     */
    public void removeItem(Thing item) {
        list.remove(item);
    }

}