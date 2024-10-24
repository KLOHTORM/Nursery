package org.example.Data;

import java.util.ArrayList;
import java.util.List;

public class Dog extends Domestic {
    private Integer id = 0;
    private static Integer dog_counter = 0;
    public List<String> commands;
    public static List<Dog> listOfDogs = new ArrayList<>();


    public Dog(String name, List<String> commands) {
        super(name);
        this.commands = commands;
        this.id = dog_counter;
        setDateOfBirth();
        dog_counter++;
        globalCounter++;
        listOfDogs.add(this);
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
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getType() {
        return super.getType();
    }


    @Override
    public String toString() {
        return "Dog{ " + "id= " + getId() + " name= " + getName() + " " +
                " command= " + commands + " dateBirth= " + getDateOfBirth() +
                '}';
    }
}
