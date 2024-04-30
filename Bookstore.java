import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bookstore extends Place {
    private int tshirts;
    private int grayHoodies;
    private int blueHoodies;
    private int paper;
    private int pens;
    private int earbuds;
    private int chargers;
    ArrayList<String> textbooks;
    ArrayList<String> snack;
    private Map<String, Place> sections; 
    

    public Bookstore(){
        super("Bookstore", "The Smith College Bookstore.");

        // Initialize map
        this.sections = new HashMap<>();

        // Add sections to the store
        sections.put("Clothing", new ClothingSection());
        sections.put("Books", new BookSection());
        sections.put("Electronics", new TechSection());
        sections.put("Snacks", new SnackSection());
        sections.put("Office Supplies", new OfficeSection());
        sections.put("Doorway", new Doorway());

        // Sections of bookstore
        ClothingSection clothing = (ClothingSection) sections.get("Clothing");
        clothing.setExit("south", sections.get("Doorway"));
        
        BookSection books = (BookSection) sections.get("Books");
        books.setExit("south", sections.get("Clothing"));

        TechSection tech = (TechSection) sections.get("Electronics");
        tech.setExit("south", sections.get("Books"));

        SnackSection snacks = (SnackSection) sections.get("Snacks");
        snacks.setExit("south", sections.get("Electronics"));

        OfficeSection office = (OfficeSection) sections.get("Office Supplies");
        snacks.setExit("south", sections.get("Snacks"));

        Doorway doorway = (Doorway) sections.get("Office Supplies");
        snacks.setExit("south", sections.get("Snacks"));


    // Inventory stock numbers
        this.tshirts = 400;
        this.grayHoodies = 100;
        this.blueHoodies = 150;
        this.paper = 700;
        this.pens = 500;
        this.earbuds = 200;
        this.chargers = 250;
        this.textbooks = new ArrayList<String> ();
        this.snack = new ArrayList<String> ();


    // Array list contents for textbook selection
        textbooks.add("Calculus 100");
        textbooks.add("Spanish 101");
        textbooks.add("Quantum Mechanics");
        textbooks.add("American History");
        textbooks.add("Foundational Astronomy");
    // Array list contents for snack selection
        snack.add("Popcorn");
        snack.add("Jelly Beans");
        snack.add("Potato Chips");
        snack.add("Chocolate");
        snack.add("Doritos");
        System.out.println("Entering the Bookstore...");
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
    public void buyGrayHoodie(){
        if (this.grayHoodies<1){
            System.out.println("Sorry, we're out of stock!");
        }
        else{
            this.grayHoodies = grayHoodies - 1;
        }
    }

    public void buyBlueHoodie(){
        if (this.blueHoodies<1){
            System.out.println("Sorry, we're out of stock!");
        }
        else{
            this.blueHoodies = blueHoodies - 1;
        }
    }

    public void buyTshirt(){
        if (this.tshirts<1){
            System.out.println("Sorry, we're out of stock!");
        }
        else{
            this.tshirts = tshirts - 1;
        }
    }

    public void buyPaper(){
        if (this.paper<1){
            System.out.println("Sorry, we're out of stock!");
        }
        else{
            this.paper = paper - 1;
        }
    }
    public void buyPen(){
        if (this.pens<1){
            System.out.println("Sorry, we're out of stock!");
        }
        else{
            this.pens = pens - 1;
        }
    }
    public void buyEarbuds(){
        if (this.earbuds<1){
            System.out.println("Sorry, we're out of stock!");
        }
        else{
            this.earbuds = earbuds - 1;
        }
    }
    public void buycharger(){
        if (this.chargers<1){
                System.out.println("Sorry, we're out of stock!");
            }
        else{
                this.chargers = chargers - 1;
            }
        }


    public void returnShirt(int number){
        if(this.tshirts<400){
            this.tshirts=this.tshirts+number;
            System.out.println("You've returned " + number + "shirt(s) successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }
    public void returnBlueHoodie(int number){
        if(this.blueHoodies<400){
            this.blueHoodies=this.blueHoodies+number;
            System.out.println("You've returned " + number + "blue hoodie(s) successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }
    public void returnGrayHoodie(int number){
        if(this.grayHoodies<400){
            this.grayHoodies=this.grayHoodies+number;
            System.out.println("You've returned " + number + "gray hoodie(s) successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }

    public void returnPen(int number){
        if(this.pens<400){
            this.pens=this.pens+number;
            System.out.println("You've returned " + number + "pens successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }
    public void returnEarbuds(int number){
        if(this.earbuds<400){
            this.earbuds=this.earbuds+number;
            System.out.println("You've returned " + number + "earbuds successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }
    public void returnCharger(int number){
        if(this.chargers<400){
            this.chargers=this.pens+number;
            System.out.println("You've returned " + number + "charger(s) successfully!");
        }else{
            System.out.println("You haven't sold any to return!");
        }
    }

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
            addItem(new Thing("Register", "Cheese-flavored corn chips."));
            
        }
    }

}





    