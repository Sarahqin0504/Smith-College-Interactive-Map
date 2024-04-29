import java.util.*;

public class Place extends Thing{

    private Map<String, Place> exits;
    private List<Thing> list;

    public Place(String name, String description) {
        super (name, description);
        this.exits = new HashMap<>();
        this.list = new ArrayList<>();
    }

     public void setExit(String direction, Place room) {
        exits.put(direction.toLowerCase(), room);
    }

    public Place getExit(String direction) {
        return exits.get(direction.toLowerCase());
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