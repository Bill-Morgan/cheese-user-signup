package org.launchcode.cheesemvc.models;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class UserData {

    public static ArrayList<User> userArray = new ArrayList<>();


    public static ArrayList<User> getUserArray() {
        return userArray;
    }

    public static Boolean addUser(User newUser, String verify){
        Boolean retValue = Boolean.FALSE;
        if (verify.equals(newUser.getPassword())) {
            userArray.add(newUser);
            retValue = Boolean.TRUE;
        }
        return retValue;
    }

    public static User getUser(String userName){
        User retValue = new User();
        return retValue;
    }
}
