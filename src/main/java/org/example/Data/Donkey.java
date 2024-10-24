package org.example.Data;

import java.util.ArrayList;
import java.util.List;

public class Donkey extends Pack {
    private Integer id = 0;
    private static Integer donkey_counter = 0;
    public List<String> commands;
    public static List<Donkey> listOfDonkeys = new ArrayList<>();


    public Donkey(String name, List<String> commands) {
        super(name);
        this.commands = commands;
        this.id = donkey_counter;
        setDateOfBirth();
        donkey_counter++;
        globalCounter++;
        listOfDonkeys.add(this);
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
        return "Donkey{" + "id= " + getId() + " name= " + getName() +
                " commands= " + commands + " dateBirth= " + getDateOfBirth() +
                '}';
    }
}
