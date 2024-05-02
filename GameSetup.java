public class GameSetup {
    private Place botanicGarden;
    private Place library;
    private Place bookstore;

    public GameSetup() {
        // Instantiate each place once
        botanicGarden = new BotanicGarden();
        library = new Library();
        bookstore = new Bookstore();

        // Set exits
        botanicGarden.setExit("east", library);
        botanicGarden.setExit("south", bookstore);
        library.setExit("west", botanicGarden);
        library.setExit("east", bookstore);
        bookstore.setExit("west", library);
        bookstore.setExit("north", botanicGarden);
    }

    public Place getStartingPlace() {
        return library; // Or wherever you want the player to start
    }
}
