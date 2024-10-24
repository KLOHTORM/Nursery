package org.example.View;

import java.util.List;

public class ViewHorses {
    public void viewHorseList(List Horse) {
        for (Object o : Horse) {
            System.out.println(o);
        }
    }
}
