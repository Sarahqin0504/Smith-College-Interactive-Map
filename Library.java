import java.util.HashMap;
import java.util.Map;

public class Library extends Place {

    private Map<String, Place> floors; 

    public Library() {
        super("Library", "Neilson library");

        // Initialize the HashMap
        floors = new HashMap<>();

        // Create and add each floor to the HashMap
        floors.put("Ground Floor", new GroundFloor());
        floors.put("First Floor", new FirstFloor());
        floors.put("Second Floor", new SecondFloor());
        floors.put("Third Floor", new ThirdFloor());
        floors.put("Fourth Floor", new FourthFloor());
        floors.put("Compass Cafe", new CompassCafe(10, 10, 10, 10));
        floors.put("Terrace", new Terrace());
        floors.put("Chapin Lawn", new ChapinLawn());
        floors.put("Burton Lawn", new BurtonLawn());
        floors.put("Seelye Lawn", new SeelyeLawn());
        floors.put("Alumni Gym", new AlumniGym());

         // Set exits for each floor
        GroundFloor groundFloor = (GroundFloor) floors.get("Ground Floor");
        groundFloor.setExit("south", floors.get("Alumni Gym"));
        groundFloor.setExit("west", floors.get("Burton Lawn"));

        FirstFloor firstFloor = (FirstFloor) floors.get("First Floor");
        firstFloor.setExit("north", floors.get("Compass Cafe"));
        firstFloor.setExit("east", floors.get("Seelye Lawn"));

        CompassCafe compassCafe = (CompassCafe) floors.get("Compass Cafe");
        compassCafe.setExit("north", floors.get("Chapin Lawn"));
        compassCafe.setExit("south", floors.get("First Floor"));

        FourthFloor fourthFloor = (FourthFloor) floors.get("Fourth Floor");
        fourthFloor.setExit("west", floors.get("Terrace"));

        Terrace terrace = (Terrace) floors.get("Terrace");
        terrace.setExit("east", floors.get("Fourth Floor"));

        BurtonLawn burtonLawn = (BurtonLawn) floors.get("Burton Lawn");
        burtonLawn.setExit("east", floors.get("Ground Floor"));

        ChapinLawn chapinLawn = (ChapinLawn) floors.get("Chapin Lawn");
        chapinLawn.setExit("south", floors.get("Compass Cafe"));

        AlumniGym alumniGym = (AlumniGym) floors.get("Alumni Gym");
        alumniGym.setExit("north", floors.get("Ground Floor"));

        SeelyeLawn seelyeLawn = (SeelyeLawn) floors.get("Seelye Lawn");
        seelyeLawn.setExit("west", floors.get("First Floor"));

    }

    public Map<String, Place> getFloors() {
        return floors;
    }
}

class GroundFloor extends Place {
    public GroundFloor() {
        super("Ground Floor", "This is the Ground Floor. At the Front desk, you can borrow or return books. There is an exit to the south and west.");
        // Add items to the ground floor inventory
        addItem(new Thing("Book", "Interactive Linear Algebra"));
        addItem(new Thing("Front Desk", "You can borrow and return books"));
        addItem(new Thing("Faculty One card", "You can access different exits"));
    
    }
}

class FirstFloor extends Place {
    public FirstFloor() {
        super("First Floor", "This is the First Floor. There is a Front desk and the Compass Cafe. Exit to the north and east.");
        // Add items or customize as needed
        addItem(new Thing("Front Desk", "You can ask questions here"));
        addItem(new Thing("Table", "An interesting looking table"));
        addItem(new Thing("One card", "Lost Onecard"));
    }
}

class SecondFloor extends Place {
    public SecondFloor() {
        super("Second Floor", "This is the Second Floor. Study Space to the north.");
        // Add items or customize as needed
        addItem(new Thing("Computer", "Hello world"));
    }
}

class ThirdFloor extends Place {
    public ThirdFloor() {
        super("Third Floor", "This is the Third Floor. Study Space to the north.");
        // Add items or customize as needed
        addItem(new Thing("Desk", "Just a desk"));
        addItem(new Thing("Chair", "You can rest here"));
    }
}

class FourthFloor extends Place {
    public FourthFloor() {
        super("Fourth Floor", "This is the Skyline reading room. Terrace to the west.");
        // Add items or customize as needed
    }
}

class CompassCafe extends Place {
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public CompassCafe(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super("Compass Cafe", "This is the Compass Cafe. You can purchase drinks here.");
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        }
        
        /**
         * selling coffee
         * @param size size of coffee/ number of coffee in ouces
         * @param nSugarPackets number of sugar packets
         * @param nCreams number of creams
         */
        public void sellCoffee(int size, int nSugarPackets, int nCreams, int nCups){
            if (size == 0 || nSugarPackets == 0 || nCreams == 0 || nCups == 0) {
                restock(size, nSugarPackets, nCreams, nCups);
            }
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= nCups;
            System.out.println("Coffee: " + nCoffeeOunces + "\nSugar: " + nSugarPackets + "\nCream: " + nCreams + "\nCups:" + nCups);
        }

        /**
         * restocking
         * @param nCoffeeOunces number of Coffee in ounces
         * @param nSugarPackets number of Sugar Packets
         * @param nCreams number of creams
         * @param nCups number of cups
         */
        private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
            this.nCoffeeOunces += nCoffeeOunces;
            this.nSugarPackets += nSugarPackets;
            this.nCreams += nCreams;
            this.nCups += nCups;
        }

}

class Terrace extends Place {
    public Terrace() {
        super("Terrace", "This is the Terrace. Please enjoy the beautiful view.");
        // Add items or customize as needed
        addItem(new Thing("Lounge Chair", "You can rest here"));
    }
}

class ChapinLawn extends Place {
    public ChapinLawn() {
        super("Chapin Lawn", "This is Chapin Lawn, where students all have fun and relax.");
        // Add items or customize as needed
    }
}

class BurtonLawn extends Place {
    public BurtonLawn() {
        super("Burton Lawn", "This is Burton lawn, leading to the academic buildings.");
        // Add items or customize as needed
    }
}

class SeelyeLawn extends Place {
    public SeelyeLawn() {
        super("Seelye Lawn", "This is Seelye Lawn. There are a lot of squirrels");
    }
}

class AlumniGym extends Place {
    public AlumniGym() {
        super("Alumni Gym", "This is the Alumni Gym, where you actually study");
    }
}
