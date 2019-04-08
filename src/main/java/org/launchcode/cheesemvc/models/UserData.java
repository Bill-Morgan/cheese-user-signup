package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

public class UserData {

    public static ArrayList<User> userArray = new ArrayList<>();


    public static ArrayList<User> getUserArray() {
        return userArray;
    }

    public static void addUser(User newUser){
        userArray.add(newUser);
    }

    public static User getUser(String userName){
        User retValue = new User();
        return retValue;
    }
}
