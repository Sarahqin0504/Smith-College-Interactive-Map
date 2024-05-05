public interface Contract {

    void grab(String item);
    String drop(String item);
    void examine(String itemName);
    String lookAround(Place currentPlace);
    void use(String item);
    void move(String direction);
    void enter(String building);
    void exit(String building);
    void elevator(int floorNumber);
    String buy(String item);
    void rest();
    void undo();


}