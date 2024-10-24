package org.example.Data;

import java.util.ArrayList;
import java.util.List;

public class Horse extends Pack {
    private Integer id = 0;
    private static Integer horse_counter = 0;
    public List<String> commands;
    public static List<Horse> listOfHorses = new ArrayList<>();

    public Horse(String name, List<String> commands) {
        super(name);
        this.commands = commands;
        this.id = horse_counter;
        setDateOfBirth();
        horse_counter++;
        globalCounter++;
        listOfHorses.add(this);
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
        return "Horse{" + "id= " + getId() + " name= " + getName() +
                " commands= " + commands + " dateBirth= " + getDateOfBirth() +
                '}';
    }
}
