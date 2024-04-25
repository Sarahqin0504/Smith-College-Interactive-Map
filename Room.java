import java.util.*;

public class Room extends Thing{

    private Map<String, Room> exits;
    private Room stairsUp;
    private Room stairsDown;
    private Room elevator;
    private List<Thing> list;

    public Room(String name, String description) {
        super (name, description);
        this.exits = new HashMap<>();
        this.list = new ArrayList<>();
    }

     public void setExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    public Room getStairsUp() {
        return stairsUp;
    }

    public void setStairsUp(Room stairsUp) {
        this.stairsUp = stairsUp;
    }

    public Room getStairsDown() {
        return stairsDown;
    }

    public void setStairsDown(Room stairsDown) {
        this.stairsDown = stairsDown;
    }

    public Room getElevator() {
        return elevator;
    }

    public void setElevator(Room elevator) {
        this.elevator = elevator;
    }

    public List<Thing> getList() {
        return list;
    }

    public void addItem(Thing item) {
        list.add(item);
    }

    public void removeItem(Thing item) {
        list.remove(item);
    }

}