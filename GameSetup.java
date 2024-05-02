public class GameSetup {
    private BotanicGarden botanicGarden;
    private Library library;
    private Bookstore bookstore;

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

    public Library getLibrary() {
        return this.library;
    }

    public BotanicGarden getBotanicGarden() {
        return this.botanicGarden;
    }
}
