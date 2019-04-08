package org.launchcode.cheesemvc.models;
import javax.validation.constraints.*;

public class Cheese {

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty.")
    private String description;

    @NotNull(message = "Ratting must be between 1 and 5.")
    @Min(1)
    @Max(5)
    private int rating;

    private CheeseType type;

    private int cheeseId;
    private static int nextId = 0;


    public Cheese(String aName, String aDescription, int rating){
        this();
        this.name = aName;
        this.description = aDescription;
        this.rating = rating;
    }

    public Cheese(){
        this.cheeseId = nextId;
        nextId++;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }
    public String getDescription(){
        return this.description;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
