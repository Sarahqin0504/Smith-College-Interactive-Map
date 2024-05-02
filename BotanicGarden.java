import java.util.HashMap;
import java.util.Map;

public class BotanicGarden extends Place {
    private Map<String, Place> rooms; 
    private Place currentLocation; 

    public BotanicGarden() {
        super("Botanic Garden", "Lyman Plant House");

        rooms = new HashMap<>();
        rooms.put("Church Gallery", new ChurchGallery());
        rooms.put("Succulent House", new SucculentHouse());
        rooms.put("Show House", new ShowHouse());
        rooms.put("Exhibition 1", new Exhibition1());
        rooms.put("Exhibition 2", new Exhibition2());
        rooms.put("Outdoor Garden", new OutdoorGarden());

        

        ChurchGallery churchGallery = (ChurchGallery) rooms.get("Church Gallery");
        churchGallery.setExit("north", rooms.get("Succulent House"));
        churchGallery.setExit("south", rooms.get("Outdoor Garden"));
        churchGallery.setExit("east", rooms.get("Exhibition 1"));
        
        Exhibition1 exhibition1 = (Exhibition1) rooms.get("Exhibition 1");
        exhibition1.setExit("west", rooms.get("Church Gallery"));
        exhibition1.setExit("east", rooms.get("Exhibition 2"));

        Exhibition2 exhibition2 =(Exhibition2) rooms.get("Exhibition 2");
        exhibition2.setExit("west", rooms.get("Exhibition 1"));;

        SucculentHouse succulentHouse = (SucculentHouse) rooms.get("Succulent House");
        succulentHouse.setExit("north", rooms.get("Show House"));
        succulentHouse.setExit("south", rooms.get("Church Gallery"));

        ShowHouse showHouse = (ShowHouse) rooms.get("Show House");
        showHouse.setExit("east", rooms.get("Outdoor Garden"));
        showHouse.setExit("south", rooms.get("Succulent House"));
        showHouse.setExit("north", rooms.get("Outdoor Garden"));

        OutdoorGarden outdoorGarden = (OutdoorGarden) rooms.get("Outdoor Garden");
        outdoorGarden.setExit("north", rooms.get("Church Gallery"));

    }

    public Map<String, Place> getRooms() {
        return rooms;
    }
}   

class ChurchGallery extends Place {
    public ChurchGallery() {
        super("Church Gallery", "Church Gallery. As you enter the Church Room, you're greeted by an introductory board detailing the room's history and botanical significance. To your right, a front desk displays leaflets and small plants, each carefully labeled. To the east, two doorways lead to themed exhibition rooms, inviting exploration. Directly north, a passageway adorned with hanging greenery offers a path deeper into the garden. The room combines historical charm with a celebration of plant life.");
        addItem(new Thing("Introductory board", "The Church Gallery is located in the front of the building downstairs from the reception area. The primary function of the Church Gallery is to serve as a space for education. The space features changing exhibitions on a variety of botanical and horticultural themes. "));
        addItem(new Thing("Front Desk", "You can book a tour here and consult questions regarding the Lymant Plant House."));
    }
}

class Exhibition1 extends Place{
    public Exhibition1(){
        super("Exhibition 1", "Plant Life Through the Ages Exhibition. Plant Life Through the Ages consists of eight panels depicting great moments in plant evolution. It is a significant body of work because while there are numerous depictions of animal evolution, there had been no mural devoted to the evolution of plants until this work. ");
    }       
}

class Exhibition2 extends Place{
    public Exhibition2(){
        super("Exhibition 2", "The Woods of the World exhibit. The Woods of the World exhibit consists of 178 unique woods from all parts of the globe.");
    addItem(new Thing("Informational panels", "Informational panels in the exhibit show examples of figure (patterns) in wood and wood grain."));
    addItem(new Thing("Elm Section","It displays a section of an American elm (Ulmus americana) trunk hanging on the north hallway wall above the water fountains. The display includes numbered markers pointing to the corresponding annual ring on the elm section which indicate the year of significant events that occurred during the elm's lifetime."));
    }
}
class SucculentHouse extends Place {
    public SucculentHouse() {
        super("SucculentHouse", "This is the Succulent House, the oldest section of Lyman, built in 1894. It holds xerophytes, or plants adapted to deserts and dry habitats, including New World cacti, Old World succulent euphorbias, and plants from families such as the Crassulaceae and Asphodelaceae.");
        // Add items to the ground floor inventory
        addItem(new Thing("New World cacti", "New World Cacti refers to the cacti that are native to the Americas. Cacti are a family of plants known scientifically as Cactaceae. They are mostly found in regions that range from Patagonia in South America through to areas of western Canada. "));
        addItem(new Thing("Old World succulent euphorbias", "Old World Cacti refer to succulent plants that resemble cacti and are native to the Old World (Africa, Europe, and Asia). These are not true cacti but are often part of different succulent families such as Euphorbiaceae or Crassulaceae."));
        addItem(new Thing("Crassulaceae", "The Crassulaceae family, commonly known as the stonecrop family or the orpine family, is a diverse group of succulent plants that are well adapted to arid and semi-arid environments."));
        addItem(new Thing("Asphodelaceae","\n" + "The Asphodelaceae family is a group of flowering plants primarily native to temperate and tropical regions of Africa, Europe, and Asia. This family includes various genera such as Asphodelus, Aloe, Kniphofia, and Haworthia, which are well-known for their distinctive and often striking appearances."));
    }
}

class ShowHouse extends Place {
    public ShowHouse() {
        super("ShowHouse", "Welcome to the Show House, where the first flower shows were staged. Today, it contains plants with foliar and floral scents, including salvias, mints, and geraniums, used in culinary, medicinal, and perfumery applications.");
        addItem(new Thing("salvias", "Salvias generally prefer locations with full sun and well-draining soil. They are drought-tolerant once established, making them suitable for xeriscaping or gardens in drier climates. The care and maintenance of salvia plants will depend on the species; some may be annuals, while others are perennials or biennials."));
        addItem(new Thing("mints", "The mint genus comprises numerous species and hybrids known for their distinctively sharp, cool flavor and fragrance, which is attributed to the compound menthol found in their leaves. Mint plants are hardy and grow well in moist, well-drained soils, preferably in full to partial sunlight. "));
    }
}

class OutdoorGarden extends Place {
    public OutdoorGarden() {
        super("Outdoor Garden", "You have enter the Systematics Garden. Students can observe and compare flower types and growth forms among the garden’s species, chosen for their botanical and evolutionary interest. As one of our oldest gardens, it not only holds Smith’s history of learning, but also the centuries-long quest of the botanical science community to better understand how plants became what they are today. ");
        addItem(new Thing("Book", "There is a linear algebra textbook on the bench. Maybe someone left it here."));
    }
}
