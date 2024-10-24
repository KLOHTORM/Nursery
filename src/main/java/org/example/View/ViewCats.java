package org.example.View;

import java.util.List;

public class ViewCats {
    public void viewCatList(List Cat) {
        for (Object o : Cat) {
            System.out.println(o);
        }
    }
}
