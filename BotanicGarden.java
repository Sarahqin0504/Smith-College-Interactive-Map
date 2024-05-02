import java.util.HashMap;
import java.util.Map;

public class BotanicGarden extends Place {
    private Map<String, Place> rooms; 

    public BotanicGarden() {
        super("Botanic Garden", "Lyman Plant House");

        rooms = new HashMap<>();
        rooms.put("Church Gallery", new ChurchGallery());
        rooms.put("Succulent House", new SucculentHouse());
        rooms.put("Show House", new ShowHouse());
        
    }

    public Map<String, Place> getRooms() {
        return rooms;
    }
}   

class ChurchGallery extends Place {
    public ChurchGallery() {
        super("Church Gallery", "The Church Gallery is located in the front of the building downstairs from the reception area. It serves as a space for education, featuring changing exhibitions on a variety of botanical and horticultural themes.");
        // Add items to the ground floor inventory
        addItem(new Thing("Book", "Interactive Linear Algebra"));
        addItem(new Thing("Front Desk", "You can borrow and return books"));
        addItem(new Thing("Faculty One card", "You can access different exits"));
    }
}

class SucculentHouse extends Place {
    public SucculentHouse() {
        super("SucculentHouse", "This is the Succulent House, the oldest section of Lyman, built in 1894. It holds xerophytes, or plants adapted to deserts and dry habitats, including New World cacti, Old World succulent euphorbias, and plants from families such as the Crassulaceae and Asphodelaceae.");
        // Add items to the ground floor inventory
        addItem(new Thing("Book", "Interactive Linear Algebra"));
        addItem(new Thing("Front Desk", "You can borrow and return books"));
        addItem(new Thing("Faculty One card", "You can access different exits"));
    }
}

class ShowHouse extends Place {
    public ShowHouse() {
        super("ShowHouse", "Welcome to the Show House, where the first flower shows were staged. Today, it contains plants with foliar and floral scents, including salvias, mints, and geraniums, used in culinary, medicinal, and perfumery applications.");
        addItem(new Thing("Book", "Interactive Linear Algebra"));
        addItem(new Thing("Front Desk", "You can borrow and return books"));
        addItem(new Thing("Faculty One card", "You can access different exits"));
    }
}
