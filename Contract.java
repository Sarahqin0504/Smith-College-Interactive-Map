public interface Contract {

    void grab(String item);
    String drop(String item);
    void examine(String itemName);
    String lookAround(Place currentPlace);
    void use(String item);
    // move can take you to places inside the building
    // when travel around building, need to exit the building to access other buildings
    void move(String direction);
    void enter(String building);
    void exit(String building);
    // elevator only available in library
    void elevator(int floorNumber);
    String buy(String item);
    void rest();
    void undo();
    // quit() to exit the game


}