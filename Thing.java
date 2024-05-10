/**
 * Represents an item 
 */
public class Thing {
    private String name;
    private String description;

    /**
     * Constructor of Thing
     * @param name The name of the thing
     * @param description The description of the thing
     */
    public Thing(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    /**
     * getter of the name of the thing
     * @return The name of the thing
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the thing
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter of the description of the thing
     * @return The description of the thing
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the thing
     * @param description The description to set
     */
    public void setDescription(String description){
        this.description = description;
    }
}
