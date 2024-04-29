public class Elevator extends Place {
    private int currentFloor;
    private int maxFloors;

    public Elevator(String name, String description, int maxFloors) {
        super(name, description);
        this.maxFloors = maxFloors;
        this.currentFloor = 1; // Start at the first floor
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int floor) {
        if (floor >= 0 && floor <= maxFloors) {
            this.currentFloor = floor;
        } else {
            System.out.println("Invalid floor number.");
        }
    }

    public void goToFloor(int floor) {
        if (floor >= 0 && floor <= maxFloors) {
            System.out.println("Moving to floor " + floor);
            setCurrentFloor(floor);
        } else {
            System.out.println("Invalid floor number.");
        }
    }

    // Additional methods can be added as needed
}
