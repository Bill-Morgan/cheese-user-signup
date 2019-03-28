package org.launchcode.cheesemvc.models;

public class Cheese {

    private int id;
    private String name;
    private String description;
    private static int nextId = 0;

    public Cheese(String aName, String aDescription){
        this();
        this.name = aName;
        this.description = aDescription;
    }

    private Cheese(){
        this.id = nextId;
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

    public int getId() {
        return id;
    }
}
