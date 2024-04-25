import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class BotanicGarden implements Contract {
    private boolean isResting = false;
    private String lastAction = "";
    private int flowerSize = 1;
    private String season = "";
    private Map<String, Room> rooms;
    
    /**
     * Constructor for the BotanicGarden class.
     */
    public BotanicGarden() {
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

    public void visitRoom(String roomName) {
        if (rooms.containsKey(roomName)) {
            rooms.get(roomName).enter();
        } else {
            System.out.println("No such room found in the Lyman Plant House.");
        }
    }
    
    /**
     * The method is for visitors to walk in a given direction in the garden.
     * @param direction The direction in which to walk.
     * @return true if the direction is valid, false otherwise.
     */
    @Override
    public boolean walk(String direction) {
        System.out.println("You walk " + direction + " through the garden.");
        return true; // In a real implementation, you might check if the direction is valid
    }


    /**
     * The method is for the visitor to pick up an item in the garden.
     * @param item The item to pick up.
     */
    @Override
    public void grab(String item) {
        System.out.println("You have picked up " + item + ".");
    }

    /**
     * The method is for the visitor to drop an item in the garden.
     * @param item The item to drop.
     * @return A message indicating the item has been dropped.
     */
    @Override
    public String drop(String item) {
        return "You have dropped " + item + ".";
    }

    /**
     * Changes the season in the garden.
     * Simulates the effect of seasons changing on the garden's flora and fauna.
     */
    public void changeSeason() {
        String[] seasons = {"spring", "summer", "autumn", "winter"};
        Random rand = new Random();
        this.season = seasons[rand.nextInt(seasons.length)];
        System.out.println("The season has changed to " + this.season + ".");
        switch (this.season) {
            case "spring":
                System.out.println("Flowers start blooming beautifully.");
                break;
            case "summer":
                System.out.println("The garden is having a hot party now!");
                break;
            case "autumn":
                System.out.println("The garden starts to calm down.");
                break;
            case "winter":
                System.out.println("The garden rests under a blanket of snow.");
                break;
        }
        lastAction = "changeSeason";
    }

    /**
     * The method is for visitors to examine an item or place in the garden.
     */
    @Override
    public void examine(String item) {
        switch (item.toLowerCase()) {
            case "butterfly":
                System.out.println("You see a butterfly. Its wings feature bright blue with black markings.");
                break;
            case "flower":
                if (season.equalsIgnoreCase("spring")) {
                    System.out.println("You examine a sakura. It seems to be a cherry-blossom season.");
                } 
                else if (season.equalsIgnoreCase("summer")) {
                    System.out.println("You're looking at a pink lotus. It lies on the lily pads.");
                }
                break;
            case "pond":
                System.out.println("The pond is peaceful, with lily pads scattered across the surface. There is a sculpture of swan standing in the middle of the pond.");
                break;
            case "tree":
                if (season.equalsIgnoreCase("autumn")) {
                    System.out.println("The maple tree features the autumn vibe. There are red, orange, and yellow leaves all over the ground.");
                } else if (season.equalsIgnoreCase("winter")) {
                    System.out.println("The bare branches of the oak tree are covered with a light dusting of snow, stark against the winter sky.");
                }
                break;
            case "bird":
                System.out.println("Birds are singing delightly.");
                break;
            default:
                System.out.println("The"+ item + "can not be found in the botanic garden.");
                break;
        }
        lastAction = "examine";
    }

    

    /**
     * The method is for visitors to use an item in the garden.
     * @param item The item to use.
     */
    @Override
    public void use(String item) {
        // Example usage could be opening a map
        if(item.equalsIgnoreCase("map")) {
            System.out.println("You use the map to find your way to the botanic garden.");
        } else {
            System.out.println("You use " + item + ".");
        }
    }

    /**
     * The method is for visitors to observes insects flying around in the garden.
     * @param x The x-coordinate of the flight path.
     * @param y The y-coordinate of the flight path.
     * @return true if the observation was successful, false otherwise (e.g., no insects in sight).
     */
    @Override
    public boolean fly(int x, int y) {
        System.out.println("You watch a insect fluttering at coordinates (" + x + ", " + y + ").");
        lastAction = "fly";
        return true; 
    }

    /**
     * The method is to represent the shrinking of a flower or plant in the garden.
     * @return The new size of the flower after shrinking.
     */
    @Override
    public Number shrink() {
        flowerSize = Math.max(0, flowerSize - 1); 
        System.out.println("A flower in the garden has shrunk.");
        lastAction = "shrink";
        return flowerSize;
    }

    /**
     * The method is to represent the growth of a flower or plant in the garden.
     * @return The new size of the flower after growing.
     */
    @Override
    public Number grow() {
        flowerSize = Math.min(2, flowerSize + 1); // Ensure flowerSize doesn't exceed 2
        System.out.println("A flower in the garden has grown.");
        lastAction = "grow";
        return flowerSize;
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

    public static void main(String[] args) {
        BotanicGarden garden = new BotanicGarden();
    
        System.out.println("Welcome to the Botanic Garden!");
    
        //spring
        System.out.println("\n--- Spring ---");
        garden.examine("flower");
        garden.examine("bird");
        garden.walk("north to the green room");
    
        //summer
        garden.changeSeason();
        System.out.println("\n--- Summer ---");
        garden.examine("flower");
        garden.rest();
        garden.walk("east to the pond");
        garden.examine("pond");
    
        //autumn
        garden.changeSeason();
        System.out.println("\n--- Autumn ---");
        garden.examine("tree");
        garden.grab("fallen leaf");
        String leaf = garden.drop("fallen leaf");
        System.out.println(leaf);
    
        //winter
        garden.changeSeason();
        System.out.println("\n--- Winter ---");
        garden.examine("tree");
        garden.rest();
    
        //Observing wildlife
        garden.fly(5, 10); 
        garden.examine("butterfly");
    
        //Interacting with the garden
        garden.use("map"); // Pretend to use a map
    
        //Dynamic changes in the garden
        garden.grow(); 
        garden.shrink(); 
        garden.undo();
    }
}
