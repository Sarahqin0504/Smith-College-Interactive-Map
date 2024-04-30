import java.util.ArrayList;

public class Bookstore extends Place{
    private int tshirts;
    private int grayHoodies;
    private int blueHoodies;
    private int paper;
    private int pens;
    private int earbuds;
    private int chargers;
    ArrayList<String> textbooks;
    ArrayList<String> snacks;

    // Takes in strings store name and address and open/closed status boolean
    public Bookstore(String name, String location, boolean isOpen){
        super("Bookstore", "This is the school bookstore");
        // Inventory values for items sold in the store
        this.tshirts = 400;
        this.grayHoodies = 100;
        this.blueHoodies = 150;
        this.paper = 700;
        this.pens = 500;
        this.earbuds = 200;
        this.chargers = 250;
        this.textbooks = new ArrayList<String> ();
        this.snacks = new ArrayList<String> ();


        // Array list contents for textbook selection
        textbooks.add("Calculus 100");
        textbooks.add("Spanish 101");
        textbooks.add("Quantum Mechanics");
        textbooks.add("American History");
        textbooks.add("Foundational Astronomy");
        // Array list contents for snack selection
        snacks.add("Popcorn");
        snacks.add("Jelly Beans");
        snacks.add("Potato Chips");
        snacks.add("Chocolate");
    }

    // Shows item menu
    public void printSelection(){
        System.out.println("Welcome to the bookstore! Feel free to browse our wares:" + "\n  1. Clothing \n  2. Textbooks \n  3. Electronics \n  4. School Supplies \n  5. Snacks");
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

    // Working on return method that adds number of returned items to original stock
    // public void returnItem(int number){
    //     if(this.tshirts<400 || this.blueHoodies<150 || this.grayHoodies<100 || this.earbuds<200|| this.chargers<250|| this.paper<700|| this.pens<500){
    //         this.tshirts=this.tshirts+number;
    //         this.blueHoodies=this.blueHoodies+number;

    //     }
    // }


    public static void main(String[] args) {
        Bookstore SmithStore = new Bookstore("Smith College Bookstore", "Smith College", true);

    SmithStore.printSelection();









    

    }





}