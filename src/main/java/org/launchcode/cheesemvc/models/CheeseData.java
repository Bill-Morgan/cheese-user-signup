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
        Cheese cheseToRemove = getById(id);
        cheesesArray.remove(cheseToRemove);
    }

    public static void update(int cheeseId, String name, String description) {
        Cheese cheeseToEdit = getById(cheeseId);
        cheeseToEdit.setName(name);
        cheeseToEdit.setDescription(description);
    }

    //getById
    public static Cheese getById(int id){
        Cheese theCheese = null;
        for (Cheese testCheese : cheesesArray) {
            if (testCheese.getId() == id) {
                theCheese = testCheese;
                break;
            }
        }
        return theCheese;
    }

}
