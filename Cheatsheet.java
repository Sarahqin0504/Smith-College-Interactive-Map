public interface Cheatsheet {

    // grab an item and this item adds to your inventory
    void grab(String item);
    // drop an item and remove from inventory
    String drop(String item);
    // get description for the item
    void examine(String itemName);
    // find what is in the room
    String lookAround(Place currentPlace);
    // you can only use computer to search things
    void use(String item);
    // move can take you to places inside the building
    // when travel around building, need to exit the building to access other buildings
    void move(String direction);
    // allows to enter the building into a room
    void enter(String building);
    // exit the room, brought you to the outside the building 
    void exit(String building);
    // elevator only available in library, moves you up or down between the floors
    void elevator(int floorNumber);
    // buy items in bookstore 
    // buy coffee method available in Compass Cafe
    String buy(String item);
    // rest: resting, not interactive 
    void rest();
    // undo: not interactive 
    void undo();
    // inventory(): to check the player's inventory
    // quit(): to exit the game


}