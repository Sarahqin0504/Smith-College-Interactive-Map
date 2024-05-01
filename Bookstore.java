import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map;

public class Bookstore extends Place {
    private int tshirts;
    private int grayHoodies;
    private int blueHoodies;
    private int plainPaper;
    private int linedPaper;
    private int pens;
    private int pencils;
    private int earbuds;
    private int chargers;
    private int drives;
    private int money;
    private Hashtable<String, Integer> textbooks;
    private Hashtable<String, Integer> snacks;
    private Map<String, Place> sections; 
    

    public Bookstore(){
        super("Bookstore", "The Smith College Bookstore.");

        // Initialize map
        this.sections = new HashMap<>();
        this.textbooks = new Hashtable<String, Integer>();
        this.snacks = new Hashtable<String, Integer>();

        // Add sections to the store
        sections.put("Clothing", new ClothingSection());
        sections.put("Books", new BookSection());
        sections.put("Electronics", new TechSection());
        sections.put("Snacks", new SnackSection());
        sections.put("Office Supplies", new OfficeSection());
        sections.put("Doorway", new Doorway());


        // Sections of bookstore - each section has an exit of the previous section as one moves farther back into the store
        ClothingSection clothing = (ClothingSection) sections.get("Clothing");
        clothing.setExit("south", sections.get("Doorway"));
        
        BookSection books = (BookSection) sections.get("Books");
        books.setExit("south", sections.get("Clothing"));

        TechSection tech = (TechSection) sections.get("Electronics");
        tech.setExit("south", sections.get("Books"));

        SnackSection snack = (SnackSection) sections.get("Snacks");
        snack.setExit("south", sections.get("Electronics"));

        OfficeSection office = (OfficeSection) sections.get("Office Supplies");
        office.setExit("south", sections.get("Snacks"));

        Doorway doorway = (Doorway) sections.get("Doorway");
        doorway.setExit("south", new AlumniGym());


    // Inventory stock numbers
        this.tshirts = 400;
        this.grayHoodies = 100;
        this.blueHoodies = 150;
        this.plainPaper = 700;
        this.linedPaper = 800;
        this.pens = 500;
        this.pencils = 600;
        this.earbuds = 200;
        this.chargers = 250;
        this.drives = 300;
        this.money = 100;
    
    // Array list contents for textbook selection
        textbooks.put("Calculus 100", 50);
        textbooks.put("Spanish 101", 20);
        textbooks.put("Quantum Mechanics", 15);
        textbooks.put("American History", 30);
        textbooks.put("Foundational Astronomy", 10);
    // Array list contents for snack selection
        snacks.put("Popcorn",30);
        snacks.put("Jelly Beans", 25);
        snacks.put("Potato Chips", 30);
        snacks.put("Chocolate", 50);
        snacks.put("Doritos", 30);
        System.out.println("Entering the Bookstore...");
    }

    public Boolean containsItem(String item){
        return this.textbooks.get(item)<0;
        }

    // Shows item menu
    public void printSelection(){
        System.out.println("Welcome to the bookstore! Feel free to browse our wares:" + "\n  1. Clothing \n  2. Textbooks \n  3. Electronics \n  4. Office Supplies \n  5. Snacks");
    }

    public boolean walk(String direction){
        System.out.println("You walk" + direction + " through the bookstore.");
        return true;
    }

    public boolean fly(int x, int y){
        System.out.println("You cannot fly inside the bookstore!");
        return true;
    }

    public void grab(String item) {
        System.out.println("You have picked up " + item + ".");
    }

    public String drop(String item) {
        return "You have dropped " + item + ".";
    }


