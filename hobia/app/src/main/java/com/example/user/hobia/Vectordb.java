package com.example.user.hobia;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by User on 24/10/2016.
 */

public class Vectordb  implements Serializable{
    Vector<User> userShop = new Vector<User>();

    public Vectordb(){

    }

    public Vectordb(Vector<User> userShop){
        this.userShop = userShop;
    }

    public int getSize(){
        return userShop.size();
    }

    public User getUser(int index){
        return userShop.get(index);
    }

    public void addUser(User user){
        userShop.add(user);
    }

}
