package org.example.View;

import java.util.List;

public class ViewDogs {
    public void viewDogList(List Dog){
        for (Object o: Dog) {
            System.out.println(o);
        }
    }
}
