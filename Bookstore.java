import java.util.Hashtable;
import java.util.ArrayList;
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
    private Hashtable<String, Integer[]> textbooks;
    //private Hashtable<String, Integer[]> snacks;
    private Hashtable<String, Integer> inventory;
    private Map<String, Place> sections; 
    

    public Bookstore(){
        super("Bookstore", "The Smith College Bookstore.");

        // Initialize map
        this.sections = new HashMap<>();
        this.textbooks = new Hashtable<String, Integer[]>();
        //this.snacks = new Hashtable<String, Integer[]>();
        this.inventory = new Hashtable<String, Integer>();

        // Add sections to the store
        sections.put("Clothing", new ClothingSection());
        sections.put("Books", new BookSection());
        sections.put("Electronics", new TechSection());
        //sections.put("Snacks", new SnackSection());
        sections.put("Office Supplies", new OfficeSection());
        sections.put("Doorway", new Doorway());


        // Sections of bookstore - each section has an exit of the previous section as one moves farther back into the store
        ClothingSection clothing = (ClothingSection) sections.get("Clothing");
        clothing.setExit("south", sections.get("Doorway"));
        
        BookSection books = (BookSection) sections.get("Books");
        books.setExit("south", sections.get("Clothing"));

        TechSection tech = (TechSection) sections.get("Electronics");
        tech.setExit("south", sections.get("Books"));

        //SnackSection snack = (SnackSection) sections.get("Snacks");
        //snack.setExit("south", sections.get("Electronics"));

        OfficeSection office = (OfficeSection) sections.get("Office Supplies");
        office.setExit("south", sections.get("Electronics"));

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
    
   
        Integer calcArray[]={50,60};
        Integer spanishArray[]={20,40};
        Integer quantumArray[]={15,70};
        Integer historyArray[]={30,60};
        Integer astroArray[]={10,70};
        textbooks.put("Calculus 100", calcArray);
        textbooks.put("Spanish 101", spanishArray);
        textbooks.put("Quantum Mechanics", quantumArray);
        textbooks.put("American History", historyArray);
        textbooks.put("Foundational Astronomy", astroArray);

    // Contents for snack selection
        // Integer popArray[]={30,5};
        // Integer beansArray[]={25,8};
        // Integer chipsArray[]={30,5};
        // Integer chocoArray[]={50,4};
        // Integer doritosArray[]={30,5};
        // snacks.put("Popcorn", popArray);
        // snacks.put("Jelly Beans", beansArray);
        // snacks.put("Potato Chips", chipsArray);
        // snacks.put("Chocolate", chocoArray);
        // snacks.put("Doritos", doritosArray);
        System.out.println("Entering the Bookstore...");
    }

    public Map<String, Place> getSections() {
        return sections;
    }

    public Boolean containsItemText(String item){
        return this.textbooks.get(item)[0]>0;
        }

        // public Boolean containsItemSnack(String item){
        //     return this.snacks.get(item)[0]>0;
        //     }
    
    public Boolean checkInventory(String item){
        return this.inventory.get(item)>0;
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

    public Boolean checkBalanceText(String item, int number){
        if(this.money>=this.textbooks.get(item)[1]*number){
            return true;
        }else{

            return false;
        }

    }
    // public Boolean checkBalanceSnack(String item){
    //     if(this.money>=this.snacks.get(item)[1]){
    //         return true;
    //     }else{

    //         return false;
    //     }

    // }
    public Boolean checkValidValueText(String item, int number){
        if(this.textbooks.get(item)[0]>=number){
            return true;
        }else{
            return false;
        }
    }
    // public Boolean checkValidValueSnack(String item, int number){
    //     if(this.snacks.get(item)[0]>=number){
    //         return true;
    //     }else{
    //         return false;
    //     }
    // }
    public void runPurchaseText(String item, int number){
       this.money=this.money-this.textbooks.get(item)[1]*number;
       this.textbooks.get(item)[0]-=number;
    }
    // public void runPurchaseSnack(String item, int number){
    //     this.money=this.money-this.snacks.get(item)[1]*number;
    //     this.snacks.get(item)[0]-=number;
    //  }

    // Buy methods for each product type
    public void buyTextbook(String item, int number){ 
        if(containsItemText(item)){
            if(checkValidValueText(item, number)&&checkBalanceText(item, number)){
            runPurchaseText(item, number);
            System.out.println(number + " copies of " + item + " purchased successfully!");
        
            }else if(checkValidValueText(item, number)==false){
                System.out.println("That's more than we have in stock!");
            }
            else if(checkBalanceText(item, number)==false){
                System.out.println("Insufficient funds.");
            }
            else if(containsItemText(item)==false){
                System.out.println("No such item in store.");
            }
        }
    }
    // public void buySnack(String item, int number){
    //     if(containsItemSnack(item)){
    //         if(checkValidValueSnack(item, number)&&checkBalanceSnack(item)){
    //         runPurchaseSnack(item, number);
    //         System.out.println(number + " packs of " + item + " purchased successfully!");
        
    //          }else{
    //             System.out.println("Invalid item.");
    //          }     
    //         }
        
   // }
    public void buyGrayHoodie(int number){
        if(this.money>=50*number){
            this.grayHoodies = this.grayHoodies - number;
            this.money = this.money - 50*number;
            this.inventory.put("Gray Hoodie", number);
            System.out.println("Purchased " + number+ " gray hoodies " + "successfully!");

        }else if(this.money<50*number){
            System.out.println("Insufficient funds.");
        }

        if (number>100){
            System.out.println("That's more than we have in stock!");
        }

        if (this.grayHoodies<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }

    public void buyBlueHoodie(int number){
        if(this.money>=50*number){
        this.blueHoodies = this.blueHoodies - number;
        this.money = this.money - 50*number;
        this.inventory.put("Blue Hoodie", number);
        System.out.println("Purchased" + number+ " blue hoodies " + "successfully!");

        }else if(this.money<50*number){
            System.out.println("Insufficient funds.");

        }
        if (number>150){
            System.out.println("That's more than we have in stock!");
        }

        if (this.blueHoodies<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }

    public void buyTShirt(int number){
        if(this.money>=30*number){
        this.tshirts = this.tshirts - number;
        this.money = this.money - 30*number;
        this.inventory.put("T-shirt", number);
        System.out.println("Purchased " + number+" t-shirts " + "successfully!");

        }else if(this.money<30*number){
            System.out.println("Insufficient funds.");
        }
        if (number>400){
            System.out.println("That's more than we have in stock!");
        }

        if (this.tshirts<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyPlainPaper(int number){
        if(this.money>=10*number){
        this.plainPaper = this.plainPaper - number;
        this.money = this.money - 10*number;
        this.inventory.put("Plain paper", number);
        System.out.println("Purchased " + number+"plain paper units " + "successfully!");
        
        }else if(this.money<10*number){
            System.out.println("Insufficient funds.");
        }
        if (number>700){
            System.out.println("That's more than we have in stock!");
        }

        if (this.plainPaper<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyLinedPaper(int number){
        if(this.money>=8*number){
        this.linedPaper = this.linedPaper - number;
        this.money = this.money - 8*number;
        this.inventory.put("Lined paper", number);
        System.out.println("Purchased "+number+"lined paper units " + "successfully!");
        
        }else if(this.money<8*number){
            System.out.println("Insufficient funds.");
        }
        if (number>800){
            System.out.println("That's more than we have in stock!");
        }

        if (this.linedPaper<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyPen(int number){
        if(this.money>=6*number){
        this.pens = this.pens - number;
        this.money = this.money - 6*number;
        this.inventory.put("Pen", number);
        System.out.println("Purchased " +number+ " pens " + "successfully!");
        
        }else if(this.money<6*number){
            System.out.println("Insufficient funds.");
        }
        if (number>500){
            System.out.println("That's more than we have in stock!");
        }

        if (this.pens<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyPencil(int number){
        if(this.money>=5*number){
        this.pencils = this.pencils - number;
        this.money = this.money - 5*number;
        this.inventory.put("Pencils", number);
        System.out.println("Purchased " + number+ "pencils " + "successfully!");

        }else if(this.money<5*number){
            System.out.println("Insufficient funds.");
        }
        if (number>600){
            System.out.println("That's more than we have in stock!");
        }

        if (this.pencils<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyEarbuds(int number){
        if(this.money>=12*number){
        this.earbuds = this.earbuds - number;
        this.money = this.money - 12*number;
        this.inventory.put("Earbuds", number);
        System.out.println("Purchased " + number+ " earbuds " + "successfully!");

        }else if(this.money<12*number){
            System.out.println("Insufficient funds.");
        }
        if (number>200){
            System.out.println("That's more than we have in stock!");
        }

        if (this.earbuds<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyCharger(int number){
        if(this.money>=10*number){
        this.chargers = this.chargers - number;
        this.money = this.money - 10*number;
        this.inventory.put("Charger", number);
        System.out.println("Purchased "+number+" chargers" + "successfully!");
        
        }else if(this.money<10*number){
            System.out.println("Insufficient funds.");
        }
        if (number>250){
            System.out.println("That's more than we have in stock!");
        }

        if (this.chargers<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void buyDrive(int number){
        if(this.money>=20*number){
        this.drives = this.drives - number;
        this.money = this.money - 20*number;
        this.inventory.put("Flash Drive", number);
        System.out.println("Purchased " + number+ " drives " + "successfully!");
        
        }else if(this.money<20*number){
            System.out.println("Insufficient funds.");
        }
        if (number>300){
            System.out.println("That's more than we have in stock!");
        }

        if (this.drives<1){
            System.out.println("Sorry, we're out of stock!");
        }
        
    }
    public void printFunds(){
        System.out.println("Current balance is " +this.money + " dollars.");
    }

// return methods for each product type
    public void returnShirt(int number){
        if(this.tshirts<400 && this.inventory.get("T-shirt")>=number){
            this.tshirts=this.tshirts+number;
            this.money = this.money + 30*number;
            this.inventory.remove("T-shirt", number);
            System.out.println("You've returned " + number + " shirt(s) successfully!");
        }else if(this.tshirts==400){
            System.out.println("You haven't sold any to return!");
        }
        else{
            System.out.println("You can't return more than you've bought!");
        }
    }
    public void returnBlueHoodie(int number){
        if(this.blueHoodies<150 && this.inventory.get("Blue Hoodie")>=number){
            this.blueHoodies=this.blueHoodies+number;
            this.money = this.money + 50*number;
            this.inventory.remove("Blue Hoodie", number);
            System.out.println("You've returned " + number + " blue hoodie(s) successfully!");
        }else if(this.blueHoodies==150){
            System.out.println("You haven't sold any to return!");

        }else{
            System.out.println("You can't return more than you've bought!");
        }
    }
    public void returnGrayHoodie(int number){
        if(this.grayHoodies<100 && this.inventory.get("Gray Hoodie")>=number){
            this.grayHoodies=this.grayHoodies+number;
            this.money = this.money + 50*number;
            this.inventory.remove("Gray Hoodie", number);
            System.out.println("You've returned " + number + " gray hoodie(s) successfully!");
        }else if(this.grayHoodies==100){
            System.out.println("You haven't sold any to return!");

        }else{
            System.out.println("You can't return more than you've bought!");
        }
    }

    public void returnPen(int number){
        if(this.pens<500 && this.inventory.get("Pen")>=number){
            this.pens=this.pens+number;
            this.money = this.money + 6*number;
            this.inventory.remove("Pen", number);
            System.out.println("You've returned " + number + " pens successfully!");
        }else if(this.pens==500){
            System.out.println("You haven't sold any to return!");

        }else{
            System.out.println("You can't return more than you've bought!");
        }
    }
    public void returnPencil(int number){
        if(this.pencils<600 && this.inventory.get("Pencils")>=number){
            this.pencils=this.pencils+number;
            this.money = this.money + 5*number;
            this.inventory.remove("Pencils", number);
            System.out.println("You've returned " + number + " pencils successfully!");
        }else if(this.pencils==600){
            System.out.println("You haven't sold any to return!");

        }else{
            System.out.println("You can't return more than you've bought!");
        }
    }
    public void returnEarbuds(int number){
        if(this.earbuds<200 && this.inventory.get("Earbuds")>=number){
            this.earbuds=this.earbuds+number;
            this.money = this.money + 12*number;
            this.inventory.remove("Earbuds", number);
            System.out.println("You've returned " + number + " earbuds successfully!");
        }else if(this.earbuds==200){
            System.out.println("You haven't sold any to return!");

        }else{
            System.out.println("You can't return more than you've bought!");
        }
    }
    public void returnCharger(int number){
        if(this.chargers<250 && this.inventory.get("Charger")>=number){
            this.chargers=this.chargers+number;
            this.money = this.money + 10*number;
            this.inventory.remove("Charger", number);
            System.out.println("You've returned " + number + " chargers successfully!");
        }else if(this.chargers==250){
            System.out.println("You haven't sold any to return!");

        }else{
            System.out.println("You can't return more than you've bought!");
        }
    }
    public void returnDrive(int number){
        if(this.drives<300 && this.inventory.get("Flash Drive")>=number){
            this.drives=this.drives+number;
            this.money = this.money + 20*number;
            this.inventory.remove("Flash Drive", number);
            System.out.println("You've returned " + number + " flash drives successfully!");
        }else if(this.drives==300){
            System.out.println("You haven't sold any to return!");

        }else{
            System.out.println("You can't return more than you've bought!");
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
    // class SnackSection extends Place {
    //     public SnackSection() {
    //         super("Snacks", "Welcome to the snack section. Find your favorite snack item here.");
    //         addItem(new Thing("Doritos", "Cheese-flavored corn chips."));
    //         addItem(new Thing("Potato Chips", "Plain potato chips."));
    //         addItem(new Thing("Popcorn", "Lightly-salted popcorn."));
    //         addItem(new Thing("Jelly Beans", "Assorted fruit-flavored jelly beans."));
    //         addItem(new Thing("Chocolate", "A milk chocolate bar."));
    //     }
    // }
    class Doorway extends Place {
        public Doorway() {
            super("Doorway", "The place to enter and exit the bookstore.");
            addItem(new Thing("Door", "A glass door with the Smith College logo."));
            
        }
    }

    public static void main(String[] args) {
        Bookstore store = new Bookstore();
        System.out.println("Welcome to the Smith College Bookstore!");
        store.buyEarbuds(6);
        store.returnEarbuds(5);

        
        


        


    }












}







    