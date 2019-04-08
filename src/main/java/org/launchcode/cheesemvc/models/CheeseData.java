package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {

    private static ArrayList<Cheese> cheesesArray = new ArrayList<>();

    //get all

    public static ArrayList<Cheese> getCheesesArray() {
        return cheesesArray;
    }


    //add cheese
    public static void add(Cheese newCheese) {
        cheesesArray.add(newCheese);
    }
    //remove
    public static void remove(int id) {
        Cheese cheeseToRemove = getById(id);
        cheesesArray.remove(cheeseToRemove);
    }

    public static void edit(int cheeseId, Cheese editCheese) {
        edit(cheeseId, editCheese.getName(), editCheese.getDescription(), editCheese.getType(), editCheese.getRating());
    }

    public static void edit(int cheeseId, String name, String description, CheeseType type, int rating) {
        Cheese cheeseToEdit = getById(cheeseId);
        cheeseToEdit.setName(name);
        cheeseToEdit.setDescription(description);
        cheeseToEdit.setType(type);
        cheeseToEdit.setRating(rating);
    }

    //getById
    public static Cheese getById(int id){
        Cheese theCheese = null;
        for (Cheese testCheese : cheesesArray) {
            if (testCheese.getCheeseId() == id) {
                theCheese = testCheese;
                break;
            }
        }
        return theCheese;
    }

}
