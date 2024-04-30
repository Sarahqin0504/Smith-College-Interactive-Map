import java.util.HashMap;
import java.util.Map;

public class BotanicGarden extends Place{
    private Map<String, Place> rooms;
    
    /**
     * Constructor for the BotanicGarden class.
     */
    public BotanicGarden() {
        super("Botanic Garden", "This is the Botanic Garden");
        initializeRooms();
        System.out.println("Welcome to the Botanic Garden of Smith College!");
        System.out.println("Explore our Lyman Plant House featuring various unique botanical rooms.");
    }

    private void initializeRooms() {
        rooms = new HashMap<>();
        rooms.put("Church Gallery", new ChurchGallery());
        rooms.put("Succulent House", new SucculentHouse());
        rooms.put("Show House", new ShowHouse());
        rooms.put("Fern House", new FernHouse());
        rooms.put("Palm House", new PalmHouse());
        rooms.put("Stove House", new StoveHouse());
        rooms.put("Cold Storage House", new ColdStorageHouse());
        rooms.put("Physiology House", new PhysiologyHouse());
        rooms.put("Cool Temperate House", new CoolTemperateHouse());
        rooms.put("Camellia Corridor", new CamelliaCorridor());
        rooms.put("Genetics House", new GeneticsHouse());
    }

    public class ChurchGallery extends Place {
        public ChurchGallery() {
            super("Church Gallery", "The Church Gallery is located in the front of the building downstairs from the reception area. It serves as a space for education, featuring changing exhibitions on a variety of botanical and horticultural themes.");
            // Additional initialization code if needed
        }
    }
    
    public class SucculentHouse extends Place {
        public SucculentHouse() {
            super("Succulent House", "This is the Succulent House, the oldest section of Lyman, built in 1894. It holds xerophytes, or plants adapted to deserts and dry habitats, including New World cacti, Old World succulent euphorbias, and plants from families such as the Crassulaceae and Asphodelaceae.");
            // Additional initialization code if needed
        }
    }
    
    public class ShowHouse extends Place {
        public ShowHouse() {
            super("Show House", "Welcome to the Show House, where the first flower shows were staged. Today, it contains plants with foliar and floral scents, including salvias, mints, and geraniums, used in culinary, medicinal, and perfumery applications.");
            // Additional initialization code if needed
        }
    }
    
    public class FernHouse extends Place {
        public FernHouse() {
            super("Fern House", "The Fern House, with its curved glass ceiling, holds many non-hardy ferns, fern allies, and ancient plant lineages such as cycads and other early gymnosperms.");
            // Additional initialization code if needed
        }
    }
    
    public class PalmHouse extends Place {
        public PalmHouse() {
            super("Palm House", "The stately Palm House is filled with plants from tropical forests worldwide, featuring palms, trees, climbers, and epiphytes, in a warm and humid environment.");
            // Additional initialization code if needed
        }
    }
    
    public class StoveHouse extends Place {
        public StoveHouse() {
            super("Stove House", "Stove House is populated with tropical orchids, bromeliads, and aquatic plants around the center pool. It originally housed the wood stove that warmed this section.");
            // Additional initialization code if needed
        }
    }
    
    public class ColdStorageHouse extends Place {
        public ColdStorageHouse() {
            super("Cold Storage House", "The Cold Storage House, built in 1902, currently hosts the Spring Bulb and Fall Mum Show and serves as a display space for large flowering woody plants.");
            // Additional initialization code if needed
        }
    }
    
    public class PhysiologyHouse extends Place {
        public PhysiologyHouse() {
            super("Physiology House", "This is the Physiology House, originally a laboratory and now hosting plant physiology classes. It also hosts the Spring Bulb and Fall Mum Shows.");
            // Additional initialization code if needed
        }
    }
    
    public class CoolTemperateHouse extends Place {
        public CoolTemperateHouse() {
            super("Cool Temperate House", "Cool Temperate House showcases trees and shrubs from tropical montane or subtropical regions, requiring cool winter growing conditions.");
            // Additional initialization code if needed
        }
    }
    
    public class CamelliaCorridor extends Place {
        public CamelliaCorridor() {
            super("Camellia Corridor", "The Camellia Corridor, reminiscent of European orangeries, grows plants that tolerate cool winter temperatures like camellias, citrus, and orchids.");
            // Additional initialization code if needed
        }
    }
    
    public class GeneticsHouse extends Place {
        public GeneticsHouse() {
            super("Genetics House", "The Genetics House is part of the Blakeslee Range, used for holding dormant plants, growing out small or recently received plants, and staging flower shows.");
            // Additional initialization code if needed
        }
    }
    

}

   