    // Buy methods for each product type
    public void buyTextbook(String item, int number){
        if(containsItem(item)){
            int num = this.textbooks.get(item)-number;
            this.textbooks.replace(item, num);
            System.out.println(number + " copies of " + item + " purchased successfully!");
            
             }
        
    }
    public void buySnack(String item, int number){
        if(containsItem(item)){
            int num = this.snacks.get(item)-number;
            this.snacks.replace(item, num);
            System.out.println(item + "purchased successfully!");
            
             }
        
    }
    public void buyGrayHoodie(int number){
        this.grayHoodies = this.grayHoodies - number;
        this.money = this.money - 50*number;

        if (number>100){
            System.out.println("That's more than we have in stock!");
        }

        if (this.grayHoodies<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }

    public void buyBlueHoodie(int number){
        this.blueHoodies = this.blueHoodies - number;
        this.money = this.money - 50*number;
        
        if (number>150){
            System.out.println("That's more than we have in stock!");
        }

        if (this.blueHoodies<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }

    public void buyTShirt(int number){
        this.tshirts = this.tshirts - number;
        this.money = this.money - 30*number;
        
        if (number>400){
            System.out.println("That's more than we have in stock!");
        }

        if (this.tshirts<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyPlainPaper(int number){
        this.plainPaper = this.plainPaper - number;
        this.money = this.money - 10*number;
        
        if (number>700){
            System.out.println("That's more than we have in stock!");
        }

        if (this.plainPaper<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyLinedPaper(int number){
        this.linedPaper = this.linedPaper - number;
        this.money = this.money - 8*number;
        
        if (number>800){
            System.out.println("That's more than we have in stock!");
        }

        if (this.linedPaper<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyPen(int number){
        this.pens = this.pens - number;
        this.money = this.money - 6*number;
        
        if (number>500){
            System.out.println("That's more than we have in stock!");
        }

        if (this.pens<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyPencil(int number){
        this.pencils = this.pencils - number;
        this.money = this.money - 5*number;
        
        if (number>600){
            System.out.println("That's more than we have in stock!");
        }

        if (this.pencils<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyEarbuds(int number){
        this.earbuds = this.earbuds - number;
        this.money = this.money - 12*number;
        
        if (number>200){
            System.out.println("That's more than we have in stock!");
        }

        if (this.earbuds<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyCharger(int number){
        this.chargers = this.chargers - number;
        this.money = this.money - 10*number;
        
        if (number>250){
            System.out.println("That's more than we have in stock!");
        }

        if (this.chargers<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyDrive(int number){
        this.drives = this.drives - number;
        this.money = this.money - 20*number;
        
        if (number>300){
            System.out.println("That's more than we have in stock!");
        }

        if (this.drives<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }

// return methods for each product type
    public void returnShirt(int number){
        if(this.tshirts<400){
            this.tshirts=this.tshirts+number;
            this.money = this.money + 30*number;
            System.out.println("You've returned " + number + " shirt(s) successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }
    public void returnBlueHoodie(int number){
        if(this.blueHoodies<150){
            this.blueHoodies=this.blueHoodies+number;
            this.money = this.money + 50*number;
            System.out.println("You've returned " + number + " blue hoodie(s) successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }
    public void returnGrayHoodie(int number){
        if(this.grayHoodies<100){
            this.grayHoodies=this.grayHoodies+number;
            this.money = this.money + 50*number;
            System.out.println("You've returned " + number + " gray hoodie(s) successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }

    public void returnPen(int number){
        if(this.pens<500){
            this.pens=this.pens+number;
            this.money = this.money + 6*number;
            System.out.println("You've returned " + number + " pens successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }
    public void returnPencil(int number){
        if(this.pencils<600){
            this.pens=this.pens+number;
            this.money = this.money + 5*number;
            System.out.println("You've returned " + number + " pencils successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }
    public void returnEarbuds(int number){
        if(this.earbuds<200){
            this.earbuds=this.earbuds+number;
            this.money = this.money + 12*number;
            System.out.println("You've returned " + number + " earbuds successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }
    public void returnCharger(int number){
        if(this.chargers<250){
            this.chargers=this.chargers+number;
            this.money = this.money + 10*number;
            System.out.println("You've returned " + number + " charger(s) successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }
    public void returnDrive(int number){
        if(this.drives<300){
            this.drives=this.drives+number;
            this.money = this.money + 20*number;
            System.out.println("You've returned " + number + " drive(s) successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }

    // Creates sections with items in the store
    class ClothingSection extends Place {
        public ClothingSection() {
            super("Clothing", "Welcome to the clothing section. We have t-shirts, blue hoodies, and gray hoodies in stock.");
            addItem(new Thing("T-Shirt", "A gray t-shirt printed with the Smith College logo."));
            addItem(new Thing("Blue Hoodie", "A blue Smith College hoodie."));
            addItem(new Thing("Gray Hoodie", "A gray Smith College hoodie."));
        }
    }
    class TechSection extends Place {
        public TechSection() {
            super("Electronics", "Welcome to the electronics section. See our selection of available tech items.");
            addItem(new Thing("Earbuds", "A set of standard, plug-in earbuds."));
            addItem(new Thing("Charger", "A USB-C device charging cable."));
            addItem(new Thing("Flash Drive", "A 100 GB flash drive with USB connection."));
        }
    }
    class BookSection extends Place {
        public BookSection() {
            super("Books", "Welcome to the textbook section. Find the textbook suitable to your coursework here.");
            addItem(new Thing("Calculus 100", "A gentle introduction to basic calculus."));
            addItem(new Thing("Spanish 101", "Begin your journey to fluency in the Spanish language with this grammatical and conversational guide."));
            addItem(new Thing("Quantum Mechanics", "An exploration of concepts in the quantum mechanics field."));
            addItem(new Thing("American History", "From 1492 to today, gain an in-depth understanding of our nation's history."));
            addItem(new Thing("Foundational Astronomy", "A beginners guide to the marvels of our galaxy and beyond."));
        }
    }
    class OfficeSection extends Place {
        public OfficeSection() {
            super("Office Supplies", "Welcome to the office supplies section. Advance your productivity with materials to suit your needs.");
            addItem(new Thing("Plain paper", "Plain, white paper in 100 sheet units."));
            addItem(new Thing("Lined paper", "Lined paper in 100 sheet units"));
            addItem(new Thing("Pens", "Black ballpoint pens."));
            addItem(new Thing("Pencils", "Mechanical graphite pencils in packs of 3."));
        }
    }
    class SnackSection extends Place {
        public SnackSection() {
            super("Snacks", "Welcome to the snack section. Find your favorite snack item here.");
            addItem(new Thing("Doritos", "Cheese-flavored corn chips."));
            addItem(new Thing("Potato Chips", "Plain potato chips."));
            addItem(new Thing("Popcorn", "Lightly-salted popcorn."));
            addItem(new Thing("Jelly Beans", "Assorted fruit-flavored jelly beans."));
            addItem(new Thing("Chocolate", "A milk chocolate bar."));
        }
    }
    class Doorway extends Place {
        public Doorway() {
            super("Doorway", "The place to enter and exit the bookstore.");
            addItem(new Thing("Door", "A glass door with the Smith College logo."));
            
        }
    }

    public static void main(String[] args) {
        Bookstore store = new Bookstore();
        System.out.println("Welcome to the Smith College Bookstore!");
        store.buyGrayHoodie(700);
        store.buyGrayHoodie(3);
        store.containsItem("Calculus 100");
        store.buyTextbook("Calculus 100", 2);
        


    }












}







    