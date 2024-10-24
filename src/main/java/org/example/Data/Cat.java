package org.example.Data;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Domestic {
    private Integer id = 0;
    private static Integer cat_counter = 0;
    public List<String> commands;
    public static List<Cat> listOfCats = new ArrayList<>();


    public Cat(String name, List<String> commands) {
        super(name);
        this.commands = commands;
        this.id = cat_counter;
        setDateOfBirth();
        cat_counter++;
        globalCounter++;
        listOfCats.add(this);
    }


    public Integer getId() {
        return id;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }


    @Override
    public String toString() {
        return "Cat{" + "id= " + getId() + " name= " + getName() +
                " commands= " + commands + " dateBirth= " + getDateOfBirth() +
                '}';
    }
}
